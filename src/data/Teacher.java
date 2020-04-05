package data;

import javafx.beans.property.SimpleStringProperty;
import pathFinding.PathfindLogic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class Teacher extends Person implements Serializable {

    private String subject;
    private ArrayList<Lesson> lessons;
    private transient SimpleStringProperty subjectTB;
    private transient SimpleStringProperty genderTB;
    private transient SimpleStringProperty lastNameTB;

    private Point2D position;
    private double angle;
    private double speed;

    private Point2D target;
    private double rotationSpeed;

    private PathfindLogic pathfindLogic;

    private transient BufferedImage image;
    private transient BufferedImage[] tiles;
    private transient BufferedImage[] up;
    private transient BufferedImage[] down;
    private transient BufferedImage[] left;
    private transient BufferedImage[] right;

    private double counter = 0;

    private boolean walkingRight = false;
    private boolean walkingLeft = false;
    private boolean walkingUp = false;
    private boolean walkingDown = true;
    private boolean collision = false;

    public Teacher (String lastName,String gender,String TeacherSubject, Point2D position) {
        super(gender, lastName);
        this.subject = TeacherSubject;
        subjectTB = new SimpleStringProperty(TeacherSubject);
        genderTB = new SimpleStringProperty(gender);
        lastNameTB = new SimpleStringProperty(lastName);

        this.position = position;
        this.angle = 0;
        this.speed = 2;
        this.target = new Point2D.Double(200, 200);
        this.rotationSpeed = 0.1;
    }

    public void setTeacherSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacherSubject() {
        return subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setPathfindLogic(PathfindLogic pathfindLogic) {
        this.pathfindLogic = pathfindLogic;
    }

    public String getSubjectTB() {
        return subjectTB.get();
    }

    public SimpleStringProperty subjectTBProperty() {
        return subjectTB;
    }

    public void setSubjectTB(String subjectTB) {
        this.subjectTB.set(subjectTB);
    }

    public String getGenderTB() {
        return genderTB.get();
    }

    public SimpleStringProperty genderTBProperty() {
        return genderTB;
    }

    public void setGenderTB(String genderTB) {
        this.genderTB.set(genderTB);
    }

    public String getLastNameTB() {
        return lastNameTB.get();
    }

    public SimpleStringProperty lastNameTBProperty() {
        return lastNameTB;
    }

    public void setLastNameTB(String lastNameTB) {
        this.lastNameTB.set(lastNameTB);
    }

    @Override
    public String toString() {
        return getLastName();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeUTF(subjectTB.get());
        oos.writeUTF(genderTB.get());
        oos.writeUTF(lastNameTB.get());
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        subjectTB = new SimpleStringProperty(ois.readUTF());
        genderTB = new SimpleStringProperty(ois.readUTF());
        lastNameTB = new SimpleStringProperty(ois.readUTF());

        if (this.genderTB.get().equals("Female")) {
            image = ImageIO.read(getClass().getResource("/FemaleTeacher.png"));
        } else {
            image = ImageIO.read(getClass().getResource("/Teacher.png"));
        }

        tiles = new BufferedImage[35];
        for (int i = 0; i < 35; i++) {
            tiles[i] = image.getSubimage(64 * (i % 9), 64 * (i / 9), 64, 64);
        }

        up = new BufferedImage[9];
        for (int i = 1; i < 9; i++) {
            up[i - 1] = image.getSubimage(64 * (i % 9), 64 * (i / 9), 64, 64);
        }

        left = new BufferedImage[9];
        for (int i = 10; i < 18; i++) {
            left[i - 10] = image.getSubimage(64 * (i % 9), 64 * (i / 9), 64, 64);
        }

        down = new BufferedImage[9];
        for (int i = 19; i < 27; i++) {
            down[i - 19] = image.getSubimage(64 * (i % 9), 64 * (i / 9), 64, 64);
        }

        right = new BufferedImage[9];
        for (int i = 28; i < 36; i++) {
            right[i - 28] = image.getSubimage(64 * (i % 9), 64 * (i / 9), 64, 64);
        }
        this.lessons = new ArrayList<>();
    }

    public void update(ArrayList<Teacher> teachers, int hour, int minute, PathfindLogic pathfindLogic) {
        double targetAngle = Math.atan2(this.target.getY() - this.position.getY(),
                this.target.getX() - this.position.getX());

        Point2D newPosition = new Point2D.Double(this.position.getX() + this.speed * Math.cos(targetAngle),
                this.position.getY() + this.speed * Math.sin(targetAngle));
        this.angle = targetAngle;

        boolean collided = false;

        for (Person other : teachers) {
            if (other != this && newPosition.distance(other.getPosition()) < 50 && collision) {
                collided = true;
            }
        }

        if (angle > 0.8 && angle < 2.2) {
            walkingRight = false;
            walkingLeft = false;
            walkingUp = false;
            walkingDown = true;
        } else if (angle > -0.8 && angle < 0.8) {
            walkingRight = true;
            walkingLeft = false;
            walkingUp = false;
            walkingDown = false;
        } else if (angle > -2.2 && angle < -0.8) {
            walkingRight = false;
            walkingLeft = false;
            walkingUp = true;
            walkingDown = false;
        } else if (angle > 2.2 || angle < -2.2) {
            walkingRight = false;
            walkingLeft = true;
            walkingUp = false;
            walkingDown = false;
        }

        if (!collided) {
            this.position = newPosition;
        } else {
            this.angle -= this.rotationSpeed * 2;
        }

        if (counter < 7) {
            counter = counter + 0.1;
        } else {
            counter = 0;
        }

        for (Lesson lesson : lessons) {
            int[] beginTime = lesson.getBeginLesson();
            int[] endTime = lesson.getEndLesson();

            String locationT = lesson.getClassroom().getClassNumber() + "t";

            if (hour >= beginTime[0] && minute >= beginTime[1] && hour <= endTime[0] && minute <= endTime[1]) {
                this.setTarget(this.pathfindLogic.getPath(this.getPosition(), locationT));
            } else {
                this.setTarget(this.pathfindLogic.getPath(this.getPosition(), "teacherroom"));
            }
        }
    }

    @Override
    public void draw(Graphics2D g) {
        if (walkingRight) {
            g.drawImage(right[(int) counter], getTransform(), null);
        } else if (walkingLeft) {
            g.drawImage(left[(int) counter], getTransform(), null);
        } else if (walkingUp) {
            g.drawImage(up[(int) counter], getTransform(), null);
        } else if (walkingDown) {
            g.drawImage(down[(int) counter], getTransform(), null);
        }
    }

    private AffineTransform getTransform() {
        AffineTransform tx = new AffineTransform();
        tx.translate(position.getX() - 32, position.getY() -32);
        tx.scale(0.9, 0.9);
        return tx;
    }

    @Override
    public void setTarget(Point2D point2D) {
        this.target = point2D;
    }

    @Override
    public Point2D getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Point2D position) {
        this.position = position;
    }

    public Point2D getTarget() {
        return this.target;
    }

    @Override
    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    @Override
    public ArrayList<Lesson> getLessons() {
        return this.lessons;
    }

    @Override
    public void setSpeed(double speedFactor) {
        this.speed *= speedFactor;
    }


}

package data;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

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


public class Student extends Person implements Serializable {

   // private String firstName;
    private Group group;
    private transient SimpleObjectProperty groupTBST;
    private transient SimpleStringProperty genderTBST;
    private transient SimpleStringProperty lastNameTBST;

    private Point2D position;
    private double angle;
    private double speed;

    private Point2D target;
    private double rotationSpeed;

    private transient BufferedImage sprite;
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

    public Student(String lastName, Group group, String gender, Point2D position) {
        super(gender,lastName);
        this.group = group;
        this.groupTBST = new SimpleObjectProperty(group);
        this.genderTBST = new SimpleStringProperty(gender);
        this.lastNameTBST = new SimpleStringProperty(lastName);

        this.position = position;
        this.angle = 0;
        this.speed = 2;
        this.target = new Point2D.Double(200, 200);
        this.rotationSpeed = 0.1;

        try {
            if (this.genderTBST.get().equals("Female")) {
                image = ImageIO.read(getClass().getResource("/Female.png"));
            } else {
                image = ImageIO.read(getClass().getResource("/Male.png"));
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

            this.sprite = tiles[0];

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Group getStudentGroup() { return group;}

    public void setStudentGroup(Group group) {this.group = group;}

    public Group getGroupTBST() {
        return (Group) this.groupTBST.get();
    }

    public SimpleObjectProperty groupTBProperty() {
        return groupTBST;
    }

    public void setGroupTBST(String groupTBST) {
        this.groupTBST.set(groupTBST);
    }

    public String getGenderTBST() {
        return genderTBST.get();
    }

    public SimpleStringProperty genderTBPSTroperty() {
        return genderTBST;
    }

    public void setGenderTBST(String genderTBST) {
        this.genderTBST.set(genderTBST);
    }

    public String getLastNameTBST() {
        return lastNameTBST.get();
    }

    public SimpleStringProperty lastNameTBPSTroperty() { return lastNameTBST; }

    public void setLastNameTBST(String lastNameTBST) {
        this.lastNameTBST.set(lastNameTBST);
    }

    @Override
    public String toString() {
        return "name: " + this.lastNameTBST.get() + ", group: " + this.groupTBST.get() + ", gender: " + this.genderTBST.get();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(groupTBST.get());
        oos.writeUTF(genderTBST.get());
        oos.writeUTF(lastNameTBST.get());
    }
    
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        groupTBST = new SimpleObjectProperty(ois.readObject());
        genderTBST = new SimpleStringProperty(ois.readUTF());
        lastNameTBST = new SimpleStringProperty(ois.readUTF());

        if (this.genderTBST.get().equals("Female")) {
                image = ImageIO.read(getClass().getResource("/Female.png"));
            } else {
                image = ImageIO.read(getClass().getResource("/Male.png"));
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
        this.sprite = tiles[0];
    }

    @Override
    public void update(ArrayList<Person> students) {
        double targetAngle = Math.atan2(this.target.getY() - this.position.getY(),
                this.target.getX() - this.position.getX());

        double angleDifference = this.angle - targetAngle;
        while (angleDifference < -Math.PI)
            angleDifference += 2 * Math.PI;
        while (angleDifference > Math.PI)
            angleDifference -= 2 * Math.PI;

        if (Math.abs(angleDifference) < this.rotationSpeed)
            this.angle = targetAngle;
        else if (angleDifference < 0)
            this.angle += this.rotationSpeed;
        else
            this.angle -= this.rotationSpeed;

        Point2D newPosition = new Point2D.Double(this.position.getX() + this.speed * Math.cos(this.angle),
                this.position.getY() + this.speed * Math.sin(this.angle));

        boolean collided = false;

        for (Person other : students) {
            if (other != this && newPosition.distance(other.getPosition()) < 64) {
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
        }
        else if (angle > -2.2 && angle < -0.8) {
            walkingRight = false;
            walkingLeft = false;
            walkingUp = true;
            walkingDown = false;
        }
        else if (angle > 2.2 || angle < -2.2) {
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
        tx.translate(position.getX(), position.getY());
        return tx;
    }

    public void setTarget(Point2D target) {
        this.target = target;
    }

    public Point2D getPosition(){
        return this.position;
    }

    @Override
    public void setPosition(Point2D position) {
        this.position = position;
    }
}

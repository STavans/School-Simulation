package gui;

import data.*;
import data.FileIO;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;
import pathFinding.PathfindLogic;
import tileMap.Target;
import tileMap.TiledMap;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("Duplicates")
public class SimulationController {

    private FileIO fileIO = new FileIO();
    private TiledMap map;
    private ResizableCanvas canvas;
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Lesson> lessons;
    private Target target;

    private int hour;
    private int minute;
    private double periodTime;
    private PathfindLogic pathfindLogic = new PathfindLogic("Tilemap.json");
    private double[][] distanceMap;


    private AnimationTimer animationTimer;
    private Timer timer;
    private ArrayList<Classroom> classroomList = new ArrayList<>();
    private ArrayList classroomCodesArrayList = new ArrayList();
    private double timeSettingValue;
    private double speedModifier = 1;

    public void start() throws Exception {
        Stage stage = new Stage();
        init();
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g), mainPane);
        mainPane.setCenter(canvas);
        FXGraphics2D g2d = new FXGraphics2D(canvas.getGraphicsContext2D());

        Image image1 = new Image(getClass().getResourceAsStream("/ff.png"));
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitHeight(40);
        imageView1.setFitWidth(40);

        Image image2 = new Image(getClass().getResourceAsStream("/Slow.png"));
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(40);
        imageView2.setFitWidth(40);

        Image image3 = new Image(getClass().getResourceAsStream("/Pause.png"));
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitHeight(40);
        imageView3.setFitWidth(40);

        HBox hBox = new HBox();
        Button ff = new Button("",imageView1);
        Button sd = new Button("",imageView2);
        Button pause = new Button("", imageView3);

        ff.setOnAction(actionEvent -> {
            speedModifier = 2.0;
        });

        sd.setOnAction(actionEvent -> {
            speedModifier = 0.5;
        });

        pause.setOnAction(actionEvent -> {
            speedModifier = 0;
        });

        hBox.getChildren().addAll(sd, pause, ff);

        mainPane.getChildren().add(hBox);

        periodTime = 1000 / timeSettingValue;

        timer = new Timer();
        timer.schedule(
                new TimerTask() {

                    @Override
                    public void run() {
                        minute++;
                        System.out.println(hour + ":" + minute);
                        if (minute >= 20) {
                            minute = 0;
                            hour++;

                        }
                    }
                }, 0, (int) periodTime);

        animationTimer = new AnimationTimer() {
            long last = -1;

            @Override
            public void handle(long now) {
                if (last == -1.0)
                    last = now;
                update((now - last) / 1000000000.0);
                last = now;
                draw(g2d);
            }
        };

        animationTimer.start();

        stage.setOnCloseRequest(event ->
                stopSimulation()
        );
        stage.setScene(new Scene(mainPane));
        stage.setTitle("School Simulation");
        stage.show();
        canvas.setOnMouseClicked(event ->
                getMouseLocation());
        draw(g2d);
    }

    public void init() throws IOException, ClassNotFoundException {
        map = new TiledMap("/Tilemap.json");
        target = new Target("/Tilemap.json");
        hour = 8;
        minute = 6;

        timeSettingValue = fileIO.getTimeSettingValue();

        pathfindLogic.generate();
        this.distanceMap = pathfindLogic.getDistanceMap().getDistanceMap();
        classroomCodesArrayList = target.getClassroomCodesList();
        classroomList = pathfindLogic.getClassroomArrayList();
        for (Classroom cla :
                pathfindLogic.getClassroomArrayList()) {
//            System.out.println("Added: " +  cla.getClassNumber() + " Active: " + cla.getChairs());
        }
        try {
            this.students = new ArrayList<>(fileIO.getStudents());
            this.teachers = new ArrayList<>(fileIO.getTeachers());
            this.lessons = new ArrayList<>(fileIO.getLessons());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Student student : this.students) {
            student.setPathfindLogic(this.pathfindLogic);
            student.setSpeed(timeSettingValue);
            for (Lesson lesson: this.lessons) {
                if (lesson.getGroup().getCode().equals(student.getStudentGroup().getCode()))
                    student.addLesson(lesson);
            }
        }

        for (Person teacher : this.teachers) {
            teacher.setPathfindLogic(pathfindLogic);
            teacher.setSpeed(timeSettingValue);
            for (Lesson lesson: this.lessons) {
                if (teacher.getLastName().equals(lesson.getTeacher().getLastName()))
                    teacher.addLesson(lesson);
            }
        }

        for (int i = 0; i < this.students.size(); i++) {
//            this.students.get(i).setPosition(new Point2D.Double(1090, 1040 + (i * 64)));
            this.students.get(i).setPosition(new Point2D.Double(1040, 1008 - 32));
        }

        for (int i = 0; i < this.teachers.size(); i++) {
//            this.teachers.get(i).setPosition(new Point2D.Double(1010, 1040 + (i * 64)));
            this.teachers.get(i).setPosition(new Point2D.Double(1040, 1008 - 32));

        }
    }

    public void draw(Graphics2D g) {
        g.setBackground(Color.pink);
        g.clearRect(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());
        map.draw(g);
        g.setTransform(new AffineTransform());

        for (Person student : students) {
            student.draw(g);
        }

        for (Person teacher : teachers) {
            teacher.draw(g);
        }

        String distanceMapString;
        for (int y = 0; y < 32; y++) {
            for (int x = 0; x < 60; x++) {
                if ((int) distanceMap[x][y] > 1000) {
                    continue;
                } else {
                    distanceMapString = String.valueOf((int) distanceMap[x][y]);
                    g.setColor(Color.yellow);
                    g.drawString(distanceMapString, x * 32 + 16, y * 32 + 16);
                }
            }
        }
    }

    public void update(double deltaTime) {
        for (Student student : this.students) {
            student.update(this.students, classroomList, hour, minute, pathfindLogic, classroomCodesArrayList);
        }

        for (Teacher teacher : this.teachers) {
            teacher.update(this.teachers, hour, minute, pathfindLogic);
        }
    }

    public void getMouseLocation() {
        System.out.println(MouseInfo.getPointerInfo().getLocation());
    }

    public void stopSimulation() {
        timer.cancel();
        animationTimer.stop();
    }
}

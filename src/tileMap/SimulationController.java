package tileMap;

import data.Lesson;
import data.Person;
import data.Student;
import gui.FileIO;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

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
    private ArrayList<Person> students;
    private ArrayList<Person> teachers;
    private ArrayList<Lesson> lessons;
    private Target target;

    private int hour = 8;
    private int minute = 5;
    private int periodTime = 1000;
    private PathfindLogic pathfindLogic = new PathfindLogic("Tilemap.json");
    private double[][] distanceMap;


    private AnimationTimer animationTimer;
    private Timer timer;
    private ArrayList classrooms;

//    private int tileTargetSwitchTime = 0;

    public void start() throws Exception {
        Stage stage = new Stage();
        init();
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g), mainPane);
        mainPane.setCenter(canvas);
        FXGraphics2D g2d = new FXGraphics2D(canvas.getGraphicsContext2D());

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
                }, 0, periodTime);

        animationTimer = new AnimationTimer() {
            long last = -1;

            @Override
            public void handle(long now) {
                if (last == -1)
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

    public void init() {
        map = new TiledMap("/Tilemap.json");
        target = new Target("/Tilemap.json");

        classrooms = target.getClassroomList();

        try {
            this.students = new ArrayList<>(fileIO.getStudents());
            this.teachers = new ArrayList<>(fileIO.getTeachers());
            this.lessons = new ArrayList<>(fileIO.getLessons());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Person student : this.students) {
            student.setPathfindLogic(pathfindLogic);
        }

        for (Person teacher : this.teachers) {
            teacher.setPathfindLogic(pathfindLogic);
        }
        pathfindLogic.generate();
        this.distanceMap = pathfindLogic.getDistanceMap().getDistanceMap();

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
        for (Person student : this.students) {
            student.update(this.students);
            for (Lesson lesson : lessons) {
                int beginTime[] = lesson.getBeginLesson();
                int endTime[] = lesson.getEndLesson();
                String locationS = lesson.getClassroom().getClassNumber() + "s";

                if (hour >= beginTime[0] && minute >= beginTime[1] && hour <= endTime[0] && minute <= endTime[1]) {
                    student.setTarget(pathfindLogic.getPath(student.getPosition(), locationS));
                } else {
                    student.setTarget(pathfindLogic.getPath(student.getPosition(), "canteen"));
                }
            }
        }

        for (Person teacher : this.teachers) {
            teacher.update(this.teachers);

            for (Lesson lesson : lessons) {
                int beginTime[] = lesson.getBeginLesson();
                int endTime[] = lesson.getEndLesson();

                String locationT = lesson.getClassroom().getClassNumber() + "t";

                if (hour >= beginTime[0] && minute >= beginTime[1] && hour <= endTime[0] && minute <= endTime[1]) {
                    teacher.setTarget(pathfindLogic.getPath(teacher.getPosition(), locationT));
                } else {
                    teacher.setTarget(pathfindLogic.getPath(teacher.getPosition(), "teacherroom"));
                }
            }
        }
//        tileTargetSwitchTime++;
    }

    public void getMouseLocation() {
        System.out.println(MouseInfo.getPointerInfo().getLocation());
    }

    public void stopSimulation() {
        timer.cancel();
        animationTimer.stop();
    }
}

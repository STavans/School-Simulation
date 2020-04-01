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
    private int minute;
    private int periodTime = 1000;
    private PathfindLogic pathfindLogic = new PathfindLogic("Tilemap.json");
    private double[][] distanceMap;

    private ArrayList classrooms;

    public void start() throws Exception {
        Stage stage = new Stage();
        init();
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g), mainPane);
        mainPane.setCenter(canvas);
        FXGraphics2D g2d = new FXGraphics2D(canvas.getGraphicsContext2D());

        new Timer().schedule(
                new TimerTask() {

                    @Override
                    public void run() {
                        minute++;
                        if (minute >= 6){
                            minute = 0;
                            hour++;
                        }
                    }
                }, 0, periodTime);

        new AnimationTimer() {
            long last = -1;

            @Override
            public void handle(long now) {
                if (last == -1)
                    last = now;
                update((now - last) / 1000000000.0);
                last = now;
                draw(g2d);
            }
        }.start();

        stage.setScene(new Scene(mainPane));
        stage.setTitle("Fading image");
        stage.show();
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

        for (Person student: this.students) {
            student.setPathfindLogic(pathfindLogic);
        }

        for (Person teacher: this.teachers) {
            teacher.setPathfindLogic(pathfindLogic);
        }

        for (int i = 0; i < this.students.size(); i++) {
            this.students.get(i).setPosition(new Point2D.Double(1090, 1040 + (i * 64)));
        }

        for (int i = 0; i < this.teachers.size(); i++) {
            this.teachers.get(i).setPosition(new Point2D.Double(1010, 1040 + (i * 64)));
        }
        pathfindLogic.generate();
        this.distanceMap = pathfindLogic.getDistanceMap().getDistanceMap();
    }

    public void draw(Graphics2D g) {
        g.setBackground(Color.pink);
        g.clearRect(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());
        map.draw(g);
        g.setTransform(new AffineTransform());

        for (Person student : students) {
            student.draw(g);
        }

        for (Person teacher : teachers){
            teacher.draw(g);
        }

        String distanceMapString;
        for (int y = 0; y < 32; y++){
            for (int x = 0; x < 60; x++){
                if ((int) distanceMap[x][y] > 1000){
                    continue;
                }
                else {
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

            for (Lesson lesson : lessons){
                int time[] = lesson.getBeginLesson();

                String locationS = lesson.getClassroom().getClassNumber() + "s";

                if (hour == time[0] && minute == time[1]){
                    student.setTarget(target.getCenter(classrooms.indexOf(locationS)));
                }
            }
        }

        for (Person teacher : this.teachers) {
            teacher.update(this.teachers);

            for (Lesson lesson : lessons){
                int time[] = lesson.getBeginLesson();

                String locationT = lesson.getClassroom().getClassNumber() + "t";

                if (hour == time[0] && minute == time[1]){
                    teacher.setTarget(target.getCenter(classrooms.indexOf(locationT)));
                }
            }
        }
    }
}

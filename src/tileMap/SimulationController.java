package tileMap;

import data.Group;
import data.Person;
import data.Student;
import gui.FileIO;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class SimulationController {

    private FileIO fileIO = new FileIO();
    private TiledMap map;
    private ResizableCanvas canvas;
    private BufferedImage[] tiles;
    private BufferedImage image;
    private ArrayList<Person> people;

    public void start() throws Exception {
        Stage stage = new Stage();
        init();
        BorderPane mainPane = new BorderPane();
        canvas = new ResizableCanvas(g -> draw(g), mainPane);
        mainPane.setCenter(canvas);
        FXGraphics2D g2d = new FXGraphics2D(canvas.getGraphicsContext2D());
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

        canvas.setOnMouseMoved(e ->
        {
            for (Person student : people) {
                student.setTarget(new Point2D.Double(e.getX(), e.getY()));
            }
        });
    }


    public void init() {
        map = new TiledMap("/Tilemap.json");

        try {
            this.people = new ArrayList<>(fileIO.getStudents());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < this.people.size(); i++) {
            this.people.get(i).setPosition(new Point2D.Double(250 * i, 500));
        }

    }


    public void draw(Graphics2D g) {
        g.setBackground(Color.pink);
        g.clearRect(0, 0, (int) canvas.getWidth(), (int) canvas.getHeight());
        map.draw(g);
        g.setTransform(new AffineTransform());

        for (Person person : people) {
            person.draw(g);
        }
    }

    public void update(double deltaTime) {
        for (Person person : people) {
            person.update(people);
        }
    }
}

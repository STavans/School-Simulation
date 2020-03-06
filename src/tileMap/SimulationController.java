package tileMap;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
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

	private TiledMap map;
	private ResizableCanvas canvas;

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
				if(last == -1)
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

		canvas.setOnMouseClicked(e ->
		{
			for(Sprite person : sprite) {
				person.setTarget(new Point2D.Double(e.getX(), e.getY()));
			}
		});
	}
	ArrayList<Sprite> sprite;

	public void init(){
		map = new TiledMap("/Tilemap.json");

		this.sprite = new ArrayList<>();

		BufferedImage image = null;
		BufferedImage imageGhost = null;
		try {
			image = ImageIO.read(this.getClass().getResourceAsStream("/npc.png"));
			imageGhost = ImageIO.read(this.getClass().getResourceAsStream("/Ghost.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.sprite.add(new Sprite(new Point2D.Double(70, 70), image));
		for(int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {

				this.sprite.add(new Sprite(new Point2D.Double(500 * i, 500 * j ), imageGhost));
			}

		}
	}



	public void draw(Graphics2D g){
		g.setBackground(Color.pink);
		g.clearRect(0,0,(int)canvas.getWidth(), (int)canvas.getHeight());

		map.draw(g);

		g.setTransform(new AffineTransform());



		for(Sprite person : sprite) {
			person.draw(g);
		}
	}

	public void update(double deltaTime){
		for(Sprite person : sprite) {
			person.update(sprite);
		}
	}
}

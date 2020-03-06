package tileMap;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

import java.awt.*;

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
	}


	public void init(){
		map = new TiledMap("/Tilemap.json");
	}



	public void draw(Graphics2D g){
		g.setBackground(Color.pink);
		g.clearRect(0,0,(int)canvas.getWidth(), (int)canvas.getHeight());
		map.draw(g);
	}

	public void update(double deltaTime){
	}
}
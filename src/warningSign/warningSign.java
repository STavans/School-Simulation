package warningSign;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;

public class warningSign {
    private ResizableCanvas canvas;

    public void start() {
        init();
        Stage stage = new Stage();
        BorderPane mainPane = new BorderPane();
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
        stage.show();
        draw(g2d);
    }
    public void init() {
        final JPanel panel = new JPanel();
        JOptionPane.showMessageDialog(panel, "A deprecated call", "Warning",
                JOptionPane.WARNING_MESSAGE);
    }
    public void draw(Graphics2D g){
        g.setBackground(Color.pink);
        g.clearRect(0,0,(int)canvas.getWidth(), (int)canvas.getHeight());
    }
    public void update(double deltaTime){
    }
}
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

public class ErrorMessage {
    private ResizableCanvas canvas;

    public void showError(String errorMessage) {
        final JPanel panel = new JPanel();
        JOptionPane.showMessageDialog(panel, errorMessage, "Error",
                JOptionPane.WARNING_MESSAGE);
    }
}
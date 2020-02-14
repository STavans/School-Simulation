package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ErrorHandler extends Application {

    public ErrorHandler() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("molumen_red_round_error_warning_icon.png");
        ImageView imageView = new ImageView(image);
        imageView.setScaleX(0.2);
        imageView.setScaleY(0.2);
        Label label=new Label("Error:");
        Button button =new Button("OK");
        GridPane gridPane=new GridPane();
        gridPane.add(imageView,0,2);
        gridPane.add(label,1,2);
        gridPane.add(button,2,3);
       // gridPane.setPrefSize(100, 180);
      // gridPane.setAlignment(Pos.CENTER);


        Scene scene=new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }


}

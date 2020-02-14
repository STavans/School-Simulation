import gui.ErrorHandler;
import gui.Gui;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
        launch(gui.ErrorHandler.class);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Gui.class.getResource("Application.fxml"));

            Parent root = loader.load();
            Gui gui = loader.getController();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

            gui.setTeacherSubjectBox();
            gui.setTeacherGenderBox();
            gui.setStudentGroupBox();
            gui.setStudentGenderBox();
            gui.setrosterTeacherColumn1();
            gui.setStudentGroupBoxs();
            gui.setBeginTimeBox();
            gui.setEndTimeBox();
            gui.setClassRoomBox();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
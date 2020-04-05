import gui.GuiController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GuiController.class.getResource("Application.fxml"));

            Parent root = loader.load();
            GuiController guiController = loader.getController();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("School Simulation");
            primaryStage.show();

            guiController.setTeacherSubjectBox();
            guiController.setTeacherGenderBox();
            guiController.setStudentGroupBox();
            guiController.setStudentGenderBox();
            guiController.setrosterTeacherColumn1();
            guiController.setStudentGroupBoxs();
            guiController.setBeginTimeBox();
            guiController.setEndTimeBox();
            guiController.setClassRoomBox();
            guiController.setSimulationSettingTimeCombo();
            primaryStage.setOnCloseRequest(event ->
                    guiController.save());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
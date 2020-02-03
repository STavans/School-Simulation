package Intro;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class GuiIntro extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // 1. Creating a password for the password query

        // 1.1 creating the components to be used
        Label loginLabel = new Label("Enter a password and press enter");
        PasswordField passwordText = new PasswordField();
        Button loginButton = new Button("Login");
        Label errorLabel = new Label("");

        // 1.2 creating layout and adding components to it
        GridPane gridPane = new GridPane();

        gridPane.add(loginLabel, 0, 0);
        gridPane.add(passwordText, 0, 1);
        gridPane.add(loginButton, 0, 2);
        gridPane.add(errorLabel, 0, 3);

        // 1.3 Style the layout
        gridPane.setPrefSize(300, 180);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(20, 20, 20, 20));

        // 1.4 creating the view itself and setting the layout to it
        Scene loginScene = new Scene(gridPane);

        // 2. Creating a view to display the welcome text
        Label welcomeLabel = new Label("Welcome, this is where it starts!");

        StackPane welcomeStackPane = new StackPane();
        welcomeStackPane.setPrefSize(300, 180);
        welcomeStackPane.getChildren().add(welcomeLabel);
        welcomeStackPane.setAlignment(Pos.CENTER);

        Scene welcomeScene = new Scene(welcomeStackPane);


        // 3. The event handler is added to the password bar button
        // the view is changed if the password is correct
        loginButton.setOnAction((event) -> {
            if (!passwordText.getText().trim().equals("password")) {
                errorLabel.setText("Unkown password!");
                return;
            }

            stage.setScene(welcomeScene);
        });

        stage.setScene(loginScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(GuiIntro.class);
    }
}
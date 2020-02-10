package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;


public class Gui implements Initializable {
    @FXML private ComboBox<String> teacherSubjectBox;//1
    @FXML private ComboBox<String> teacherGenderBox;//2
    @FXML private ComboBox<String> studentGroupBox;//3
    @FXML private ComboBox<String> studentGenderBox;//4

    ObservableList<String> comboTeacherSubject= FXCollections.observableArrayList("OGP","Math");//1
    ObservableList<String> comboTeacherGender= FXCollections.observableArrayList("Male","Female");//2
    ObservableList<String> comboStudentGroup= FXCollections.observableArrayList("A3","C3");//3
    ObservableList<String> comboStudentGender= FXCollections.observableArrayList("Male","Female");//4


    @FXML void teacherAddButton(){
        System.out.println("TeacherAdd");
    }
    @FXML void teacherDeleteButton(){
        System.out.println("TeacherDelete");
    }
    @FXML void teacherEditButton(){
        System.out.println("TeacherEdit");
    }
    @FXML void teacherSaveButton(){
        System.out.println("TeacherSave");
    }
    @FXML void teacherGenerateButton(){
        System.out.println("TeacherGenerate");
    }
    @FXML void studentAddButton(){
        System.out.println("StudentAdd");
    }
    @FXML void studentDeleteButton(){
        System.out.println("StudentDelete");
    }
    @FXML void studentEditButton(){
        System.out.println("StudentEdit");
    }
    @FXML void studentSaveButton(){
        System.out.println("StudentSave");
    }
    @FXML void studentGenerateButton(){
        System.out.println("StudentGenerate");
    }
    @FXML void generateMaxButton(){
        System.out.println("GenerateMax");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teacherSubjectBox.setItems(comboTeacherSubject);
        teacherGenderBox.setItems(comboTeacherGender);
        studentGroupBox.setItems(comboStudentGroup);
        studentGenderBox.setItems(comboStudentGender);

        System.out.println("Combobox Initialised");
    }
}

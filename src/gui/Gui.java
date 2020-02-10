package gui;

import data.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;



public class Gui implements Initializable {
    //ComboBox
    @FXML private ComboBox<String> teacherSubjectBox;//1
    @FXML private ComboBox<String> teacherGenderBox;//2
    @FXML private ComboBox<String> studentGroupBox;//3
    @FXML private ComboBox<String> studentGenderBox;//4

    ObservableList<String> comboTeacherSubject = FXCollections.observableArrayList("OGP","Math","OOM","2D Graphics","P&OC");
    ObservableList<String> comboTeacherGender  = FXCollections.observableArrayList("Male","Female");
    ObservableList<String> comboStudentGroup   = FXCollections.observableArrayList("A1","A2","A3","B1","B2","B3");
    ObservableList<String> comboStudentGender  = FXCollections.observableArrayList("Male","Female");

    //Buttons
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
    //Making ComboBox working
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teacherSubjectBox.setItems(comboTeacherSubject);
        teacherGenderBox.setItems(comboTeacherGender);
        studentGroupBox.setItems(comboStudentGroup);
        studentGenderBox.setItems(comboStudentGender);
        System.out.println("Combobox Initialised");
    }
    //TextFields names
    public void teacherName(){
        System.out.println("TeacherName");
    }
    public void studentName(){
        System.out.println("StudentName");
    }



}

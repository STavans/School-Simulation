package gui;

import data.Student;
import data.Teacher;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class Gui implements Initializable {
    //ComboBox
    @FXML private ComboBox<String> teacherSubjectBox;//1
    @FXML private ComboBox<String> teacherGenderBox;//2
    @FXML private ComboBox<String> studentGroupBox;//3
    @FXML private ComboBox<String> studentGenderBox;//4
    //new privates
    @FXML private TableColumn<?, ?> rosterNameColumn;
    @FXML private TableColumn<?, ?> rosterSubjectColumn;
    @FXML private ComboBox<?> rosterGroupColumn;
    @FXML private ComboBox<?> rosterClassroomColumn;
    @FXML private TableColumn<?, ?> rosterBeginTimeColumn;
    @FXML private TableColumn<?, ?> rosterEndTimeColumn;
    @FXML private ComboBox<?> rosterTeacherColumn;
    @FXML private TextField beginTimeField;
    @FXML private TextField endTimeField;
    @FXML private Button rosterAddButton;
    @FXML private Button rosterEditButton;
    @FXML private Button rosterDeleteButton;
    @FXML private Button rosterSaveButton;
    @FXML private TableColumn<?, ?> teacherNameColumn;
    @FXML private TableColumn<?, ?> teacherSubjectColumn;
    @FXML private TableColumn<?, ?> teacherGenderColumn;
    @FXML private TextField teacherNameField;
    @FXML private TextField studentNameField;
    @FXML private ComboBox teacherGender;
    @FXML private Button teacherGenerateButton;
    @FXML private Button teacherAddButton;
    @FXML private Button teacherDeleteButton;
    @FXML private Button teacherEditButton;
    @FXML private Button teacherSaveButton;

    ObservableList<String> comboTeacherSubject = FXCollections.observableArrayList("OGP","Math","OOM","2D Graphics","P&OC");
    ObservableList<String> comboTeacherGender  = FXCollections.observableArrayList("Male","Female");
    ObservableList<String> comboStudentGroup   = FXCollections.observableArrayList("A1","A2","A3","B1","B2","B3");
    ObservableList<String> comboStudentGender  = FXCollections.observableArrayList("Male","Female");

    private String TeacherSubject="";
    public void setTeacherSubjectBox() {
        teacherSubjectBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                TeacherSubject = observable.getValue().toString();
                System.out.println(TeacherSubject);
            }
        });
    }
    private String TeacherGender = "";
    public void setTeacherGenderBox() {
        teacherGenderBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                TeacherGender = observable.getValue().toString();
                System.out.println(TeacherGender);
            }
        });
    }
    private String StudentGroup="";
    public void setStudentGroupBox() {
        studentGroupBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                StudentGroup = observable.getValue().toString();
                System.out.println(StudentGroup);
            }
        });
    }
    private String StudentGender = "";
    public void setStudentGenderBox() {
        studentGenderBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                StudentGender = observable.getValue().toString();
                System.out.println(StudentGender);
            }
        });
    }

    //Buttons
    @FXML void teacherAddButton(){
       data.Teacher TeacherTotal = new data.Teacher(teacherNameField.getText(),TeacherGender,TeacherSubject);
        System.out.println("TeacherAdd: " +TeacherTotal.getLastName()+" "+TeacherTotal.getGender()+" "+ TeacherTotal.getTeacherSubject());
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
        data.Student StudentTotal = new data.Student(studentNameField.getText(),StudentGender,StudentGroup);
        System.out.println("StudentAdd: " + StudentTotal.getLastName()+" "+ StudentTotal.getGender()+" "+  StudentTotal.getStudentGroup());
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

package gui;

import data.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;


public class Gui {
    //ComboBox
    @FXML private ComboBox teacherSubjectBox;//1
    @FXML private ComboBox teacherGenderBox;//2
    @FXML private ComboBox studentGroupBox;//3
    @FXML private ComboBox studentGenderBox;//4

    ObservableList<String> comboTeacherSubject= FXCollections.observableArrayList("OGP","Math");//1
    ObservableList<String> comboTeacherGender= FXCollections.observableArrayList("Male","Female");//2
    ObservableList<String> comboStudentGroup= FXCollections.observableArrayList("A3","C3");//3
    ObservableList<String> comboStudentGender= FXCollections.observableArrayList("Male","Female");//4

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
    public void initialize(){
        teacherSubjectBox.setItems(comboTeacherSubject);
        System.out.println("TeacherSubject");
    }
    public void initialize2(){
        teacherGenderBox.setItems(comboTeacherGender);
        System.out.println("TeacherGender");
    }
    public void initialize3(){
        studentGroupBox.setItems(comboStudentGroup);
        System.out.println("StudentGroup");
    }
    public void initialize4(){
        studentGenderBox.setItems(comboStudentGender);
        System.out.println("StudentGender");
    }
    //TextFields names
    public void teacherName(){
        System.out.println("TeacherName");
    }
    public void studentName(){
        System.out.println("StudentName");
    }



}

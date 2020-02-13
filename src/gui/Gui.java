package gui;

import data.Student;
import data.Teacher;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Gui implements Initializable {
    //tableView
    @FXML private TableView teachersTable;
    @FXML private TableView studentsTable;
    //ComboBox
    @FXML private ComboBox<String> teacherSubjectBox;//1
    @FXML private ComboBox<String> teacherGenderBox;//2
    @FXML private ComboBox<String> studentGroupBox;//3
    @FXML private ComboBox<String> studentGenderBox;//4
    //new privates colums
    @FXML private TableColumn<Teacher, String> teacherNameColumn;
    @FXML private TableColumn<Teacher, String> teacherSubjectColumn;
    @FXML private TableColumn<Teacher, String> teacherGenderColumn;
    @FXML private TableColumn<Student, String> studentNameColumn;
    @FXML private TableColumn<Student, String> studentGroupColumn;
    @FXML private TableColumn<Student, String> studentGenderColumn;
    //textfield
    @FXML private TextField teacherNameField;
    @FXML private TextField studentNameField;
    //ArrayList test
    @FXML private ArrayList<String> RandomTeacher;
    public ArrayList<String> RandomTeacher() {
        RandomTeacher.add("Pieter");
        RandomTeacher.add("David");
        RandomTeacher.add("Jan");
        return RandomTeacher;
    }
//    Random rand = new Random();
//    int random = rand.nextInt(RandomTeacher.size());
//    String note = RandomTeacher.get(random);

    //list gender,subject,group
    // private ArrayList<String>nameTeachers;
//    ArrayList<String> nameTeachers=new ArrayList<String>();
//        nameTeachers.add(studentNameField.getText());
//
//    for (String allTeachers:nameTeachers) {
//        ObservableList<String> comboTeacherList= FXCollections.observableArrayList(allTeachers);
//    }
    ObservableList<String> comboTeacherSubject = FXCollections.observableArrayList("OGP", "Math", "OOM", "2D Graphics", "P&OC");
    ObservableList<String> comboTeacherGender  = FXCollections.observableArrayList("Male", "Female");
    ObservableList<String> comboStudentGroup   = FXCollections.observableArrayList("A", "B", "C", "D", "E", "F");
    ObservableList<String> comboStudentGender  = FXCollections.observableArrayList("Male", "Female");

     //to get something out the combobox
    private String TeacherSubject = "";
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
    private String StudentGroup = "";
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
    //Buttons Teacher
    @FXML void teacherAddButton(){
        ObservableList<Teacher> list = FXCollections.observableArrayList(new data.Teacher(teacherNameField.getText(), TeacherGender, TeacherSubject));
       data.Teacher TeacherTotal = new data.Teacher(teacherNameField.getText(), TeacherGender, TeacherSubject);
        System.out.println("TeacherAdd: " + TeacherTotal.getLastName() + " " + TeacherTotal.getGender() + " " + TeacherTotal.getTeacherSubject());
        teachersTable.getItems().addAll(list);
   }
    @FXML void teacherDeleteButton(){
        ObservableList<Teacher> list ,list2;
        list=teachersTable.getItems();
        list2=teachersTable.getSelectionModel().getSelectedItems();
        list2.forEach(list::remove);
        System.out.println("TeacherDelete" + teacherNameField.getText() + " " + TeacherGender + " " + TeacherSubject);
    }
    @FXML void teacherEditButton(){
        teachersTable.setEditable(true);
        teacherNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        teacherSubjectColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        teacherGenderColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        System.out.println("TeacherEdit" + teacherNameField.getText() + " " + TeacherGender + " " + TeacherSubject);
    }
    @FXML void teacherSaveButton(){
        System.out.println("TeacherSave");
    }
    @FXML void teacherGenerateButton(){
        ObservableList<Teacher> list = FXCollections.observableArrayList(new data.Teacher(RandomTeacher.get(0),TeacherGender,TeacherSubject));
        System.out.println("TeacherGenerate");
        teachersTable.getItems().addAll(list);
    }
    //Student
    @FXML void studentAddButton(){
        ObservableList<Student> list1 = FXCollections.observableArrayList(new data.Student(studentNameField.getText(), StudentGroup, StudentGender));
        data.Student StudentTotal = new data.Student(studentNameField.getText(), StudentGender, StudentGroup);
        System.out.println("StudentAdd: " + StudentTotal.getLastName() + " " +  StudentTotal.getGender() + " " +  StudentTotal.getStudentGroup());
        studentsTable.getItems().addAll(list1);
    }
    @FXML void studentDeleteButton(){
        ObservableList<Student> list ,list2;
        list=studentsTable.getItems();
        list2=studentsTable.getSelectionModel().getSelectedItems();
        list2.forEach(list::remove);
        System.out.println("StudentDelete: " + studentNameField.getText() + " " + StudentGroup + " " +  StudentGender);
    }
    @FXML void studentEditButton(){
        studentsTable.setEditable(true);
        studentNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        studentGroupColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        studentGenderColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        System.out.println("StudentEdit: " + studentNameField.getText() + " " + StudentGroup + " " +  StudentGender);
    }
    @FXML void studentSaveButton(){
        System.out.println("StudentSave");
    }
    @FXML void studentGenerateButton(){
        System.out.println("StudentGenerate");
    }
    //generate
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
        //Table view working TB = tableview
        teacherGenderColumn.setCellValueFactory(new PropertyValueFactory("genderTB"));
        teacherSubjectColumn.setCellValueFactory(new PropertyValueFactory("subjectTB"));
        teacherNameColumn.setCellValueFactory(new PropertyValueFactory("lastNameTB"));
         //student
        studentGenderColumn.setCellValueFactory(new PropertyValueFactory("genderTBST"));
        studentGroupColumn.setCellValueFactory(new PropertyValueFactory("GroupTBST"));
        studentNameColumn.setCellValueFactory(new PropertyValueFactory("lastNameTBST"));
    }
    //TextFields names
    public void teacherName(){
        System.out.println("TeacherName"); }
    public void studentName(){
        System.out.println("StudentName"); }
}

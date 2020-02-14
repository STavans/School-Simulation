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

import java.io.*;
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
    @FXML private ComboBox<String> teacherAllNameBox;//5
    @FXML private ComboBox<String> studentGroupBoxs;//6
    @FXML private ComboBox<String> beginTimeBox;//7
    @FXML private ComboBox<String> endTimeBox;//8
    @FXML private ComboBox<String> classRoomBox;//8
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

    //list gender,subject,group
    // private ArrayList<String>nameTeachers;
//    ArrayList<String> nameTeachers=new ArrayList<String>();
//        nameTeachers.add(studentNameField.getText());
//
//    for (String allTeachers:nameTeachers) {
//        ObservableList<String> comboTeacherList= FXCollections.observableArrayList(allTeachers);
//    }
    //list PersonManager
    ObservableList<String> comboTeacherSubject = FXCollections.observableArrayList("OGP", "Math", "OOM", "2D Graphics", "P&OC");
    ObservableList<String> comboTeacherGender  = FXCollections.observableArrayList("Male", "Female");
    ObservableList<String> comboStudentGroup   = FXCollections.observableArrayList("A", "B", "C", "D", "E", "F");
    ObservableList<String> comboStudentGender  = FXCollections.observableArrayList("Male", "Female");
    //Roster
    ObservableList<String> comboTeacherNameList  = FXCollections.observableArrayList("david");
    ObservableList<String> comboClassRoom  = FXCollections.observableArrayList("001","101","202","220");
    ObservableList<String> comboBeginTime  = FXCollections.observableArrayList("9:00","10:00","11:00","12:00","13:00","14:00","15:00");
    ObservableList<String> comboEndTime  = FXCollections.observableArrayList("9:50","10:50","11:50","12:50","13:50","14:50","15:50");


     //to get something out the combobox PersonManager
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
    //Roster
    private String rosterTeacherColumn1 = "";
    public void setrosterTeacherColumn1() {
        teacherAllNameBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                rosterTeacherColumn1 = observable.getValue().toString();
                System.out.println(rosterTeacherColumn1);
            }
        });
    }
    private String StudentGroups = "";
    public void setStudentGroupBoxs() {
        studentGroupBoxs.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                StudentGroups = observable.getValue().toString();
                System.out.println(StudentGroups);
            }
        });
    }
    private String ClassRoom = "";
    public void setClassRoomBox() {
        classRoomBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                ClassRoom = observable.getValue().toString();
                System.out.println(ClassRoom);
            }
        });
    }
    private String BeginTime = "";
    public void setBeginTimeBox() {
        beginTimeBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                BeginTime = observable.getValue().toString();
                System.out.println(BeginTime);
            }
        });
    }
    private String EndTime = "";
    public void setEndTimeBox() {
        endTimeBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                EndTime = observable.getValue().toString();
                System.out.println(EndTime);
            }
        });
    }
    //Buttons Teacher
    @FXML void teacherAddButton(){
        ObservableList<Teacher> list = FXCollections.observableArrayList(new data.Teacher(teacherNameField.getText(), TeacherGender, TeacherSubject));
       data.Teacher TeacherTotal = new data.Teacher(teacherNameField.getText(), TeacherGender, TeacherSubject);
        System.out.println("TeacherAdd: " + TeacherTotal.getLastName() + " " + TeacherTotal.getGender() + " " + TeacherTotal.getTeacherSubject());
        teachersTable.getItems().addAll(list);

        try {
            File teacherAdd = new File("Teacher.txt");
            FileWriter teacherAddFr = new FileWriter(teacherAdd, true);
            BufferedWriter teacherAddBr = new BufferedWriter(teacherAddFr);
            teacherAddBr.write(teacherNameField.getText() + "," + TeacherGender + "," + TeacherSubject + ":" + "\n");

            teacherAddBr.close();
            teacherAddFr.close();
        }catch (IOException e){

        }
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
        System.out.println("TeacherGenerate");
    }
    //Student
    @FXML void studentAddButton(){
        ObservableList<Student> list1 = FXCollections.observableArrayList(new data.Student(studentNameField.getText(), StudentGroup, StudentGender));
        data.Student StudentTotal = new data.Student(studentNameField.getText(), StudentGender, StudentGroup);
        System.out.println("StudentAdd: " + StudentTotal.getLastName() + " " +  StudentTotal.getGender() + " " +  StudentTotal.getStudentGroup());
        studentsTable.getItems().addAll(list1);

        try {
            File studentAdd = new File("Student.txt");
            FileWriter studentAddFr = new FileWriter(studentAdd, true);
            BufferedWriter studentAddBr = new BufferedWriter(studentAddFr);
            studentAddBr.write(studentNameField.getText() + "," + StudentGender + "," + StudentGroup + ":" + "\n");

            studentAddBr.close();
            studentAddFr.close();
        }catch (IOException e){

        }
    }
    @FXML void studentDeleteButton(){
        ObservableList<Student> list ,list2;
        list=studentsTable.getItems();
        list2=studentsTable.getSelectionModel().getSelectedItems();
        list2.forEach(list::remove);

        try {
            File inputFile = new File("Student.txt");
            File tempFile = new File("StudentTemp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            for (int i = 0; i < studentsTable.getItems().size(); i++){
                writer.write(studentsTable.getItems().get(i).toString());
            }

            writer.close();
            reader.close();

            tempFile.renameTo(inputFile);
        }catch (IOException e) {

        }

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
        //PersonManager
        teacherSubjectBox.setItems(comboTeacherSubject);
        teacherGenderBox.setItems(comboTeacherGender);
        studentGroupBox.setItems(comboStudentGroup);
        studentGenderBox.setItems(comboStudentGender);
        teacherAllNameBox.setItems(comboTeacherNameList);
        //Roster
        studentGroupBoxs.setItems(comboStudentGroup);
        classRoomBox.setItems(comboClassRoom);
        beginTimeBox.setItems(comboBeginTime);
        endTimeBox.setItems(comboEndTime);
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

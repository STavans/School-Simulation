package gui;

import data.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Gui implements Initializable {
    //tableView
    @FXML private TableView<Teacher> teachersTable;
    @FXML private TableView<Student> studentsTable;
    @FXML private TableView<Student> rosterTable;

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
    //new privates colums Teacher
    @FXML private TableColumn<Teacher, String> teacherNameColumn;
    @FXML private TableColumn<Teacher, String> teacherSubjectColumn;
    @FXML private TableColumn<Teacher, String> teacherGenderColumn;
    //Student
    @FXML private TableColumn<Student, String> studentNameColumn;
    @FXML private TableColumn<Student, String> studentGroupColumn;
    @FXML private TableColumn<Student, String> studentGenderColumn;
    //Roster
    @FXML private TableColumn<Lesson, String> rosterTeacherColumn;
    @FXML private TableColumn<Lesson, String> rosterGroupColumn;
    @FXML private TableColumn<Lesson, String> rosterClassRoomColumn;
    @FXML private TableColumn<Lesson, String> rosterBeginTimeColumn;
    @FXML private TableColumn<Lesson, String> rosterEndTimeColumn;
    //textfield
    @FXML private TextField teacherNameField;
    @FXML private TextField studentNameField;
    //ArrayList test
    @FXML private ArrayList<String> RandomTeacher;

    //list PersonManager
    private ObservableList<String> comboTeacherSubject = FXCollections.observableArrayList("OGP", "Math", "OOM", "2D Graphics", "P&OC");
    private ObservableList<String> comboTeacherGender  = FXCollections.observableArrayList("Male", "Female");
    private ObservableList<String> comboStudentGroup   = FXCollections.observableArrayList("A", "B", "C", "D", "E", "F");
    private ObservableList<String> comboStudentGender  = FXCollections.observableArrayList("Male", "Female");
    //Roster
    private ObservableList<String> comboTeacherNameList  = FXCollections.observableArrayList();
    private ObservableList<String> comboClassRoom  = FXCollections.observableArrayList("001","101","202","220");
    private ObservableList<String> comboBeginTime  = FXCollections.observableArrayList("9:00","10:00","11:00","12:00","13:00","14:00","15:00");
    private ObservableList<String> comboEndTime  = FXCollections.observableArrayList("9:50","10:50","11:50","12:50","13:50","14:50","15:50");


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
        teacherSubjectColumn.setCellFactory(ComboBoxTableCell.forTableColumn(comboTeacherSubject));
        teacherGenderColumn.setCellFactory(ComboBoxTableCell.forTableColumn(comboStudentGender));

        teacherNameColumn.setOnEditCommit(event ->
                teachersTable.getItems().get(event.getTablePosition().getRow()).setLastName(event.getNewValue()));
        teacherSubjectColumn.setOnEditCommit(event ->
                teachersTable.getItems().get(event.getTablePosition().getRow()).setSubject(event.getNewValue()));
        teacherGenderColumn.setOnEditCommit(event ->
                teachersTable.getItems().get(event.getTablePosition().getRow()).setGender(event.getNewValue()));
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
        studentsTable.getItems().addAll(list1);


    }
    @FXML void studentDeleteButton(){
        ObservableList<Student> list ,list2;
        list = studentsTable.getItems();
        list2 = studentsTable.getSelectionModel().getSelectedItems();
        list2.forEach(list::remove);
        
    }
    @FXML void studentEditButton(){
        studentsTable.setEditable(true);
        studentNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        studentGroupColumn.setCellFactory(ComboBoxTableCell.forTableColumn(comboStudentGroup));
        studentGenderColumn.setCellFactory(ComboBoxTableCell.forTableColumn(comboStudentGender));

        studentNameColumn.setOnEditCommit((TableColumn.CellEditEvent<Student, String> event) ->
                studentsTable.getItems().get(event.getTablePosition().getRow()).setLastName(event.getNewValue()));
        studentGroupColumn.setOnEditCommit(event ->
                studentsTable.getItems().get(event.getTablePosition().getRow()).setStudentGroup(event.getNewValue()));
        studentGenderColumn.setOnEditCommit(event ->
                studentsTable.getItems().get(event.getTablePosition().getRow()).setGender(event.getNewValue()));
    }
    @FXML void studentSaveButton(){

        System.out.println(studentsTable.getItems());
    }
    @FXML void studentGenerateButton(){
        System.out.println("StudentGenerate");
    }
    //generate
    @FXML void generateMaxButton(){
        System.out.println("GenerateMax");
    }
    //Button Roster
    @FXML void rosterAddButton(){
        ObservableList<Lesson> list = FXCollections.observableArrayList(new data.Lesson(rosterTeacherColumn1, StudentGroups, ClassRoom,BeginTime,EndTime));
       // data.Lesson RosterTotal = new data.Lesson(rosterTeacherColumn1, StudentGroups, ClassRoom,BeginTime,EndTime);
       // System.out.println("TeacherAdd: " + TeacherTotal.getLastName() + " " + TeacherTotal.getGender() + " " + TeacherTotal.getTeacherSubject());
        rosterTable.getItems().addAll(list);
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
        System.out.println("Comboboxes Initialised");

        //Table view working TB = tableview
        teacherGenderColumn.setCellValueFactory(new PropertyValueFactory<>("genderTB"));
        teacherSubjectColumn.setCellValueFactory(new PropertyValueFactory<>("subjectTB"));
        teacherNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastNameTB"));

         //student
        studentGenderColumn.setCellValueFactory(new PropertyValueFactory<>("genderTBST"));
        studentGroupColumn.setCellValueFactory(new PropertyValueFactory<>("GroupTBST"));
        studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastNameTBST"));

        //roster
        rosterTeacherColumn.setCellValueFactory(new PropertyValueFactory<>("teacherTB"));
        rosterGroupColumn.setCellValueFactory(new PropertyValueFactory<>("groupTB"));
        rosterClassRoomColumn.setCellValueFactory(new PropertyValueFactory<>("classRoomTB"));
        rosterBeginTimeColumn.setCellValueFactory(new PropertyValueFactory<>("beginTimeTB"));
        rosterEndTimeColumn.setCellValueFactory(new PropertyValueFactory<>("endTimeTB"));

    }

    //TextFields names
    public void teacherName(){
        System.out.println("TeacherName"); }
    public void studentName(){
        System.out.println("StudentName"); }
}

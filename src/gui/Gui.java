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

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Gui implements Initializable {

    //tableView
    @FXML private TableView<Teacher> teachersTable;
    @FXML private TableView<Student> studentsTable;
    @FXML private TableView<Lesson> rosterTable;

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
    @FXML private TableColumn<Lesson, String> rosterClassroomColumn;
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
    private ObservableList<String> comboTeacherNameList  = FXCollections.observableArrayList("ddddd");
    private ObservableList<String> comboClassRoom  = FXCollections.observableArrayList("001","101","202","220");
    private ObservableList<String> comboBeginTime  = FXCollections.observableArrayList("9:00","10:00","11:00","12:00","13:00","14:00","15:00");
    private ObservableList<String> comboEndTime  = FXCollections.observableArrayList("9:50","10:50","11:50","12:50","13:50","14:50","15:50");


     //to get something out the combobox PersonManager
    private String TeacherSubject = "";
    public void setTeacherSubjectBox() {
        teacherSubjectBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            TeacherSubject = observable.getValue();
            System.out.println(TeacherSubject);
        });
    }

    private String TeacherGender = "";
    public void setTeacherGenderBox() {
        teacherGenderBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            TeacherGender = observable.getValue();
            System.out.println(TeacherGender);
        });
    }

    private String StudentGroup = "";
    public void setStudentGroupBox() {
        studentGroupBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            StudentGroup = observable.getValue();
            System.out.println(StudentGroup);
        });
    }

    private String StudentGender = "";
    public void setStudentGenderBox() {
        studentGenderBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            StudentGender = observable.getValue();
            System.out.println(StudentGender);
        });
    }

    //Roster
    private data.Teacher rosterTeacherColumn1;
    public void setrosterTeacherColumn1() {
        teacherAllNameBox.valueProperty().addListener((observable, oldValue, newValue) -> {
           String rosterTeacherColumn1 = observable.getValue();
            System.out.println(rosterTeacherColumn1);
        });
    }

    private data.Group StudentGroups;
    public void setStudentGroupBoxs() {
        studentGroupBoxs.valueProperty().addListener((observable, oldValue, newValue) -> {
           String StudentGroups = observable.getValue();
            System.out.println(StudentGroups);
        });
    }

    private data.Room ClassRoom;
    public void setClassRoomBox() {
        classRoomBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            String ClassRoom = observable.getValue();
            System.out.println(ClassRoom);
        });
    }

    private String BeginTime = "";
    public void setBeginTimeBox() {
        beginTimeBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            BeginTime = observable.getValue();
            System.out.println(BeginTime);
        });
    }

    private String EndTime = "";
    public void setEndTimeBox() {
        endTimeBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            EndTime = observable.getValue();
            System.out.println(EndTime);
        });
    }

    //Buttons Teacher
    @FXML void teacherAddButton(){
        ObservableList<Teacher> list = FXCollections.observableArrayList(new data.Teacher(teacherNameField.getText(), TeacherGender, TeacherSubject));
        data.Teacher TeacherTotal = new data.Teacher(teacherNameField.getText(), TeacherGender, TeacherSubject);

        System.out.println("TeacherAdd: " + TeacherTotal.getLastName() + " " + TeacherTotal.getGender() + " " + TeacherTotal.getTeacherSubject());
        teachersTable.getItems().addAll(list);

        try {
            File teacherAdd = new File("Student.txt");
            FileWriter teacherAddFr = new FileWriter(teacherAdd, true);
            BufferedWriter teacherAddBr = new BufferedWriter(teacherAddFr);
            teacherAddBr.write(studentNameField.getText() + "," + StudentGender + "," + StudentGroup + "\n");

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

        try {
            File inputFile = new File("Teacher.txt");
            File tempFile = new File("TeacherTemp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            for (int i = 0; i < teachersTable.getItems().size(); i++){
                writer.write(teachersTable.getItems().get(i).toString());
            }

            writer.close();
            reader.close();

            inputFile.delete();
            tempFile.renameTo(new File("Teacher.txt"));
        }catch (IOException e) {

        }

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
        comboTeacherNameList.add("Bartinos");
    }

    @FXML void teacherGenerateButton(){
        System.out.println("TeacherGenerate");
    }

    //Student
    @FXML void studentAddButton(){
        ObservableList<Student> list1 = FXCollections.observableArrayList(new data.Student(studentNameField.getText(), StudentGroup, StudentGender));
        studentsTable.getItems().addAll(list1);

        try {
            File studentAdd = new File("Student.txt");
            FileWriter studentAddFr = new FileWriter(studentAdd, true);
            BufferedWriter studentAddBr = new BufferedWriter(studentAddFr);
            studentAddBr.write("name: " + studentNameField.getText() + "," + "group: " + StudentGroup + "," + "gender: " + StudentGender + "\n");

            studentAddBr.close();
            studentAddFr.close();
        }catch (IOException e){

        }
    }

    @FXML void studentDeleteButton(){
        ObservableList<Student> list ,list2;
        list = studentsTable.getItems();
        list2 = studentsTable.getSelectionModel().getSelectedItems();
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

            inputFile.delete();
            tempFile.renameTo(new File("Student.txt"));
        }catch (IOException e) {

        }
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
        rosterTable.getItems().addAll(list);

        try {
            File RosterAdd = new File("Roster.txt");
            FileWriter rosterAddFr = new FileWriter(RosterAdd, true);
            BufferedWriter rosterAddBr = new BufferedWriter(rosterAddFr);
            rosterAddBr.write("name: " + rosterTeacherColumn1 + "," + "group: " + StudentGroups + "," + "classroom: " + ClassRoom + "," + "begin time: " + BeginTime + "," + "end time: " + EndTime + "\n");

            rosterAddBr.close();
            rosterAddFr.close();
        }catch (IOException e){

        }
    }
    @FXML void rosterDeleteButton(){
        System.out.println("doet het");
    }

    @FXML void rosterEditButton(){
        System.out.println("doet het");
    }

    @FXML void rosterSaveButton(){
        System.out.println("doet het");
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
       // rosterTeacherColumn.setCellValueFactory(new PropertyValueFactory<>("teacherTB"));
        rosterGroupColumn.setCellValueFactory(new PropertyValueFactory<>("groupTB"));
        rosterClassroomColumn.setCellValueFactory(new PropertyValueFactory<>("classRoomTB"));
        rosterBeginTimeColumn.setCellValueFactory(new PropertyValueFactory<>("beginTimeTB"));
        rosterEndTimeColumn.setCellValueFactory(new PropertyValueFactory<>("endTimeTB"));
    }

    //TextFields names
    public void teacherName(){
        System.out.println("TeacherName"); }

    public void studentName(){
        System.out.println("StudentName"); }
}

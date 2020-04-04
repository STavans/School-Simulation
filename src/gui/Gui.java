package gui;

import data.*;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import tileMap.SimulationController;
import warningSign.ErrorMessage;

import java.io.*;
import java.net.URL;
import java.util.*;

import static javafx.collections.FXCollections.observableArrayList;

public class Gui implements Initializable {
    int i = 0;
    int A = 0;
    int B = 0;
    int C = 0;
    int D = 0;
    int E = 0;
    int F = 0;
    SimulationController simulationController = new SimulationController();
    ErrorMessage errorMessage = new ErrorMessage();
    ArrayList<String> Teachersize = new ArrayList();
    ArrayList<String> Studentsize = new ArrayList();
    ArrayList<String> Groupsize = new ArrayList();
    //tableView
    @FXML
    private TableView<Teacher> teachersTable;
    @FXML
    private TableView<Student> studentsTable;
    @FXML
    private TableView<Lesson> rosterTable;

    //ComboBox
    @FXML
    private ComboBox<String> teacherSubjectBox;//1
    @FXML
    private ComboBox<String> teacherGenderBox;//2
    @FXML
    private ComboBox<Group> studentGroupBox;//3
    @FXML
    private ComboBox<String> studentGenderBox;//4
    @FXML
    private ComboBox<Teacher> teacherAllNameBox;//5
    @FXML
    private ComboBox<Group> studentGroupBoxs;//6
    @FXML
    private ComboBox<String> beginTimeBox;//7
    @FXML
    private ComboBox<String> endTimeBox;//8
    @FXML
    private ComboBox<Classroom> classRoomBox;//8
    @FXML
    private ComboBox<String> simulationSettingTimeCombo;//9

    //new privates colums Teacher
    @FXML
    private TableColumn<Teacher, String> teacherNameColumn;
    @FXML
    private TableColumn<Teacher, String> teacherSubjectColumn;
    @FXML
    private TableColumn<Teacher, String> teacherGenderColumn;

    //Student
    @FXML
    private TableColumn<Student, String> studentNameColumn;
    @FXML
    private TableColumn<Student, Group> studentGroupColumn;
    @FXML
    private TableColumn<Student, String> studentGenderColumn;

    //Roster
    @FXML
    private TableColumn<Lesson, Teacher> rosterTeacherColumn;
    @FXML
    private TableColumn<Lesson, String> rosterSubjectColumn;
    @FXML
    private TableColumn<Lesson, Group> rosterGroupColumn;
    @FXML
    private TableColumn<Lesson, Classroom> rosterClassroomColumn;
    @FXML
    private TableColumn<Lesson, String> rosterBeginTimeColumn;
    @FXML
    private TableColumn<Lesson, String> rosterEndTimeColumn;

    //textfield
    @FXML
    private TextField teacherNameField;
    @FXML
    private TextField studentNameField;

    private HashSet<Group> groupSet = new HashSet<>();
    private FileIO fileIO = new FileIO();

    //Groups
    private Group groupA = new Group("A");
    private Group groupB = new Group("B");
    private Group groupC = new Group("C");
    private Group groupD = new Group("D");
    private Group groupE = new Group("E");
    private Group groupF = new Group("F");

    private Classroom classroom101 = new Classroom("101");
    private Classroom classroom102 = new Classroom("102");
    private Classroom classroom103 = new Classroom("103");
    private Classroom classroom104 = new Classroom("104");
    private Classroom classroom105 = new Classroom("105");
    private Classroom classroom106 = new Classroom("106");

    //list PersonManager
    private ObservableList<String> comboTeacherSubject = observableArrayList("OGP", "Math", "OOM", "2D Graphics", "P&OC");
    private ObservableList<String> comboTeacherGender = observableArrayList("Male", "Female");
    private ObservableList<Group> comboStudentGroup = observableArrayList(groupA, groupB, groupC, groupD, groupE, groupF);
    private ObservableList<String> comboStudentGender = observableArrayList("Male", "Female");

    //Settings
    private ObservableList<String> comboTimeSetting = observableArrayList("x0,5", "x1", "x2", "x4", "x8");

    //Roster
    private ObservableList<Teacher> comboTeacherNameList = observableArrayList();
    private ObservableList<Group> comboStudentGroupRoster = observableArrayList();
    private ObservableList<Classroom> comboClassroom = observableArrayList(classroom101, classroom102, classroom103, classroom104, classroom105, classroom106);
    private ObservableList<String> comboBeginTime = observableArrayList("9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00");
    private ObservableList<String> comboEndTime = observableArrayList("9:30", "10:30", "11:30", "12:30", "13:30", "14:30", "15:30");


    //to get something out the combobox PersonManager
    private String TeacherSubject = "";

    @SuppressWarnings("Duplicates")
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            studentsTable.setItems(fileIO.getStudents());
            teachersTable.setItems(fileIO.getTeachers());
            rosterTable.setItems(fileIO.getLessons());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Missing data to load");
        }

        for (Student student : studentsTable.getItems()) {
            groupSet.add(student.getStudentGroup());
        }
        comboStudentGroupRoster.setAll(groupSet);
        studentGroupBoxs.setItems(comboStudentGroupRoster);
        System.out.println(groupSet);

        //PersonManager
        teacherSubjectBox.setItems(comboTeacherSubject);
        teacherGenderBox.setItems(comboTeacherGender);
        studentGroupBox.setItems(comboStudentGroup);
        studentGenderBox.setItems(comboStudentGender);

        //Settings
        simulationSettingTimeCombo.setItems(comboTimeSetting);

        //Roster
        teacherAllNameBox.setItems(teachersTable.getItems());
        classRoomBox.setItems(comboClassroom);
        beginTimeBox.setItems(comboBeginTime);
        endTimeBox.setItems(comboEndTime);
        System.out.println("Comboboxes Initialised");

        //Table view working TB = tableview
        teacherGenderColumn.setCellValueFactory(new PropertyValueFactory<>("genderTB"));
        teacherSubjectColumn.setCellValueFactory(new PropertyValueFactory<>("subjectTB"));
        teacherNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastNameTB"));

        //student
        studentGenderColumn.setCellValueFactory(new PropertyValueFactory<>("genderTBST"));
        studentGroupColumn.setCellValueFactory(new PropertyValueFactory<>("groupTBST"));
        studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastNameTBST"));

        //roster
        rosterTeacherColumn.setCellValueFactory(new PropertyValueFactory<>("teacherTB"));
        rosterSubjectColumn.setCellValueFactory(new PropertyValueFactory<>("subjectTB"));
        rosterGroupColumn.setCellValueFactory(new PropertyValueFactory<>("groupTB"));
        rosterClassroomColumn.setCellValueFactory(new PropertyValueFactory<>("classRoomTB"));
        rosterBeginTimeColumn.setCellValueFactory(new PropertyValueFactory<>("beginTimeTB"));
        rosterEndTimeColumn.setCellValueFactory(new PropertyValueFactory<>("endTimeTB"));

        teachersTable.getItems().addListener((ListChangeListener<Teacher>) c -> {
            comboTeacherNameList = teachersTable.getItems();
            teacherAllNameBox.setItems(comboTeacherNameList);
        });
        studentsTable.getItems().addListener((ListChangeListener<Student>) c -> {
            groupSet.clear();
            for (Student student : studentsTable.getItems()) {
                groupSet.add(student.getStudentGroup());
            }
            comboStudentGroupRoster.clear();
            comboStudentGroupRoster.addAll(groupSet);
            studentGroupBoxs.setItems(comboStudentGroupRoster);
        });
    }

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

    private Group StudentGroup;

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
    private Teacher rosterTeacherColumn1;

    public void setrosterTeacherColumn1() {
        teacherAllNameBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            rosterTeacherColumn1 = observable.getValue();
            System.out.println(rosterTeacherColumn1);
        });
    }

    private data.Group StudentGroups;

    public void setStudentGroupBoxs() {
        studentGroupBoxs.valueProperty().addListener((observable, oldValue, newValue) -> {
            StudentGroups = observable.getValue();
            System.out.println(StudentGroups);
        });
    }

    private Classroom ClassRoom;

    public void setClassRoomBox() {
        classRoomBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            ClassRoom = observable.getValue();
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

    private String TimeSetting = "";
    private int timeSettingValue = 1;

    public void setSimulationSettingTimeCombo() {
        simulationSettingTimeCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
            TimeSetting = observable.getValue();
            System.out.println(TimeSetting);

            if(TimeSetting.equals("x0,5")){
                timeSettingValue = 5;
            } else if (TimeSetting.equals("x2")) {
                timeSettingValue = 2;
            } else if (TimeSetting.equals("x4")) {
                timeSettingValue = 4;
            } else if (TimeSetting.equals("x8")) {
                timeSettingValue = 8;
            } else {
                timeSettingValue = 1;
            }
            System.out.println(timeSettingValue);
        });
    }

    public int getSimulationSettingTimeCombo() {
        return this.timeSettingValue;
    }

    private String EndTime = "";

    public void setEndTimeBox() {
        endTimeBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            EndTime = observable.getValue();
            System.out.println(EndTime);
        });
    }

    //Buttons Teacher
    @FXML
    void teacherAddButton() {
        ObservableList<Teacher> list = observableArrayList(new data.Teacher(teacherNameField.getText(), TeacherGender, TeacherSubject, null));
        data.Teacher TeacherTotal = new data.Teacher(teacherNameField.getText(), TeacherGender, TeacherSubject, null);
        if(teacherNameField.getText().isEmpty()) {
            errorMessage.showError("Not all attributes are filled. Please make sure all attributes are filled.");
        }
        else if(Teachersize.size() >= 6) {
            errorMessage.showError("Sorry to much!");
        }
        else if(Teachersize.contains(teacherNameField.getText())) {
            errorMessage.showError("This teacher already excist ");
        }
        else if(teacherNameField.getText().matches(".*[^a-zA-Z].*")) {
            errorMessage.showError("Teacher name contains non Alphabetic characters: please use only Alphabetic characters ");
        }
        else if(TeacherGender.isEmpty()) {
            errorMessage.showError("Not all attributes are filled. Please make sure all attributes are filled.");
        }
        else if(TeacherSubject.isEmpty()) {
            errorMessage.showError("Not all attributes are filled. Please make sure all attributes are filled.");
        }
        else {
            teachersTable.getItems().addAll(list);
            Teachersize.add(teacherNameField.getText());
        }
    }

    @FXML
    void teacherDeleteButton() {
        ObservableList<Teacher> list, list2;
        list = teachersTable.getItems();
        list2 = teachersTable.getSelectionModel().getSelectedItems();
        list2.forEach(list::remove);
    }

    @FXML
    void teacherEditButton() {
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

    @FXML
    void teacherSaveButton() {
        System.out.println("TeacherSave");
    }

    @FXML
    void teacherGenerateButton() {
        System.out.println("TeacherGenerate");
    }

    //Student
    @FXML
    void studentAddButton() {
        ObservableList<Student> list1 = observableArrayList(new data.Student(studentNameField.getText(), StudentGroup, StudentGender,null));
        if (Groupsize.isEmpty()) {
            i = 0;
        }
       else if (Groupsize.get(i).equals("Group A")) {
            A++; i++;
        }
       else if (Groupsize.get(i).equals("Group B")) {
            B++; i++;
        }
       else if (Groupsize.get(i).equals("Group C")) {
            C++; i++;
        }
       else if (Groupsize.get(i).equals("Group D")) {
            D++;i++;
        }
        else if (Groupsize.get(i).equals("Group E")) {
            E++; i++;
        }
        else if (Groupsize.get(i).equals("Group F")) {
            F++; i++;
        }

        if(studentNameField.getText().matches(".*[^a-zA-Z].*")) {
            errorMessage.showError("Student name contains non Alphabetic characters: please use only alphabetic characters ");
        }
        else if(Studentsize.size() >= 72) {
            errorMessage.showError("Sorry to much students!");
        }
        else if(A >= 6||B >= 6||C >= 6||D >= 6||E >= 6||F >= 6) {
            errorMessage.showError("Sorry to much students in the group!");
        }
        else if(studentNameField.getText().isEmpty()) {
            errorMessage.showError("Not all attributes are filled. Please make sure all attributes are filled.");
        }
        else if(StudentGender.isEmpty()) {
            errorMessage.showError("Not all attributes are filled. Please make sure all attributes are filled.");
        }
        else if(StudentGroup == null) {
            errorMessage.showError("Not all attributes are filled. Please make sure all attributes are filled.");
        }
        else {
            studentsTable.getItems().addAll(list1);
            Studentsize.add(studentNameField.getText());
            Groupsize.add(StudentGroup.toString());
        }
    }

    @FXML
    void studentDeleteButton() {
        ObservableList<Student> list, list2;
        list = studentsTable.getItems();
        list2 = studentsTable.getSelectionModel().getSelectedItems();
        list2.forEach(list::remove);

    }

    @FXML
    void studentEditButton() {
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

    @FXML
    void studentSaveButton() {
        System.out.println(studentsTable.getItems());
    }

    @FXML
    void studentGenerateButton() {
        System.out.println("StudentGenerate");
    }

    //generate
    @FXML
    void generateMaxButton() {
        System.out.println("GenerateMax");
    }

    //Button Roster
    @FXML
    void rosterAddButton() {
        ObservableList<Lesson> list = observableArrayList(new data.Lesson(rosterTeacherColumn1, StudentGroups, ClassRoom, BeginTime, EndTime));
        System.out.println(rosterTeacherColumn1 + " " + StudentGroups + " " + ClassRoom + " " + BeginTime + " " + EndTime);
            if (comboEndTime.indexOf(EndTime) < comboBeginTime.indexOf(BeginTime)) {
                errorMessage.showError("Can't add a new lesson: please select a chronological time order.");
            } else if (rosterTeacherColumn1 == null) {
                errorMessage.showError("Not all attributes are filled. Please make sure all attributes are filled.");
            } else if (StudentGroups == null) {
                errorMessage.showError("Not all attributes are filled. Please make sure all attributes are filled.");
            } else if (ClassRoom == null) {
                errorMessage.showError("Not all attributes are filled. Please make sure all attributes are filled.");
            } else if (BeginTime.isEmpty()) {
                errorMessage.showError("Not all attributes are filled. Please make sure all attributes are filled.");
            } else if (EndTime.isEmpty()) {
                errorMessage.showError("Not all attributes are filled. Please make sure all attributes are filled.");
            } else {
                rosterTable.getItems().addAll(list);
            }
}
    @FXML
    void rosterDeleteButton() {
        ObservableList<Lesson> list, list2;
        list = rosterTable.getItems();
        list2 = rosterTable.getSelectionModel().getSelectedItems();
        list2.forEach(list::remove);
    }

    @FXML
    void rosterEditButton() {
        rosterTable.setEditable(true);
        rosterTeacherColumn.setCellFactory(ComboBoxTableCell.forTableColumn(comboTeacherNameList));
        rosterSubjectColumn.setCellFactory(ComboBoxTableCell.forTableColumn(comboTeacherSubject));
        rosterGroupColumn.setCellFactory(ComboBoxTableCell.forTableColumn(comboStudentGroupRoster));
        rosterClassroomColumn.setCellFactory(ComboBoxTableCell.forTableColumn(comboClassroom));
        rosterBeginTimeColumn.setCellFactory(ComboBoxTableCell.forTableColumn(comboBeginTime));
        rosterEndTimeColumn.setCellFactory(ComboBoxTableCell.forTableColumn(comboEndTime));

        rosterTeacherColumn.setOnEditCommit(event ->
                rosterTable.getItems().get(event.getTablePosition().getRow()).setTeacher(event.getNewValue()));
        rosterSubjectColumn.setOnEditCommit(event ->
                rosterTable.getItems().get(event.getTablePosition().getRow()).setSubject(event.getNewValue()));
        rosterGroupColumn.setOnEditCommit(event ->
                rosterTable.getItems().get(event.getTablePosition().getRow()).setGroup(event.getNewValue()));
        rosterClassroomColumn.setOnEditCommit(event ->
                rosterTable.getItems().get(event.getTablePosition().getRow()).setClassroom(event.getNewValue()));
        rosterBeginTimeColumn.setOnEditCommit(event ->
                rosterTable.getItems().get(event.getTablePosition().getRow()).setBeginLesson(event.getNewValue()));
        rosterEndTimeColumn.setOnEditCommit(event ->
                rosterTable.getItems().get(event.getTablePosition().getRow()).setEndLesson(event.getNewValue()));
    }

    @FXML
    void rosterSaveButton() {
    }

    //TextFields names
    public void teacherName() {
        System.out.println("TeacherName");
    }

    public void studentName() {
        System.out.println("StudentName");
    }

    public void save() {
        try {
            fileIO.writeAll(studentsTable.getItems(), teachersTable.getItems(), rosterTable.getItems());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void simulationStartButton() {
        save();
        try {
            simulationController.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to start simulation");
        }
    }
}

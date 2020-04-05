package data;

import data.Student;
import data.Teacher;
import data.Lesson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static javafx.collections.FXCollections.observableArrayList;


@SuppressWarnings("Duplicates")
public class FileIO {
    private Scanner scanner;
    private File file;
    private FileWriter fileWriter;

    public FileIO() {

    }

    public void writeAll(ObservableList<Student> obStudents, ObservableList<Teacher> obTeachers, ObservableList<Lesson> obLessons, double timeSettingValue) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/SaveFile.txt"));

        ArrayList<Student> allStudents = new ArrayList<>(obStudents);
        ArrayList<Teacher> allTeachers = new ArrayList<>(obTeachers);
        ArrayList<Lesson> allLessons = new ArrayList<>(obLessons);

        oos.writeObject(allStudents);
        oos.writeObject(allTeachers);
        oos.writeObject(allLessons);
        oos.writeDouble(timeSettingValue);

        oos.close();
    }

    public ObservableList getStudents() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/SaveFile.txt"));
        ArrayList<Student> loadedStudents = (ArrayList<Student>) ois.readObject();
        ObservableList<Student> ObsStudents = observableArrayList(loadedStudents);
        ois.close();
        return ObsStudents;

    }

    public ObservableList getTeachers() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/SaveFile.txt"));
        ois.readObject();
        ArrayList<Teacher> loadedTeachers = (ArrayList<Teacher>) ois.readObject();
        ObservableList<Teacher> ObsTeachers = observableArrayList(loadedTeachers);
        ois.close();
        return ObsTeachers;
    }

    public ObservableList getLessons() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/SaveFile.txt"));
        ois.readObject();
        ois.readObject();
        ArrayList<Lesson> loadedLessons = (ArrayList<Lesson>) ois.readObject();
        ObservableList<Lesson> ObsLessons = observableArrayList(loadedLessons);
        ois.close();
        return ObsLessons;
    }

    public double getTimeSettingValue() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/SaveFile.txt"));
        ois.readObject();
        ois.readObject();
        ois.readObject();
        double timeSettingValue = ois.readDouble();
        ois.close();
        return timeSettingValue;
    }
}

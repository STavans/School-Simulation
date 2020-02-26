package gui;

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

    public void writeAll(ObservableList<Student> obStudents, ObservableList<Teacher> obTeachers, ObservableList<Lesson> obLessons) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/SaveFile"));

        ArrayList<Student> allStudents = new ArrayList<>(obStudents);
        ArrayList<Teacher> allTeachers = new ArrayList<>(obTeachers);
        ArrayList<Lesson> allLessons = new ArrayList<>(obLessons);

        oos.writeObject(allStudents);
        oos.writeObject(allTeachers);
        oos.writeObject(allLessons);

        oos.close();
    }

    public ObservableList getStudents() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/SaveFile"));
        ArrayList<Student> loadedStudents = (ArrayList<Student>) ois.readObject();
        ObservableList<Student> ObsStudents = observableArrayList(loadedStudents);
        ois.close();
        return ObsStudents;

    }

    public ObservableList getTeachers() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/SaveFile"));
        ois.readObject();
        ArrayList<Teacher> loadedTeachers = (ArrayList<Teacher>) ois.readObject();
        ObservableList<Teacher> ObsTeachers = observableArrayList(loadedTeachers);
        ois.close();
        return ObsTeachers;
    }

    public ObservableList getLessons() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/SaveFile"));
        ois.readObject();
        ois.readObject();
        ArrayList<Lesson> loadedLessons = (ArrayList<Lesson>) ois.readObject();
        ObservableList<Lesson> ObsLessons = observableArrayList(loadedLessons);
        ois.close();
        return ObsLessons;
    }
}

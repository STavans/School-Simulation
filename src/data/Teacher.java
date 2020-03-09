package data;

import javafx.beans.property.SimpleStringProperty;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Teacher extends Person implements Serializable {

    private String subject;
    private transient SimpleStringProperty subjectTB;
    private transient SimpleStringProperty genderTB;
    private transient SimpleStringProperty lastNameTB;

    public Teacher (String lastName,String gender,String TeacherSubject) {
        super(gender, lastName);
        this.subject = TeacherSubject;

        subjectTB = new SimpleStringProperty(TeacherSubject);
        genderTB = new SimpleStringProperty(gender);
        lastNameTB = new SimpleStringProperty(lastName);
    }

    public void setTeacherSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacherSubject() {
        return subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubjectTB() {
        return subjectTB.get();
    }

    public SimpleStringProperty subjectTBProperty() {
        return subjectTB;
    }

    public void setSubjectTB(String subjectTB) {
        this.subjectTB.set(subjectTB);
    }

    public String getGenderTB() {
        return genderTB.get();
    }

    public SimpleStringProperty genderTBProperty() {
        return genderTB;
    }

    public void setGenderTB(String genderTB) {
        this.genderTB.set(genderTB);
    }

    public String getLastNameTB() {
        return lastNameTB.get();
    }

    public SimpleStringProperty lastNameTBProperty() {
        return lastNameTB;
    }

    public void setLastNameTB(String lastNameTB) {
        this.lastNameTB.set(lastNameTB);
    }

    @Override
    public String toString() {
        return getLastName();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeUTF(subjectTB.get());
        oos.writeUTF(genderTB.get());
        oos.writeUTF(lastNameTB.get());
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        subjectTB = new SimpleStringProperty(ois.readUTF());
        genderTB = new SimpleStringProperty(ois.readUTF());
        lastNameTB = new SimpleStringProperty(ois.readUTF());
    }


    @Override
    public void update(ArrayList<Person> people) {

    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public void setTarget(Point2D point2D) {

    }

    @Override
    public Point2D getPosition() {
        return null;
    }

    @Override
    public void setPosition(Point2D position) {

    }
}

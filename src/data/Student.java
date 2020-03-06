package data;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Student extends Person implements Serializable {

   // private String firstName;
    private Group group;
    private transient SimpleObjectProperty groupTBST;
    private transient SimpleStringProperty genderTBST;
    private transient SimpleStringProperty lastNameTBST;

    public Student(String lastName, Group group, String gender) {
        super(gender,lastName);
        this.group = group;
        groupTBST = new SimpleObjectProperty(group);
        genderTBST = new SimpleStringProperty(gender);
        lastNameTBST = new SimpleStringProperty(lastName);

    }

    public Group getStudentGroup() { return group;}

    public void setStudentGroup(Group group) {this.group = group;}

    public Group getGroupTBST() {
        return (Group) this.groupTBST.get();
    }

    public SimpleObjectProperty groupTBProperty() {
        return groupTBST;
    }

    public void setGroupTBST(String groupTBST) {
        this.groupTBST.set(groupTBST);
    }

    public String getGenderTBST() {
        return genderTBST.get();
    }

    public SimpleStringProperty genderTBPSTroperty() {
        return genderTBST;
    }

    public void setGenderTBST(String genderTBST) {
        this.genderTBST.set(genderTBST);
    }

    public String getLastNameTBST() {
        return lastNameTBST.get();
    }

    public SimpleStringProperty lastNameTBPSTroperty() { return lastNameTBST; }

    public void setLastNameTBST(String lastNameTBST) {
        this.lastNameTBST.set(lastNameTBST);
    }

    @Override
    public String toString() {
        return "name: " + this.lastNameTBST.get() + ", group: " + this.groupTBST.get() + ", gender: " + this.genderTBST.get();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(groupTBST.get());
        oos.writeUTF(genderTBST.get());
        oos.writeUTF(lastNameTBST.get());
    }
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        groupTBST = new SimpleObjectProperty(ois.readObject());
        genderTBST = new SimpleStringProperty(ois.readUTF());
        lastNameTBST = new SimpleStringProperty(ois.readUTF());
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {

    }
}

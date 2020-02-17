package data;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student extends Person {

   // private String firstName;
    private Group group;
    private SimpleObjectProperty groupTBST;
    private SimpleStringProperty genderTBST;
    private SimpleStringProperty lastNameTBST;

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
        return "name: " + this.getLastName() + ", group: " + this.getStudentGroup() + ", gender: " + this.getGender();
    }
}

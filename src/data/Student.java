package data;

import javafx.beans.property.SimpleStringProperty;

public class Student extends Person {
   // private String firstName;
    private String Group;
    private SimpleStringProperty groupTBST;
    private SimpleStringProperty genderTBST;
    private SimpleStringProperty lastNameTBST;

    public Student(String lastName, String Group, String gender) {
        super(gender,lastName);
        this.Group = Group;
        groupTBST = new SimpleStringProperty(Group);
        genderTBST = new SimpleStringProperty(gender);
        lastNameTBST = new SimpleStringProperty(lastName);

    }
    public String getStudentGroup() { return Group;}

    public void setStudentGroup(String Group) {
        this.Group=Group;
    }

    public String getGroupTBST() {
        return groupTBST.get();
    }

    public SimpleStringProperty groupTBProperty() {
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
        return "name: " + this.getLastName() + ", group: " + this.getStudentGroup()+ ", gender: " + this.getGender();
    }
}

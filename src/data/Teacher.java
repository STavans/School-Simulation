package data;

import javafx.beans.property.SimpleStringProperty;

public class Teacher extends Person {

    private String subject;
    private SimpleStringProperty subjectTB;
    private SimpleStringProperty genderTB;
    private SimpleStringProperty lastNameTB;

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
}

package data;

public class Teacher extends Person {
    private String subject;

    public Teacher (String TeacherSubject,String gender) {
        super(gender);
        this.subject = TeacherSubject;

    }

    public void setTeacherSubject(String subject) {
        this.subject = subject;
    }
    public String getTeacherSubject() {
        return subject;
    }
}

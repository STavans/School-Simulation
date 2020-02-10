package data;

public class Teacher extends Person {
    private String subject;

    public Teacher (String name, boolean gender, String subject) {
        super(name, gender);
        this.subject = subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getSubject() {
        return subject;
    }
}

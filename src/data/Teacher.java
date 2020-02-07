package data;

public class Teacher extends Person {
    private String subject;

    public Teacher (String subject,String gender) {
        super(gender);
        this.subject = subject;

    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getSubject() {
        return subject;
    }
}

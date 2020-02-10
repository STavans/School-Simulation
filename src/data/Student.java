package data;

public class Student extends Person {
    private String firstName;


    public Student(String gender,String lastName) {
        super(gender,lastName);
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}

package data;

public class Student extends Person {
   // private String firstName;
    private String Group;


    public Student(String lastName,String gender,String Group) {
        super(gender,lastName);
        this.Group=Group;
    }
   // public String getFirstName() {
   //     return firstName;
   // }
   // public void setFirstName(String firstName) {
   //     this.firstName = firstName;
  //  }
    public String getStudentGroup() { return Group;}
    public void setStudentGroup(String Group) {this.Group=Group;}
}

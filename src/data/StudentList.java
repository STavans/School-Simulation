package data;

import java.util.ArrayList;

public class StudentList {
    ArrayList<Student> allStudents;

    public StudentList() {
        this.allStudents = new ArrayList<>();
    }

    public ArrayList<Student> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(ArrayList<Student> allStudents) {
        this.allStudents = allStudents;
    }
    public void addStudent(Student student){
        this.allStudents.add(student);
    }
    public void removeStudent(Student student){
        this.allStudents.remove(student);
    }
    public void print(){
        for (Student student: this.allStudents) {
            System.out.println(student);
        }
    }
    public ArrayList<String> getAllStudentNames(){
        ArrayList<String> names = new ArrayList<>();
        for (Student student: allStudents) {
            names.add(student.getLastName());
        }
        return names;
    }
}

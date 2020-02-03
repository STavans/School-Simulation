package data;

import java.util.ArrayList;

public abstract class Person {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;


    public Person() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public void addStudents(Student student){
       this.students.add(student);
    }

    public void addTeachers(Teacher teacher){
        this.teachers.add(teacher);
    }
}


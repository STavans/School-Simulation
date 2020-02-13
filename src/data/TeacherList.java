package data;

import java.util.ArrayList;

public class TeacherList {
    private ArrayList<Teacher> allTeachers;

    public TeacherList() {
        this.allTeachers = new ArrayList<>();
    }

    public ArrayList<Teacher> getAllTeachers() {
        return allTeachers;
    }

    public void setAllTeachers(ArrayList<Teacher> allTeachers) {
        this.allTeachers = allTeachers;
    }

    public void addTeacher(Teacher teacher){
        allTeachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher){
        allTeachers.remove(teacher);
    }
    public void print(){
        for (Teacher teacher: this.allTeachers) {
            System.out.println(teacher);
        }
    }

}

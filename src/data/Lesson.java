package data;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Lesson {
    private String beginLesson;
    private String endLesson;
    private String subject;
    //private Room name;
    private String classRoom;
    private String code;
   // private Group amount;
    private Teacher teacher;
   //private Student firstName;
    private Group group;
    private Classroom classroom;

    private SimpleObjectProperty teacherTB;
    private SimpleObjectProperty groupTB;
    private SimpleObjectProperty classRoomTB;
    private SimpleStringProperty beginLessonTB;
    private SimpleStringProperty endLessonTB;


    public Lesson (Teacher teacher, Group group, Classroom classroom ,String beginLesson, String endLesson) {
        this.teacher = teacher;
        this.group = group;
        this.classroom = classroom;
        this.beginLesson = beginLesson;
        this.endLesson = endLesson;

        teacherTB = new SimpleObjectProperty(this.teacher);
        groupTB = new SimpleObjectProperty(this.group);
        classRoomTB = new SimpleObjectProperty(this.classroom);
        beginLessonTB = new SimpleStringProperty(this.beginLesson);
        endLessonTB = new SimpleStringProperty(this.endLesson);

    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBeginLesson() {
        return beginLesson;
    }

    public void setBeginLesson(String beginLesson) {
        this.beginLesson = beginLesson;
    }

    public String getEndLesson() {
        return endLesson;
    }

    public void setEndLesson(String endLesson) {
        this.endLesson = endLesson;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getBeginLessonTB() {
        return beginLessonTB.get();
    }

    public SimpleStringProperty beginLessonTBProperty() {
        return beginLessonTB;
    }

    public void setBeginLessonTB(String beginLessonTB) {
        this.beginLessonTB.set(beginLessonTB);
    }

    public String getEndLessonTB() {
        return endLessonTB.get();
    }

    public SimpleStringProperty endLessonTBProperty() {
        return endLessonTB;
    }

    public void setEndLessonTB(String endLessonTB) {
        this.endLessonTB.set(endLessonTB);
    }

    public Classroom getClassRoomTB() {
        return (Classroom) classRoomTB.get();
    }

    public SimpleObjectProperty classRoomTBProperty() {
        return classRoomTB;
    }

    public void setClassRoomTB(Classroom classRoomTB) {
        this.classRoomTB.set(classRoomTB);
    }

    public Group getGroupTB() {
        return (Group) groupTB.get();
    }

    public SimpleObjectProperty groupTBProperty() {
        return groupTB;
    }

    public void setGroupTB(Group groupTB) {
        this.groupTB.set(groupTB);
    }

    public Teacher getTeacherTB() {
        return (Teacher) teacherTB.get();
    }

    public SimpleObjectProperty teacherTBProperty() {
        return teacherTB;
    }

    public void setTeacherTB(Teacher teacherTB) {
        this.teacherTB.set(teacherTB);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}

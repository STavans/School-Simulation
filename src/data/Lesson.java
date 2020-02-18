package data;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Lesson {

    private Teacher teacher;
    private String subject;
    private Group group;
    private Classroom classroom;
    private String beginTime;
    private String endTime;

    private SimpleObjectProperty teacherTB;
    private SimpleStringProperty subjectTB;
    private SimpleObjectProperty groupTB;
    private SimpleObjectProperty classRoomTB;
    private SimpleStringProperty beginTimeTB;
    private SimpleStringProperty endTimeTB;


    public Lesson (Teacher teacher, Group group, Classroom classroom, String beginTime, String endTime) {
        this.teacher = teacher;
        this.group = group;
        this.classroom = classroom;
        this.beginTime = beginTime;
        this.endTime = endTime;

        teacherTB = new SimpleObjectProperty(this.teacher);
        groupTB = new SimpleObjectProperty(this.group);
        subjectTB = new SimpleStringProperty(this.teacher.getTeacherSubject());
        classRoomTB = new SimpleObjectProperty(this.classroom);
        beginTimeTB = new SimpleStringProperty(this.beginTime);
        endTimeTB = new SimpleStringProperty(this.endTime);

    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBeginLesson() {
        return beginTime;
    }

    public void setBeginLesson(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndLesson() {
        return endTime;
    }

    public void setEndLesson(String endTime) {
        this.endTime = endTime;
    }

    public Classroom getClassRoom() {
        return classroom;
    }

    public void setClassRoom(Classroom classroom) {
        this.classroom = classroom;
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
        return beginTimeTB.get();
    }

    public SimpleStringProperty beginTimeTBProperty() {
        return beginTimeTB;
    }

    public void setBeginLessonTB(String beginTimeTB) {
        this.beginTimeTB.set(beginTimeTB);
    }

    public String getEndLessonTB() {
        return endTimeTB.get();
    }

    public SimpleStringProperty endTimeTBProperty() {
        return endTimeTB;
    }

    public void setEndLessonTB(String endTimeTB) {
        this.endTimeTB.set(endTimeTB);
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

    public Group getGroupTBST() {
        return (Group) this.groupTB.get();
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

    public String getSubjectTB() {
        return subjectTB.get();
    }

    public SimpleStringProperty subjectTBProperty() {
        return subjectTB;
    }

    public void setSubjectTB(String subjectTB) {
        this.subjectTB.set(subjectTB);
    }

    @Override
    public String toString() {
        return "Teacher: " + teacher.getLastName() + " subject; " + teacher.getTeacherSubject() + " classroom: " + classroom + " begin time: " + beginTime + " end time: "+ endTime;
    }
}

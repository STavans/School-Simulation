package data;

import javafx.beans.property.SimpleStringProperty;

public class Lesson {
    private String beginLesson;
    private String endLesson;
    private String subject;
    private Room name;
    private Room classRoom;
    private Group code;
    private Group amount;
    private Teacher TeacherName;
    private Student firstName;
    private Group group;

    private SimpleStringProperty teacherTB;
    private SimpleStringProperty groupTB;
    private SimpleStringProperty classRoomTB;
    private SimpleStringProperty beginLessonTB;
    private SimpleStringProperty endLessonTB;


    public Lesson (Teacher teacher,Group group,Room classRoom , String beginLesson,String endLesson) {
        this.TeacherName=teacher;
        this.group=group;
        this.classRoom=classRoom;
        this.beginLesson = beginLesson;
        this.endLesson = endLesson;

        teacherTB = new SimpleStringProperty(teacher);
        groupTB = new SimpleStringProperty(group);
        classRoomTB = new SimpleStringProperty(classRoom);
        beginLessonTB = new SimpleStringProperty(beginLesson);
        endLessonTB = new SimpleStringProperty(endLesson);

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

    public Room getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Room classRoom) {
        this.classRoom = classRoom;
    }

    public Teacher getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(Teacher teacherName) {
        TeacherName = teacherName;
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

    public String getClassRoomTB() {
        return classRoomTB.get();
    }

    public SimpleStringProperty classRoomTBProperty() {
        return classRoomTB;
    }

    public void setClassRoomTB(String classRoomTB) {
        this.classRoomTB.set(classRoomTB);
    }

    public String getGroupTB() {
        return groupTB.get();
    }

    public SimpleStringProperty groupTBProperty() {
        return groupTB;
    }

    public void setGroupTB(String groupTB) {
        this.groupTB.set(groupTB);
    }

    public String getTeacherTB() {
        return teacherTB.get();
    }

    public SimpleStringProperty teacherTBProperty() {
        return teacherTB;
    }

    public void setTeacherTB(String teacherTB) {
        this.teacherTB.set(teacherTB);
    }

}

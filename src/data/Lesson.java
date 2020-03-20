package data;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Lesson implements Serializable {

    private Teacher teacher;
    private String subject;
    private Group group;
    private Classroom classroom;
    private String beginTime;
    private String endTime;

    private transient SimpleObjectProperty teacherTB;
    private transient SimpleStringProperty subjectTB;
    private transient SimpleObjectProperty<Group> groupTB;
    private transient SimpleObjectProperty<Classroom> classRoomTB;
    private transient SimpleStringProperty beginTimeTB;
    private transient SimpleStringProperty endTimeTB;


    public Lesson (Teacher teacher, Group group, Classroom classroom, String beginTime, String endTime) {
        this.teacher = teacher;
        this.subject = this.teacher.getSubject();
        this.group = group;
        this.classroom = classroom;
        this.beginTime = beginTime;
        this.endTime = endTime;

        teacherTB = new SimpleObjectProperty(this.teacher);
        groupTB = new SimpleObjectProperty<>(this.group);
        subjectTB = new SimpleStringProperty(this.subject);
        classRoomTB = new SimpleObjectProperty<>(this.classroom);
        beginTimeTB = new SimpleStringProperty(this.beginTime);
        endTimeTB = new SimpleStringProperty(this.endTime);

    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int[] getBeginLesson() {
        String[] splittedBeginTime = beginTime.split(":");

        int time[] = new int[2];

        time[0] = Integer.parseInt(splittedBeginTime[0]);

        if (splittedBeginTime[1].equals("30")){
            time[1] = 30;
        }

        return time;
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
        return classRoomTB.get();
    }

    public SimpleObjectProperty<Classroom> classRoomTBProperty() {
        return classRoomTB;
    }

    public void setClassRoomTB(Classroom classRoomTB) {
        this.classRoomTB.set(classRoomTB);
    }

    public Group getGroupTBST() {
        return this.groupTB.get();
    }

    public SimpleObjectProperty<Group> groupTBProperty() {
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

    @SuppressWarnings("Duplicates")
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(teacherTB.get());
        oos.writeUTF(subjectTB.get());
        oos.writeObject(groupTB.get());
        oos.writeObject(classRoomTB.get());
        oos.writeUTF(beginTimeTB.get());
        oos.writeUTF(endTimeTB.get());
    }
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        teacherTB = new SimpleObjectProperty(ois.readObject());
        subjectTB = new SimpleStringProperty(ois.readUTF());
        groupTB = new SimpleObjectProperty(ois.readObject());
        classRoomTB = new SimpleObjectProperty(ois.readObject());
        beginTimeTB = new SimpleStringProperty(ois.readUTF());
        endTimeTB = new SimpleStringProperty(ois.readUTF());
    }
}

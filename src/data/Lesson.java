package data;

public class Lesson {
    private int beginLesson;
    private int endLesson;
    private String subject;
    private Room name;
    private Room classRoom;
    private Group code;
    private Group amount;
    private Teacher TeacherSubject;

    public Lesson (String subject, int beginLesson,int endLesson) {
        this.subject=subject;
        this.beginLesson=beginLesson;
        this.endLesson=endLesson;
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getBeginLesson() {
        return beginLesson;
    }

    public void setBeginLesson(int beginLesson) {
        this.beginLesson = beginLesson;
    }

    public int getEndLesson() {
        return endLesson;
    }

    public void setEndLesson(int endLesson) {
        this.endLesson = endLesson;
    }
}

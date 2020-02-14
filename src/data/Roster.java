package data;

import java.util.ArrayList;

public class Roster {
    private Lesson lesson;
    private ArrayList<Lesson> roster = new ArrayList<>();
    private Teacher lastName;
    private Group group;
    private Room classRoom;
    private Lesson beginTime;
    private Lesson endTime;


    public Roster(String teacher,String group,int classRoom, int beginTime,int endTime) {
//this.lastName=teacher;

    }

    public void addLesson(Lesson lesson){
        this.roster.add(lesson);
    }
}

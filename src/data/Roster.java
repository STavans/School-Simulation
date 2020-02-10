package data;

import java.util.ArrayList;

public class Roster {
    private Lesson lesson;
    private ArrayList<Lesson> roster = new ArrayList<>();

    public Roster() {
    }

    public void addLesson(Lesson lesson){
        this.roster.add(lesson);
    }
}

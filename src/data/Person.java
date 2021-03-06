package data;

import pathFinding.PathfindLogic;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Person implements Serializable, Drawable {

    private String gender;
    private String lastName;
    private Point2D position;

    public Person(String gender,String lastName) {
        this.gender = gender;
        this.lastName = lastName;
        this.position = null;
    }

    public String getGender() {
       return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public abstract void setPathfindLogic(PathfindLogic pathfindLogic);


    public abstract Point2D getTarget();

    public abstract void setLessons(ArrayList<Lesson> lessons);

    public abstract void addLesson(Lesson lesson);

    public abstract ArrayList<Lesson> getLessons();

    public abstract void setSpeed(double speedFactor);

}


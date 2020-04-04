package data;

import tileMap.Chair;
import tileMap.DistanceMap;

import java.io.Serializable;
import java.util.ArrayList;

public class Classroom implements Serializable {

    private String classNumber;
    private ArrayList<Chair> chairList;


    public Classroom(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String toString() {
        return "" + this.classNumber;
    }

    public void setChairs(ArrayList<Chair> chairDistanceMaps) {
        this.chairList = chairDistanceMaps;
    }

    public ArrayList<Chair> getChairs() {
        return chairList;
    }
}


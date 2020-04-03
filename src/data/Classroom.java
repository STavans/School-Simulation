package data;

import tileMap.DistanceMap;

import java.io.Serializable;
import java.util.ArrayList;

public class Classroom implements Serializable {

    private String classNumber;
    private ArrayList<DistanceMap> chairLocations;


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

    public void setChairDistanceMaps(ArrayList<DistanceMap> distanceMapArrayList) {
        this.chairLocations = distanceMapArrayList;
    }

    public ArrayList<DistanceMap> getChairDistanceMaps() {
        return chairLocations;
    }
}


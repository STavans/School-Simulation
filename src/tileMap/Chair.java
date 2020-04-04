package tileMap;

import data.Student;

public class Chair {
    private boolean isTaken;
    private DistanceMap distanceMap;
    private Student reservedStudent;

    public Chair(DistanceMap distanceMap) {
        this.distanceMap = distanceMap;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken, Student student) {
        isTaken = taken;
        reservedStudent = student;
    }

    public Student getReservedStudent() {
        return reservedStudent;
    }

    public DistanceMap getDistanceMap() {
        return distanceMap;
    }

    public void setDistanceMap(DistanceMap distanceMap) {
        this.distanceMap = distanceMap;
    }
}

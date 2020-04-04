package tileMap;

import data.Student;

public class Chair {
    private boolean isTaken;
    private DistanceMap distanceMap;
    private Student reservedStudent;
    private boolean towardsEast;

    public Chair(DistanceMap distanceMap, boolean towardsEast) {
        this.distanceMap = distanceMap;
        this.towardsEast = towardsEast;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken, Student student) {
        this.isTaken = taken;
        this.reservedStudent = student;
    }

    public boolean isTowardsEast() {
        return towardsEast;
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

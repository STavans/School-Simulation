package tileMap;

public class Chair {
    private boolean isTaken;
    private DistanceMap distanceMap;

    public Chair(DistanceMap distanceMap) {
        this.distanceMap = distanceMap;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public DistanceMap getDistanceMap() {
        return distanceMap;
    }

    public void setDistanceMap(DistanceMap distanceMap) {
        this.distanceMap = distanceMap;
    }
}

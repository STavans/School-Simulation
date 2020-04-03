package data;

import tileMap.DistanceMap;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Room implements Serializable {

    private int roomID;

    public abstract void setChairDistanceMaps(ArrayList<DistanceMap> distanceMapArrayList);

}


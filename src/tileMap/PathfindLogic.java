package tileMap;

import data.Classroom;

import javax.json.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

public class PathfindLogic {
    private Target target;
    private HashMap<String, DistanceMap> distanceHashMaps = new HashMap<>();
    private HashMap<String, Integer> classroomHashMap;
    private ArrayList classroomsArrayList;
    private String fileName;
    private Point2D[][] tileTargets = new Point2D[60][32];

    public PathfindLogic(String fileName) {
        this.fileName = fileName;
        this.target = new Target(fileName);
        this.classroomHashMap = target.getClassroomsHashMap();
        this.classroomsArrayList = target.getClassroomList();
    }
    public void generate(){
        for (String classroom: classroomHashMap.keySet()) {
            System.out.println(classroom);
            System.out.println(get2DArrayCollisionLayer().length);
            int targetX = target.getX(classroomsArrayList.indexOf(classroom)) / 32;
            int targetY = target.getY(classroomsArrayList.indexOf(classroom)) / 32;
            distanceHashMaps.put(classroom, new DistanceMap(get2DArrayCollisionLayer(), targetX, targetY));

            for (int y = 0; y < 32; y++){
                for (int x = 0; x < 60; x++){
                    tileTargets[x][y] = new Point2D.Double(x * 32 + 16, y * 32 + 16);
                }
            }
        }
    }
    public int[][] get2DArrayCollisionLayer(){
        JsonReader reader = Json.createReader(getClass().getResourceAsStream("/Tilemap.json"));
        JsonObject root = reader.readObject();
        for (int i = 0; i < root.getJsonArray("layers").size(); i++) {
            if (root.getJsonArray("layers").getJsonObject(i).getString("name").equals("Collision")){
                JsonArray collisionArray = root.getJsonArray("layers").getJsonObject(i).getJsonArray("data");
                int[][] collision2DArray = new int[32][60];
                int j = 0;
                for(int y = 0; y < 32; y++)
                {
                    for(int x = 0; x < 60; x++)
                    {
                        collision2DArray[y][x] = collisionArray.getInt(j);
                        j++;
                    }
                }
                return collision2DArray;
            }
        }
        System.out.println("Failed to get Collision layer");
        return null;
    }
    public DistanceMap getDistanceMap(){
        return distanceHashMaps.get("103s");
    }
    public Point2D getPath(Point2D position, String target){
        int currentTileX = (int) Math.round((position.getX()) / 32);
        int currentTileY = (int) Math.round((position.getY()) / 32);
        DistanceMap targetField = distanceHashMaps.get(target);
        double currentDistance = targetField.getDistanceMap()[currentTileX][currentTileY];
//        System.out.println(currentDistance);
//        System.out.println(currentTileX+ " "+ currentTileY);
        if (currentDistance > targetField.getDistanceMap()[currentTileX + 1][currentTileY] && targetField.getDistanceMap()[currentTileX + 1][currentTileY] != 2.147483647E9) {
//                System.out.println("left");
            return tileTargets[currentTileX + 1][currentTileY];
        }

        if (currentDistance > targetField.getDistanceMap()[currentTileX][currentTileY + 1] && targetField.getDistanceMap()[currentTileX][currentTileY + 1] != 2.147483647E9) {
//                System.out.println("down");
            return tileTargets[currentTileX][currentTileY + 1];
        }
        if (currentDistance > targetField.getDistanceMap()[currentTileX -1][currentTileY] && targetField.getDistanceMap()[currentTileX - 1][currentTileY] != 2.147483647E9) {
//                System.out.println("right");
            return tileTargets[currentTileX - 1][currentTileY];
        }
        if (currentDistance > targetField.getDistanceMap()[currentTileX][currentTileY -1] && targetField.getDistanceMap()[currentTileX][currentTileY - 1] != 2.147483647E9) {
//                System.out.println("up");
            return tileTargets[currentTileX][currentTileY -1];
        }
        return tileTargets[currentTileX][currentTileY - 1];
    }
}

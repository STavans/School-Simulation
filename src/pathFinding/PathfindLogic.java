package pathFinding;

import data.Classroom;
import pathFinding.Chair;
import pathFinding.DistanceMap;
import tileMap.Target;

import javax.json.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

public class PathfindLogic {
    private Target target;
    private HashMap<String, DistanceMap> distanceHashMaps = new HashMap<>();
    private HashMap<String, Integer> classroomHashMap;
    private ArrayList classroomCodesArrayList;
    private ArrayList<Classroom> classroomArrayList;
    private String fileName;
    private Point2D[][] tileTargets = new Point2D[60][32];

    public PathfindLogic(String fileName) {
        this.fileName = fileName;
        this.target = new Target(fileName);
        this.classroomHashMap = target.getClassroomsHashMap();
        this.classroomCodesArrayList = target.getClassroomCodesList();
        this.classroomArrayList = target.getClassroomsList();
    }

    public void generate() {
        for (String classroom : classroomHashMap.keySet()) {
            int targetX = target.getX(classroomCodesArrayList.indexOf(classroom)) / 32;
            int targetY = target.getY(classroomCodesArrayList.indexOf(classroom)) / 32;
            int location = classroomCodesArrayList.indexOf(classroom);
            distanceHashMaps.put(classroom, new DistanceMap(get2DArrayCollisionLayer(), targetX, targetY));

            for (int y = 0; y < 32; y++) {
                for (int x = 0; x < 60; x++) {
                    tileTargets[x][y] = new Point2D.Double(x * 32 + 16, y * 32 + 16);
                }
            }
            if (target.getWidth(location) == 224) {
                ArrayList<Chair> chairs = new ArrayList<>();
                for (int y = 0; y < 4; y++) {
                    for (int x = 0; x < 3; x++) {
                        if (target.getName(location).equals("101s") || target.getName(location).equals("102s") || target.getName(location).equals("105s") || target.getName(location).equals("106s")) {
                            chairs.add(new Chair(new DistanceMap(get2DArrayCollisionLayer(), targetX + (3 * x), targetY + y), false));
                        } else {
                            chairs.add(new Chair(new DistanceMap(get2DArrayCollisionLayer(), targetX + (3 * x), targetY + y), true));
                        }
                    }
                }
                classroomArrayList.get(location).setChairs(chairs);
            } else if (target.getName(location).equals("Canteen")) {
                ArrayList<Chair> chairs = new ArrayList<>();

                for (int y = 0; y < 8; y++) {
                    for (int xE = 0; xE < 2 ; xE++) {
                        chairs.add(new Chair(new DistanceMap(get2DArrayCollisionLayer(), targetX + (5 * xE), targetY + y), true));
                    }
                    for (int xW = 0; xW < 2; xW++) {
                        chairs.add(new Chair(new DistanceMap(get2DArrayCollisionLayer(), targetX + 4 + (5 * xW), targetY + y), false));
                    }
                }
                for (int y = 0; y < 8; y++) {
                    for (int xE = 0; xE < 2 ; xE++) {
                        chairs.add(new Chair(new DistanceMap(get2DArrayCollisionLayer(), targetX + (5 * xE), targetY + 11 + y), true));
                    }
                    for (int xW = 0; xW < 2; xW++) {
                        chairs.add(new Chair(new DistanceMap(get2DArrayCollisionLayer(), targetX + 4 + (5 * xW), targetY + 11 + y), false));
                    }
                }

                classroomArrayList.get(location).setChairs(chairs);
                System.out.println(classroomArrayList.get(location) + " Initialized");
            }
        }
    }

    public int[][] get2DArrayCollisionLayer() {
        JsonReader reader = Json.createReader(getClass().getResourceAsStream("/Tilemap.json"));
        JsonObject root = reader.readObject();
        for (int i = 0; i < root.getJsonArray("layers").size(); i++) {
            if (root.getJsonArray("layers").getJsonObject(i).getString("name").equals("Collision")) {
                JsonArray collisionArray = root.getJsonArray("layers").getJsonObject(i).getJsonArray("data");
                int[][] collision2DArray = new int[32][60];
                int j = 0;
                for (int y = 0; y < 32; y++) {
                    for (int x = 0; x < 60; x++) {
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

    public DistanceMap getDistanceMap() {
        return classroomArrayList.get(5).getChairs().get(4).getDistanceMap();
    }

    public Point2D getPath(Point2D position, String target) {
        DistanceMap targetField = distanceHashMaps.get(target);
        return calculatePath(position, targetField);
    }

    public Point2D getPath(Point2D position, DistanceMap distanceMap) {
        DistanceMap targetField = distanceMap;
        return calculatePath(position, targetField);
    }

    private Point2D calculatePath(Point2D position, DistanceMap targetField) {
        int currentTileX = (int) Math.floor((position.getX()) / 32);
        int currentTileY = (int) Math.floor((position.getY()) / 32);
        double currentDistance = targetField.getDistanceMap()[currentTileX][currentTileY];
        if (currentDistance > targetField.getDistanceMap()[currentTileX + 1][currentTileY] && targetField.getDistanceMap()[currentTileX + 1][currentTileY] != Integer.MAX_VALUE) {
            return tileTargets[currentTileX + 1][currentTileY];
        }

        if (currentDistance > targetField.getDistanceMap()[currentTileX][currentTileY + 1] && targetField.getDistanceMap()[currentTileX][currentTileY + 1] != Integer.MAX_VALUE) {
            return tileTargets[currentTileX][currentTileY + 1];
        }
        if (currentDistance > targetField.getDistanceMap()[currentTileX - 1][currentTileY] && targetField.getDistanceMap()[currentTileX - 1][currentTileY] != Integer.MAX_VALUE) {
            return tileTargets[currentTileX - 1][currentTileY];
        }
        if (currentDistance > targetField.getDistanceMap()[currentTileX][currentTileY - 1] && targetField.getDistanceMap()[currentTileX][currentTileY - 1] != Integer.MAX_VALUE) {
            return tileTargets[currentTileX][currentTileY - 1];
        }
        return tileTargets[currentTileX][currentTileY - 1];
    }

    public ArrayList<Classroom> getClassroomArrayList() {
        return classroomArrayList;
    }
}

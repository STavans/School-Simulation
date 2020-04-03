package tileMap;

import data.Classroom;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.awt.geom.Point2D;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Target {

    private Classroom cantine = new Classroom("canteen");
    private Classroom teacherRoom = new Classroom("teacherroom");
    private Classroom classroom101t = new Classroom("101t");
    private Classroom classroom102t = new Classroom("102t");
    private Classroom classroom101s = new Classroom("101s");
    private Classroom classroom102s = new Classroom("102s");
    private Classroom classroom103s = new Classroom("103s");
    private Classroom classroom104s = new Classroom("104s");
    private Classroom classroom103t = new Classroom("103t");
    private Classroom classroom104t = new Classroom("104t");
    private Classroom classroom105t = new Classroom("105t");
    private Classroom classroom105s = new Classroom("105s");
    private Classroom classroom106t = new Classroom("106t");
    private Classroom classroom106s = new Classroom("106s");
    private Classroom toilets = new Classroom("toilets");

    private JsonArray layers;
    private ArrayList<String> classrooms;
    private HashMap<String, Integer> hashMap;

    public Target(String filename){
        classrooms = new ArrayList<>();
        hashMap = new HashMap();

        classrooms.add(cantine.getClassNumber());
        classrooms.add(teacherRoom.getClassNumber());
        classrooms.add(classroom101t.getClassNumber());
        classrooms.add(classroom102t.getClassNumber());
        classrooms.add(classroom101s.getClassNumber());
        classrooms.add(classroom102s.getClassNumber());
        classrooms.add(classroom103s.getClassNumber());
        classrooms.add(classroom104s.getClassNumber());
        classrooms.add(classroom103t.getClassNumber());
        classrooms.add(classroom104t.getClassNumber());
        classrooms.add(classroom105t.getClassNumber());
        classrooms.add(classroom105s.getClassNumber());
        classrooms.add(classroom106t.getClassNumber());
        classrooms.add(classroom106s.getClassNumber());
        classrooms.add(toilets.getClassNumber());

        JsonReader reader;
        reader = Json.createReader(getClass().getResourceAsStream("/Tilemap.json"));
//        System.out.println(Json.createReader(getClass().getResourceAsStream("/" + filename)));
        JsonObject root = reader.readObject();

        layers = root.getJsonArray("layers").getJsonObject(4).getJsonArray("objects");

        for(int i = 0; i < layers.size(); i++) {
            int id = layers.getJsonObject(i).getInt("id");

            hashMap.put(classrooms.get(i), id);
        }
        reader.close();
    }

    public int getX(int location){
        return layers.getJsonObject(location).getInt("x");
    }

    public int getY(int location){
        return layers.getJsonObject(location).getInt("y");
    }

    public int getHeight(int location){
        return layers.getJsonObject(location).getInt("height");
    }

    public int getWidth(int location){
        return layers.getJsonObject(location).getInt("width");
    }

    public Point2D getCenter(int location){
        return new Point2D.Float((float) (getX(location) + (getWidth(location) / 2.0)), getY(location) + (float) (getHeight(location) / 2.0));
    }

    public ArrayList getClassroomList(){
        return classrooms;
    }

    public HashMap<String, Integer> getClassroomsHashMap() {
        return hashMap;
    }
}
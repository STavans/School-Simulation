package data;

import java.util.ArrayList;

public class Group {
    private String name;
    private ArrayList<Student> group;

    public Group(String name) {
        this.name = name;
        this.group = new ArrayList<>();
    }

    public String getCode() {
        return name;
    }

    public void setCode(String name) {
        this.name = name;
    }

}

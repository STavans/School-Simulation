package data;

import java.util.ArrayList;

public class Group {
    private String name;
    private ArrayList<Student> group;

    public Group(String name) {
        this.name = name;
        this.group = new ArrayList<>();
    }

    public String getGroupName() {
        return name;
    }
    public void setGroupName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getGroup() {
        return group;
    }

    public void setGroup(ArrayList<Student> group) {
        this.group = group;
    }
}

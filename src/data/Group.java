package data;

import java.util.ArrayList;

public class Group {
    private String nameGroup;
    private ArrayList<Student> group;

    public Group(String nameGroup) {
        this.nameGroup = nameGroup;
        this.group = new ArrayList<>();
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public void add(){

    }
}

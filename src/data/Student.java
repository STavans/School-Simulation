package data;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;

public class Student extends Person {
    private enum groups{A, B, C, D, E, F}
    private String name;
    private Group group;


    public Student(String name, Boolean gender, Group group) {
        super(name, gender);
        this.group = group;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}

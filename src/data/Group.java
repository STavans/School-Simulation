package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable {
    private String code;
    private ArrayList<Student> group;

    public Group(String code) {
        this.code = code;
        this.group = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Group " + code;
    }
}

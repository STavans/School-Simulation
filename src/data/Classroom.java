package data;

import java.io.Serializable;

public class Classroom implements Serializable {

    private String classNumber;

    public Classroom(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String toString() {
        return "" + this.classNumber;
    }
}


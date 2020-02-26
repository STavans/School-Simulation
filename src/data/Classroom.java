package data;

import java.io.Serializable;

public class Classroom implements Serializable {

    private int classNumber;

    public Classroom(int classNumber) {
        this.classNumber = classNumber;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String toString() {
        return "" + this.classNumber;
    }
}


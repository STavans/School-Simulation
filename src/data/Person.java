package data;

import java.io.Serializable;

public abstract class Person implements Serializable, Drawable {

    private String gender;
    private String lastName;


    public Person(String gender,String lastName) {
        this.gender = gender;
        this.lastName = lastName;
    }

    public String getGender() {
       return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}


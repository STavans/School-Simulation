package data;

import javafx.beans.property.SimpleStringProperty;

public abstract class Person {
<<<<<<< HEAD
    private Boolean gender;
    private String name;

    public Person(String name, Boolean gender) {
=======
    private String gender;
    private String lastName;


    public Person(String gender,String lastName) {
>>>>>>> bartinos
        this.gender = gender;
        this.name = name;
    }

<<<<<<< HEAD

    public Boolean getGender() {
        return gender;
    }
    public void setGender(Boolean gender) {
=======
    public String getGender() {
       return gender;
    }

    public void setGender(String gender) {
>>>>>>> bartinos
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public void setLastName(String name) {
        this.name = name;
    }

}


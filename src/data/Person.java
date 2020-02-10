package data;

public abstract class Person {
    private Boolean gender;
    private String name;

    public Person(String name, Boolean gender) {
        this.gender = gender;
        this.name = name;
    }


    public Boolean getGender() {
        return gender;
    }
    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public void setLastName(String name) {
        this.name = name;
    }
}


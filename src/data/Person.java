package data;

public abstract class Person {
    private String gender;

    public Person(String gender) {
        this.gender=gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

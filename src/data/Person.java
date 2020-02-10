package data;

public abstract class Person {
    private Boolean gender;
    private String lastName;

    public Person(Boolean gender,String lastName) {
        this.gender = gender;
        this.lastName = lastName;
    }

//    public Boolean getGender() {
//        if(this.gender.equals()) {
//            return true;
//        }
//            return false;
//    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}


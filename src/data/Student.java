package data;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Student extends Person {
    private String firstName;


    public Student(Boolean gender,String lastName) {
        super(gender,lastName);
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}

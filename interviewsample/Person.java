package interviewsample;

import java.io.IOException;
import java.io.Serializable;

public class Person  extends ParentPerson implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String gender;
    private Leg leg;

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    Person() {
    };

    Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Name:" + name + "\nAge: " + age + "\nGender: " + gender;
    }

    /**
     * override
     * @param stream
     * @throws IOException
     */
    private void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        stream.writeObject(name);

    }
}
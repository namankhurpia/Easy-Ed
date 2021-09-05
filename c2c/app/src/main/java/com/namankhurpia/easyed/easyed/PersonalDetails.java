package com.namankhurpia.easyed.easyed;

/**
 * Created by Naman Khurpia on 18-03-2018.
 */

public class PersonalDetails {
    private String Name;
    private int Age;

    public PersonalDetails(String name,int age) {
        Name = name;
        Age = age;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

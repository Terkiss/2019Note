package com.dotge.chap08_exercise;

import java.io.Serializable;
import java.util.jar.Attributes;

public class Person implements Serializable {
    public static long serialVersionUID = 00000001L;

    private String name ;
    private int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

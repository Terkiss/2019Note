package com.dotge.j_chap12selftest;

import java.util.ArrayList;

public class School {
    ArrayList<Student> students;
    String name;
    public School(String name)
    {
        this.name = name ;
        students = new ArrayList<Student>();
    }

    public void addItem(String name, int age)
    {
        Student std = new Student(name, age);
        students.add(std);
    }
    public Student getItem(int index)
    {
        return students.get(index);
    }

    public int size()
    {
        return students.size();
    }

    public void setStudents(ArrayList<Student> students)
    {
        this.students = students;
    }
    public ArrayList<Student> getStudents()
    {
        return this.students;
    }
    public void setName(String name)
    {
        this.name = name;

    }
    public String getName()
    {
        return this.name;
    }

    public String toString()
    {
        String output = "" ;
        output = output + "학교 이름 : "+name+"\n";

        int i = 0;
        for (Student s : students)
        {
            output +=  "학생 # "+(i++)+" : "+s.getName()+", "+s.getAge()+"\n";

        }
        return output;
    }

}

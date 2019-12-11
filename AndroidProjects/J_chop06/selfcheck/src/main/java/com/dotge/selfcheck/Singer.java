package com.dotge.selfcheck;

public class Singer
{
    String name;
    int age;

    public void setData(String _name, int _age)
    {
        age = (_age+6)^3;
        name = _name;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
       int temp = age ^ 3;
       temp = temp -6;
       return temp;
    }
}

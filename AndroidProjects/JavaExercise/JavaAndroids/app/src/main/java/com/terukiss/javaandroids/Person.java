package com.terukiss.javaandroids;

import android.widget.Toast;

public class Person {
    public String name;
    protected  MainActivity activity;

    public Person(String name, MainActivity activity)
    {
        this.name = name;
        this.activity = activity;


    }

    public void walk(int speed)
    {
        Toast.makeText(activity.getApplicationContext(), name+"이(가)"+speed+" km 속도로 걸어갑니다.", Toast.LENGTH_LONG).show();
        activity.SetImage(R.drawable.person_walk);
    }
    public void run(int speed)
    {
        Toast.makeText(activity.getApplicationContext(), name+"이(가)"+speed+" km 속도로 뜁니다.", Toast.LENGTH_LONG).show();
        activity.SetImage(R.drawable.person_run);
    }
    public void cry()
    {
        Toast.makeText(activity.getApplicationContext(), name+"이(가) 아기가 아니여서 아무데서나 울수 없습니다.", Toast.LENGTH_LONG).show();
        activity.SetImage(0);
    }


}

package com.dotge.j_chop06;

import android.widget.Toast;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class Person {
    String name;
    MainActivity activity;

    public Person(String name, MainActivity activity)
    {
        this.name = name;
        this.activity = activity;
        Toast.makeText(activity.getApplicationContext(), name+" 이(가) 생성 되었습니다.", Toast.LENGTH_LONG).show();

        activity.imageView.setImageResource(R.drawable.person);
    }

    public void walk(int _speed)
    {
        Toast.makeText(activity.getApplicationContext(), name+" 이(가) "+_speed+"km 속도로 걸어 갑니다.", Toast.LENGTH_LONG).show();
        activity.imageView.setImageResource(R.drawable.person_walk);
    }

    public void run(int _speed)
    {
        Toast.makeText(activity.getApplicationContext(), name+" 이(가) "+_speed+"km 속도로 뛰어 갑니다.", Toast.LENGTH_LONG).show();
        activity.imageView.setImageResource(R.drawable.person_run);


    }




}

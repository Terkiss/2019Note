package com.terukiss.javaandroids;

import android.widget.Toast;

public class Baby extends  Person {
    public Baby(String name, MainActivity activity)
    {
        super(name, activity);
    }


    public void walk(int speed)
    {
        Toast.makeText(activity.getApplicationContext(), name+"이(가)"+speed+" km 속도로 걸어갑니다.", Toast.LENGTH_LONG).show();
        activity.SetImage(R.drawable.baby_walk);

    }
    public void run(int speed)
    {
        Toast.makeText(activity.getApplicationContext(), " 아기는 뛸수  없습니다.", Toast.LENGTH_LONG).show();
        activity.SetImage(0);
    }
    public void cry()
    {
        Toast.makeText(activity.getApplicationContext(), "아이가 엉엉 웁니다", Toast.LENGTH_LONG).show();
        activity.SetImage(R.drawable.baby_cry);
    }
}

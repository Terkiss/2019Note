package com.dotge.chap08_exercise_another;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.dotge.chap08_exercise.Person;
import com.dotge.chap08_exercise.Person2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 시리얼 라이즈드 방식 직렬화
       // serializedTest();


        // 파스러블 방식 직렬화
        //parcezableTest();

        // 번들 방식 직렬화
        bundelTest();
    }

    public void serializedTest()
    {
        Intent intent = getIntent();

        Person p1 = (Person) intent.getSerializableExtra("teacher");
        Person p2 = (Person) intent.getSerializableExtra("soulworker");

        TextView  textView = findViewById(R.id.textView);

        if(p1 != null && p2 !=  null)
        {
            textView.setText("이름 : "+p1.getName()+" 나이 : "+p1.getAge()+"\n");
            textView.append("이름 : "+p2.getName()+" 나이 : "+p2.getAge()+"\n");
        }


    }
    public void parcezableTest()
    {
        Intent intent = getIntent();

        Person2 p1 = (Person2) intent.getParcelableExtra("teacher");
        Person2 p2 = (Person2) intent.getParcelableExtra("soulworker");

        TextView  textView = findViewById(R.id.textView);

        if(p1 != null && p2 !=  null)
        {
            textView.setText("이름 : "+p1.getName()+" 나이 : "+p1.getAge()+"\n");
            textView.append("이름 : "+p2.getName()+" 나이 : "+p2.getAge()+"\n");
        }


    }

    public void bundelTest()
    {
        Intent intent = getIntent();

        Bundle aa = intent.getBundleExtra("bun");

        Person p1 = (Person)aa.getSerializable("teacher");
        Person p2 = (Person)aa.getSerializable("soulworker");

        TextView  textView = findViewById(R.id.textView);

        if(p1 != null && p2 !=  null)
        {
            textView.setText("이름 : "+p1.getName()+" 나이 : "+p1.getAge()+"\n");
            textView.append("이름 : "+p2.getName()+" 나이 : "+p2.getAge()+"\n");
        }

    }
    public void BackApplication()
    {

    }
}

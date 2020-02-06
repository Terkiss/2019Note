package com.dotge.chap08_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 명시적 인텐트
                meongsiIntent();

                //묵시적 인텐트
                implicitIntent();

            }
        });

    }

    public void meongsiIntent()
    {
        // 명시적
        Intent intent = new Intent();
        ComponentName name = new ComponentName("com.dotge.chap08_exercise_another", "com.dotge.chap08_exercise_another.MainActivity");

        intent.setComponent(name);

        // 데이터 전송 시리얼 라이즈드 방식
        serializedTest(intent);


        startActivity(intent);

    }
    public void implicitIntent()
    {

    }


    public Intent serializedTest(Intent intent)
    {
        Person person = new Person("김영준", 99);
        Person person1 = new Person("Chii Aruel", 16);

        intent.putExtra("teacher", person);
        intent.putExtra("soulworker", person1);

        return intent;
    }
}

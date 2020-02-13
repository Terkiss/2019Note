package com.dotge.chap10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TaskA2 extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_a2);
        setTitle("TaskC");

        Button button = findViewById(R.id.button2);
        Intent intent = getIntent();
        String val = intent.getStringExtra("A3");
        tv= findViewById(R.id.textView);
        tv.setText(val);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TaskA.class);
                intent.putExtra("A2", "A2 다시 호출 함");
                startActivity(intent);
            }
        });
        Log.d("LifeCycle", "onCreate() 실행");
    }




    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "onStart() 실행");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "onStop() 실행");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "onDestroy() 실행");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "onPause() 실행");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "onResume() 실행");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "onRestart() 실행");
    }
}

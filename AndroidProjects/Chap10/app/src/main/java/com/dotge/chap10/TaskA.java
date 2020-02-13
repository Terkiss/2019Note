package com.dotge.chap10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TaskA extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        setTitle("TaskB");

        Intent intent = getIntent();
        String val = intent.getStringExtra("A2");
        tv= findViewById(R.id.textView);
        tv.setText(val);
        Button button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TaskA2.class);
                intent.putExtra("A3", "A2에서 돌렷습니다");
                intent.addFlags(intent.FLAG_ACTIVITY_SINGLE_TOP);
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                startActivity(intent);
            }
        });
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("LifeCycle", "onNewIntent() 실행");
        String val = intent.getStringExtra("A2");
        tv.setText(val);
    }
}

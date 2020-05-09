package com.dotge.chap08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Button button = findViewById(R.id.button);


        intent = getIntent();
        String name = intent.getStringExtra("activity");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                int sum=0;
                for(int i = 0 ; i <=100 ; i++)
                {
                    sum+=i;
                }
                intent.putExtra("sum", sum);
                intent.putExtra("name", "NewActivity"); // 스트링형
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

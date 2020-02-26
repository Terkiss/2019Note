package com.terukiss.broadcastingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsActivity extends AppCompatActivity {
    EditText editText1,editText2,editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        Button button = findViewById(R.id.accept);
        editText1 = findViewById(R.id.receivNumber);
        editText2 = findViewById(R.id.receivText);
        editText3 = findViewById(R.id.receivTIme);

        Intent intent = getIntent();
        processIntent(intent);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void onNewIntent(Intent intent)
    {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent){
        if(intent!=null){
            String sender = intent.getStringExtra("sender");
            String contents = intent.getStringExtra("contents");
            String receveDate = intent.getStringExtra("receveDate");

            editText1.setText(sender);
            editText2.setText(contents);
            editText3.setText(receveDate);
        }
    }

}

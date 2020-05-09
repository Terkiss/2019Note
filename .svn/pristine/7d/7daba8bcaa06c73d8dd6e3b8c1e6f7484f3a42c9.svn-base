package com.cyberkyj.brodcastreceiver_sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SMSActivity extends AppCompatActivity {

    EditText edt_Sender, edt_Date, edt_Contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        edt_Sender = findViewById(R.id.editText);
        edt_Date = findViewById(R.id.editText3);
        edt_Contents = findViewById(R.id.editText2);
        Button button = findViewById(R.id.button);

        Intent intent = getIntent();
        processIntent(intent);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent){

        if(intent!=null){
            String sender = intent.getStringExtra("sender");
            String contents = intent.getStringExtra("contents");
            String receiveDate = intent.getStringExtra("receiveDate");

            edt_Sender.setText(sender);
            edt_Contents.setText(contents);
            edt_Date.setText(receiveDate);
        }
    }
}

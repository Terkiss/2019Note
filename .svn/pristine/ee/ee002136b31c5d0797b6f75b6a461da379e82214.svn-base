package com.dotge.service_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MyService.class);

                intent.putExtra("name", name);
                startService(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService( new Intent(getApplicationContext(), MyService.class) );
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (intent != null)
        {
            String name = intent.getStringExtra("name");
            Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
        }
        super.onNewIntent(intent);

    }
}

package com.dotge.j_chop06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ImageView imageView;
    Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1, button2, button3;

        editText = findViewById(R.id.personName);
        imageView = findViewById(R.id.imageView);

        button1 = findViewById(R.id.humenCreate);
        button2 = findViewById(R.id.humenWalk);
        button3 = findViewById(R.id.humenRun);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String name = editText.getText().toString();
               person = new Person(name, MainActivity.this);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person.walk(10);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person.run(20);
                
            }
        });



    }
}

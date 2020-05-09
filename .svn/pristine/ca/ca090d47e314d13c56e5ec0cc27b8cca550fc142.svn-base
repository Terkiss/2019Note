package com.terukiss.javaandroids;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public ImageView imageView;
    Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText humanName = findViewById(R.id.nameText);
        imageView = findViewById(R.id.imageView);
        Button genHumanBtn = findViewById(R.id.genHuman);
        Button walkBtn = findViewById(R.id.walk);
        Button runBtn = findViewById(R.id.run);
        Button cryBtn = findViewById(R.id.cryBtn);
        final RadioButton personRadio = findViewById(R.id.baby);

        genHumanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = personRadio.isChecked();
               createPerson(humanName.getText().toString(), check);
            }
        });

        walkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(person == null)
                {
                    return;
                }
                person.walk(10);
            }
        });

        runBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(person == null)
                {
                    return;
                }
                person.run(20);
            }
        });
        cryBtn.setOnClickListener(new View.OnClickListener()
        {
            public void  onClick(View v)
            {
                if(person == null)
                {
                    return;
                }
                person.cry();
            }
        });


    }

    public void createPerson(String name, boolean check){
        if(check )
        {
            person = new Baby(name,MainActivity.this);
            SetImage(R.drawable.baby);
        }
        else
        {
            person = new Person(name,MainActivity.this);
            SetImage(R.drawable.person);
        }
    }
    public void SetImage(int imageNum)
    {
        imageView.setImageResource(imageNum);
    }
}

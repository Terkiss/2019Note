package com.dotge.j_chap12selftest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView studentView,stnList;
    School sc = new School("크 학교");
    EditText stnName, stnAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btnAdd;

        stnAge = findViewById(R.id.stnAge);
        stnName = findViewById(R.id.stnName);

        btnAdd = findViewById(R.id.stnAdd);

        studentView = findViewById(R.id.stnView);
        stnList = findViewById(R.id.stnList);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = stnName.getText().toString();

                int age = Integer.parseInt(stnAge.getText().toString());


                sc.addItem(name, age);

                String text = "추가된 학생의 총수 ";
                studentView.setText(text+String.valueOf(sc.size()));

                Toast.makeText(getApplicationContext(), "학생 객체가 리스트에 추가됨, "+name+" 학생의 나이 "+age, Toast.LENGTH_LONG).show();

            }
        });


    }
    public void onList(View v)
    {
        String output = sc.toString();
        stnList.setText(output);
    }
}

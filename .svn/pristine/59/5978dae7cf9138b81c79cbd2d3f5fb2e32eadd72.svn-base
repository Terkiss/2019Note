package com.dotge.selfcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Singer singer1, singer2;
    EditText editText1;
    EditText editText2 ;
    RadioButton radiobutton1, radiobutton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singer1 = new Singer();
        singer2 = new Singer();

        ImageView imageView1, imageView2;

        imageView1 = findViewById(R.id.imageView2);
        imageView2 = findViewById(R.id.imageView3);

        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        radiobutton1 = findViewById(R.id.radioButton);
        radiobutton2 = findViewById(R.id.radioButton2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString();
                int age = Integer.parseInt(editText2.getText().toString());

                if(radiobutton1.isChecked())
                {
                    singer1.setData(name, age);
                    Toast.makeText(getApplicationContext(), "입력한 값이 첫번쨰 Singerr 객체에 설정 되었습니다", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    singer2.setData(name, age);
                    Toast.makeText(getApplicationContext(), "입력한 값이 두번쨰 Singerr 객체에 설정 되었습니다", Toast.LENGTH_SHORT).show();

                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "가수의 이름 : "+singer1.getName()+"가수의 나이 :"+singer1.getAge(), Toast.LENGTH_LONG  ).show();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "가수의 이름 : "+singer2.getName()+"가수의 나이 :"+singer2.getAge(), Toast.LENGTH_LONG  ).show();
            }
        });
    }
}

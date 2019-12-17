package com.dotge.j_chap12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    String[]  names = {"철수", "영희", "민희", "수지", "지민", "스룽겔"};
    int count = 0;
    ArrayList<Person> persons = new ArrayList<Person>();
    TextView txt_Count ;
    LinearLayout layout;
    EditText edt_Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_Create = findViewById(R.id.btn_Create);
        Button btn_Add = findViewById(R.id.btn_Add);

        txt_Count = findViewById(R.id.txt_Count);

        edt_Name = findViewById(R.id.edt_Name);

        layout = findViewById(R.id.layout);

        btn_Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nameIndex = count % names.length;
                Person curPerson =  new Person(names[nameIndex]);

                persons.add(curPerson);
                Toast.makeText(getApplicationContext(), names[nameIndex] +"이(가) 만들어 졋습니다.",Toast.LENGTH_LONG).show();

                String curName = curPerson.getName();

                TextView textView = new TextView(getApplicationContext());
                //textView.setText(curName);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);

                LinearLayout.LayoutParams  params = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                String tt ="포이치";
                for(Person p : persons)
                {
                    tt += p.getName();
                }
                textView.setText(tt);

                layout.addView(textView, params);
                count++;
                txt_Count.setText(count+" 영");




            }
        });


        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = edt_Name.getText().toString();
                Person curPerson = new Person(curName);

                persons.add(curPerson);

                Toast.makeText(getApplicationContext(), curName +"이(가) 만들어 졋습니다.",Toast.LENGTH_LONG).show();

                String Name = curPerson.getName();

                TextView textView = new TextView(getApplicationContext());
                textView.setText(Name);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);

                LinearLayout.LayoutParams  params = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                layout.addView(textView, params);

                txt_Count.setText(count+" 영");
            }
        });

    }
}

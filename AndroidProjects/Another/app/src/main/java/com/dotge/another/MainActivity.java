package com.dotge.another;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.dotge.chap08.Person;
import com.dotge.chap08.Person2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView2);

        /*
        Intent intent = getIntent();


        Person person = (Person) intent.getSerializableExtra("p");
        Person person1 = (Person) intent.getSerializableExtra("p1");
        Person person2 = (Person) intent.getSerializableExtra("p2");

        if(person == null && person1 == null && person2== null)
        {
            Toast.makeText(getApplicationContext(), "데이터를 전달 받지 못함",Toast.LENGTH_LONG).show();
        }

        textView.setText("이름 : "+person.getName() +"나이 : "+person.getAge() +"\n");
        textView.append( "이름 : "+person1.getName() +"나이 : "+person1.getAge() +"\n" );
        textView.append( "이름 : "+person2.getName() +"나이 : "+person2.getAge() +"\n" );

         */

        Intent intent = getIntent();

        Person2 person1 = (Person2) intent.getParcelableExtra("김영준");
        Person2 person2 = (Person2) intent.getParcelableExtra("Chii Aruel");


        if(person1 != null&& person2 != null)
        {
            textView.setText("이름 : "+person1.getName() +"나이 : "+person1.getAge() +"\n");
            textView.append( "이름 : "+person2.getName() +"나이 : "+person2.getAge() +"\n" );
        }


    }
}

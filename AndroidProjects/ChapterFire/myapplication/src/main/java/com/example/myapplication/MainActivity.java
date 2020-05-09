package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    EditText checkId;
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkId = findViewById((R.id.editText));

        reference = FirebaseDatabase.getInstance().getReference("users");

        Button login = findViewById(R.id.login);
        Button register = findViewById(R.id.register);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       Iterator<DataSnapshot> child =  dataSnapshot.getChildren().iterator();

                       if(child.hasNext());
                       while(child.hasNext())
                       {
                           Log.d("Jeong", "child "+checkId.getText().toString());
                           if(child.next().getKey().equals(checkId.getText().toString()))
                           {
                               //Toast.makeText(getApplicationContext(), checkId.getText().toString()+"으로 로그인 성공", Toast.LENGTH_LONG).show();
                                Toast.makeText(getApplicationContext(), dataSnapshot.child(checkId.toString()).getValue().toString()+" 에 가입 하셧습니다 ",Toast.LENGTH_LONG).show();
                               return;
                           }

                       }
//                       SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//                       Date date = new Date(System.currentTimeMillis());
//                       e
                      //  Toast.makeText(getApplicationContext(), "겈색 을 모ㅓㅅ햇암", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);

                        startActivity(intent);
            }
        });
    }
}

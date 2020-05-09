package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
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

public class RegisterActivity extends AppCompatActivity {

    EditText edit;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edit = findViewById(R.id.editText2);
        reference = FirebaseDatabase.getInstance().getReference();

        Button register = findViewById(R.id.button2);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Iterator<DataSnapshot> child = dataSnapshot.getChildren().iterator();

                        while(child.hasNext())
                        {
                            if(edit.getText().toString().equals(child.next().getKey()))
                            {
                                Toast.makeText(getApplicationContext(), "존재하는 아디", Toast.LENGTH_LONG).show();
                                reference.removeEventListener(this);
                                return;
                            }
                        }
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hH:mm:ss");
                        Date data =new Date(System.currentTimeMillis());
                        String data_time = format.format(data);
                        reference.child(edit.getText().toString()).setValue(data_time);

                        Toast.makeText(getApplicationContext(), "회원가입",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}

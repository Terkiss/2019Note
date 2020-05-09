package com.example.firedb;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
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
import java.util.Iterator;

public class RegisterActivity extends AppCompatActivity {

    EditText edtId;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtId = findViewById(R.id.editText2);
        reference = FirebaseDatabase.getInstance().getReference("users");
        Button register = findViewById(R.id.button2);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //                                   유저의 자식을 참조하는 이터레터
                        Iterator<DataSnapshot> child = dataSnapshot.getChildren().iterator();


                        while (child.hasNext())
                        {
                            if(edtId.getText().toString().equals(child.next().getKey())){
                                Toast.makeText(getApplicationContext(),"존재하는 아이디입니다.",Toast.LENGTH_LONG).show();
                                reference.removeEventListener(this);
                                return;
                            }
                        }

                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // 심플 포맷팅 
                        Date date = new Date(System.currentTimeMillis());
                        String date_Time = format.format(date);
                        reference.child(edtId.getText().toString()).setValue(date_Time);
                        Toast.makeText(getApplicationContext(),"회원가입이 완료되었습니다.",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}

package com.example.testecercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class ContactAdd extends AppCompatActivity {
    EditText nameEdit, phoneNumberEdit, emailEdit;
    DatabaseManager accessDB;
    String databaseName ="myAdress.db";
    ArrayList<String> daces = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_add);

        Button btnAdd = findViewById(R.id.btnadd);


        nameEdit = findViewById(R.id.nameedit);
        phoneNumberEdit = findViewById(R.id.phonenumberedit);
        emailEdit = findViewById(R.id.emailedit);

        String nameData, phoneNumberData, emailData;
        accessDB = DatabaseManager._Instance.initialization(this, databaseName);





        Intent intent = getIntent();

        int length = intent.getIntExtra("length", 0);


        JeongLog.log.logD("데이터 의 길이2  :: "+length);
        for(int i = 0; i < length; i++)
        {
            String dddd =intent.getStringExtra("data"+i);
            daces.add(dddd);
            String receiverName = "data"+i;
            JeongLog.log.logD(receiverName+" 의데이터 :: "+dddd);
        }




        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JeongLog.log.logD("데이터 베이스에 데이터 삽입 시작 ");

                String nameData, phoneNumberData, emailData;

                nameData = nameEdit.getText().toString();
                phoneNumberData = phoneNumberEdit.getText().toString();
                emailData = emailEdit.getText().toString();
                ContactData contactData = new ContactData(nameData, phoneNumberData, emailData);
                accessDB.insertData(daces.get(1), new String[]{"name", "phonenumber", "email"}, contactData.getDataArray());

                JeongLog.log.logD("데이터 베이스 안전 하게 들어감 ");

                finish();
            }
        });
    }
}

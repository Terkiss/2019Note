package com.example.testecercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class ContactSelect extends AppCompatActivity {

    ArrayList<String> daces = new ArrayList<>();
    ListView listView;
    DatabaseManager accessDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_select);

        listView = findViewById(R.id.listView);
        Button btnClose = findViewById(R.id.btn_close);


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

        accessDB = DatabaseManager._Instance.initialization(getApplicationContext(), daces.get(0));


        Cursor cursor =  accessDB.selectdata("Select * from "+daces.get(1)+";");
        cursor.moveToFirst();
//        JeongLog.log.logD("name :: "+ cursor.getString(0));
//        JeongLog.log.logD("phoneNumber :: "+cursor.getString(1));
//        JeongLog.log.logD("email :: "+cursor.getString(2));

        String[] columns = {"name", "phonenumber", "email"};
        int[] to = {R.id.nametxt, R.id.phonenumbertxt, R.id.emailtxt};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.list_item,cursor,columns,to);
        listView.setAdapter(adapter);


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

package com.example.movie_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MovieData> items = new ArrayList<>();
    ListView listView;
    AdapterForList adapter;
    DatabaseManager accessDB;
    String dbName = "Movie.db";
    String tableName = "Listofmovies";

    String tableSQL ="create table "+tableName+"( titleName varchar(20), createYear varchar(10), director varchar(16), starRating varchar(10), createCountry varchar(10), primary key(titleName));";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JeongLog jeongLog = new JeongLog();
        Button btn_Add;

        accessDB = DatabaseManager._Instance.initialization(getApplicationContext(), dbName, tableSQL);

        btn_Add = findViewById(R.id.movie_Add);

        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MovieDisplay.class);
                JeongLog.log.logD(" 인텐트 연결 확인 "+intent);
                intent.putExtra("sendMessage", "add");
                intent.putExtra("dbName", dbName);
                intent.putExtra("tableName",tableName);
                startActivity(intent);
            }
        });


        Cursor cursor = accessDB.selectdata("select * from "+tableName);

        cursor.moveToFirst();

        while(cursor.moveToNext())
        {
            MovieData data = new MovieData();
            data.setTitleName(cursor.getString(0));

            data.setCreateYear(cursor.getString(1));

            data.setDirector(cursor.getString(2));

            data.setStarRating(cursor.getString(3));

            data.setCreateCountry(cursor.getString(4));

            items.add(data);
        }

        listView = findViewById(R.id.listView);
        adapter = new AdapterForList(items, getApplicationContext());
          listView.setAdapter(adapter);
          listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent intent = new Intent(getApplicationContext(), MovieDisplay.class);

                  intent.putExtra("sendMessage", "modify");
                  intent.putExtra("dbName", dbName);
                  intent.putExtra("tableName",tableName);
                  intent.putExtra("movieData", items.get(position).getArrayData());

                  startActivity(intent);
              }
          });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        JeongLog.log.logD("재 실행 확인 ");

        Cursor cursor = accessDB.selectdata("select * from "+tableName);

        cursor.moveToFirst();
        items.clear();

        while(cursor.moveToNext())
        {
            MovieData data = new MovieData();
            data.setTitleName(cursor.getString(0));

            data.setCreateYear(cursor.getString(1));

            data.setDirector(cursor.getString(2));

            data.setStarRating(cursor.getString(3));

            data.setCreateCountry(cursor.getString(4));

            items.add(data);
        }

        adapter.notifyDataSetChanged();
      //  listView = findViewById(R.id.listView);
      //  AdapterForList adapter = new AdapterForList(items, getApplicationContext());
       // listView.setAdapter(adapter);
    }
}

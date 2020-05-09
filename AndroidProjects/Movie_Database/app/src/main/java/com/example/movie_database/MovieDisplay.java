package com.example.movie_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MovieDisplay extends AppCompatActivity implements View.OnClickListener {

    EditText editTitleName, edtCreateYear, edtdirector, edtstarRating, edtcreateCountry;

    DatabaseManager accessDB;
    String dbName, tableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_display);

        editTitleName = findViewById(R.id.editText_name);
        edtCreateYear = findViewById(R.id.editText_year);
        edtdirector = findViewById(R.id.editText_director);
        edtstarRating = findViewById(R.id.editText_rate);
        edtcreateCountry = findViewById(R.id.editText_nation);

        Button btn_Save, btn_Update, btn_Delete;

        btn_Save = findViewById(R.id.button_save);
        btn_Update = findViewById(R.id.button_update);
        btn_Delete = findViewById(R.id.button_delete);

        btn_Save.setOnClickListener(this);
        btn_Update.setOnClickListener(this);
        btn_Delete.setOnClickListener(this);




        Intent intent = getIntent();
        String receiver = intent.getStringExtra("sendMessage");

        dbName = intent.getStringExtra("dbName");
        tableName = intent.getStringExtra("tableName");
        if(receiver.equals("add"))
        {
            JeongLog.log.logD("Message add accept ");
            JeongLog.log.logD(" 받은 데이터 확인 name :: "+dbName+" tableName  :: "+tableName);
            btn_Save.setVisibility(View.VISIBLE);

        }
        else
        {
            btn_Save.setVisibility(View.INVISIBLE);
            String[] movieData = intent.getStringArrayExtra("movieData");
            for(int i = 0 ; i < movieData.length; i++)
            {
                JeongLog.log.logD("전달 받은 데이터 :::: "+ movieData[i]);
            }

            editTitleName.setText(movieData[0]);
            edtCreateYear.setText(movieData[1]);
            edtdirector.setText(movieData[2]);
            edtstarRating.setText(movieData[3]);
            edtcreateCountry.setText(movieData[4]);
        }
        accessDB = DatabaseManager._Instance.initialization(getApplicationContext(), dbName);
    }

    @Override
    public void onClick(View v) {

        // 저장
        String name = editTitleName.getText().toString();
        String year = edtCreateYear.getText().toString();
        String director = edtdirector.getText().toString();
        String rate = edtstarRating.getText().toString();
        String nation = edtcreateCountry.getText().toString();
        MovieData data = new MovieData();

        JeongLog.log.logD("name -> "+name);
        JeongLog.log.logD("year -> "+year);
        JeongLog.log.logD("director -> "+director);
        JeongLog.log.logD("rate -> "+rate);
        JeongLog.log.logD("nation -> "+nation);

        switch(v.getId())
        {
            case R.id.button_save:


                data.setTitleName(name);
                data.setCreateYear(year);
                data.setDirector(director);
                data.setStarRating(rate);
                data.setCreateCountry(nation);

                accessDB.insertData(tableName, new String[]{"titleName", "createYear", "director", "starRating", "createCountry"}, data.getArrayData() );
                Toast.makeText(getApplicationContext(), "데이터가 추가 되었음", Toast.LENGTH_LONG).show();
                break;
            case R.id.button_update:

                if(name.length() > 0)
                {
                    JeongLog.log.logD(name + "지웁니다 ");
                    accessDB.deleteData(tableName, "titleName", new String[]{name} );


                    data.setTitleName(name);
                    data.setCreateYear(year);
                    data.setDirector(director);
                    data.setStarRating(rate);
                    data.setCreateCountry(nation);
                    accessDB.insertData(tableName, new String[]{"titleName", "createYear", "director", "starRating", "createCountry"}, data.getArrayData() );
                    Toast.makeText(getApplicationContext(), "데이터가 업데이트 되었음", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.button_delete:
                if(name.length() > 0)
                {
                    JeongLog.log.logD(name + "지웁니다 ");
                    accessDB.deleteData(tableName, "titleName", new String[]{name} );
                    Toast.makeText(getApplicationContext(), "데이터가 삭제 되었음", Toast.LENGTH_LONG).show();
                }

                break;
        }
        finish();
    }
}

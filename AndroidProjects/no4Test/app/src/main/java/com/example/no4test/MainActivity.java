package com.example.no4test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtName, edtNumber;
    Database Db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Db = new Database();
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNumber);

        Button btnAdd, btnSelect;

        btnAdd = findViewById(R.id.btbadd);
        btnSelect = findViewById(R.id.btnselect);

        btnAdd.setOnClickListener(this);
        btnSelect.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String name;
        String number;
        switch(v.getId())
        {

            case R.id.btbadd:
                name = edtName.getText().toString();
                number = edtNumber.getText().toString();

                Db.insertDB(name, number);
                edtName.setText("");
                edtNumber.setText("");

                break;

            case R.id.btnselect:

                name = edtName.getText().toString();
                if(name.length() <1)
                {
                    break;
                }
                Cursor cursor = Db.selectDB(name);
                cursor.moveToFirst();

                name = cursor.getString(0);
                number = cursor.getString(1);

                edtName.setText(name);
                edtNumber.setText(number);

                break;
        }
    }





    class Database
    {


        String dbName = "MyContactDb";
        String Tablename = "contacts";
        DBHelper dbHelper;
        SQLiteDatabase db;

        int version = 1;
        public Database()
        {
            dbHelper = new DBHelper(getApplicationContext(), dbName, null, version);
            db = dbHelper.getWritableDatabase();
        }



        public void insertDB(String name, String number)
        {
            ContentValues data = new ContentValues();
            data.put("name", name);
            data.put("number", number);
            db.insert(Tablename, null, data);
        }

        public Cursor selectDB(String name)
        {
            String[] data = {name};
            String sql = "select * from contacts where name = ?;";
            Cursor cursor = db.rawQuery(sql, data);
            return cursor;
        }

        class DBHelper extends  SQLiteOpenHelper
        {

            public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
                super(context, name, factory, version);
            }

            @Override
            public void onCreate(SQLiteDatabase db) {
                String sql ="create table contacts(name varchar(20), number varchar(20));";
                db.execSQL(sql);

            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            }
        }


    }
}

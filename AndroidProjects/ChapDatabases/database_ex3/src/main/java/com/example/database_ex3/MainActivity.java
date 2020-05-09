package com.example.database_ex3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editName, edtNumber, edtNameResult, edtNumberReseult;
    String db_Name ="girlgroup.db";
    int version = 1;

    myDBhelper dBhelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editText);
        edtNumber = findViewById(R.id.editText2);
        edtNameResult = findViewById(R.id.editText3);
        edtNumberReseult = findViewById(R.id.editText4);

        Button btnInit =findViewById(R.id.button);
        Button btnInsert = findViewById(R.id.button2);
        Button btnUpdate = findViewById(R.id.button3);
        Button btnDelete = findViewById(R.id.button4);
        final Button btnSelect = findViewById(R.id.button5);
        dBhelper = new myDBhelper(this);
        db = dBhelper.getWritableDatabase();
        Log.d("j","어허");
        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dBhelper.onUpgrade(db, version,1);
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                boolean numNull =false;
                int num=0;
                try {
                    num= Integer.parseInt(edtNumber.getText().toString());
                }
                catch (Exception e)
                {
                    Log.d("j","숫자란이 빔" );
                    numNull = true;
                }




                if(!(name.isEmpty())  && !numNull)
                {
                    Log.d("j",num+"어허" + name);

                    db.execSQL("insert into groupTBL values('"+name+"', "+ num+");");

                    Log.d("j", edtNumber.getText().toString());
                    Toast.makeText(getApplicationContext(), edtNumber.getText().toString()+"데이터가 입력됨", Toast.LENGTH_LONG).show();

                    editName.setText("");
                    edtNumber.setText("");
                    btnSelect.callOnClick();
                }


            }
        });


        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.rawQuery("select * from groupTBL", null);

                String strName = "그룹 이름"+"\n"+"________" +"\n";
                String strNumber ="인원"+"\n"+"________"+"\n";

                while(cursor.moveToNext())
                {
                    strName += cursor.getString(0)+"\n";
                    strNumber += cursor.getString(1)+"\n";
                }
                edtNameResult.setText(strName);
                edtNumberReseult.setText(strNumber);

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                boolean numNull =false;
                int num=0;
                try {
                    num= Integer.parseInt(edtNumber.getText().toString());
                }
                catch (Exception e)
                {
                    Log.d("j","숫자란이 빔" );
                    numNull = true;
                }




                if(!(name.isEmpty())  && !numNull)
                {
                    Log.d("j",num+"어허" + name);

                    db.execSQL("update groupTBL set gNumber = "+num +" where gName ='" + name+"';");

                    Log.d("j", edtNumber.getText().toString());
                    Toast.makeText(getApplicationContext(), edtNumber.getText().toString()+"데이터가 수정됨", Toast.LENGTH_LONG).show();

                    editName.setText("");
                    edtNumber.setText("");
                    btnSelect.callOnClick();
                }

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();

                if( !(name.isEmpty()))
                {
                    db.execSQL("delete from groupTBL where gName ='"+name+"';");
                    btnSelect.callOnClick();

                    Log.d("j", "데이터가 삭제됨");
                    Toast.makeText(getApplicationContext(), edtNumber.getText().toString()+"데이터가 삭제됨", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
    public class myDBhelper extends SQLiteOpenHelper
    {
        public myDBhelper(@Nullable Context context) {
            super(context, db_Name, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table groupTBL(gName varchar(20) PRIMARY KEY, gNUmber integer);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists groupTBL");
            onCreate(db);
            Toast.makeText(getApplicationContext(), " 테이블이 초기화 됨ㅂ!", Toast.LENGTH_LONG).show();
        }
    }
}

package com.example.testecercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    DatabaseManager accessDB;
    String databaseName ="myAdress.db";
    String tableName ="numberBook";
    String tableGenSql ="create table numberBook(_id integer PRIMARY KEY AUTOINCREMENT, name varchar(10), phonenumber varchar(16), email varchar(16) );";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JeongLog logSystem = new JeongLog();


        Button btnAdd, btnDel, btnSelect;

        btnAdd = findViewById(R.id.btnadd);
        btnDel = findViewById(R.id.btndelete);
        btnSelect = findViewById(R.id.btnselect);

        btnAdd.setOnClickListener(new btnListenr());
        btnDel.setOnClickListener(new btnListenr());
        btnSelect.setOnClickListener(new btnListenr());

        accessDB = DatabaseManager._Instance.initialization(this, databaseName, tableGenSql );

        //accessDB.deleteDataForTable(tableName);


    }
    class btnListenr implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {


            if(v.getId() == R.id.btnadd)
            {

                JeongLog.log.logD("추가 버튼 클릭된 아이디 :: "+v.getId());
                loadActivity(ContactAdd.class, "myAdress.db", "numberBook");
            }
            else  if(v.getId() == R.id.btndelete)
            {
                JeongLog.log.logD("삭제 버튼 클릭된 아이디 :: "+v.getId());
            }
            else  if(v.getId() == R.id.btnselect)
            {
                JeongLog.log.logD("조회 버튼 클릭된 아이디 :: "+v.getId());
                loadActivity(ContactSelect.class, "myAdress.db", "numberBook");
            }
        }


        /**
         * 다음 액티비티 로딩
         * @param cls
         */
        private void loadActivity(Class<?> cls)
        {
            Intent intent   =   new Intent(getApplicationContext(), cls) ;

            startActivity(intent) ;
        }
        private void loadActivity(Class<?> cls, String...data)
        {
            Intent intent   =   new Intent(getApplicationContext(), cls) ;
            intent.putExtra("length", data.length);

            JeongLog.log.logD("랭스 길이  :: "+data.length);

            for(int i = 0; i < data.length; i++)
            {
                JeongLog.log.logD("데이터   :: "+data[i]);
                String sendName = "data"+i;
                String datasss = data[i];
                intent.putExtra(sendName,datasss);
            }
            startActivity(intent) ;
        }
        /**
         * 다음 액티비티 로딩
         * @param cls
         * @param reCode
         */
        private void loadActivity(Class<?> cls, int reCode)
        {
            Intent intent   =   new Intent(getApplicationContext(), cls) ;

            startActivityForResult(intent, reCode) ;
        }

        /**
         * 다음 액티비티 로딩
         * @param cls
         * @param reCode
         * @param data
         */
        private void loadActivity(Class<?> cls, int reCode, Serializable data)
        {
            Intent intent    =   new Intent(getApplicationContext(), cls) ;

            intent.putExtra(String.valueOf(reCode), data) ;
            startActivityForResult(intent, reCode) ;
        }
    }
}

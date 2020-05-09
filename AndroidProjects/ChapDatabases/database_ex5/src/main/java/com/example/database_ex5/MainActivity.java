package com.example.database_ex5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    JeongLog jeongLog= new JeongLog();
    EditText editText;
    Button btn_Update;
    DatabaseManager dbConnetor;
    public static  int _year, _month, _day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dbConnetor = DatabaseManager._Instance.initialization(this, "myDB");

        DatePicker dataPicker = findViewById(R.id.datePicker);
        editText = findViewById(R.id.editText);
        btn_Update = findViewById(R.id.btnUpdate);

         //현재 날짜 기록
        Calendar calender = Calendar.getInstance();
        int year1 = calender.get(Calendar.YEAR);
        int month1 = calender.get(Calendar.MONTH);
        int day1 = calender.get(Calendar.DAY_OF_MONTH);

        String DateGen = String.valueOf(year1)+"-"+String.valueOf(month1)+"-"+String.valueOf(day1);
        readDiary(DateGen);



        dataPicker.init(year1, month1, day1, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                jeongLog.logD("Year : "+year);
                jeongLog.logD("Year : "+monthOfYear); // 월은 그럼 !!! 0 부터 시작임
                jeongLog.logD("Year : "+dayOfMonth);
                _year = year;
                _month = monthOfYear;
                _day = dayOfMonth;
                String DateGen = String.valueOf(year)+"-"+String.valueOf(monthOfYear)+"-"+String.valueOf(dayOfMonth);
                JeongLog.log.logD("생성된 날짜 :"+DateGen);
                readDiary(DateGen);
//                Cursor cursor =    dbConnetor.selectdata("select * from myDiary where diaryDate = '"+DateGen+"';");
//                cursor.moveToFirst();
//
//
//                JeongLog.log.logD(" is firt? "+cursor.isBeforeFirst() );







            }
        });

        btn_Update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String name =  ((Button)v).getText().toString();
                if(name.equals("새로쓰기"))
                {
                    String content = editText.getText().toString();
                    String DateGen =  String.valueOf(_year)+"-"+String.valueOf(_month)+"-"+String.valueOf(_day);
                    dbConnetor.insertData("myDiary",new String[]{"diaryDate", "content"},new String[]{DateGen, content});
                   //dbConnetor.executeSQL("insert into myDiary (diaryDate, content) values ('"+DateGen+"', '"+content+"');");
                }
                else
                {
                    //dbConnetor.
                }

            }
        });




    }



    public  void readDiary(@NonNull String date)
    {
        Cursor cursor = dbConnetor.selectdata("select content from myDiary where diaryDate= '"+date+"';");

        String content = "";

        JeongLog.log.logD("커서 카운트  "+cursor.getCount());
        if(cursor.getCount() == 0)
        {

            editText.setText("");
            btn_Update.setText("새로쓰기");
        }
        else
        {
            cursor.moveToFirst();
            content = cursor.getString(0);
            editText.setText(content);
            btn_Update.setText("수정하기");
        }
    }
//    public String readDiary(String str)
//    {
//        String data = "";
//        try {
//            FileInputStream inputStream = new FileInputStream(str);
//            byte[] txt = new byte[500];
//            inputStream.read(txt);
//
//            data = new String(txt).trim();
//            btn_Update.setText("수정하기");
//            inputStream.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            editText.setHint("일기 없음");
//            btn_Update.setText("새로저장");
//        }
//
//        return data;
//
//    }
}

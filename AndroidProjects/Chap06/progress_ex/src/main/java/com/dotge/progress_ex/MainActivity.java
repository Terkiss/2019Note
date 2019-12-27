package com.dotge.progress_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar ;
    TextView textView;
    ProgressDialog progressDialog;
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar2);
        textView = findViewById(R.id.textView);

        Button btnUP = findViewById(R.id.button);
        Button btnDwon = findViewById(R.id.button2);
        Button btnDownload = findViewById(R.id.button3);

        progressDialog = new ProgressDialog(this);

        btnUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(progressBar.getProgress() >100)
                {
                    progressBar.setProgress(100);
                }
                else
                {
                    progressBar.incrementProgressBy(10);
                }
                textView.setText(progressBar.getProgress()+"%");
            }
        });

        btnDwon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(progressBar.getProgress() <0 )
                {
                    progressBar.setProgress(0);
                }
                else
                {
                    progressBar.incrementProgressBy(-10);
                }
                textView.setText(progressBar.getProgress()+"%");
            }
        });
        ;
    }

    public void onDownload(View v)
    {
        progressDialog.setMessage("네트웤에서 다운로드 중입니다 ");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);
        progressDialog.setMax(100);
        progressDialog.show();

        thread = new Thread(){
            public void run(){
                int time = 0;
                while(time < 100 )
                {
                    SystemClock.sleep(16);
                    time += 1;
                    progressDialog.setProgress(time);
                }
                SystemClock.sleep(1000);
                progressDialog.dismiss();
            }
        };

        thread.start();
    }

    public void onDate(View v)
    {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                if(dayOfMonth < 10 )
                {
                    Toast.makeText(getApplicationContext(), year + " - " + (month+1)+" - 0"+ dayOfMonth, Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),  year + " - " + (month+1)+" - "+ dayOfMonth, Toast.LENGTH_LONG).show();
                }
            }
        }, year, month, day);
        datePickerDialog.show();
    }
    public void onTime(View v)
    {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if(minute < 10 )
                {
                    Toast.makeText(getApplicationContext(), hourOfDay + " : 0" +minute, Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), hourOfDay + " : " +minute, Toast.LENGTH_LONG).show();
                }
            }
        }, hour, minute, false);

        timePickerDialog.show();
    }

}

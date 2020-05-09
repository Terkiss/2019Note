package com.dotge.chap06;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    DatePicker dataPicker;
    TimePicker timePicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

    RadioButton rdo_Date;
    RadioButton rdo_Time;

    LinearLayout layout  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);

        chronometer = findViewById(R.id.chro_n);
        rdo_Date = findViewById(R.id.radioDate);
        rdo_Time = findViewById(R.id.radioTime);

        dataPicker = findViewById(R.id.datePeef);
        timePicker = findViewById(R.id.timePeef);

        tvYear = findViewById(R.id.txt_Year);
        tvMonth = findViewById(R.id.txt_Month);
        tvDay = findViewById(R.id.txt_Day);
        tvHour = findViewById(R.id.txt_Hour);
        tvMinute = findViewById(R.id.txt_Min);


        rdo_Date.setVisibility(View.INVISIBLE);
        rdo_Time.setVisibility(View.INVISIBLE);
        dataPicker.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.INVISIBLE);



        chronometer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
                rdo_Date.setVisibility(View.VISIBLE);
                rdo_Time.setVisibility(View.VISIBLE);
                return false;
            }
        });

        rdo_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataPicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);

                tvYear.setText( Integer.toString(dataPicker.getYear()) );
                tvMonth.setText( Integer.toString(dataPicker.getMonth()));
                tvDay.setText( Integer.toString(dataPicker.getDayOfMonth()));

                tvHour.setText( Integer.toString(timePicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(timePicker.getCurrentMinute()));

                rdo_Date.setVisibility(View.INVISIBLE);
                rdo_Time.setVisibility(View.INVISIBLE);

                dataPicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });
    }




    public void nene(Object a)
    {

    }

}

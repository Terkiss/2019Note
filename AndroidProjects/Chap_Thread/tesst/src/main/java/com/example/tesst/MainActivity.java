package com.example.tesst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import android.widget.Button;


import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;



    int state = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll = findViewById(R.id.ll);
        Button button1 = findViewById(R.id.button1);
        Button button2=findViewById(R.id.button2);
        text = findViewById(R.id.maintext);
        /*
         button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(state == 0)
                {
                    Datarun data = new Datarun();
                    text.setText(String.valueOf(10));
                    data.execute();
                }
                else if(state == 1)
                {
                    state = 0;
                }


            }
        });

        button2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(state == 0 || state == 2)
                {
                    state = 1;
                }
            }
        });
        */


    }



    class Datarun extends AsyncTask<Integer, Integer,Boolean>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

            if(aBoolean == true)
            {
                state =  0 ;
            }
            super.onPostExecute(aBoolean);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            //text.setText(values[0].toString());
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(Boolean aBoolean) {
            super.onCancelled(aBoolean);
        }

        @Override
        protected Boolean doInBackground(Integer... voids) {

            int i = voids[0];
            while(true)
            {
                if(state == 1 )
                {
                    continue;
                }
                else if( i < 0 )
                {
                    break;
                }
                publishProgress(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i--;
            }
            return false;
        }
    }



}

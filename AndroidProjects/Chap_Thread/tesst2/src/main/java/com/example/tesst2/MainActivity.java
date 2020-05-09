package com.example.tesst2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
        ImageView button1 = ll.findViewById(R.id.startbtn);
        ImageView button2=ll.findViewById(R.id.paucebtn);
        text = findViewById(R.id.maintext);

         button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(state == 0)
                {
                    Datarun data = new Datarun();
                    text.setText(String.valueOf(10));
                    Log.d("j", "진입");
                    data.execute(10);
                    state = 2 ;

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



    }



    class Datarun extends AsyncTask<Integer, Integer,Boolean> {


        @Override
        protected void onPreExecute() {
            Log.d("j", "스레드 준비 단계");
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
            Log.d("j",  " 스레드 UI 그리기 동작");
            text.setText(values[0].toString());
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(Boolean aBoolean) {
            super.onCancelled(aBoolean);
        }

        @Override
        protected Boolean doInBackground(Integer... voids) {
            // 스레드 시작 단계
            Log.d("j", "스레드 시작 단계");
            int i = voids[0];
            while(true)
            {
                Log.d("j",  i+" 스레드 동작");
                if(state == 1 )
                {
                    continue;
                }
                else if( i < 0 )
                {
                    Log.d("j",  " 스레드 탈축");
                    break;
                }
                publishProgress(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i--;
            }
            return false;
        }
    }



}

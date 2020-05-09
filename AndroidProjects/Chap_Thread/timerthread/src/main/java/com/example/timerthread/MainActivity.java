package com.example.timerthread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.BoringLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ImageView StartView;
    ImageView pauseView;
    Mythread mythread;
    Boolean isrun = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById( R.id.main_textView);
        StartView = findViewById(R.id.main_startBtn);
        pauseView= findViewById(R.id.main_pauseBtn);

        mythread = new Mythread();
    }

    public void startView(View view) {
        isrun =true;
        mythread.start();
    }

    public void pauseView(View view) {
        isrun=false;
    }


    class Mythread extends Thread{

        public void run()
        {
            try {
                int count = 10 ;
                while(isrun)
                {
                    Thread.sleep(500);
                    count--;

                    Message message =  handler.obtainMessage();

                    message.what =1;
                    message.arg1 = count;

                    handler.sendMessage(message);

                    if(count == 0 )
                    {
                        message = new Message();
                        message.what =2;
                        message.obj="fini";
                        handler.sendMessage(message);
                        isrun= false;
                    }

                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    Handler handler = new Handler()
    {
        public void handleMessage(@NonNull Message msg)
        {if(msg.what == 1)
        {
            textView.setText(String.valueOf(msg.arg1));

        }
        else if(msg.what == 2)
        {
            textView.setText((String)msg.obj);
        }
        }
    };
}

package com.example.playmusicservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView playBtn;
    ImageView stopBtn;

    ProgressBar progressBar;
    TextView textView;
    String oneFilePath;
    String twoFilePath;
    Boolean runThread = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = findViewById( R.id.lab1_play);
        stopBtn = findViewById(R.id.lab1_stop);
        progressBar = findViewById(R.id.lab1_progress);
        textView = findViewById(R.id.lab1_title);
        stopBtn.setEnabled(false);

        oneFilePath = "/data/data/com.example.playmusicservice/Days.mp3";
        twoFilePath = "/data/data/com.example.playmusicservice/Akie.mp3";

        stopBtn.setOnClickListener(this);
        playBtn.setOnClickListener(this);

        // 위험 권한 요청  하기전 권한을 부여 받았는지 검사하는 문구
        if(ContextCompat.checkSelfPermission( this , Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            // 위험 권한 요청
            ActivityCompat.requestPermissions(this,  new String[]{Manifest.permission.READ_EXTERNAL_STORAGE }, 100);
        }


        registerReceiver(receiver, new IntentFilter("Jeong.Music.Activity"));

        Intent intent = new Intent(this, PlayService.class);
        intent.putExtra("filepath", new String[]{oneFilePath, twoFilePath});
        startService(intent);



    }

    public void onClick(View v)
    {
        if( v == playBtn)
        {
            Intent intent = new Intent("Jeong.Music.PlayService");
            intent.putExtra("mode", "start");
            sendBroadcast(intent);



            playBtn.setEnabled(false);
            stopBtn.setEnabled(true);
        }
        else if( v == stopBtn)
        {
            Intent intent = new Intent("Jeong.Music.PlayService");
            intent.putExtra("mode", "stop");
            sendBroadcast(intent);


            playBtn.setEnabled(true);
            stopBtn.setEnabled(false);
        }
    }

    // 미디어 플레이어 서비스 로부터 전달 받은거
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String mode = intent.getStringExtra("mode");
            if(mode == null)
            {
                Log.d("Jeong", "Activiti 쪽 receive 안 모드 가 널" );
            }
            if(mode.equals("start"))
            {
                int duration = intent.getIntExtra("duration", 0);
                String songName = intent.getStringExtra("songName");
                if(duration == 0 )
                {
                    Log.d("Jeong", "Activity 쪽 receiver 듀레이션 값 이 0 ");
                }

                progressBar.setMax(duration);
                progressBar.setProgress(0);
                textView.setText(songName);
                runThread = true;

                PrograssThread th = new PrograssThread();
                th.start();

            }
            else if(mode.equals("stop"))
            {
                runThread = false;
            }
        }
    };

    public void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    class PrograssThread extends Thread
    {
        public void run()
        {
            while(runThread)
            {
                // 프로그래스바를 1초식
                progressBar.incrementProgressBy(1000);
                SystemClock.sleep(1000);

                if(progressBar.getProgress() == progressBar.getMax())
                {
                    runThread = false;
                }
            }
        }
    }
}

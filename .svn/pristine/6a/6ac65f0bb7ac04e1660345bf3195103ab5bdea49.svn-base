package com.terukiss.mp3player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("logs", " 경로 명 : "+ Environment.getDataDirectory() );
        Log.d("logs", " 절대 경로 명 : "+ Environment.getDataDirectory().getAbsolutePath() );
        Log.d("logs", " 루트 경로 명 : "+ Environment.getRootDirectory() );



        Intent intet = new Intent();
        intet.setAction( Intent.ACTION_VIEW);

        String audioPath = "file:///"+ Environment.getExternalStorageDirectory()+"/Download/01.+紅蓮華.mp3";

        intet.setDataAndType(Uri.parse(audioPath), "audio/*");

        startActivity(intet);

    }
}

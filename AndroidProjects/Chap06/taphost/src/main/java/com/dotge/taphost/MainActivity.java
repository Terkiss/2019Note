package com.dotge.taphost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sssa);

        TabHost tabHost = findViewById(R.id.tabhost2);

        tabHost.setup();

        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("foot1").setIndicator("음악7별"); // 탭 생성
        tabSpecSong.setContent(R.id.a1); // 생성된 탭에 컨텐츠 연결
        tabHost.addTab(tabSpecSong); // 탭을 등록


        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("foot2").setIndicator("가수별");
        tabSpecArtist.setContent(R.id.a2);
        tabHost.addTab(tabSpecArtist);

        TabHost.TabSpec tabSpecALBUM = tabHost.newTabSpec("foot3").setIndicator("앨범별");
        tabSpecALBUM.setContent(R.id.a3);
        tabHost.addTab(tabSpecALBUM);
        TabHost.TabSpec tabSpecALBUM2 = tabHost.newTabSpec("foot4").setIndicator("장난 앨범");
        tabSpecALBUM2.setContent(R.id.a4);
        tabHost.addTab(tabSpecALBUM2);

        tabHost.setCurrentTab(1);
    }
}

package com.Dotge.MyApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void onPrint(View v)
    {
        Toast.makeText(getApplicationContext(), "첫번 쨰 애플리케이션 입니다 .!!!!", Toast.LENGTH_LONG ).show();
    }

    public void onNaver(View v)
    {
                                    // 종류
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
        startActivity(intent);
    }

    public void onCall(View v)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-8603-3706"));
        startActivity(intent);
    }

    public void onMenus(View v)
    {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);

    }
}

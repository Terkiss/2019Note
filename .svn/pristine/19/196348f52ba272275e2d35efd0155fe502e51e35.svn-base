package com.dotge.intentim_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //editText = findViewById(R.id.editText);

        WebView webView = findViewById(R.id.webView);

        WebSettings setting = webView.getSettings();

        setting.setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/sample.html");

    }






    public void onSumit(View v)
    {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plan");

        //intent.putExtra("sms-body", "2교시 는 쉬는 시간입니다");
        intent.putExtra(Intent.EXTRA_TEXT, editText.getText().toString());
        if(intent.resolveActivity(getPackageManager()) != null )
        {
            startActivity(intent);
        }
    }
}

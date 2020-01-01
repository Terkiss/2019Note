package com.terukiss.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGO;
        Button btnBack ;
        final WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        editText    = findViewById(R.id.edtUrl);
        btnGO       = findViewById(R.id.btnGO);
        btnBack     = findViewById(R.id.btnBack);

       WebSettings webSettings = webView.getSettings();
       webSettings.setJavaScriptEnabled(true);

       //webView.loadUrl();

        btnGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = editText.getText().toString();

                String isNotHttp = uri.substring(0, 8);
                if(isNotHttp.equals("https://") == false )
                {
                    uri = "https://" + uri;
                    Toast.makeText(getApplicationContext(), uri, Toast.LENGTH_LONG).show();
                }

                webView.loadUrl(uri);

                //Toast.makeText(getApplicationContext(), "isnothttp :: "+isNotHttp, Toast.LENGTH_LONG).show();
            }
        });

    }
    class WebBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}

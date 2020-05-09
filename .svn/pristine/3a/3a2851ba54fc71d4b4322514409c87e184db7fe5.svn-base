package com.dotge.orientation_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int sum = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        if(savedInstanceState != null)
        {
            int scope = savedInstanceState.getInt("sun");
            textView.setText("출력 결과 : "+ scope);
        }


        print("OnCreate 호출됨");


        Button button = findViewById(R.id.button);
        textView = findViewById(R.id.textView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < 1200; i++)
                {
                    sum +=i;
                    textView.setText("출력결과 : " +sum);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        print("OnStart 호출됨");
        super.onStart();
    }

    @Override
    protected void onStop() {
        print("OnStop 호출됨");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        print("OnDestroy 호출됨");
        super.onDestroy();
    }
    void print(String data)
    {
        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("sun",sum);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            print("방향 : orfentatopm 랜드 스케이드 ");
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            print("방향 : orfentatopm portait");
        }
    }
}

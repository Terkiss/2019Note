package com.terukiss.homework20200106;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String a = "가로";
    String b = "새로";
    int i = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null)
        {
            i = savedInstanceState.getInt("ikey");
            Toast.makeText(getApplicationContext(), "값을 복원 하엿습니다."+ savedInstanceState.getString("key1"), Toast.LENGTH_LONG).show();

        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(i == 0 )
        {
            outState.putString("key1",a+" 모드 에서 보냄");
            outState.putInt("ikey", ++i);

        }
        else
        {
            outState.putString("key1",b+" 모드 에서 보냄");
            outState.putInt("ikey", --i);
        }

    }
}

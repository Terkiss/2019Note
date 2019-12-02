package com.terukiss.chop04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

       Button button = (Button)  findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "현재 시간은 10시 22분 입니다.", Toast.LENGTH_LONG).show();
            }
         //   OnClick2();
        });



    }
    public  void OnClick2(View v)
    {
        Toast.makeText(getApplicationContext(), "첫번쨰 버튼입니다.", Toast.LENGTH_SHORT).show();
    }
}

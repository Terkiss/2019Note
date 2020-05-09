package com.terukiss.chop04;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        TextView tv1, tv2, tv3;

        tv1 = (TextView)findViewById(R.id.T1);
        tv2 = (TextView)findViewById(R.id.T2);
        tv3 = (TextView)findViewById(R.id.T3);


        tv1.setText("안녕하세요");
        tv1.setTextColor(Color.RED);
        tv2.setTextSize(30);
        tv2.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
        tv3.setText("가나다라 마바사아자차가카");
        tv3.setSingleLine();



        /*
       Button button = (Button)  findViewById(R.id.button);
       Button button2 = (Button) findViewById(R.id.button2);


       button.setOnClickListener( new View.OnClickListener()
                                  {
                                      public void onClick(View v)
                                      {
                                          Toast.makeText(getApplicationContext(), "버튼 인력 테스트 중", Toast.LENGTH_LONG).show();
                                      }
                                  }
       );

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "버튼 변환", Toast.LENGTH_LONG).show();
            }
        });


*/
    }

}

package com.dotge.selfcheck2;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int Tchcount = 0;
    TextView xposition, yposition;
    TextView touchCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayout ll ;

        Button exitButton;

        ll = (LinearLayout) findViewById(R.id.linearLayout);

        xposition = (TextView) findViewById(R.id.xposition);
        yposition = (TextView) findViewById(R.id.yposition);
        touchCount = (TextView) findViewById(R.id.touchcount);
        exitButton =(Button) findViewById(R.id.appexit);


        ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                String pos = String.valueOf(event.getX());
                xposition.setText("X좌표 :: "+pos);
                pos = String.valueOf(event.getY());
                yposition.setText("Y좌표 :: "+pos);
                pos = "터치한 횟수 :: "+(++Tchcount);
                touchCount.setText(pos);




                return false;
            }
        });


    }

}

package com.terukiss.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.seekbar);

       /*
        Button startBtn, stopBtn;
        final ViewFlipper viewFlipper;

        stopBtn = findViewById(R.id.button2);
        startBtn = findViewById(R.id.button1);

        viewFlipper = findViewById(R.id.flipper);


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setFlipInterval(1000);
                viewFlipper.startFlipping();
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.stopFlipping();
            }
        });
        */

       SelfJavaView selfJavaView = new SelfJavaView(getApplicationContext(), LinearLayout.VERTICAL);

       LinearLayout FirstLayout = selfJavaView.getLinearLayout();
       FirstLayout.setPadding(3,3,3,3);

       selfJavaView.linearLayoutGenerator("buttonLayout", LinearLayout.HORIZONTAL, Color.GREEN,LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
       LinearLayout SecondLayout = selfJavaView.getLinearLayout("buttonLayout");
       SecondLayout.setPadding(3,3,3,3);
       selfJavaView.btnGenerator("button1", "사진보기 시작", SecondLayout, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               viewFlipper.setFlipInterval(1000);
               viewFlipper.startFlipping();
           }
       });

        Button left = selfJavaView.buttonGet("button1");
        if(left == null)
        {
            Toast.makeText(getApplicationContext(), "왼쪽 널입니다",Toast.LENGTH_LONG).show();
        }
        else
        {
            LinearLayout.LayoutParams params =  (LinearLayout.LayoutParams)left.getLayoutParams();
            params.weight = 1.0f;
            left.setLayoutParams(params);
        }

        selfJavaView.btnGenerator("button2", "사진보기 정지", SecondLayout,  LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setFlipInterval(1000);
                viewFlipper.stopFlipping();
            }
        });
        Button right = selfJavaView.buttonGet("button2");
        if(right == null)
        {
            Toast.makeText(getApplicationContext(), " 오늘쪽 널입니다",Toast.LENGTH_LONG).show();
        }
        else
        {
            LinearLayout.LayoutParams  params =  (LinearLayout.LayoutParams)right.getLayoutParams();
            params.weight = 1.0f;
            right.setLayoutParams(params);
        }

        selfJavaView.viewFlipperGenerator("flipper", -1, -1);
        viewFlipper = selfJavaView.viewFlipperGet("flipper");

        for(int i = 1 ; i < 15; i++)
        {
            //      이름                      타입                  패키지명
            int imgNum = getResources().getIdentifier("@drawable/jeju"+i, "drawable",this.getPackageName());
            selfJavaView.imageViewGenerator("image"+i, viewFlipper, -2, -2, imgNum);
        }
        LinearLayout.LayoutParams _params = new LinearLayout.LayoutParams(-1,-1);
        setContentView(FirstLayout, _params);
    }
}

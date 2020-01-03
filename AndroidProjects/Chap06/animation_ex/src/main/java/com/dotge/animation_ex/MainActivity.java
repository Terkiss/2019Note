package com.dotge.animation_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    boolean isPageOpen = false;
    LinearLayout layout ;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnOpen);
        layout = findViewById(R.id.layout);

       final Animation translate_left = AnimationUtils.loadAnimation(this, R.anim.transleft);
        final Animation translate_right = AnimationUtils.loadAnimation(this, R.anim.transright);

        PageListener pageListener = new PageListener();

        translate_left.setAnimationListener(pageListener);
        translate_right.setAnimationListener(pageListener);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPageOpen)
                {
                    layout.startAnimation(translate_right);
                }
                else
                {
                    layout.startAnimation(translate_left);
                    layout.setVisibility(View.VISIBLE);
                }
            }
        });

    }
    class  PageListener implements Animation.AnimationListener
    {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if(isPageOpen)
            {
                layout.setVisibility(View.GONE);
                button.setText("Open");
                isPageOpen = false;
            }
            else
                {
                button.setText("close");
                isPageOpen=true;
                }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}

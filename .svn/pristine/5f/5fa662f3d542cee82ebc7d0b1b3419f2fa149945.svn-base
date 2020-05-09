package com.dotge.animation_scale_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.in);

        imageView.startAnimation(anim);
        
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation anims2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.trans);
                anims2.setFillAfter(true);
                imageView.startAnimation(anims2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}

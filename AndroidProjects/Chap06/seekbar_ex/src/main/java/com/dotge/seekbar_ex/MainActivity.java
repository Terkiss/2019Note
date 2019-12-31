package com.dotge.seekbar_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    LinearLayout layout;
    TextView textView;
    int bright =100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seek);
        layout = findViewById(R.id.layout);
        textView = findViewById( R.id.textview);
        Button btn= findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation anim =  AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_left);
                seekBar.setProgress(bright);
                layout.setVisibility(View.VISIBLE);
                layout.startAnimation(anim);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress < 10)
                {
                    progress = 10;
                }
                else if(progress > 100)
                {
                    progress = 100;
                }
                bright = progress;

                WindowManager.LayoutParams params = getWindow().getAttributes();

                params.screenBrightness =(float) progress/100;
                getWindow().setAttributes(params);
                textView.setText("밝기 수준 : "+progress+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_right);
                layout.setVisibility(View.GONE);
                layout.startAnimation(anim);
            }
        });

    }
}

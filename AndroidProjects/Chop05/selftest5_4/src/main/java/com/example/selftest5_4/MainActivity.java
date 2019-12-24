package com.example.selftest5_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1, imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1 = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);

        Button btnup = findViewById(R.id.button2);
        Button btndown = findViewById(R.id.button);

        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView1.setImageResource(R.drawable.bg_tv);
                imageView2.setImageResource(0);
                imageView1.invalidate();
                imageView2.invalidate();
            }
        });

        btndown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView1.setImageResource(0);
                imageView2.setImageResource(R.drawable.bg_tv);
                imageView1.invalidate();
                imageView2.invalidate();
            }
        });
    }
}

package com.example.snackbar_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab, fabSub1, fabSub2;
    boolean isFabOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        fabSub1 = findViewById(R.id.fabSub1);
        fabSub2 = findViewById(R.id.fabSub2);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFab();

                Snackbar.make(v,"나는 스낵바입니다.",Snackbar.LENGTH_LONG)
                        .setAction("More Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(),"스낵바의 액션입니다.",Toast.LENGTH_LONG).show();
                            }
                        }).show();


            }
        });

        fabSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "알람 fab입니다.", Toast.LENGTH_LONG).show();
            }
        });

        fabSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "쇼핑 fab입니다.", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void toggleFab() {
        if (isFabOpen) {

            ObjectAnimator.ofFloat(fabSub1, "translationY", 0f).start();
            ObjectAnimator.ofFloat(fabSub2, "translationY", 0f).start();
            fab.setImageResource(R.drawable.ic_add);
        } else {
            ObjectAnimator.ofFloat(fabSub1, "translationY", -200f).start();
            ObjectAnimator.ofFloat(fabSub2, "translationY", -400f).start();
            fab.setImageResource(R.drawable.ic_sub);
        }
        isFabOpen = !isFabOpen;

    }
}

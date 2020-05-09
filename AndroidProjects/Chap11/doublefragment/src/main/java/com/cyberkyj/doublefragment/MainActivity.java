package com.cyberkyj.doublefragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ImageFragment imageFragment;
    int[] id={R.drawable.jeju1, R.drawable.jeju2, R.drawable.jeju3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageFragment = (ImageFragment)getSupportFragmentManager().findFragmentById(R.id.image_Fragment);
    }

    public void onImageSelected(int postion){
        imageFragment.setImage(id[postion]);
    }
}

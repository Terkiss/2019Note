package com.example.doublefragment;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    ImageFragment imageFragment ;
    int[] picID = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageFragment = (ImageFragment)getSupportFragmentManager().findFragmentById(R.id.imageView_Fragment);

    }

    public void onImageselected(int position)
    {
        Log.d("Jeong", "mainactivity position :: "+position);
        imageFragment.setImage(picID[position]);
    }

}

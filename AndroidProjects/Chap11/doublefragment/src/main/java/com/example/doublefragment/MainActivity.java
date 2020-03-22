package com.example.doublefragment;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    ImageFragment imageFragment ; // 프레그먼트 생성

    int[] picID = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                            // 프래그 먼트 리턴                        ID를 이용해 프래그먼트 객체를 찿음
        imageFragment = (ImageFragment)getSupportFragmentManager().findFragmentById(R.id.imageView_Fragment);

    }

    public void onImageselected(int position)
    {
        Log.d("Jeong", "mainactivity position :: "+position);
        imageFragment.setImage(picID[position]);
    }

}

package com.example.framelaout_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton img1, img2;
    int[] imgarray  = new int[13];
    int image_index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        img1 = findViewById(R.id.imageButton);


        for(int i = 1 ; i < 14; i++)
        {
                                                    //      이름                      타입                  패키지명
            int img = getResources().getIdentifier("@drawable/jeju"+i, "drawable",this.getPackageName());

            imgarray[i-1] = img;
        }



    }

    public  void onChange(View v)
    {
        if(image_index == imgarray.length)
        {
            image_index = 0;

        }

        img1.setImageResource(imgarray[image_index]);
        Toast.makeText(getApplicationContext(), "생성 아이디 "+imgarray[image_index],Toast.LENGTH_LONG).show();
        image_index++;
    }
}

package com.dotge.self10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class ViewPlereaper extends AppCompatActivity {
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_plereaper);

        Intent intent = getIntent();
        int voteResult[] = intent.getIntArrayExtra("VoteCount");
        String imgName[] = intent.getStringArrayExtra("ImageName");
        int imageFiled[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};
        int imageViewID[] = {
                R.id.viewImage1, R.id.viewImage2, R.id.viewImage3, R.id.viewImage4,
                R.id.viewImage5, R.id.viewImage6, R.id.viewImage7, R.id.viewImage8,
                R.id.viewImage9
        };
        ImageView imageView[] = new ImageView[imageViewID.length];


        Button autoStart = findViewById(R.id.button1);
        Button autoStop = findViewById(R.id.button2);

        for(int i = 0; i < imageViewID.length; i++)
        {
            imageView[i] = findViewById(imageViewID[i]);
        }


        viewFlipper = findViewById(R.id.viewFlipper);




        EvalutionRating(voteResult, imageFiled, imgName, imageView);







        autoStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewFlipper.setFlipInterval(1000);
                viewFlipper.startFlipping();
            }
        });

        autoStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setFlipInterval(1000);
                viewFlipper.stopFlipping();
            }
        });


    }



    public void EvalutionRating(int[] voteCount, int[] imageFiled, String[] imageName, ImageView[] imageViews)
    {
        int i = 0;
        int j = 0;
        int ProcessingVoteCount = 0;
        int ProcessingImageFiled = 0;
        String ProcessingImageID = "";


        Toast.makeText(getApplicationContext(), "호출합니다",  Toast.LENGTH_LONG).show();
        while(i < voteCount.length)
        {
            ProcessingVoteCount = voteCount[i];
            ProcessingImageFiled = imageFiled[i];
            ProcessingImageID = imageName[i];
            for ( j = i - 1; j >= 0 && voteCount[j] > ProcessingVoteCount; j--)
            {
                voteCount[j + 1] =  voteCount[j]; // 레코드의 오른쪽으로 이동
                imageFiled[j + 1] = imageFiled[j];
                imageName[ j + 1 ] = imageName[j];
            }
            voteCount[j + 1] = ProcessingVoteCount;
            imageFiled[j+1] = ProcessingImageFiled;
            imageName[j+1] = ProcessingImageID;
            i++;
        }
        j = 0;
        for(i =imageName.length-1; i>= 0; i--)
        {
            Toast.makeText(getApplicationContext(), imageName[i],  Toast.LENGTH_LONG).show();
            imageViews[j].setImageResource(imageFiled[i]);
            j++;
        }
    }
}

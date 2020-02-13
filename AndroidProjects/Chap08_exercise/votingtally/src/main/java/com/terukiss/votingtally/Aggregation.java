package com.terukiss.votingtally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Aggregation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggregation);
        Intent intent = getIntent();

        int rbID[] = {
                R.id.rb1, R.id.rb2, R.id.rb3,
                R.id.rb4, R.id.rb5, R.id.rb6,
                R.id.rb7, R.id.rb8, R.id.rb9
        };
        int tvID[] = {
                R.id.tv1, R.id.tv2, R.id.tv3,
                R.id.tv4, R.id.tv5, R.id.tv6,
                R.id.tv7, R.id.tv8, R.id.tv9
        };

        TextView[] textViews = new TextView[9];
        RatingBar rb[] = new RatingBar[9];

        int imgFiled [] = intent.getIntArrayExtra("files");
        int voteRating[] = intent.getIntArrayExtra("score");
        String name[] = intent.getStringArrayExtra("name");

        int max =0;

        for(int i = 0 ; i <  voteRating.length; i++)
        {
            textViews[i] = findViewById(tvID[i]);
            textViews[i].setText(name[i]);

            rb[i] = findViewById(rbID[i]);

            if(voteRating[max]<voteRating[i]){
                max = i;
            }

        }


        for(int i =0; i < voteRating.length; i++)
        {
            float rating = voteRating[i];
            rb[i].setRating(rating);
        }

        Button button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        TextView tvTop = findViewById(R.id.tvTop);
        ImageView ivTop = findViewById(R.id.ivTop);

        tvTop.setText(textViews[max].getText());
        ivTop.setImageResource(imgFiled[max]);













    }
}

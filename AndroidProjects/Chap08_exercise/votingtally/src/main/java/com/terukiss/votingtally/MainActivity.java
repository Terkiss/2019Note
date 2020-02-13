package com.terukiss.votingtally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int voteRating[];
    String name[]= {"1번", "2번", "3번", "4번", "5번", "6번", "7번", "8번", "9번"};
    int imgFiled[] = new int[9];
    ImageView imageView[] = new ImageView[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.voteExit);


        voteRating = new int[9];
        for (int i = 0; i < imgFiled.length; i++) {
            //      이름                      타입                  패키지명
            imgFiled[i] = getResources().getIdentifier("@drawable/pic" + (i + 1), "drawable", this.getPackageName());
            int id = getResources().getIdentifier("pic" + (i + 1), "id", this.getPackageName());
            imageView[i] = findViewById(id);
            Log.d("Voting", "이미지 동적 아이디" + imgFiled[i] + " 이미지뷰 동적 아이디  " + id + "  " + imageView[i]);
        }
        for (int i = 0; i < imgFiled.length; i++) {
            imageView[i].setImageResource(imgFiled[i]);
            voteRating[i] = 0;
        }

        for (int i = 0; i < imageView.length; i++)
        {
            final int index = i;
            imageView[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteRating[index]++;
                    Toast.makeText(getApplicationContext(), name[index]+" : 총" +voteRating[index]+"표",Toast.LENGTH_LONG).show();
                }
            });
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Aggregation.class);

                intent.putExtra("files", imgFiled);
                intent.putExtra("score", voteRating);
                intent.putExtra("name", name);

                startActivity(intent);
            }
        });


    }




}

package com.terukiss.mysinger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static MainActivity _this  = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 자체 싱글톤
        if(_this == null)
        {
            _this = MainActivity.this;
        }
        final EditText nameText, ageText;
        Button soloSing, groupSing;
        nameText = findViewById(R.id.nameInput);
        ageText = findViewById(R.id.ageInput);

        soloSing = findViewById(R.id.singerGen);
        groupSing = findViewById(R.id.groupSingerGen);

        soloSing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singer singer = new Singer(nameText.getText().toString(), ageText.getText().toString());

                ToastMessanger("가수 추가 완료됨  %s 의 나이 %s", singer.name, singer.age);
                setTotalCount(singer.getTotal());
            }
        });

        groupSing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GirlGroupSinger girlGroupSinger = new GirlGroupSinger(nameText.getText().toString(), ageText.getText().toString());
                ToastMessanger("걸그룹 추가 완료됨  %s 의 나이 %s", girlGroupSinger.name, girlGroupSinger.age);
                setTotalCount(girlGroupSinger.getTotal());
            }
        });

    }
    public void ToastMessanger(String data, Object...oj )
    {
        String tempStringData = String.format(data, oj);

        Toast.makeText(getApplicationContext(), tempStringData, Toast.LENGTH_LONG ).show();
    }
    public void setTotalCount(int count)
    {
        TextView textView = findViewById(R.id.textView);
        String data = "추가한 가수의 총수 : "+count;
        textView.setText(data);
    }

}

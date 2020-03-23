package com.example.viewpager_ex;

import android.app.assist.AssistStructure;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Person extends LinearLayout {
    Context context;
    TextView textView;
    Button button;
    ImageView imageView;
    int imageId;

    public Person(Context context)
    {
        super(context);
        this.context = context;
        init();
    }

    // init UI를 그리기 위한 레이아웃 초기화
    public void init()
    {
        final LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_pager, this, true);

        textView = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String call_num = (String)button.getTag();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+call_num));
                context.startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                switch (imageId)
                {
                    case R.drawable.jeju1:
                    Intent intent = new Intent(context.getApplicationContext(), NewActivity.class);
                    break;
                }
            }
        });

    }

    public void setName(String name) {
        textView.setText(name);
    }

    public void setCall_Btn(String number) {
        button.setText(number);
        button.setTag(number);
    }

    public void setImage(int id){
        imageView.setImageResource(id);
        imageId = id;
    }


}



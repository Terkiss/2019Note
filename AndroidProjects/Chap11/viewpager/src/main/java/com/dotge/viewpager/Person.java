package com.dotge.viewpager;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Person extends LinearLayout
{
    Context context;
    TextView textView;
    Button bUtton;
    ImageView imageView;

    int imageId;

    public Person(Context conter)
    {
        super(conter);

        this.context =conter;
        init();

    }
    public void init()
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_page, this, true);

        textView = findViewById(R.id.textView);
        bUtton = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

        bUtton.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v)
           {
               String call = bUtton.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+call));
                context.startActivity(intent);
           }
        });

        imageView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                switch (imageId)
                {
                    case R.drawable.jeju1:
                        Intent intent = new Intent(context.getApplicationContext(), New1Activity.class);
                        context.startActivity(intent);
                        break;
                }
            }
        });


    }

    public void setName(String name)
    {
        textView.setText(name);
    }
    public void setcall(String callNum)
    {
        bUtton.setText(callNum);
        bUtton.setTag(callNum);

    }

    public void setImageID(int id)
    {
        imageView.setImageResource(id);
        imageId = id;
    }

}

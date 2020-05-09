package com.dotge.self4_42;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    RadioGroup radioGroup;
    RadioButton rbo_7, rbo_8, rbo_9;
    ImageView imageView;
    Button button1, button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Switch sw = findViewById(R.id.switch2);
        textView = findViewById(R.id.textView2);
        radioGroup = findViewById(R.id.rdo_group);

        rbo_7 = findViewById(R.id.rdo_7);
        rbo_8 = findViewById(R.id.rdo_8);
        rbo_9 = findViewById(R.id.rdo_8);

        imageView= findViewById(R.id.imageView);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true)
                {
                    textView.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                }
                else
                {
                    textView.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                    button1.setVisibility(View.INVISIBLE);
                    button2.setVisibility(View.INVISIBLE);
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.INVISIBLE);
                radioGroup.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);

                imageView.setImageResource(0);
                radioGroup.clearCheck();
                sw.setChecked(false);

            }
        });

    }
    public void onVersion(View view)
    {
        switch (view.getId())
        {
            case R.id.rdo_7:
                imageView.setImageResource(R.drawable.api50);
                break;
            case R.id.rdo_8:
                imageView.setImageResource(R.drawable.api60);
                break;
            case R.id.rdo_9:
                imageView.setImageResource(R.drawable.api70);
                break;

        }
    }
}

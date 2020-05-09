package com.dotge.chap11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
               View aa = inflater.inflate(R.layout.ac_sub, layout, false);
                TextView tv = aa.findViewById(R.id.textView);
                final CheckBox checkBox = aa.findViewById(R.id.checkBox);
                tv.append(" "+(count++));

                layout.addView(aa);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked == true)
                        {
                            checkBox.setText("로딩");
                        }
                        else
                        {
                            checkBox.setText("");
                        }
                    }
                });


            }
        });


    }
}

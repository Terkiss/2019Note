package com.terukiss.inflator_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;
    int count = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = findViewById(R.id.container);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater LF = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View a= LF.inflate(R.layout.scondery_main, ll, false);
                TextView textView =  a.findViewById(R.id.textView1);
                ll.addView(a);
                CheckBox chk = ll.findViewById(R.id.checkbox1);
                textView.setText(textView.getText().toString() + count++);
                chk.setText("로딩 완료요");
            }
        });
    }
}

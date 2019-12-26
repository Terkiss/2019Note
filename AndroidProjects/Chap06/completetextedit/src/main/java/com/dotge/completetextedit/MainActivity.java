package com.dotge.completetextedit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] item =
                {
                    "CSI-뉴욕", "CSI-라스베가스", "CSI-마이매미", "FREIND", "Fringe", "Lost"
                };

        AutoCompleteTextView auto = findViewById(R.id.autoTextGen);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item);
        auto.setAdapter(adapter);

        MultiAutoCompleteTextView autoMult = findViewById(R.id.multAutoTextGen);

        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();

        autoMult.setTokenizer(token);
        autoMult.setAdapter(adapter);
    }
}

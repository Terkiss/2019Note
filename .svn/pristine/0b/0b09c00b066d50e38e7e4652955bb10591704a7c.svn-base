package com.dotge.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Secondery extends AppCompatActivity {

    int result;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondery);

        Button button = findViewById(R.id.button);

        Intent intent = getIntent();
        int leftOp =  intent.getIntExtra("Left Operator",0);

        int rightOp = intent.getIntExtra("Right Operator",0);
        int middleOp = intent.getIntExtra("Middle Operator",0);

        if(middleOp < 2)
        {
            if(middleOp == 0)
            {
                result = leftOp + rightOp;
                data = leftOp+"+"+rightOp+"덧셈 결과 :: "+result;
            }
            else
            {
                result = leftOp - rightOp;
                data = leftOp+"-"+rightOp+"뺄샘 결과 :: "+result;
            }
        }
        else
        {
            if(middleOp == 2)
            {
                result = leftOp * rightOp;
                data = leftOp+"*"+rightOp+"곱셈 결과 :: "+result;
            }
            else
            {
                result = leftOp / rightOp;
                data = leftOp+"/"+rightOp+"나눗셈 결과 :: "+result;
            }
        }

        intent.putExtra("resultString", data);
        intent.putExtra("resultInt", result);
        setResult(RESULT_OK, intent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

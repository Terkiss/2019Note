package com.dotge.self10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Calculrate extends AppCompatActivity {
    RadioGroup radioGroup;
    EditText edt, edt2;
    int result ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculrate);

        radioGroup = findViewById(R.id.radiogroup);
        edt = findViewById(R.id.operator1);
        edt2 = findViewById(R.id.operator2);

    }
    public void OnCalculate(View v)
    {
        int op, op2;
        op = Integer.parseInt(edt.getText().toString());
        op2 = Integer.parseInt(edt2.getText().toString());
        switch (radioGroup.getCheckedRadioButtonId())
        {
            case R.id.radioButton: // +
                result = op+op2;
                Toast.makeText(getApplicationContext(), "결과는 : "+(op+op2), Toast.LENGTH_LONG).show();
                break;
            case R.id.radioButton2: // -
                result = op-op2;
                Toast.makeText(getApplicationContext(), "결과는 : "+(op-op2), Toast.LENGTH_LONG).show();
                break;
            case R.id.radioButton3: // *
                result = op*op2;
                Toast.makeText(getApplicationContext(), "결과는 : "+(op*op2), Toast.LENGTH_LONG).show();
                break;
            case R.id.radioButton4: // /
                result = op/op2;
                Toast.makeText(getApplicationContext(), "결과는 : "+(op/op2), Toast.LENGTH_LONG).show();
                break;
        }


        setResult(RESULT_OK);
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable()  {
            public void run() {
                // 시간 지난 후 실행할 코딩
                finish();


            }
        }, 5000); // 5초후
    }
}

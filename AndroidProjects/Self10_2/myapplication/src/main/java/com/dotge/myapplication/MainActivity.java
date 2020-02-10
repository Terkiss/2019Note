package com.dotge.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    EditText edt, edt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radiogroup);
        edt = findViewById(R.id.operator1);
        edt2 = findViewById(R.id.operator2);




    }

    public void OnCalculate(View v)
    {
        int op, op2;
        op = Integer.parseInt(edt.getText().toString());
        op2 = Integer.parseInt(edt2.getText().toString());

        final Intent intent = new Intent(getApplicationContext(), Secondery.class);
        int selector = 0;
        switch (radioGroup.getCheckedRadioButtonId())
        {
            case R.id.radioButton: // +
                selector = 0;

                break;
            case R.id.radioButton2: // -
                selector = 1;

                break;
            case R.id.radioButton3: // *
                selector = 2;

                break;
            case R.id.radioButton4: // /
                selector = 3;

                break;
        }

        intent.putExtra("Left Operator", op);
        intent.putExtra("Right Operator", op2);
        intent.putExtra("Middle Operator", selector);


        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable()  {
            public void run() {
                // 시간 지난 후 실행할 코딩
                startActivityForResult(intent, 999);
            }
        }, 5000); // 5초후
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 999 && resultCode == RESULT_OK)
        {
            String result = data.getStringExtra("resultString");
            int resultInt = data.getIntExtra("resultInt", 0);
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }
}


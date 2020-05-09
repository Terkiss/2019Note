package com.dotge.self4_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.edit1);
        editText2 = findViewById(R.id.edit2);

        txtResult = findViewById(R.id.textResult);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnDiv = findViewById(R.id.btnDiv);
        Button btnRem = findViewById(R.id.btnRem);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = editText1.getText().toString();
                String num2 = editText2.getText().toString();

                if(num1.length() < 1 || num2.length() < 1)
                {
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다.", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Double result = Double.parseDouble(num1) + Double.parseDouble(num2);

                    txtResult.setText("계산결과 : "+ result.toString() );
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = editText1.getText().toString();
                String num2 = editText2.getText().toString();

                if(num1.length() < 1 || num2.length() < 1)
                {
                    Toast.makeText(getApplicationContext(), "입력 값이 비었습니다.", Toast.LENGTH_LONG).show();

                }
                else
                {
                    Double result = Double.parseDouble(num1) - Double.parseDouble(num2);

                    txtResult.setText("계산결과 : "+ result.toString() );
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = editText1.getText().toString();
                String num2 = editText2.getText().toString();

                if(num1.length() < 1 || num2.length() < 1)
                {
                   print("입력값이 비었습니다");
                }
                else
                {
                    Double result = Double.parseDouble(num1) * Double.parseDouble(num2);

                    txtResult.setText("계산결과 : "+ result.toString() );
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = editText1.getText().toString();
                String num2 = editText2.getText().toString();

                if(num1.length() < 1 || num2.length() < 1)
                {
                   print("입력값이 비었습니다");
                }
                else if(num1.equals("0") || num2.equals("0"))
                {
                    print("0으로 나누면 안됩니다.");
                }
                else
                {
                    Double result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    result = (int) (result * 10 ) / 10.0;// 소수점 아래 한자리까지
                    txtResult.setText("계산결과 : "+ result.toString() );

                }
            }
        });

        btnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = editText1.getText().toString();
                String num2 = editText2.getText().toString();

                if(num1.length() < 1 || num2.length() < 1)
                {
                    print("입력 값이 비었습니다.");
                }
                else if(num1.equals("0") || num2.equals("0"))
                {
                    print("0으로 나누면 안됩니다.");
                }
                else
                {
                    Double result = Double.parseDouble(num1) % Double.parseDouble(num2);

                    txtResult.setText("계산결과 : "+ result.toString() );

                }
            }
        });

    }
    public void print(String _message)
    {
        Toast.makeText(getApplicationContext(), _message, Toast.LENGTH_LONG).show();

    }
}

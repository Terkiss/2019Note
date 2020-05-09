package com.dotge.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

   // EditText inputNum2 ;
    //TextView result ;
   // Button add ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewBuId
        // R.id


        final Button operatorView, plusBtn, minusBtn, muxBtn, diviBtn;



        final EditText inputNum1        =       (EditText) findViewById(R.id.txtnum)    ;
        final EditText inputNum2        =       (EditText) findViewById(R.id.txtnum2)   ;
        final TextView result           =       (TextView) findViewById(R.id.resultcal) ;


        Button add      =       (Button) findViewById(R.id.calulatebtn)     ;
        operatorView    =       (Button) findViewById(R.id.operaterView)    ;
        plusBtn         =       (Button) findViewById(R.id.plusbtn)         ;
        minusBtn        =       (Button) findViewById(R.id.minusbtn)        ;
        muxBtn          =       (Button) findViewById(R.id.multibtn)        ;
        diviBtn         =       (Button) findViewById(R.id.divisionbtn)     ;


        operatorView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                operatorView.setVisibility(View.INVISIBLE);
                plusBtn.setVisibility(View.VISIBLE);
                minusBtn.setVisibility(View.VISIBLE);
                muxBtn.setVisibility(View.VISIBLE);
                diviBtn.setVisibility(View.VISIBLE);
            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minusBtn.setVisibility(View.INVISIBLE);
                muxBtn.setVisibility(View.INVISIBLE);
                diviBtn.setVisibility(View.INVISIBLE);
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusBtn.setVisibility(View.INVISIBLE);
                muxBtn.setVisibility(View.INVISIBLE);
                diviBtn.setVisibility(View.INVISIBLE);
            }
        });
        muxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusBtn.setVisibility(View.INVISIBLE);
                minusBtn.setVisibility(View.INVISIBLE);
                diviBtn.setVisibility(View.INVISIBLE);
            }
        });
        diviBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusBtn.setVisibility(View.INVISIBLE);
                minusBtn.setVisibility(View.INVISIBLE);
                muxBtn.setVisibility(View.INVISIBLE);

            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   int number1 = convert2Int( inputNum1.getText() );
                //int number2 = convert2Int( inputNum2.getText() );
                //int sum = number1 + number2;

                if(operatorView.getVisibility() == View.VISIBLE)
                {
                    result.setText("연산자를 골르고 버튼을 눌러 바보야");
                }
                else
                {
                    if(inputNum1.getText().toString().length() < 1 || inputNum2.getText().toString().length() < 1)
                    {
                        result.setText(String.valueOf("값을 넣어야지..."));

                    }
                    else if(plusBtn.getVisibility() == View.VISIBLE)
                    {
                        int number1 = convert2Int( inputNum1.getText() );
                        int number2 = convert2Int( inputNum2.getText() );
                        int sum = number1 + number2;
                        result.setText(String.valueOf(sum));
 // 010 36739644
                        operatorView.setVisibility(View.VISIBLE);
                        plusBtn.setVisibility(View.INVISIBLE);
                        minusBtn.setVisibility(View.INVISIBLE);
                        muxBtn.setVisibility(View.INVISIBLE);
                        diviBtn.setVisibility(View.INVISIBLE);
                    }
                    else if(minusBtn.getVisibility() == View.VISIBLE)
                    {
                        int number1 = convert2Int( inputNum1.getText() );
                        int number2 = convert2Int( inputNum2.getText() );
                        int sum = number1 - number2;
                        result.setText(String.valueOf(sum));

                        operatorView.setVisibility(View.VISIBLE);
                        plusBtn.setVisibility(View.INVISIBLE);
                        minusBtn.setVisibility(View.INVISIBLE);
                        muxBtn.setVisibility(View.INVISIBLE);
                        diviBtn.setVisibility(View.INVISIBLE);
                    }
                    else if(muxBtn.getVisibility() == View.VISIBLE)
                    {
                        int number1 = convert2Int( inputNum1.getText() );
                        int number2 = convert2Int( inputNum2.getText() );
                        int sum = number1 * number2;
                        result.setText(String.valueOf(sum));

                        operatorView.setVisibility(View.VISIBLE);
                        plusBtn.setVisibility(View.INVISIBLE);
                        minusBtn.setVisibility(View.INVISIBLE);
                        muxBtn.setVisibility(View.INVISIBLE);
                        diviBtn.setVisibility(View.INVISIBLE);
                    }
                    else if(diviBtn.getVisibility() == View.VISIBLE)
                    {
                        int number1 = convert2Int( inputNum1.getText() );
                        int number2 = convert2Int( inputNum2.getText() );
                        int sum = number1 / number2;
                        result.setText(String.valueOf(sum));

                        operatorView.setVisibility(View.VISIBLE);
                        plusBtn.setVisibility(View.INVISIBLE);
                        minusBtn.setVisibility(View.INVISIBLE);
                        muxBtn.setVisibility(View.INVISIBLE);
                        diviBtn.setVisibility(View.INVISIBLE);
                    }
                }


                //result.setText(String.valueOf(sum));
            }
        });



    }


    public static int convert2Int(Object data)
    {
        return Integer.parseInt(String.valueOf(data));
    }
    public static long convert2Long(Object data)
    {
        return Long.parseLong(String.valueOf(data));
    }
    public static byte convert2Byte(Object data)
    {

        return Byte.parseByte(String.valueOf(data));
    }
    public static float convert2Float(Object data)
    {
        return Float.parseFloat(String.valueOf(data));
    }
}

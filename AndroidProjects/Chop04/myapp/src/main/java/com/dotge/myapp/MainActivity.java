package com.dotge.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        final EditText inputNum1 = (EditText) findViewById(R.id.txtnum);
        final EditText inputNum2 = (EditText) findViewById(R.id.txtnum2);
        final TextView result = (TextView) findViewById(R.id.resultcal);
        Button add = (Button) findViewById(R.id.addbtn);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1 = convert2Int( inputNum1.getText() );
                int number2 = convert2Int( inputNum2.getText() );
                int sum = number1 + number2;
                result.setText(String.valueOf(sum));
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

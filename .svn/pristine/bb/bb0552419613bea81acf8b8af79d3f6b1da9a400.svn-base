package com.dotge.selfcheck1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String data1, data2, data3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name,etage,etadress;
        final TextView nametv,agetv,adresstv;
        Button storeBtn,exitBtn;

        name = (EditText) findViewById(R.id.nametxt);
        etage = (EditText) findViewById(R.id.agetxt);
        etadress = (EditText) findViewById(R.id.adresstxt);

        storeBtn = (Button) findViewById(R.id.storebtn);
        exitBtn = (Button) findViewById(R.id.exitbtn);

        nametv = (TextView) findViewById(R.id.tvname);
        agetv = (TextView) findViewById(R.id.tvage);
        adresstv = (TextView) findViewById(R.id.tvadress);

        data1 = nametv.getText().toString() + " : ";
        data2 = agetv.getText().toString()+ " : ";
        data3 = adresstv.getText().toString()+ " : ";

        

        storeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = name.getText().toString();
                nametv.setText(data1 + a);
                agetv.setText(data2 + String.valueOf(etage.getText()));
                adresstv.setText(data3 + String.valueOf( etadress.getText()));

                Toast.makeText(getApplicationContext(), "해내땅 해내땅", Toast.LENGTH_LONG).show();
            }
        });




    }
    public void onClose(View v)
    {
        finish();
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

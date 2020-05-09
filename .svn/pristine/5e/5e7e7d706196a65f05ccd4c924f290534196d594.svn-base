package com.dotge.j_chap16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        layout = findViewById(R.id.layout);


    }
    public void OnBenz(View view)
    {
        int price =  Integer.parseInt(editText.getText().toString());
        Benz benz = new Benz(this);
        benz.setPrice(price);
        CarProtoType.cars.add((benz));
        Toast.makeText(getApplicationContext(), "Benz 구매함", Toast.LENGTH_LONG).show();
        addToLayout();
    }
    public void OnBmw(View view)
    {
        int price =  Integer.parseInt(editText.getText().toString());
        Bmw bmw = new Bmw(this);
        bmw.setPrice(price);
        CarProtoType.cars.add((bmw));
        Toast.makeText(getApplicationContext(), "Bmw 구매함", Toast.LENGTH_LONG).show();
        addToLayout();
    }

    public void addToLayout()
    {
        Button button = new Button(this);
        button.setTag(CarProtoType.cars.size() -1 );
        button.setText("CAR "+CarProtoType.cars.size());
        button.setTextSize(50);
        layout.addView(button);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Button curButton = (Button) v;
                int index = ((Integer)curButton.getTag()).intValue();
                Car curCar = CarProtoType.cars.get(index);

                int price = curCar.getPrice();

                if(curCar instanceof Benz)
                {
                    Toast.makeText(getApplicationContext(), "지금 선택 하신 차종은 Benz 차종 이고 가격은 "+price+" 만원 입니다", Toast.LENGTH_LONG).show();
                }
                else if(curCar instanceof Bmw)
                {
                    Toast.makeText(getApplicationContext(), "지금 선택 하신 차종은 Bmw 차종 이고 가격은 "+price+" 만원 입니다", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}

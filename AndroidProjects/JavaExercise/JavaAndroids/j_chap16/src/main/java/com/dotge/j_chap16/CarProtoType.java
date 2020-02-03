package com.dotge.j_chap16;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public abstract class CarProtoType implements  Car {

    public static ArrayList<Car> cars = new ArrayList<Car>();

    Context context;
    private  int price;
    public CarProtoType(Context context)
    {
        this.context = context;
    }

    public void doStart()
    {
        Toast.makeText(context, "CarPortoType 의 doStart 메소드가 호출도히었습니다.", Toast.LENGTH_LONG).show();
    }
    public void doTurn()
    {
        Toast.makeText(context, "CarPortoType 의 doTurn 메소드가 호출도히었습니다.", Toast.LENGTH_LONG).show();
    }

    public void doStop()
    {
        Toast.makeText(context, "CarPortoType 의 doStop 메소드가 호출도히었습니다.", Toast.LENGTH_LONG).show();
    }

    public abstract  void doRun();

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

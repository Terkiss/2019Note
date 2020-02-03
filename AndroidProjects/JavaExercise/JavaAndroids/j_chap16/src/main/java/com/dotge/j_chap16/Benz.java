package com.dotge.j_chap16;

import android.content.Context;
import android.widget.Toast;

public class Benz extends CarProtoType{

    public Benz(Context context)
    {
        super(context);
    }

    @Override
    public void doRun() {
        Toast.makeText(context, "Benz 의 doRun 메소드가 호출됨 ", Toast.LENGTH_LONG).show();
    }
}

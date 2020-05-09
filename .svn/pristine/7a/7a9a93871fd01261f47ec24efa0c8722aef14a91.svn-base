package com.dotge.chap10;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class LoadingManager extends AppCompatActivity  {
    public static LoadingManager _LoadingManager  = new LoadingManager();
    Context context;
    private LoadingManager()
    {

    }
    public void setContext(Context a)
    {
        context =a;
    }
    public void Load(Class<?> cls)
    {
        Intent intent = new Intent(this, cls);

        startActivity(intent);
    }
}

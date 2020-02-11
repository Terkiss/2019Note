package com.dotge.chap09;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle", "onCreate() 실행");
        textView = findViewById(R.id.textView2);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "onStart() 실행");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "onStop() 실행");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "onDestroy() 실행");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "onPause() 실행");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "onResume() 실행");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "onRestart() 실행");
    }

    public void onNew(View view) {
        Intent intent = new Intent(getApplicationContext(), NewActivity.class);
        startActivity(intent);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("LifeCycle", "onConfigurationChange 실행");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("LifeCycle", "onSaveInstanceState 실행");
        String data = textView.getText().toString();
        outState.putString("bakup", data);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("LifeCycle", "onRestoreInstanceState 실행");
        if(savedInstanceState != null)
        {
            textView.setText(savedInstanceState.getString("bakup"));
        }
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Log.d("LifeCycle", "onRestoreInstanceState 실행");

    }
}

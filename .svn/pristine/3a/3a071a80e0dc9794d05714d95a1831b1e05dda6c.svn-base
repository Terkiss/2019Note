package com.cyberkyj.local_broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import java.io.BufferedOutputStream;
import java.util.concurrent.BrokenBarrierException;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        broadcastReceiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(MyReceiver.MY_ACTION);

        //filter.setPriority(1000);
        registerReceiver(broadcastReceiver, filter);
    }

    public void onSend(View v){
        Intent intent = new Intent(MyReceiver.MY_ACTION);
        sendBroadcast(intent);

    }
}

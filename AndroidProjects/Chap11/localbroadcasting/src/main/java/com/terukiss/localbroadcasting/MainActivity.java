package com.terukiss.localbroadcasting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        broadcastReceiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(MyReceiver.My_ACTION);
        filter.setPriority(1000);

        registerReceiver(broadcastReceiver, filter);

    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(broadcastReceiver);
        super.onDestroy();
    }

    public void onMessage(View v)
    {
        Intent intent = new Intent(MyReceiver.My_ACTION);
        sendBroadcast(intent);
    }
}

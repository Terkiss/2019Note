package com.example.systembroadcast_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = findViewById(R.id.textViewer);
        Button  button = findViewById(R.id.textGenBtn);

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);


        Intent batteryStatus = registerReceiver(chargingReceive, ifilter);


        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status==BatteryManager.BATTERY_STATUS_CHARGING;

        // 배터리가 차징 되고 있다면
        if(isCharging){
            int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            boolean usbCharge =  chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
            boolean acCharge =  chargePlug == BatteryManager.BATTERY_PLUGGED_AC;

            Log.d("Jeong", "USB :: "+BatteryManager.BATTERY_PLUGGED_USB);
            Log.d("Jeong", "USB :: "+BatteryManager.BATTERY_PLUGGED_AC);


        }



    }
    BroadcastReceiver chargingReceive = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String filter = intent.getAction();
            if(filter.equals(Intent.ACTION_BATTERY_CHANGED))
            {
                Log.d("Jeong", "현재 배터리가 충전 중입니다");
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scal = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
                Log.d("Jeong", "현재 배터리의 양은? : "+(level/(float)scal) );
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(chargingReceive);
    }
}

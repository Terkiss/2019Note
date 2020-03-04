package com.terukiss.systembreoadcasting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<String> datas;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        datas = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datas);
        listView.setAdapter(adapter);

        // 배터리 상황을 파악
        // 실제 브로드 캐스트 리시버를 등록하는 구문이 아니라
        // 시스템 배터리 상태의 정보값만 얻기 위한구문
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
                                    // 여기에 따로 리시버를 넣는다면? 알아보자
        Intent batteryStatus = registerReceiver(null,filter);


        // 스마트 폰에 배터리가 차징 되고 있니 ? ? ?
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status==BatteryManager.BATTERY_STATUS_CHARGING;

        // 배터리가 차징 되고 있다면
        if(isCharging){
            int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            boolean usbCharge =  chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
            boolean acCharge =  chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
            if(usbCharge){
                addListItem("Battery is USB Charging");
            }else if(acCharge){
                addListItem("Battery is AC Charging");
            }
        }else{
            addListItem("Battery State is not Charging");
        }


        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float pct = (level/(float)scale)*100;
        addListItem("Current Battery : "+pct+"%");
        // 브로드 캐스트 등록
        registerReceiver(brOn,new IntentFilter(Intent.ACTION_SCREEN_ON));
        registerReceiver(brOff,new IntentFilter(Intent.ACTION_SCREEN_OFF));
        registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_POWER_CONNECTED));
        registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_POWER_DISCONNECTED));


        // 위험 권한 설정
        if( ContextCompat.checkSelfPermission(this, Manifest.permission.PROCESS_OUTGOING_CALLS) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED){

            // 위험 권한 요청
            ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.PROCESS_OUTGOING_CALLS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_CALL_LOG }, 100);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0) {
            // 하나라도 권한이 승이이 안되었다면 .
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED || grantResults[1] != PackageManager.PERMISSION_GRANTED || grantResults[2] != PackageManager.PERMISSION_GRANTED) {
                Toast toast = Toast.makeText(this, "no permission", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(brOn);
        unregisterReceiver(brOff);
        unregisterReceiver(batteryReceiver);
    }

    private void addListItem(String msg){
        datas.add(msg);
        adapter.notifyDataSetChanged();
    }

    // 화면 on/ off 이상황을 체크해서 특정 로직의 수행을 구동하거나 정지
    // 액티비티 서비스 들의 코드 에서 동적으로 등록해야만 실행
    BroadcastReceiver brOn = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            addListItem("Screen On");
        }
    };
    BroadcastReceiver brOff = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            addListItem("Screen Off");
        }
    };

    BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(Intent.ACTION_POWER_CONNECTED)){
                addListItem("On Connected");
            }else if(action.equals(Intent.ACTION_POWER_DISCONNECTED)){
                addListItem("On Disconnected");
            }
        }
    };
}

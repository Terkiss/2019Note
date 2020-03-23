package com.cyberkyj.system_broadcastreceiver;

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
import android.widget.Adapter;
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

        // 리스트뷰의 기본 제공하는 어뎁터
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datas);

        // 어뎁터 등록
        listView.setAdapter(adapter);

        /// 인텐트 필터로 현재 배터리의 상태가 변했다면
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        /*
            1. intent filter 를 만든다.
            2. intent filter에 action을 추가한다.
            3. BroadCastReceiver를 익명 클래스로 구현 or 구현 한다.
            4. intent filter와 BroadCastReceiver를 등록한다.
         */
        Intent batteryStatus = registerReceiver(null,filter); // 얻은 배터리의 상태 필터로 널 브로드 캐스트 등록

        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);  // 현재 배터리의 상태를 추출

        boolean isCharging = status==BatteryManager.BATTERY_STATUS_CHARGING; // 배터리의 상태가 충전 중이면

        // 배터리의 상태가 충전중이 라면
        if(isCharging){

            int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1); // 차징 플러그값 가져오기

            boolean usbCharge =  chargePlug == BatteryManager.BATTERY_PLUGGED_USB; // 플러그 값을 이용 현재 충전 플러그가 어떤것인지 판단 해 해당 플러그일경우 true
            boolean acCharge =  chargePlug == BatteryManager.BATTERY_PLUGGED_AC;

            // usb 충전
            if(usbCharge)
            {
                addListItem("Battery is USB Charging");
            }// ac 충전
            else if(acCharge){
                addListItem("Battery is AC Charging");
            }
        }
        else // 그밖의 경우 충전주이지 않을떄
        {
            addListItem("Battery State is not Charging");
        }

        // 배터리 충전 상태 계산
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float pct = (level/(float)scale)*100;

        // 리스트뷰에 등록
        addListItem("Current Battery : "+pct+"%");


        // 브로드 캐스트 등록
        registerReceiver(brOn,new IntentFilter(Intent.ACTION_SCREEN_ON));
        registerReceiver(brOff,new IntentFilter(Intent.ACTION_SCREEN_OFF));
        registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_POWER_CONNECTED));
        registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_POWER_DISCONNECTED));

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.PROCESS_OUTGOING_CALLS) != PackageManager.PERMISSION_GRANTED ||
           ContextCompat.checkSelfPermission(this,Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED ||
           ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED){
           ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_CALL_LOG}, 100);

        }
    }


    // 퍼미션 요청했을떄 콜백되는 메서드
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length > 0) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED || grantResults[1] != PackageManager.PERMISSION_GRANTED || grantResults[2] != PackageManager.PERMISSION_GRANTED) {
                Toast toast = Toast.makeText(this, "no permission", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }


    // 액티비가 소멸시
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(brOn);
        unregisterReceiver(brOff);
        unregisterReceiver(batteryReceiver);
    }

    // 리스트뷰에 아이템 추가
    private void addListItem(String msg){
        datas.add(msg);
        adapter.notifyDataSetChanged();
    }

    // 브로드 캐스트 리시버 설정 작업
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

package com.terukiss.localbroadcasting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public static final String My_ACTION = "com.My.Broad.Receive";

    @Override
    public void onReceive(Context context, Intent intent) {
        // 브로드 캐스트도 인텐트가 옴으로 인텐트를 통한 데이터 전송이 가능해 보인다 일단 해보자
        if (My_ACTION.equals(intent.getAction())){
            Toast.makeText(context,"나만의 방송이 수신되었습니다.",Toast.LENGTH_LONG).show();
            String a;
            a = intent.getStringExtra("key")+"\n";
            a +=intent.getStringExtra("key1")+"\n";
            a +=intent.getStringExtra("key2")+"\n";
            Log.d("Jeong", "나의 방송 수신 됨 ");
            Log.d("Jeong", " \n"+a);
            abortBroadcast();
        }
    }
}

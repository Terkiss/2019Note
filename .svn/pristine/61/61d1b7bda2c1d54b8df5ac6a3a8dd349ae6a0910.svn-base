package com.cyberkyj.system_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // 인텐트 액션을 가져옴
        String action = intent.getAction();

        // 전화중일떄 액션
        if(action.equals("android.intent.action.NEW_OUTGOING_CALL"))
        {
            // 인탠트로 전화번호 추출
            String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);


            // 명시적 인탠트
            Intent intent1 = new Intent(context, DialogActivity.class);

            // 전화번호 삽입
            intent1.putExtra("number",phoneNumber);

            // 새창에서
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // 액티비티 실행
            context.startActivity(intent1);
        } // 전화 수신중 일떄 액션
        else if (action.equals("android.intent.action.PHONE_STATE"))
        {
            // 인텐트에서 번들 데이터 추출
            Bundle bundle = intent.getExtras();

            // 전화 상태를 추출
            String state = bundle.getString(TelephonyManager.EXTRA_STATE);
            String phoneNumber = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);

            // 통화 통화 벨 울릴 떄
            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING) && phoneNumber!=null){
                Intent intent1 = new Intent(context, DialogActivity.class);
                intent1.putExtra("number", phoneNumber);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
            }
        }
    }
}

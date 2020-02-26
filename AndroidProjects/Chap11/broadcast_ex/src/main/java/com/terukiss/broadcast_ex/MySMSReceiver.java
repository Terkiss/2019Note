package com.terukiss.broadcast_ex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MySMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Jeong", "OnReceive 호출됨");
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED"))
        {
            // sms 리시브 액션인지 확인
            Log.d("Jeong", "SMS Event received");

            // 브로드 캐스팅 취소
            abortBroadcast();

            Intent myIntent = new Intent(context, MainActivity.class);
            myIntent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(myIntent);

        }
    }
}

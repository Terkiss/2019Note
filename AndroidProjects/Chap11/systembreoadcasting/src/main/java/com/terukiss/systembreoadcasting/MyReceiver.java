package com.terukiss.systembreoadcasting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        // 전화가 걸을떄
        if(action.equals("android.intent.action.NEW_OUTGOING_CALL"))
        {
            String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Intent intent1 = new Intent(context, Dialog.class);
            intent1.putExtra("number",phoneNumber);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        } // 전화가 왔을떄
        else if(action.equals("android.intent.action.PHONE_STATE"))
        {
            Bundle bundle = intent.getExtras();
            String state = bundle.getString(TelephonyManager.EXTRA_STATE);
            String phoneNumber = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING) && phoneNumber!=null){
                Intent intent1 = new Intent(context, Dialog.class);
                intent1.putExtra("number", phoneNumber);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
            }
        }  // 부팅 했을떄
        else if(action.equals("android.intent.action.BOOT_COMPLETED"))
        {
            Log.d("Jeong", "부팅 했습니다 ");
            Intent intent1 = new Intent(context, MainActivity.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);

            context.startActivity(intent1);
        }
    }
}

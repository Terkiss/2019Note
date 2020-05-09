package com.cyberkyj.local_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public static final String MY_ACTION = "action.ACTION_MY_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {

        if(MY_ACTION.equals(intent.getAction())){
            Toast.makeText(context,"나만의 방송이 수신되었습니다.",Toast.LENGTH_LONG).show();
            abortBroadcast();
        }

    }




}

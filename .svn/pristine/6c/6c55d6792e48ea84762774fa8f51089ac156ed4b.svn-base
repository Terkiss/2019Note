package com.terukiss.localbroadcasting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public static final String My_ACTION = "action.ACTION_MY_REACT";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (My_ACTION.equals(intent.getAction())){
            Toast.makeText(context,"나만의 방송이 수신되었습니다.",Toast.LENGTH_LONG).show();
            Log.d("Jeong", "나의 방송 수신 됨 ");
            abortBroadcast();
        }
    }
}

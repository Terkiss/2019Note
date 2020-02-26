package com.terukiss.broadcastingtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.util.Log.*;

public class SmsReceiver extends BroadcastReceiver {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final String TAG = "SmsReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        // 리시브 받았을떄 호출됨

        Log.d("Jeong", "메서드 호출됨");


        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSmsMessage(bundle);

        if(messages != null && messages.length > 0 )
        {
            String sender = messages[0].getOriginatingAddress();
            log("Sms Sender :: "+sender);

            String contents = messages[0].getMessageBody().toString();
            log("Sms Body :: "+contents);

            Date receivedData = new Date(messages[0].getTimestampMillis());
            log("Sms received :: "+ receivedData);

            intent = new Intent(context,SmsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("sender",sender);
            intent.putExtra("contents",contents);
            intent.putExtra("receveDate",dateFormat.format(receivedData));
            context.startActivity(intent);

        }

    }

    private void log(String str)
    {
        Log.d("Jeong", str);
    }
    private SmsMessage[] parseSmsMessage(Bundle bundle)
    {
        Object[] objs = (Object[])bundle.get("pdus");
        SmsMessage[] message = new SmsMessage[objs.length];

        int smsCount = objs.length;
        for(int i = 0; i < smsCount; i++)
        {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                String format = bundle.getString("format");
                message[i] = SmsMessage.createFromPdu((byte[])objs[i], format );
            }
            else
            {
                message[i] = SmsMessage.createFromPdu((byte[]) objs[i]);
            }
        }
        return message;
    }
}

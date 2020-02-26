package com.cyberkyj.brodcastreceiver_sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SMSReceiver extends BroadcastReceiver {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("SMS_Receiver", "onReceive() 호출");
        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSMSMessage(bundle);
        if(messages!=null&&messages.length>0){
            String sender = messages[0].getOriginatingAddress(); //발신번호 확인
            Log.d("SMS_Receiver", "SMS Sender : "+sender);
            String contents = messages[0].getMessageBody();//발신 메시지 확인
            Log.d("SMS_Receiver", "SMS contents : "+contents);
            Date receiveDate = new Date(messages[0].getTimestampMillis());//수신 시간 확인
            Log.d("SMS_Receiver", "SMS receiveDate : "+receiveDate);


            intent = new Intent(context, SMSActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("sender", sender);
            intent.putExtra("contents", contents);
            intent.putExtra("receiveDate", dateFormat.format(receiveDate));
            context.startActivity(intent);

        }
    }

    private SmsMessage[] parseSMSMessage(Bundle bundle){
        Object[] objects =  (Object[])bundle.get("pdus");
       //sms 데이터를 처리하는 SMTP가 있는데 그 안에 pdus라는 이름으로 sms 정보들이 들어가 있음
       // 실제 메시지는 object[]에 pdus 형식으로 저장되어 있음
        SmsMessage[] messages = new SmsMessage[objects.length];
       // sms를 받아올 SmsMessage 배열을 만듬
        for(int i=0; i<objects.length; i++){
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[])objects[i], format);
                // 각 메시지를 추출하기 위해 사용
            }else{
                messages[i] = SmsMessage.createFromPdu((byte[])objects[i]);
            }
        }

        return messages;
    }
}









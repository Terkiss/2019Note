package com.dotge.chap11_ex_ex;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class PlayService extends Service  implements MediaPlayer.OnCompletionListener {
    MediaPlayer player;
    String filepath;
    public PlayService() {
    }
    public void onCreate()
    {
        // regiser receiv
    }

    public int onStartCommand(Intent intent, int flag, int startID)
    {
        filepath = intent.getStringExtra("filepath");

        return super.onStartCommand(intent, flag, startID);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // 방소 처리 내용

        }
    };

    @Override
    public void onCompletion(MediaPlayer mp) {
        Intent intent = new Intent("com.dotge.chap11_ex_ex.Play_TO_ACTIVITY");
        intent.putExtra("mode", "stop");
        sendBroadcast(intent);
    }
}

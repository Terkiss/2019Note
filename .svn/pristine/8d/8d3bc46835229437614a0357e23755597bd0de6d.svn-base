package com.dotge.newmusic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {
    MediaPlayer mediaPlayer;

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService", "Service -> onCreate");

        mediaPlayer = MediaPlayer.create(this, R.raw.sample);
        mediaPlayer.setLooping(false);
        Log.d("MyService", "Service -> MediaPlayer Setting ");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("MyService", "Service -> onStartCommand");
        Log.d("MyService", "Service -> Music Start");
        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("MyService", "Service -> Music Stop");
        mediaPlayer.stop();
        Log.d("MyService", "Service -> onDestory");
        super.onDestroy();
    }
}

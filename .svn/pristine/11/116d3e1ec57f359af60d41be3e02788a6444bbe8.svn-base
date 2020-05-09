package com.example.playmusicservice;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class PlayService extends Service  {

    // 미디어 플레이어
    MediaPlayer player;
    ArrayList<String> filepath = new ArrayList<String>();
    int CurrentPlay = 0 ;
    public PlayService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        registerReceiver(receiver, new IntentFilter("Jeong.Music.PlayService"));

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String[] path = intent.getStringArrayExtra("filepath");
        if(path.length == 0)
        {
            Log.d("Jeong", "빈것 입니다.");
        }
        for(int i = 0 ; i < path.length; i++)
        {
            filepath.add(path[i]);
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    /*
    public void onCompletion(MediaPlayer mp) {
        Log.d("Jeong","onCompletaion ");
        CurrentPlay++;
        Intent intent = new Intent("Jeong.Music.Activity");
        intent.putExtra("mode", "stop");

        sendBroadcast(intent);
        Log.d("Jeong",CurrentPlay+ " "+filepath.size());
        if(CurrentPlay < filepath.size())
        {
            try
            {
                Log.d("Jeong","재실행 입니다 ");
                player.setDataSource(filepath.get(CurrentPlay));
                player.prepare();
                player.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] songName = filepath.get(CurrentPlay).split("/");

            intent = new Intent("Jeong.Music.Activity");
            intent.putExtra("mode", "start");
            intent.putExtra("songName",songName[songName.length -1] );
            intent.putExtra("duration", player.getDuration());

            sendBroadcast(intent);
        }
        else
        {
            CurrentPlay = 0;
            stopSelf();
        }
    }
*/
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String mode = intent.getStringExtra("mode");

            if(mode == null)
            {
                Log.d("Jeong", "playService 단 리시버 모드가 널 ");
                return;
            }

            if(mode.equals("start"))
            {
                String[] songName = filepath.get(CurrentPlay).split("/");
                if(player != null && player.isPlaying())
                {


                    Log.d("Jeong", "onReceive: 현재 "+songName[songName.length -1] +"재생중");
                    return;
                }


                try {
                    Log.d("Jeong", "mediaplayer :: filpath :::  "+filepath.get(CurrentPlay));
                    player = new MediaPlayer();
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            Log.d("Jeong","onCompletaion ");
                            CurrentPlay++;
                            if(CurrentPlay < filepath.size())
                            {
                                player.stop();
                                player.release();
                                player = null;

                                Intent intent = new Intent("Jeong.Music.Activity");
                                intent.putExtra("mode", "stop");

                                sendBroadcast(intent);

                                intent = new Intent("Jeong.Music.PlayService");
                                intent.putExtra("mode", "start");
                                sendBroadcast(intent);
                            }

                        }
                    });
                    player.setDataSource(filepath.get(CurrentPlay));
                    player.prepare();
                    player.start();

                    intent = new Intent("Jeong.Music.Activity");
                    intent.putExtra("mode", "start");
                    intent.putExtra("songName",songName[songName.length -1] );
                    intent.putExtra("duration", player.getDuration());

                    sendBroadcast(intent);
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
            else if(mode.equals("stop"))
            {
                if(player == null)
                {
                    Log.d("Joeng", "Player null");
                }
                player.stop();
                player.release();
                player = null;

                CurrentPlay = 0;

                intent = new Intent("Jeong.Music.Activity");
                intent.putExtra("mode", "stop");

                sendBroadcast(intent);
            }
        }
    };
}

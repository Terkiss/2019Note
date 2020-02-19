package com.dotge.service_ex;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override //바인더
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService", "service - > Oncreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "service - > OnStartCommand ");
        String name = intent.getStringExtra("name");
        Log.d("MyService", "service - > OnStartCommand ");
        Log.d("MyService", name );
        Log.d("MyService2", "service2 - > OnStartCommand ");
        intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("name", "Service -> MainActivity Call");
        startActivity(intent);
       // onDestroy();
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService", "service - > OnDestroy");
    }
}

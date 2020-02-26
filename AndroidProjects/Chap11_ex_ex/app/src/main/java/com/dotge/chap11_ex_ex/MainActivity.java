package com.dotge.chap11_ex_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Boolean runThread = false ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String filepath = "";

        Intent intent = new Intent(this, PlayService.class);
        intent.putExtra("filepath", filepath);
        startService(intent);
    }
    public void onClick(View v )
    {
        // start btn  -> thread -> true
        if(v = startBtn)
        {
            runThread = true;
            ProgressThread thread = new ProgressThread();
            thread.run();
        }
        else if(v = stopBtn)
        {

        }
        //// stop btn  -> thread -> false
    }


    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String mode = intent.getStringExtra("mode");

            if(mode != null)
            {
                if(mode.equals("start"))
                {
                    int duration = intent.getIntExtra("duration", 0);
                    // progressBar.setMax(duration);
                    // progressBar.setProgress(0)
                } else if (mode.equals("stop"))
                {
                    runThread = false;
                }

            }
        }
    };

    class ProgressThread extends  Thread
    {

        public void run()
        {
            if(runThread)
            {
                // prograssBar.incrementProgressBy(diff :1000);
                SystemClock.sleep(1000);
                //if(prograssBar.getProgress() == prograssBar.getMax())
                //  -> runThread = false ;
            }
        }
    }
}

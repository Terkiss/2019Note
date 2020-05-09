package com.cyberkyj.looper_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    MainHandler mainHandler;
    NewThread newThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        Button button = findViewById(R.id.button);

        mainHandler = new MainHandler();
        newThread = new NewThread();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText1.getText().toString();
                Message message = Message.obtain(); // Message message = mainHandler.obtainMessage();
                message.obj = str;
                newThread.newHandler.sendMessage(message);
            }
        });

        newThread.start();


    }

    class NewThread extends Thread{

        NewHandler newHandler = new NewHandler();
        public void run(){
            Looper.prepare();
            Looper.loop();
        }
    }

    class MainHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            String str = (String)msg.obj;
            editText2.setText(str);
        }
    }

    class NewHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            Message message = Message.obtain();
            message.obj = (String)msg.obj+" Android~!";
            mainHandler.sendMessage(message);
        }
    }
}

package com.dotge.chop07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    GestureDetector gestureDetector;
    ScrollView scrollView;
    final int SWIPE_MIN_DISTANCE  = 120;// SWIPE 를 인식 하는 가장 작은 거리
    final int SWIPE_MAX_OFF_PATH = 250; // 인식 하는 최대 거리
    final int SWIPE_THRSHOLD_VELOCITY = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = findViewById(R.id.layout1);
        LinearLayout layout2 = findViewById(R.id.layout2);
        scrollView = findViewById(R.id.scrollvv);
        textView = findViewById(R.id.textView);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action= event.getAction();
                float x = event.getX();
                float y = event.getY();

                switch ( event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        textView.append("손가락 늘림 : "+x+", "+y+"\n");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        textView.append("손가락 움직임 : "+x+", "+y+"\n");
                        break;
                    case MotionEvent.ACTION_UP:
                        textView.append("손가락 똄 : "+x+", "+y+"\n");
                        break;

                }

                scrollView.fullScroll(ScrollView.FOCUS_DOWN);


                return false;
            }
        });

        layout2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                gestureDetector.onTouchEvent(event);
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                return false;
            }
        });

        gestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                textView.append("OnDown 호출됨 \n");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                textView.append("OnShowPress 호출됨 \n");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                textView.append("OnSingletapup 호출됨 \n");
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                textView.append("OnScroll 호출됨 \n");
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                textView.append("Onlongpress 호출됨 \n");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                //textView.append("Onfling 호출됨 \n");

                if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX)>SWIPE_THRSHOLD_VELOCITY)
                {
                    Toast.makeText(getApplicationContext(), "LEFT SWife", Toast.LENGTH_LONG).show();
                }
                else  if(e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX)>SWIPE_THRSHOLD_VELOCITY)
                {
                    Toast.makeText(getApplicationContext(), "right SWife", Toast.LENGTH_LONG).show();
                }
                else if(e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY)>SWIPE_THRSHOLD_VELOCITY)
                {
                    Toast.makeText(getApplicationContext(), "Up SWife", Toast.LENGTH_LONG).show();
                }
                else  if(e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY)>SWIPE_THRSHOLD_VELOCITY)
                {
                    Toast.makeText(getApplicationContext(), "DOWN SWife", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
    }
}

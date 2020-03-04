package com.terukiss.localbroadcasting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 매니 페스트가 아닌 리시버를 동적으로 등록하는 방식으로 해당 액티비티가 동작중일떄만
        // 동작하는 리시버 이다.
        // 특히 오래오 부터는 미리 정의 된 방송은 로컬 방송 수신 방법을 사용 해야만 수신된다.

        broadcastReceiver = new MyReceiver(); // 브로드 캐스트 클래스 생성
        IntentFilter filter = new IntentFilter(); // 인텐트 필터 생성
        filter.addAction(MyReceiver.My_ACTION); // 플터에 액션 이름 지정
        filter.setPriority(1000); // 우선순위 설정

        registerReceiver(broadcastReceiver, filter);  // 리시버 등록

    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(broadcastReceiver); // 리시버 등록 해제
        super.onDestroy();
    }

    public void onMessage(View v)
    {
        Intent intent = new Intent(MyReceiver.My_ACTION); // 이동할 액션 지정
        intent.putExtra("key", "안녕하세요");
        intent.putExtra("key1", "브로드 캐스트 입니다");
        intent.putExtra("key2", "이야 인텐트를 통한 데이터 전송도 되는구나");
        sendBroadcast(intent); // 브로드 캐스트 실행
    }
}

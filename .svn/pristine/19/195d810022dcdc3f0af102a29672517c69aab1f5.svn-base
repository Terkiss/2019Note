package com.cyberkyj.system_broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogActivity extends AppCompatActivity  implements View.OnClickListener{

    ImageView finishBtn;
    TextView numberView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  // 타이틀 바 제거
        setContentView(R.layout.activity_dialog);  // 현재 화면 등록
        numberView=findViewById(R.id.lab1_phone_number);  // 넘버 뷰
        finishBtn=findViewById(R.id.lab1_remove_icon);   // 종료 버튼

        finishBtn.setOnClickListener(this);  // 이클래스에 리스너가 있다
        Intent intent=getIntent();  // 인텐트 얻어오기
        String number=intent.getStringExtra("number"); // 넘버 데이터 추출
        numberView.setText(number);
    }


    @Override
    public void onClick(View v) {
        finish();  // 종료
    }
}
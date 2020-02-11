package com.dotge.self10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Calculrate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_calculrate);

        SelfJavaView selfJavaView = new SelfJavaView(getApplicationContext(), LinearLayout.VERTICAL);
        LinearLayout FirstLayout = selfJavaView.getLinearLayout();
        selfJavaView.buttonGenerator("aa1", LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, "리버튼", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        selfJavaView.buttonGenerator("aa2", LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, "리버튼1", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        selfJavaView.buttonGenerator("aa3", LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, "리버튼2", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        selfJavaView.buttonGenerator("aa4", LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, "리버튼3", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        selfJavaView.buttonGenerator("aa5", LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, "리버튼3", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        selfJavaView.buttonGenerator("a4", LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, "리버튼4", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        selfJavaView.buttonGenerator("aa6", LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, "리버튼5", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        selfJavaView.buttonGenerator("aa6", LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, "김우진넴", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "샹크스",Toast.LENGTH_LONG).show();
            }
        });
        selfJavaView.buttonGenerator("aa6", LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, "김우진넴2", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "루피찡",Toast.LENGTH_LONG).show();
            }
        });

        int a = R.id.bottom;

        LinearLayout.LayoutParams _params = new LinearLayout.LayoutParams(-1,-1);
        setContentView(selfJavaView.getLinearLayout(), _params );
        Button aa = selfJavaView.findViewById("a4");
        aa.setText("ㅋㅋㅋㅋ"); //  해내따
        Button ab = selfJavaView.findViewById("aa1");
        ab.setText("자체 자바 UI 생성 라이브러리 FindViewBy 함수 테스트");

        ab = selfJavaView.findViewById("aa15");
        ab.setText("원피스");

        //aa.setText("aa");
    }



}

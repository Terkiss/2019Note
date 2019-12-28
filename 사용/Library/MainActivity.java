package com.terukiss.mytextviewlibrary;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        /*
        버튼을 크릵하면 토스트 메시지가 출력되는 화면을 java로 코딩해보자

        안드로이드 프로젝트 생성
            main xml 삭제
            java 코드 작성 및  수정 main xml을 삭해해서 오류 발생

         */
        /*
        SelfJavaView javaView = new SelfJavaView(getApplicationContext());

        javaView.btnGenerator("Button", LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, "버튼",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "코드로 생성한 버튼 입니다", Toast.LENGTH_LONG).show();
                    }
                });
        javaView.linearLayoutGenerator("Linear", 0xFF0000, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
*/
        SelfJavaView javaView = new SelfJavaView(getApplicationContext());
        javaView.tvGenerator("textview", "이름을 입력 하세요",LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT );
        javaView.textViewGet("textview").setTextColor(Color.RED);

        javaView.etGenerator("edit", LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT  );
        javaView.btnGenerator("Button", LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, "저장하기",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "저장 완료", Toast.LENGTH_LONG).show();
                    }
                });

        setContentView(javaView.getLinearLayout());
    }

}

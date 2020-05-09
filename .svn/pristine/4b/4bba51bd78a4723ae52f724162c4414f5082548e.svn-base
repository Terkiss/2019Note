package com.terukiss.mytextviewlibrary;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
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
        SelfJavaView javaView = new SelfJavaView(getApplicationContext(),LinearLayout.VERTICAL);

        javaView.linearLayoutGenerator("Layout1", Color.BLUE, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout layout = javaView.getLinearLayout("Layout1");
        javaView.tvGenerator("text", "이름을 입력하세요", layout, 0, LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView textView = javaView.textViewGet("text");

        LinearLayout.LayoutParams params =  (LinearLayout.LayoutParams)textView.getLayoutParams();
        params.weight = 1.0f;
        textView.setLayoutParams(params);
        javaView.etGenerator("editTextView","입력", layout, 0, LinearLayout.LayoutParams.WRAP_CONTENT);

        TextView editText = javaView.editTextGet("editTextView");

        params =  (LinearLayout.LayoutParams)editText.getLayoutParams();
        params.weight = 1.0f;
        editText.setLayoutParams(params);

        javaView.btnGenerator("button", LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, "저장하기", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), " 저장에 성공 하셧습니다 ", Toast.LENGTH_LONG).show();
                    }
                });

        setContentView(javaView.getLinearLayout());

    }

}

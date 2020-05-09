package com.dotge.filegel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    File[] imageFiles;
    String fileName;
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 권한 요청
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE},0);

        // UI 요소 할당
        textView = findViewById(R.id.textView);
        Button btn_Pre = findViewById(R.id.button);
        Button btn_next = findViewById(R.id.button2);
        final MyPictureView myView = findViewById(R.id.myView);

        // 이미지 파일 가져 오기
        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures").listFiles();
        fileName = imageFiles[0].toString();

        // 커스텀 뷰에 파일 네임 을 포함한 경로 설정
        myView.setPath(fileName);
        Log.d("Jeong", "fileName :  "+fileName);
        textView.setText("1/"+imageFiles.length);

        myView.invalidate(); // 다시 그림

        btn_Pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<=0){
                    index=imageFiles.length-1;
                }else{
                    index--;
                }
                fileName = imageFiles[index].toString();
                if(dataCheck(fileName))
                {
                    index--;
                    fileName = imageFiles[index].toString();
                }


                Log.d("Jeong", "이전 클릭 인덱스 : "+index+" \n 파일경로 :: "+fileName);
                myView.setPath(fileName);
                myView.invalidate();
                textView.setText((index+1)+"/"+imageFiles.length);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index>=imageFiles.length-1){
                    index=0;
                }else{
                    index++;
                }
                fileName = imageFiles[index].toString();
                if(dataCheck(fileName))
                {
                    index++;
                    fileName = imageFiles[index].toString();
                }

                Log.d("Jeong", "다음 클릭 인덱스 : "+index+" \n 파일경로 :: "+fileName);
                myView.setPath(fileName);
                myView.invalidate();
                textView.setText((index+1)+"/"+imageFiles.length);
            }
        });



    }


    private boolean dataCheck(String _name)
    {
        String[] SplitData = _name.split("/");
        Log.d("Jeong", "dataChgeck 연산 결과 :: "+ SplitData[SplitData.length - 1]);

        // 정규식 패턴 매치
        /*
        패턴분석
        ^\\S+.(?i)(txt|pdf|hwp|xls)$
        ^ : 시작
        \ : \ 가 왔기 때문에 다음에 올 문자는 특수문자로 취급하고 , \다음 특수문자고 오면 그 자체로 취급.
        \S : 공백 아닌 문자
        +. : .이 반드시 한개는 와야한다.
        (?i) : 대소문자 구별하지 않음.
        (txt|pdf|hwp|xls) : txt 혹은 pdf 혹은 hwp 혹은 xls 만 허용. | 을 이용한 or 연산!
        $ : 끝
        -> 공백아닌 문자와 .이 반드시 와야하고 뒤에는 txt, pdf, hwp, xls 만 허용.*/

        String pattern = "^\\S+.(?i)(png|jpg)$";



        boolean evalution = Pattern.matches(pattern, SplitData[SplitData.length - 1]);
        return !evalution;
    }
}

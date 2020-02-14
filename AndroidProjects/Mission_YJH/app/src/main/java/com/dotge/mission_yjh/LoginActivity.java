package com.dotge.mission_yjh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
{

    EditText ID ;
    EditText PW ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_login) ;

        ID  =   findViewById(R.id.etID) ;
        PW  =   findViewById(R.id.etPW) ;
        Button nextActivity = findViewById(R.id.runBtn) ;


        nextActivity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String checkID =ID.getText().toString() ;
                String checkPW = PW.getText().toString() ;
                if( isEmpty(checkID)  || isEmpty(checkPW))
                {
                    Toast.makeText(getApplicationContext(), "사용자 이름과 비밀번호를 입력하세요", Toast.LENGTH_SHORT).show() ;
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class) ;
                    intent.putExtra("ID", checkID) ;
                    intent.putExtra("PW", checkPW) ;
                    startActivity(intent) ;
                }
            }
        });
    }

    /**
     * 문자열 비었는지 체크
     * @param str
     * @return
     */
    private boolean isEmpty(String str)
    {
        if(str.length() < 1)
        {
            return true ;
        }
        else
        {
            return false ;
        }
    }
}

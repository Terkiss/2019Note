package com.example.database_ex42;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_main) ;

        Button btnAdd = findViewById(R.id.btnadd) ;
        Button btnDel = findViewById(R.id.btndelete) ;
        Button btnSelect = findViewById(R.id.btnselect) ;

        btnAdd.setOnClickListener(this) ;
        btnDel.setOnClickListener(this) ;
        btnSelect.setOnClickListener(this) ;

    }

    @Override
    public void onClick(View v) {
        Intent intent ;
        switch (v.getId()){
            case R.id.btnadd:
                // 데이터 베이스 추가
                intent = new Intent(getApplicationContext(), ContactAddActivity.class) ;
                startActivity(intent) ;
                break;
            case R.id.btndelete:
                // 데이터 베이스 삭제
                intent = new Intent(getApplicationContext(), ContactDelActivity.class) ;
                startActivity(intent) ;
                break;
            case R.id.btnselect:
                // 데이터 베이스 조회
                intent = new Intent(getApplicationContext(), ContactSelectActivity.class) ;
                startActivity(intent) ;
                break;
            default:
                break;
        }
    }
}

package com.dotge.mission_yjh;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;

public class MenuActivity extends AppCompatActivity {

    final   int     CUSTOMER    =   100 ;
    final   int     REVENUE     =   200 ;
    final   int     PRODUCT     =   300 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_menu) ;
        Intent intent = getIntent() ;

        String  checkedID    = intent.getStringExtra("ID") ;
        String  checkedPW    = intent.getStringExtra("PW") ;

        Button  customerManagerButton       = findViewById(R.id.cmbtn) ;
        final   Button revenueManagerButton = findViewById(R.id.rmbtn) ;
        Button  productManagerButton        = findViewById(R.id.pmbtn) ;




        customerManagerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loadActivity(CustomerActivity.class, CUSTOMER) ;
            }
        });
        revenueManagerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loadActivity(RevenueActivity.class, REVENUE) ;
            }
        });

        productManagerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
               loadActivity(ProductActivity.class, PRODUCT) ;
            }
        });


        Toast.makeText(getApplicationContext(),"사용자 이름 : "+checkedID+" 님이 로그인 하셨습니다.",Toast.LENGTH_LONG).show() ;
    }

    /**
     * 다음 액티비티 로딩
     * @param cls
     * @param reCode
     */
    private void loadActivity(Class<?> cls, int reCode)
    {
        Intent intent   =   new Intent(getApplicationContext(), cls) ;

        startActivityForResult(intent, reCode) ;
    }

    /**
     * 다음 액티비티 로딩
     * @param cls
     * @param reCode
     * @param data
     */
    private void loadActivity(Class<?> cls, int reCode, Serializable data)
    {
        Intent intent    =   new Intent(getApplicationContext(), cls) ;

        intent.putExtra(String.valueOf(reCode), data) ;
        startActivityForResult(intent, reCode) ;
    }

    /**
     * 수신측 메서드
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        String defaultStr[]     =   {"응답 : ", "result is Ok!"} ;

        if(resultCode == RESULT_OK)
        {
            String result   =   data.getStringExtra("result") ;
            if(result.equals("login"))
            {
                finish() ;
            }
            else if(result.equals("menu"))
            {
                if(requestCode == PRODUCT || requestCode == CUSTOMER || requestCode == REVENUE)
                {
                    String managerName = data.getStringExtra("data") ;
                    String managerName2 = data.getStringExtra("data2") ;
                    Toast.makeText(getApplicationContext(), managerName+defaultStr[0]+managerName2+defaultStr[1], Toast.LENGTH_LONG).show() ;
                }
            }
        }



        /*
        if(requestCode == 100)
        {
            // 고객 관리
            if(resultCode == RESULT_OK)
            {
                String result = data.getStringExtra("result");
                Toast.makeText(getApplicationContext(),result+"dd", Toast.LENGTH_LONG).show();
                if(result.equals("menu"))
                {
                    String managerName = data.getStringExtra("data");
                    String managerName2 = data.getStringExtra("data2");
                    Toast.makeText(getApplicationContext(), managerName+defaultStr[0]+managerName2+defaultStr[1], Toast.LENGTH_LONG).show();
                }
                else if(result.equals("login"))
                {
                    finish();
                }
            }
        }
        else if(requestCode == 200)
        {   // 매출관리
            if(resultCode == RESULT_OK)
            {
                String result = data.getStringExtra("result");
                Toast.makeText(getApplicationContext(),result+"dd", Toast.LENGTH_LONG).show();
                if(result.equals("menu"))
                {
                    String managerName = data.getStringExtra("data");
                    String managerName2 = data.getStringExtra("data2");
                    Toast.makeText(getApplicationContext(), managerName+defaultStr[0]+managerName2+defaultStr[1], Toast.LENGTH_LONG).show();
                }
                else if(result.equals("login"))
                {
                    finish();
                }
            }
        }
        else if(requestCode == 300)
        {
            // 상품관리
            if(resultCode == RESULT_OK)
            {
                String result = data.getStringExtra("result");
                Toast.makeText(getApplicationContext(),result+"dd", Toast.LENGTH_LONG).show();
                if(result.equals("menu"))
                {
                    String managerName = data.getStringExtra("data");
                    String managerName2 = data.getStringExtra("data2");
                    Toast.makeText(getApplicationContext(), managerName+defaultStr[0]+managerName2+defaultStr[1], Toast.LENGTH_LONG).show();
                }
                else if(result.equals("login"))
                {
                    finish();
                }
            }
        }*/
    }
}

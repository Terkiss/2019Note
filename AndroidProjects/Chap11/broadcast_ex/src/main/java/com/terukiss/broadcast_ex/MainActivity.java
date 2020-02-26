package com.terukiss.broadcast_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 권한이 있는 지 체크
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);

        if(permissionCheck == PackageManager.PERMISSION_GRANTED )
        {
            Log.d("Jeong", "SMS 수신 권한 있음");
        }
        else
        {
            Log.d("Jeong", "SMS 수신 권한 없음");
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECEIVE_SMS))
            {
                Toast.makeText(this, "SMS 권한 설명 필요함", Toast.LENGTH_LONG).show();
            }
            else
            {
                ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.RECEIVE_SMS}, 1);
            }
        }
    }

    /**
     *  사용자가 앱 권한 요청에 응답하면 시스템은 앱의 onRequestPermissionsResult()
     *  메서드를 호출하여 사용자 응답을 전달합니다. 앱은 해당 메서드를 재정의하여
     *  권한이 부여되었는지 확인해야 합니다.
     * @param requestCode 응답 코드
     * @param permissions 퍼미션
     * @param grantResults 응답
     */
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode)
        {
            case 1:
            {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this, "SMS 권한을 사용자가 승인함 ",  Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(this, "SMS 권한 거부됨 ", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
}

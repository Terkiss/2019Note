package com.terukiss.broadcastingtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.widget.Toast;

import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoPermissions.Companion.loadAllPermissions(this, 101);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // 외부  라이브러리 실행
        AutoPermissions.Companion.parsePermissions(this,requestCode,permissions,this);
    }

    @Override
    public void onDenied(int i, String[] strings) {
        Toast.makeText(this,"permissions denied : " + strings.length , Toast.LENGTH_LONG).show();
        Log.d("Jeong", "permissions denied : ");
        Log.d("Jeong", "앱 실행을 위해선 권한이 필요 합니다 권한을 주십시오  : ");
    }

    @Override
    public void onGranted(int i, String[] strings) {
        Toast.makeText(this,"permissions Granted : "  + strings.length, Toast.LENGTH_LONG).show();
        Log.d("Jeong", "permissions Granted  : ");
    }
}

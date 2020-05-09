package com.dotge.singlefragment_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    /*
        프래그먼트를 만들어 사용하는 과정
        1. 프래그먼트를 위한 xml 레이아웃 만들기
        2. 프래그먼트 클래스 만들기.
        3. onCreateView() 메소드 안에서 인플레이션 하기
        4. 메인 액티비티를 위한 xml 레이아웃에 추가하거나 프래그먼트 매니저를 이용해 코드에서 추가하기.


        프래그먼트 처리 순서
        1. 프래그먼트 매니저 객체 참조
        2. 트랜젝션 시작
        3. 프래그먼트의 추가 , 삭제 또는 교체
        4. 트랜젝션 커밋
     */

    MainFragment mainFragment;
    MenuFragment menuFragment;

    FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        manager = getSupportFragmentManager();

        mainFragment = new MainFragment();
        menuFragment = new MenuFragment();




    }

    public void onFragmentChange(int index)
    {
        switch (index)
        {
            case 0:
                manager.beginTransaction().replace(R.id.container, mainFragment).commit();
                break;
            case 1:
                manager.beginTransaction().replace(R.id.container, menuFragment).commit();
                break;
        }
    }


    public void onClick(View v)
    {
        Fragment fr = null;

        switch(v.getId())
        {
            case R.id.button:
                Log.d("Jeong", " 여기인가?");
                fr = mainFragment;
                break;
            case R.id.button2:
                fr = menuFragment;
                break;
        }
        Log.d("Jeong", fr.toString());
       // manager.beginTransaction().replace(R.id.container, fr).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fr).commit();
    }




}

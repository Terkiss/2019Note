package com.dotge.viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager ;
    String[] names = {
            "AOA", "트와이스" ,"ㅇ", "ㅋㅋ"
    };
    int[] id = {R.drawable.jeju1, R.drawable.jeju2, R.drawable.jeju02, R.drawable.jeju3};
    String[]  call = {"010-3645-5423", "101-2000-2000", "010-3000-3000", "010-4000-4000"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(names.length);


    }


    class  ViewPagerAdapter extends PagerAdapter
    {
        Context context;

        ViewPagerAdapter(Context context)
        {
            this.context = context;
        }
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            // 2. VIew Pager 에서 사용할 뷰 객체를 생성 및 등록
            Person person = new Person(getApplicationContext());
            person.setName(names[position]);
            person.setcall(call[position]);
            person.setImageID(id[position]);

            container.addView(person,position);

            Log.d("Jeong", "position = "+position );
            Log.d("Jeong", "position = "+container.getVerticalFadingEdgeLength() );
            return person;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            // 4, 화면에 보이지 않는 View 객체를 삭제해서 관리
           container.removeView( (View)object );
        }

        @Override
        public int getCount() { // 1. 현재 페이저 어탑타에서 관리할 페이지의 수
            return 4;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            // 3. instantiateItem  메소드에 생성한 객체가 뷰페이저와 맞는지 확인하는 메소드
            return view.equals(object);
        }
    }

}

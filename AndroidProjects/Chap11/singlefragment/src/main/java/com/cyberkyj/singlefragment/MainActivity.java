package com.cyberkyj.singlefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;
    MenuFragment menuFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

       // mainFragment = (MainFragment)fragmentManager.findFragmentById(R.id.mainFragment);
        mainFragment = new MainFragment();
        menuFragment = new MenuFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, mainFragment).commit();

    }

    public void onFragmentChanged(int index){
            if(index==0){
            fragmentManager.beginTransaction().replace(R.id.container,mainFragment).commit();
        }else if(index==1){
            fragmentManager.beginTransaction().replace(R.id.container,menuFragment).commit();
        }
    }

    public void onSelect(View v){
        Fragment fr=null;
        switch (v.getId()) {
            case R.id.button:
                fr = mainFragment;
                break;
            case R.id.button2:
                fr = menuFragment;
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fr).commit();

    }
}

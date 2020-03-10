package com.dotge.singlefragment_ex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Jeong", " 메인 플래그 먼트 실행");
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_main,container,false);

        Button button = viewGroup.findViewById(R.id.button3);
        Log.d("Jeong", button.getText().toString());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Jeong", " 클릭 실행 ");
                ((MainActivity)getActivity()).onFragmentChange(1);
            }
        });
        return viewGroup;
    }

}

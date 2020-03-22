package com.example.doublefragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageFragment extends Fragment {
   ImageView iv ; // 이미지 뷰


    /**
     *
     * @param inflater 인플레이터
     * @param container 컨테이너
     * @param savedInstanceState  세이브 인스텐스
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_image, container, false);
        iv = viewGroup.findViewById(R.id.imageView);

        return viewGroup;
    }

    /**
     * 이미지를 새팅 합니다 .
    */
    public void setImage(int id)
    {
        Log.d("Jeong", "ImageFragment position :: "+id);
        iv.setImageResource(id);
    }
}

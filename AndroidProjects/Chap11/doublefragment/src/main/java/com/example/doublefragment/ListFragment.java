package com.example.doublefragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;




/*
리스트 뷰 프레그 먼트
 */
public class ListFragment extends Fragment {

    String name[] = {"첫번쨰 이미지", "두번쨰 이미지", "세번쨰 이미지", "내번쨰 이미지 "};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("Jeong", "실행 중 ㄷㄷㄷ");


        // 뷰그룹 생성 인플레이터 인플레이트
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_list, container, false);

        // 리스트 뷰를 인플레이트 한것에서 가져오기
        ListView listView = viewGroup.findViewById(R.id.listView);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,name);

        listView.setAdapter(adapter);

        // 각각의 아이템 클릭 리스너 부착
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // 이 프래그먼트를 포함하는 액티비티를 리턴함 여기서는 즉 MainActivity
                ((MainActivity)getActivity()).onImageselected(position);
            }
        });
        // 인플레이트 한 뷰그룹 리턴 해줘야함
        return viewGroup;
    }
}

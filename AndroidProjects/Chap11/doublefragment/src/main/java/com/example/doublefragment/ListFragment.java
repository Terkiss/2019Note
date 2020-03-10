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


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {
    String name[] = {"첫번쨰 이미지", "두번쨰 이미지", "세번쨰 이미지", "내번쨰 이미지 "};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Jeong", "실행 중 ㄷㄷㄷ");
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_list, container, false);
        ListView listView = viewGroup.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,name);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((MainActivity)getActivity()).onImageselected(position);
            }
        });
        // Inflate the layout for this fragment
        return viewGroup;
    }
}

package com.dotge.bottom_sheet_ex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomSheetBehavior<View> persitentBottomSheet;


    ArrayList<Item> items;

    public static BottomSheetDialog aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.bottom_Sheet);
        persitentBottomSheet = BottomSheetBehavior.from(view);


        items = new ArrayList<>();
        items.add(new Item(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_1, null), "keep"));
        items.add(new Item(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_2, null), "inbox"));
        items.add(new Item(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_3, null), "messanger"));
        items.add(new Item(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_4, null), "Google"));




        persitentBottomSheet.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {


                                                                    // 안보임 상태
                if(persitentBottomSheet.getState() == BottomSheetBehavior.STATE_HIDDEN)
                {
                    // 바텀 시트 를 기본 크기 상태 로 세팅
                    persitentBottomSheet.setState(BottomSheetBehavior.STATE_COLLAPSED);

                }
            }

            // 슬라이더의 세밀한 조정
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    public void onModal(View v)
    {

        MyAdapter adapter = new MyAdapter(items, getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);


        View view = getLayoutInflater().inflate(R.layout.layout_recycler, null);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_View);


        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        aa = new BottomSheetDialog(this);
        aa.setContentView(view);
        aa.show();
    }
}

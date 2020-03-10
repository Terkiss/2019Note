package com.cyberkyj.recyclerview_ex1;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Recycler_Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<Recycler_Model>();
        list.add(new Recycler_Model("흥부와 놀부","지은이"));
        list.add(new Recycler_Model("금도끼 은도끼","지은이"));
        list.add(new Recycler_Model("콩쥐팥쥐","지은이"));
        list.add(new Recycler_Model("이솝 우화","지은이"));
        list.add(new Recycler_Model("헨젤과 그레텔","지은이"));
        list.add(new Recycler_Model("개구리 왕자","지은이"));


        MyAdapter adapter = new MyAdapter(this, R.layout.item_recycler, list, recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }


}

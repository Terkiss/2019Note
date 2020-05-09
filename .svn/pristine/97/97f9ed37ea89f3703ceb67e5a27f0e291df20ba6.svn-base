package com.dotge.recyclerview_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recyleView1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<RecycleModel> item = new ArrayList<RecycleModel>();


        item.add(new RecycleModel(R.drawable.aa, "#1"));
        item.add(new RecycleModel(R.drawable.bb, "#1"));
        item.add(new RecycleModel(R.drawable.cc, "#1"));
        item.add(new RecycleModel(R.drawable.dd, "#1"));
        item.add(new RecycleModel(R.drawable.ee, "#1"));




        RecyclerAdapter adapter = new RecyclerAdapter(item, this);
        recyclerView.setAdapter(adapter);
    }
}

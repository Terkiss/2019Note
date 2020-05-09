package com.example.movie_database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterForList extends BaseAdapter {
    private ArrayList<MovieData> items;
    private Context context;
    public AdapterForList(ArrayList<MovieData> items, Context context)
    {
        this.items = items;
        this.context = context;
    }

    public ArrayList<MovieData> getItems() {
        return items;
    }

    public void setItems(ArrayList<MovieData> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {

        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //JeongLog.log.logD("getView 메서드의 인자중 convertView "+convertView);
        JeongLog.log.logD("Context  "+context);
        View v = LayoutInflater.from(context).inflate(R.layout.listviewitem, parent, false);
        TextView textView = v.findViewById(R.id.movie_Title);
        textView.setText(items.get(position).getTitleName());
        return v;
    }


}

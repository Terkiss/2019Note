package com.cyberkyj.chap_listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class SongAdapter extends BaseAdapter {

    ArrayList<SongItem> items = new ArrayList<SongItem>();
    Context context;

    public SongAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        // 1번쨰 실행
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        // 아이템 겟 포지션
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SongItemView view=null;
        if(convertView==null){
            // 인플레이션
            view = new SongItemView(context);
        }else {
            // 재활용
            view = (SongItemView)convertView;
        }

        SongItem item = items.get(position);
        view.setTitle(item.getTitle());
        view.setSinger(item.getSinger());
        view.setImageView(R.drawable.song);

        return view;
    }

    public void addItem(SongItem item){
        items.add(item);
    }

    public void removeItem(int postion){
        items.remove(postion);
    }


}

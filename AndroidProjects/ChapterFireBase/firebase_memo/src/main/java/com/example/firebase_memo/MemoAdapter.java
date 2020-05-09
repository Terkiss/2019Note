package com.example.firebase_memo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.ViewHolder>
{
    ArrayList<MemoItem> items ;

    Context context;

    public MemoAdapter(ArrayList<MemoItem> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.memo_item_list, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleView.setText(items.get(position).getMemoTitle());
        holder.contentView.setText(items.get(position).getMemoContents());
    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView titleView;
        TextView contentView;

        public ViewHolder(View v)
        {
            super(v);

            this.titleView = v.findViewById(R.id.memotitle);
            this.contentView = v.findViewById(R.id.memocontents);


        }

    }
}

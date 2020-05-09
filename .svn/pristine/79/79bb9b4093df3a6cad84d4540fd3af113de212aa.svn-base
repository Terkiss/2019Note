package com.dotge.bottom_sheet_ex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    ArrayList<Item> list  ;
    Context context;

    public MyAdapter(ArrayList<Item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //2  인플레이트
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_modal, parent, false);


        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Item item = list.get(position);
        holder.imageView.setImageDrawable(item.getDrawable());
        holder.textView.setText(item.getTitle());
        holder.modal_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
                MainActivity.aa.dismiss();
            }
        });
        // 여기 와야함!
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        LinearLayout modal_layout;

        public MyViewHolder(@NonNull View itemView)
        { // 1
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.textView = itemView.findViewById(R.id.textView);
            this.modal_layout = itemView.findViewById(R.id.modal_layout);
        }
    }
}

package com.dotge.recyclerview_ex;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    ArrayList<RecycleModel> item;
    Context context;

    public RecyclerAdapter(ArrayList<RecycleModel> item, Context context) {
        this.item = item;
        this.context = context;
    }

    class ViewHolder extends  RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        CardView cardView;
        public ViewHolder (@NonNull View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            cardView = itemView.findViewById(R.id.reCard);

        }

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_carview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final RecycleModel model = item.get(position);
        holder.imageView.setImageResource(model.getImageID());
        holder.textView.setText(model.getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Jeong", "타이틀 명 "+model.getTitle());
            }
        });
    }


    @Override
    public int getItemCount() {
        return item.size();
    }
}

package com.example.imagecollect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  {
    private ArrayList<Item> m_List;

    private Context context;

    public MyAdapter(ArrayList<Item> itemList, Context _context)
    {
        JeongLog.log.logD("어답터 생성자 실행 ");
        this.m_List = itemList;
        context = _context;
    }
    public MyAdapter() {
        super();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Item item = m_List.get(position);

        holder.title.setText( item.getTitle() );
        holder.release.setText( item.getRelease());
        holder.dractor.setText( item.getDirector());
        holder.imageView.setImageBitmap(item.getBitImg());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "이미지 주소 "+item.getImg_url(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        JeongLog.log.logD("어답터 1번 실행 ");
        return m_List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView title;
        TextView dractor;
        TextView release;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.titleName);
            dractor = itemView.findViewById(R.id.dractor);
            release = itemView.findViewById(R.id.releaseData);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}

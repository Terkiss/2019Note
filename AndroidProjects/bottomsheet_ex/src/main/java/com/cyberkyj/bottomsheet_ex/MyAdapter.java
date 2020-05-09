package com.cyberkyj.bottomsheet_ex;

import android.content.Context;
import android.telephony.TelephonyManager;
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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Item> list;
    Context context;

    public MyAdapter(ArrayList<Item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_modal,parent,false);
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
                MainActivity.bottomSheetDialog.dismiss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView textView;
    LinearLayout modal_layout;

    public MyViewHolder(View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageView);
        this.textView = itemView.findViewById(R.id.textView);
        this.modal_layout = itemView.findViewById(R.id.modal_layout);
    }
}

}


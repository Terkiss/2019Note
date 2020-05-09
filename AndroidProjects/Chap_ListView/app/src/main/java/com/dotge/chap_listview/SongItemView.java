package com.dotge.chap_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SongItemView extends LinearLayout {

    Context content;
    TextView title;
    TextView singger;
    ImageView imageView;
    public SongItemView(Context context) {
        super(context);
        this.content = context;
        init();
    }

    private void init()
    {
        LayoutInflater inflater = (LayoutInflater) content.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.songitem, this, true);

        title = findViewById(R.id.textView);
        singger = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setSingger(String singger) {
        this.singger.setText(singger);
    }

    public void setImageView(int imageView) {
        this.imageView.setImageResource(imageView);
    }
}

package com.terukiss.mytextviewlibrary;

import android.widget.TextView;

public class SelfTextView {
    private String Id;
    private int color;
    private TextView textView;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public void setColor(int _color)
    {
        color = _color;
    }

}

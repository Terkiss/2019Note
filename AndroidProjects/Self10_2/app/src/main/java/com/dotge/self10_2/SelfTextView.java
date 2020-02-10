package com.dotge.self10_2;

import android.widget.TextView;

public class SelfTextView extends SelfObject{


    private TextView textView;

    public SelfTextView()
    {

    }
    public SelfTextView(String id)
    {
        super(id);
    }


    public String getID() {
        return ID;
    }

    public void setId(String id) {
        ID = id;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }


}

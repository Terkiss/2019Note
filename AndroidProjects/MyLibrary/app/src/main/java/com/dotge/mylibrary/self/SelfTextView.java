package com.dotge.mylibrary.self;

import android.view.View;
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

    public void setID(String id) {
        ID = id;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public View getObject()
    {
        return textView;
    }
    public void setObject()
    {

    }

}

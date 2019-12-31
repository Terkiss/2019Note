package com.terukiss.homework;

import android.widget.LinearLayout;

public class SelfLiearLayout {

    private String Id;
    private LinearLayout linearLayout;
    private int backgroundColor;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public LinearLayout getLinearLayout() {
        return linearLayout;
    }

    public void setLinearLayout(LinearLayout linearLayout) {
        this.linearLayout = linearLayout;
        this.linearLayout.setBackgroundColor(this.backgroundColor);
    }

    public SelfLiearLayout(String id )
    {
        this.Id = id;
    }




}

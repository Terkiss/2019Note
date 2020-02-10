package com.dotge.self10_2;

import android.widget.ViewFlipper;

public class SelfViewFlipper extends SelfObject {

    private ViewFlipper viewFlipper;

    public SelfViewFlipper()
    {

    }
    public SelfViewFlipper(String id)
    {
        super(id);
    }

    public String getID() {
        return ID;
    }

    public void setId(String id) {
        this.ID = id;
    }

    public ViewFlipper getViewFlipper() {
        return viewFlipper;
    }

    public void setViewFlipper(ViewFlipper viewFlipper) {
        this.viewFlipper = viewFlipper;
    }
}

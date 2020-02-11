package com.dotge.self10_2;

import android.view.View;
import android.widget.Button;

public class SelfButton extends SelfObject {

    private Button button;

    public SelfButton()
    {

    }
    public SelfButton(String id)
    {
        super(id);
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        ID = id;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }



}

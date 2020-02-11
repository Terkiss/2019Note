package com.dotge.self10_2;

import android.view.View;

import java.util.ArrayList;

public abstract class SelfObject {
    protected  String ID;

    public SelfObject()
    {

    }
    public SelfObject(String id)
    {
        ID = id;
    }
    public abstract String getID();
    public abstract void setID(String id);
}

package com.dotge.self10_2;

import android.widget.ImageView;

public class SelfImageVIew extends SelfObject{

    private ImageView imageView;
    public SelfImageVIew()
    {

    }
    public SelfImageVIew(String id)
    {
        super(id);
    }
    public String getID() {
        return ID;
    }

    public void setId(String id) {
        this.ID = id;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}

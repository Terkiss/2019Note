package com.dotge.self10_2;

import android.view.View;
import android.widget.ImageView;

/// 이미지 뷰
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

    public void setID(String id) {
        this.ID = id;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }


    public View getObject()
    {
        return imageView;
    }
    public void setObject()
    {

    }

}

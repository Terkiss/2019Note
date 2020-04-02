package com.example.imagecollect;

import android.graphics.Bitmap;

public class Item {
    private String title;
    private String img_url;
    private String detail_link;
    private String release;
    private String director;
    private Bitmap BitImg;

    public Item(String title, String img_url, String detail_link, String release, String director)
    {
        this.title = title;
        this.img_url = img_url;
        this.detail_link = detail_link;
        this.release =release;
        this.director = director;

    }

    public String getTitle() {
        return title;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getDetail_link() {
        return detail_link;
    }

    public String getRelease() {
        return release;
    }

    public Bitmap getBitImg() {
        return BitImg;
    }

    public void setBitImg(Bitmap bitImg) {
        BitImg = bitImg;
    }

    public String getDirector() {
        return director;
    }

}

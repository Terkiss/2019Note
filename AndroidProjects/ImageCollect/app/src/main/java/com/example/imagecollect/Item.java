package com.example.imagecollect;

public class Item {
    private String title;
    private String img_url;
    private String detail_link;

    public Item(String title, String img_url, String detail_link)
    {
        this.title = title;
        this.img_url = img_url;
        this.detail_link = detail_link;

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
}

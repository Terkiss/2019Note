package com.dotge.recyclerview_ex;

public class RecycleModel {
    private int imageID ;
    private String title;


    public RecycleModel(int imageID, String title) {
        this.imageID = imageID;
        this.title = title;
    }

    public int getImageID() {
        return imageID;
    }

    public String getTitle() {
        return title;
    }

}

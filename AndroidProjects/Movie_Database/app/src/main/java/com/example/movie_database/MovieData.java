package com.example.movie_database;

public class MovieData {

    private  String titleName;
    private  String createYear;
    private  String director;
    private  String starRating;
    private  String createCountry;

    public MovieData(String titleName)
    {
        this.titleName = titleName;
    }
    public MovieData()
    {
        this.titleName = titleName;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getCreateYear() {
        return createYear;
    }

    public void setCreateYear(String createYear) {
        this.createYear = createYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String drector) {
        this.director = drector;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    public String getCreateCountry() {
        return createCountry;
    }

    public void setCreateCountry(String createCountry) {
        this.createCountry = createCountry;
    }

    public String[] getArrayData()
    {
        String[] tempData = {this.titleName, this.createYear, this.director, this.starRating, this.createCountry};

        return tempData;
    }
}

package com.example.caroline.example;

/**
 * Created by princ on 27/09/2017.
 */

public class ListExamples {

    //part of the model layer because it knows nothing about Android
    private String name;
    private String desc;
    private int ranking;

    private int imageResourceId;

    public ListExamples(String name, String desc, int ranking, int imageResourceId){
        this.name = name;
        this.desc = desc;
        this.ranking = ranking;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageSResourceId() {
        return imageResourceId;
    }

    public void setImageSResourceId(int imageSResourceId) {
        this.imageResourceId = imageSResourceId;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "" + name;
        //return super.toString();
    }
}

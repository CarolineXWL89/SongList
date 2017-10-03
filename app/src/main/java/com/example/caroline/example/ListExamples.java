package com.example.caroline.example;

/**
 * Created by princ on 27/09/2017.
 */

public class ListExamples {

    //part of the model layer because it knows nothing about Android
    private String name;
    private String desc;
    private int imageResourceId;

    public ListExamples(String name, String desc, int imageResourceId){
        this.name = name;
        this.desc = desc;
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

    @Override
    public String toString() {
        return "" + name;
        //return super.toString();
    }
}

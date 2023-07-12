package com.example.myfinalproject;

public class Cities {

    private String name;
    private int imageID;

    public static final Cities[] cities = {
            new Cities("Ramallah", R.drawable.ramallah),
            new Cities("Nablus", R.drawable.nablus),
            new Cities("Hebron", R.drawable.hebron),
            new Cities("Jericho", R.drawable.nablus),
            new Cities("Jenin", R.drawable.hebron)

    };
    private Cities(String name, int imageID){
        this.name = name;
        this.imageID = imageID;
    }
    public String getName(){return name;}
    public void setName(String name){
        this.name= name;
    }

    public int getImageID(){return imageID;}

}


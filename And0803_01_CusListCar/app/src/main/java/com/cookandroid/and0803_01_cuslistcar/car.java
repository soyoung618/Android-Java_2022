package com.cookandroid.and0803_01_cuslistcar;

public class car {
    private int image_id;
    private String name;

    //기본 생성자
    public car(){ }
    public car(int image_id, String name){
        this.image_id =image_id;
        this.name =name;
    }
    public int getImage_id(){ return image_id;}
    public void setImage_id(int image_id){ this.image_id =image_id; }
    public String getName() { return  name; }
    public void setName(String name){ this.name =name; }



}

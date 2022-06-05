package com.example.multigaming;

public class ElementModel {
    private int imageview1 ;
    private String game ;


    ElementModel(int imageview1 , String game){
        this.imageview1 = imageview1;
        this.game = game;
     }

    public int getImageview1() {
        return imageview1;
    }
    public String getgame(){
        return game;
    }

    public void setgame(String game) {
        this.game = game;
    }



    public void setImageview1(int imageview1) {
        this.imageview1 = imageview1;
    }

}

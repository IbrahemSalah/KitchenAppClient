package com.example.android.kitchenappclient;

/**
 * Created by Eng_I on 12/27/2017.
 */

public class Food {
    private String name;
    private String price;
    private String desc;
    private String image;

    public Food(){
    }

    public Food(String Name,String Price, String Desc, String Image){
        this.name = Name;
        this.price = Price;
        this.desc = Desc;
        this.image = Image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

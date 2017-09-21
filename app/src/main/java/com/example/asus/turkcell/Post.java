package com.example.asus.turkcell;

/**
 * Created by Ceyda on 21.09.2017.
 */

public class Post {

    private String name;
    private String description;
    private String image;

    public Post(){

    }

    public Post(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}

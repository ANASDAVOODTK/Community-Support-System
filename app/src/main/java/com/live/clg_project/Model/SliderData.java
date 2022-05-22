package com.live.clg_project.Model;

public class SliderData {

    // image url is used to
    // store the url of image
    private String image,title,sub_title,description;

    public SliderData(String image, String title, String sub_title, String description) {
        this.image = image;
        this.title = title;
        this.sub_title = sub_title;
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
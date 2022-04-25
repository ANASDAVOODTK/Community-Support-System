package com.live.clg_project.Model;

public class SliderData {

    // image url is used to
    // store the url of image
    private String imgUrl,title,subTile;

    public SliderData(String imgUrl, String title, String subTile) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.subTile = subTile;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTile() {
        return subTile;
    }

    public void setSubTile(String subTile) {
        this.subTile = subTile;
    }
}
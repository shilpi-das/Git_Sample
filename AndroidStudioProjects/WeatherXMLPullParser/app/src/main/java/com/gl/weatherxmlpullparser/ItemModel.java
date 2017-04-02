package com.gl.weatherxmlpullparser;

/**
 * Created by shilpi.das on 18-09-2016.
 */
public class ItemModel {
    private String title;
    private String description;
    private String link;
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public static final String DESCRIPTION="description";
    public static final String TITLE="title";
    public static final String LINK="link";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder("title"+title+"\nDescription"+description+"\nLink"+link+"\nimage url"+imgUrl);
        return builder.toString();
    }
}

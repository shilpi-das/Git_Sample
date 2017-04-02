package com.gl.newsvolleyparser.model;

/**
 * Created by shilpi.das on 25-09-2016.
 */
public class NewsModel {
    private String mTitle;
    private String mLink;
    private String mDescription;
    private String mImageUrl;
    private String mUrl;
    private String mAuthor;

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmLink() {
        return mLink;
    }

    public void setmLink(String mLink) {
        this.mLink = mLink;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    @Override
    public String toString() {
        return new String("Title : "+mTitle+"\nLink : "+mUrl+"\nDescription : "+mDescription+"\nAuthor : "+mAuthor+"\nImage Url : "+mImageUrl);
    }

    public String getmAuthor() {
        return mAuthor;
    }
}

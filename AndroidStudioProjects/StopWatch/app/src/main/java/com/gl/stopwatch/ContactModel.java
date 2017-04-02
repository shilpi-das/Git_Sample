package com.gl.stopwatch;

import java.util.Date;

/**
 * Created by shilpi.das on 21-09-2016.
 */
public class ContactModel {
    private String mName="Shilpi";
    private long mNumber=123445;
    private String mType="OnGoing";
    private Date mDate;
    private String mImagePath;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public long getmNumber() {
        return mNumber;
    }

    public void setmNumber(long mNumber) {
        this.mNumber = mNumber;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmImgePath() {
        return mImagePath;
    }

    public void setmImgePath(String mImgePath) {
        this.mImagePath = mImgePath;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }
}

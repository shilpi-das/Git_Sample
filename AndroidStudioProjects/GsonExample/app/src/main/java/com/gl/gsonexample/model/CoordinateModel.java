package com.gl.gsonexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shilpi.das on 30-11-2016.
 */

public class CoordinateModel {
    @SerializedName("name")
    @Expose
    private String mObjName;
    @SerializedName("xCoord")
    @Expose
    private float mXCoord;
    @SerializedName("yCoord")
    @Expose
    private float mYCoord;
    @SerializedName("zCoord")
    @Expose
    private float mZCoord;
    @SerializedName("uuid")
    @Expose
    private String mUuid;
    @SerializedName("type")
    @Expose
    private String mType;
    @SerializedName("desc")
    @Expose
    private String mDesc;
    @SerializedName("otherType")
    @Expose
    private String mOtherDesc;

    public String getOtherDesc() {
        return mOtherDesc;
    }

    public void setOtherDesc(String otherDesc) {
        this.mOtherDesc = otherDesc;
    }

    public CoordinateModel() {

    }

    public String getType() {
        return mType;
    }

    public void setType(String mType) {
        this.mType = mType;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public CoordinateModel(String mObjName, float mXCoord, float mYCoord, float mZCoord, String mUuid, String mType, String mDesc, String mOtherDesc) {
        this.mObjName = mObjName;
        this.mXCoord = mXCoord;
        this.mYCoord = mYCoord;
        this.mZCoord = mZCoord;
        this.mUuid = mUuid;
        this.mType = mType;
        this.mDesc = mDesc;
        this.mOtherDesc = mOtherDesc;
    }

    public String getUuid() {
        return mUuid;
    }

    public void setUuid(String uuid) {
        this.mUuid = uuid;
    }

    public void setObjName(String mObjName) {
        this.mObjName = mObjName;
    }

    public void setXCoord(float mXCoord) {
        this.mXCoord = mXCoord;
    }

    public void setYCoord(float mYCoord) {
        this.mYCoord = mYCoord;
    }

    public void setZCoord(float mZCoord) {
        this.mZCoord = mZCoord;
    }

    public String getObjName() {
        return mObjName;
    }

    public float getXCoord() {
        return mXCoord;
    }

    public float getYCoord() {
        return mYCoord;
    }

    public float getZCoord() {
        return mZCoord;
    }
}

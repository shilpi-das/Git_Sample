package com.gl.gsonexample.model;

/**
 * Created by shilpi.das on 06-12-2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoryItemRead {

    @SerializedName("id")
    @Expose
    private String mId;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("locationName")
    @Expose
    private String mLocationName;
    @SerializedName("quantity")
    @Expose
    private int mQuantity;
    @SerializedName("units")
    @Expose
    private String mUnits;
    @SerializedName("prize")
    @Expose
    private int mPrice;
    @SerializedName("action")
    @Expose
    private Object mAction;
    @SerializedName("itemCreatedDate")
    @Expose
    private long mItemCreatedDate;
    @SerializedName("itemUpdatedDate")
    @Expose
    private long mItemUpdatedDate;
    @SerializedName("availbleQty")
    @Expose
    private int mAvailbleQty;

    /**
     * No args constructor for use in serialization
     *
     */
    public HistoryItemRead() {
    }

    /**
     *
     * @param id
     * @param availbleQty
     * @param itemCreatedDate
     * @param prize
     * @param name
     * @param action
     * @param quantity
     * @param locationName
     * @param itemUpdatedDate
     * @param units
     */
    public HistoryItemRead(String id, String name, String locationName, int quantity, String units, int prize, Object action, int itemCreatedDate, int itemUpdatedDate, int availbleQty) {
        super();
        this.mId = id;
        this.mName = name;
        this.mLocationName = locationName;
        this.mQuantity = quantity;
        this.mUnits = units;
        this.mPrice = prize;
        this.mAction = action;
        this.mItemCreatedDate = itemCreatedDate;
        this.mItemUpdatedDate = itemUpdatedDate;
        this.mAvailbleQty = availbleQty;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return mId;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.mId = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return mName;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.mName = name;
    }

    /**
     *
     * @return
     * The locationName
     */
    public String getLocationName() {
        return mLocationName;
    }

    /**
     *
     * @param locationName
     * The locationName
     */
    public void setLocationName(String locationName) {
        this.mLocationName = locationName;
    }

    /**
     *
     * @return
     * The quantity
     */
    public int getQuantity() {
        return mQuantity;
    }

    /**
     *
     * @param quantity
     * The quantity
     */
    public void setQuantity(int quantity) {
        this.mQuantity = quantity;
    }

    /**
     *
     * @return
     * The units
     */
    public String getUnits() {
        return mUnits;
    }

    /**
     *
     * @param units
     * The units
     */
    public void setUnits(String units) {
        this.mUnits = units;
    }

    /**
     *
     * @return
     * The prize
     */
    public int getPrize() {
        return mPrice;
    }

    /**
     *
     * @param prize
     * The prize
     */
    public void setPrize(int prize) {
        this.mPrice = prize;
    }

    /**
     *
     * @return
     * The action
     */
    public Object getAction() {
        return mAction;
    }

    /**
     *
     * @param action
     * The action
     */
    public void setAction(Object action) {
        this.mAction = action;
    }

    /**
     *
     * @return
     * The itemCreatedDate
     */
    public long getItemCreatedDate() {
        return mItemCreatedDate;
    }

    /**
     *
     * @param itemCreatedDate
     * The itemCreatedDate
     */
    public void setItemCreatedDate(int itemCreatedDate) {
        this.mItemCreatedDate = itemCreatedDate;
    }

    /**
     *
     * @return
     * The itemUpdatedDate
     */
    public long getItemUpdatedDate() {
        return mItemUpdatedDate;
    }

    /**
     *
     * @param itemUpdatedDate
     * The itemUpdatedDate
     */
    public void setItemUpdatedDate(int itemUpdatedDate) {
        this.mItemUpdatedDate = itemUpdatedDate;
    }

    /**
     *
     * @return
     * The availbleQty
     */
    public int getAvailbleQty() {
        return mAvailbleQty;
    }

    /**
     *
     * @param availbleQty
     * The availbleQty
     */
    public void setAvailbleQty(int availbleQty) {
        this.mAvailbleQty = availbleQty;
    }

    @Override
    public String toString() {
        return
                "mId='" + mId + '\'' +
                ", mName='" + mName + '\'' +
                ", mLocationName='" + mLocationName + '\'' +
                ", mQuantity=" + mQuantity +
                ", mUnits='" + mUnits + '\'' +
                ", mPrice=" + mPrice +
                ", mAction=" + mAction +
                ", mItemDate=" + mItemCreatedDate +
                ", mItemUpdatedDate=" + mItemUpdatedDate +
                ", mAvailbleQty=" + mAvailbleQty;
    }
}

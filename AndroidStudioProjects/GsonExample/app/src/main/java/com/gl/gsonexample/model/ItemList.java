package com.gl.gsonexample.model;

/**
 * Created by shilpi.das on 06-12-2016.
 */

import com.gl.gsonexample.util.FzUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemList extends Model {

    @SerializedName("_id")
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
    private long mQuantity;
    @SerializedName("units")
    @Expose
    private String mUnits;
    @SerializedName("prize")
    @Expose
    private long mPrice;
    @SerializedName("action")
    @Expose
    private Object mAction;
    @SerializedName("itemCreatedDate")
    @Expose
    private long mItemCreatedDate;
    @SerializedName("itemUpdatedDate")
    @Expose
    private long mItemUpdatedDate;
    @SerializedName("trendingItem")
    @Expose
    private boolean mTrendingItem;
    @SerializedName("newItem")
    @Expose
    private boolean newItem;

    private ItemList[] mItemLists;

    /**
     * No args constructor for use in serialization
     */
    public ItemList() {
    }

    /**
     * @param id
     * @param newItem
     * @param trendingItem
     * @param itemCreatedDate
     * @param prize
     * @param name
     * @param action
     * @param quantity
     * @param locationName
     * @param itemUpdatedDate
     * @param units
     */
    public ItemList(String id, String name, String locationName, long quantity, String units, long prize, Object action, long itemCreatedDate, long itemUpdatedDate, boolean trendingItem, boolean newItem) {
        this.mId = id;
        this.mName = name;
        this.mLocationName = locationName;
        this.mQuantity = quantity;
        this.mUnits = units;
        this.mPrice = prize;
        this.mAction = action;
        this.mItemCreatedDate = itemCreatedDate;
        this.mItemUpdatedDate = itemUpdatedDate;
        this.mTrendingItem = trendingItem;
        this.newItem = newItem;
    }

    /**
     * @return The id
     */
    public String getId() {
        return mId;
    }


    /**
     * @return The name
     */
    public String getName() {
        return mName;
    }


    /**
     * @return The locationName
     */
    public String getLocationName() {
        return mLocationName;
    }


    /**
     * @return The quantity
     */
    public long getQuantity() {
        return mQuantity;
    }

    /**
     * @return The units
     */
    public String getUnits() {
        return mUnits;
    }

    /**
     * @return The prize
     */
    public long getPrize() {
        return mPrice;
    }

    /**
     * @return The action
     */
    public Object getAction() {
        return mAction;
    }

    /**
     * @return The itemCreatedDate
     */
    public long getItemCreatedDate() {
        return mItemCreatedDate;
    }

    /**
     * @return The itemUpdatedDate
     */
    public long getItemUpdatedDate() {
        return mItemUpdatedDate;
    }

    /**
     * @return The trendingItem
     */
    public boolean isTrendingItem() {
        return mTrendingItem;
    }


    /**
     * @return The newItem
     */
    public boolean isNewItem() {
        return newItem;
    }

    /**
     * @return Attays of Items
     */
    public ItemList[] getmItemLists() {
        return mItemLists;
    }

    @Override
    public String toString() {
        return "mId='" + mId + '\'' +
                ", mName='" + mName + '\'' +
                ", mLocationName='" + mLocationName + '\'' +
                ", mQuantity=" + mQuantity +
                ", mUnits='" + mUnits + '\'' +
                ", mPrice=" + mPrice +
                ", mAction=" + mAction +
                ", mItemCreatedDate=" + mItemCreatedDate +
                ", mItemUpdatedDate=" + mItemUpdatedDate +
                ", mTrendingItem=" + mTrendingItem +
                ", newItem=" + newItem;
    }

    @Override
    public void parseJson(String jsonData) {
        mItemLists = (ItemList[]) FzUtils.getModel(jsonData, ItemList[].class);

    }

    //Todo Remove in actual implementation of foodzilla application
    @Override
    public String toJson() {
        return FzUtils.toJson(mItemLists, ItemList[].class);
    }

    @Override
    public void print() {

    }
}
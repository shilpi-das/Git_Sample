package com.gl.gsonexample.model;

/**
 * Created by shilpi.das on 06-12-2016.
 */

import com.gl.gsonexample.util.FzUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HistoryRead extends Model {

    @SerializedName("id")
    @Expose
    private String mId;
    @SerializedName("amt")
    @Expose
    private String mAmt;
    @SerializedName("itemList")
    @Expose
    private List<HistoryItemRead> mItemList = null;
    @SerializedName("status")
    @Expose
    private String mStatus;
    @SerializedName("orderCreatedDate")
    @Expose
    private String mOrderCreatedDate;
    private HistoryRead[] mHistoryReads;

    /**
     * No args constructor for use in serialization
     */
    public HistoryRead() {
    }

    /**
     * @param id
     * @param amt
     * @param status
     * @param itemList
     * @param orderCreatedDate
     */
    public HistoryRead(String id, String amt, List<HistoryItemRead> itemList, String status, String orderCreatedDate) {
        super();
        this.mId = id;
        this.mAmt = amt;
        this.mItemList = itemList;
        this.mStatus = status;
        this.mOrderCreatedDate = orderCreatedDate;
    }

    /**
     * @return array of HistoryReads
     */
    public HistoryRead[] getmHistoryReads() {
        return mHistoryReads;
    }

    /**
     * @return The id
     */
    public String getId() {
        return mId;
    }

    /**
     * @return The amt
     */
    public String getAmt() {
        return mAmt;
    }


    /**
     * @return The itemList
     */
    public List<HistoryItemRead> getItemList() {
        return mItemList;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return mStatus;
    }


    /**
     * @return The orderCreatedDate
     */
    public String getOrderCreatedDate() {
        return mOrderCreatedDate;
    }

    @Override
    public String toString() {
        return "mId='" + mId + '\'' +
                ", mAmt='" + mAmt + '\'' +
                ", mItemList=" + mItemList.toString() +
                ", mStatus='" + mStatus + '\'' +
                ", mOrderCreatedDate='" + mOrderCreatedDate + "\n";
    }

    @Override
    public void parseJson(String jsonData) {
        mHistoryReads = (HistoryRead[]) FzUtils.getModel(jsonData, HistoryRead[].class);
    }

    //Todo remove in actual implementation of fooodzilla app
    @Override
    public String toJson() {
        return FzUtils.toJson(mHistoryReads, HistoryRead[].class);
    }

    @Override
    public void print() {
    }
}
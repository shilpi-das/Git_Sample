package com.gl.gsonexample.model;

/**
 * Created by shilpi.das on 09-12-2016.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ItemListPlaceOrder {

    @SerializedName("_id")
    @Expose
    private String mId;
    @SerializedName("quantity")
    @Expose
    private int mQuantity;

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
     * The _id
     */
    public void setId(String id) {
        this.mId = id;
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

    @Override
    public String toString() {
        return "Id :"+mId+" Quantity: "+mQuantity+" ";
    }

}

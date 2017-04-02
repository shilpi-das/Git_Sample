package com.gl.multichoice;


/**
 * ProductsModelClass
 */
public class ProductsModel {


    //No image provided in JSON response
    public static final String IMAGE="image";

    private String mId;
    private String mName="NA";
    private int mQuantity=0;
    private int mPrice=0;
    private String mImageUrl;
    private int mSelectedQuantity=0;

    public int getmSelectedQuantity() {
        return mSelectedQuantity;
    }

    public void setmSelectedQuantity(int mSelectedQuantity) {
        this.mSelectedQuantity = mSelectedQuantity;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmQuantity() {
        return mQuantity;
    }

    public void setmQuantity(int mQuantity) {
        this.mQuantity = mQuantity;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }


    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append("Name : "+mName+" ");
        builder.append("Quantity : "+mQuantity+" ");
        builder.append("Price : "+mPrice+" ");
        builder.append("\n");
        return builder.toString();
    }
}




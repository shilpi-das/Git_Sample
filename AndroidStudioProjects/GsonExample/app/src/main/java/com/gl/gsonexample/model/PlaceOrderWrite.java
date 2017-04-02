package com.gl.gsonexample.model;

import android.util.Log;

import com.gl.gsonexample.util.FzUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlaceOrderWrite extends Model {

    @SerializedName("empId")
    @Expose
    private String mEmpId;
    @SerializedName("empName")
    @Expose
    private String mEmpName;
    @SerializedName("itemList")
    @Expose
    private List<ItemListPlaceOrder> mItemList = null;


    /**
     * @param empId The empId
     */
    public void setEmpId(String empId) {
        this.mEmpId = empId;
    }



    /**
     * @param empName The empName
     */
    public void setEmpName(String empName) {
        this.mEmpName = empName;
    }

    /**
     * @param itemList The itemList
     */
    public void setItemList(List<ItemListPlaceOrder> itemList) {
        this.mItemList = itemList;
    }

    @Override
    public String toString() {
        return "Emp Id: " + mEmpId + " EmpName: " + mEmpName + " Items :" + mItemList.toString();
    }
    //TODO Remove this implementation .Not needed in actual Foodzilla application
    @Override
    public void parseJson(String jsonData) {
       PlaceOrderWrite placeOrderWrite = (PlaceOrderWrite) FzUtils.getModel(jsonData, PlaceOrderWrite.class);
        this.mEmpId=placeOrderWrite.mEmpId;
        this.mEmpName=placeOrderWrite.mEmpName;
        this.mItemList=placeOrderWrite.mItemList;
    }

    @Override
    public String toJson() {
        return FzUtils.toJson(this,PlaceOrderWrite.class);
    }

    @Override
    public void print() {
        Log.d("PlaceOrderModel", "json: " + FzUtils.toJson(this, PlaceOrderWrite.class));
    }
}


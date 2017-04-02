package com.gl.gsonexample.model;

import com.gl.gsonexample.util.FzUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shilpi.das on 06-12-2016.
 */

public class LoginRead extends Model{
    @SerializedName("empName")
    @Expose
    private String mEmpName;
    @SerializedName("empId")
    @Expose
    private String mEmpId;
    @SerializedName("mail")
    @Expose
    private String mMail;
    @SerializedName("role")
    @Expose
    private String mRole;


    public String getEmpId() {
        return mEmpId;
    }



    public String getEmpName() {
        return mEmpName;
    }


    public String getMail() {
        return mMail;
    }


    public String getRole() {
        return mRole;
    }



    @Override
    public String toString() {
        return "Email :"+mMail+" Name: "+mEmpName+" Id: "+mEmpId;
    }

    @Override
    public void parseJson(String jsonData) {
        LoginRead lr = (LoginRead) FzUtils.getModel(jsonData, LoginRead.class);
        this.mEmpId=lr.mEmpId;
        this.mEmpName=lr.mEmpName;
        this.mRole=lr.mRole;
        this.mMail=lr.mMail;
}

    //TODO Remove implementation not required in actual Foodzilla app
    @Override
    public String toJson() {
        return FzUtils.toJson(this,LoginRead.class);
    }

    @Override
    public void print() {

    }
}

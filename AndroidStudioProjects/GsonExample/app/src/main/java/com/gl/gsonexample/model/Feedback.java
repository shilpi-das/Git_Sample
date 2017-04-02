package com.gl.gsonexample.model;

import android.util.Log;

import com.gl.gsonexample.util.FzUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feedback extends Model{

    @SerializedName("empName")
    @Expose
    private String mEmpName;
    @SerializedName("mail")
    @Expose
    private String mMail;
    @SerializedName("feedback")
    @Expose
    private String mFeedback;
    @SerializedName("status")
    @Expose
    private String mStatus;


    /**
     * @return The empName
     */


    public void setEmpName(String empName) {
        this.mEmpName = empName;
    }

    /**
     * @return The mail
     */
    public void setMail(String mail) {
        this.mMail = mail;
    }

    /**
     * @return The feedback
     */

    public void setFeedback(String feedback) {
        this.mFeedback = feedback;
    }


    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.mStatus = status;
    }

    @Override
    public String toString() {
        return "Name: " + mEmpName + " Mail: " + mMail + " Feedback: " + mFeedback + " Status: " + mStatus;
    }


    //TODO Remove this implementation .Not needed in actual Foodzilla application
    @Override
    public  void parseJson(String jsonData) {
        Feedback fm = (Feedback) FzUtils.getModel(jsonData, Feedback.class);
        this.mMail = fm.mMail;
        this.mEmpName = fm.mEmpName;
        this.mFeedback = fm.mFeedback;
        this.mStatus=fm.mStatus;

    }

    @Override
    public String toJson() {
        return FzUtils.toJson(this,Feedback.class);
    }

    @Override
    public void print() {
        Log.d("FeedbackModel", "json: " + FzUtils.toJson(this, Feedback.class));
    }
}

package com.gl.gsonexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Class responsible to maintain the information about the application and SDK.<br/>
 * This will have SDK version, contact and email for feedback.<br/>
 * This will also get its values from {@link ConfigurationManager}
 * TODO: @Shilpi please implement the respective methods for member variables
 */

public class AboutApplicationConfiguration {

    private static final String TAG = AboutApplicationConfiguration.class.getSimpleName();
    @SerializedName("version")
    @Expose
    private String mSdkVersion;
    @SerializedName("contactemail")
    @Expose
    private String mContactEmail;
    @SerializedName("contactextension")
    @Expose
    private String mContactExtn;
    @SerializedName("contactphone")
    @Expose
    private String mContactPhone;

    public String getSdkVersion() {
        return mSdkVersion;
    }

    public String getContactEmail() {
        return mContactEmail;
    }

    public String getContactExtn() {
        return mContactExtn;
    }

    public String getContactPhone() {
        return mContactPhone;
    }

    @Override
    public String toString()
    {
        return "\ncontactemail = "+mContactEmail+", contactextension = "+mContactExtn+", version = "+mSdkVersion+", Phone = "+mContactPhone;
    }
}

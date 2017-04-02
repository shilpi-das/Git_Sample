package com.gl.gsonexample.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * The object to hold the information of network URL and HTTP methods for an individual
 * REST request.<br/>
 * Each REST request in SDK will have one network object mapped to it.<br/>
 * passing the corresponding network key.
 *
 * TODO: @Disha please implement the respective methods for member variables
 */

public class NetworkObject {
    private static final String TAG = NetworkObject.class.getSimpleName();

    @SerializedName("id")
    @Expose
    private String mId;

    @SerializedName("requestMethod")
    @Expose
    private String mRequestMethod;

    @SerializedName("uri")
    @Expose
    private String mUri;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getRequestMethod() {
        return mRequestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.mRequestMethod = requestMethod;
    }

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        this.mUri = uri;
    }

    @Override
    public String toString()
    {
        return "\nClassPojo [id = "+mId+", requestMethod = "+mRequestMethod+", uri = "+mUri+"]";
    }
}

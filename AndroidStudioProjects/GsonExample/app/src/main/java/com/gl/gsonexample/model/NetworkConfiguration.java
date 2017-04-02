package com.gl.gsonexample.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class will be responsible to maintain the configuration related
 * to network communication like the base URL, the various relative URLs and HTTP methods
 * for order, menu, feedback, etc.<br/><br/>
 *
 * This class will be initialized and populated by {@link ConfigurationManager}.
 * TODO: @Shilpi Please implement the respective methods for base URL, network object map
 */

public class NetworkConfiguration {

    private static final String TAG = NetworkConfiguration.class.getSimpleName();

    @SerializedName("networkobject")
    @Expose
    private List<NetworkObject> mNetworkObject;

    @SerializedName("baseurl")
    @Expose
    private String mBaseUrl;

    private Map<String, NetworkObject> mNetworkObjectMap;


    public String getBaseUrl() {
        return mBaseUrl;
    }


    public Map<String, NetworkObject> getNetworkObjectMap() {
        createNetworkObjectMap();
        return mNetworkObjectMap;
    }


    /**
     * Create hash map object with key as Id of Network Object and Network Object as value
     */
    private void createNetworkObjectMap() {
        mNetworkObjectMap=new HashMap<String, NetworkObject>() ;
        for(NetworkObject networkObject:mNetworkObject){
        mNetworkObjectMap.put(networkObject.getId(),networkObject);
        }
    }
    @Override
    public String toString()
    {
        return "\nnetworkobject = "+mNetworkObject+", baseurl = "+mBaseUrl;
    }
}

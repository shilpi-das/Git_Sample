package com.gl.gsonexample.model;


import com.gl.gsonexample.util.FzUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Class responsible for maintaining configurations for network,
 * about application, current app session with SDK.<br/>
 * The application will initialize the various configuration based
 * on the JSON in file assets or sdcard.<br/>
 * This class will get all the configurations from {@link ConfigurationManager}<br/>
 * This way the configuration can be controlled without changing the APK.
 */

public class ApplicationConfiguration extends Model{

    private static final String TAG = ApplicationConfiguration.class.getSimpleName();

    private static ApplicationConfiguration sAppConfig;

    // TODO: @Shilpi implement the respective methods to set and return the configuration
    @SerializedName("networkconfiguration")
    @Expose
    private NetworkConfiguration mNetworkConfiguration;
    private SessionConfiguration mSessionConfiguration;
    @SerializedName("isLogEnabled")
    @Expose
    private boolean mIsLogEnabled;

    @SerializedName("aboutapplicationConfiguration")
    @Expose
    private AboutApplicationConfiguration mAboutApplicationConfiguration;

    private ApplicationConfiguration() {
    }

    public static ApplicationConfiguration getInstance() {
        if (sAppConfig == null) {
            sAppConfig = new ApplicationConfiguration();
        }

        return sAppConfig;
    }

    public boolean isLogEnabled() {
        // TODO: @Shilpi
        // return the value from the JSON file as received from the ConfigurationManager
        return true;
    }

    public NetworkConfiguration getNetworkConfiguration() {
        return mNetworkConfiguration;
    }

    public void setNetworkConfiguration(NetworkConfiguration networkConfiguration) {
        this.mNetworkConfiguration = networkConfiguration;
    }

    public SessionConfiguration getSessionConfiguration() {
        return mSessionConfiguration;
    }

    public void setSessionConfiguration(SessionConfiguration sessionConfiguration) {
        this.mSessionConfiguration = sessionConfiguration;
    }

    public AboutApplicationConfiguration getAboutApplicationConfiguration() {
        return mAboutApplicationConfiguration;
    }

    public void setAboutApplicationConfiguration(AboutApplicationConfiguration aboutApplicationConfiguration) {
        this.mAboutApplicationConfiguration = aboutApplicationConfiguration;
    }

    @Override
    public String toString()
    {
        return "\nClassPojo [aboutapplicationConfiguration = "+mAboutApplicationConfiguration+", networkconfiguration = "+mNetworkConfiguration+", isLogEnabled = "+mIsLogEnabled+"]";
    }

    @Override
    public void parseJson(String jsonData) {
        ApplicationConfiguration ac = (ApplicationConfiguration) FzUtils.getModel(jsonData, ApplicationConfiguration.class);
        this.mAboutApplicationConfiguration=ac.mAboutApplicationConfiguration;
        this.mNetworkConfiguration=ac.mNetworkConfiguration;
        this.mIsLogEnabled=ac.mIsLogEnabled;
    }

    @Override
    public String toJson() {
        return FzUtils.toJson(this,ApplicationConfiguration.class);
    }

    @Override
    public void print() {

    }
}

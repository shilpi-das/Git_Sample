package com.gl.gsonexample.model;

import android.content.Context;
import android.util.Log;

import com.gl.gsonexample.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * This class will be responsible to get various configuration from
 * JSON which will be in file which will be in assets or sdcard.<br/>
 * This will read the JSON from file and parse the corresponding properties
 * to respective the object.
 */

public class ConfigurationManager {

    private static final String TAG = ConfigurationManager.class.getSimpleName();
    /**
     * File name of the JSON file
     */
    private static final String FILE_NAME = "gl_foodzilla_config.json";
    /**
     * Instance of class.
     */
    private static ConfigurationManager mConfigManger;
    private static Context mContext;
    private ApplicationConfiguration mApplicationConfiguration;

    /**
     * Constructor
     */
    private ConfigurationManager() {

    }

    /**
     * Gets instance of class.
     */
    public static ConfigurationManager getInstance() {
        if (mConfigManger == null) {
            throw new IllegalStateException("Please initialize the Configuration Manager first!");
        }
        return mConfigManger;
    }

    /**
     * Read JSON file placed on sdcard or assets.
     */
    public static void init(Context context) {
        if (mConfigManger == null)
            mConfigManger = new ConfigurationManager();
        mContext = context;
        /* TODO: @Shilpi
           load the configuration from file present in asset or SD card
           For now implement to read the config from assets
           parse the JSON file and create the respective configurations
         */
        mConfigManger.readConfigFile();
    }

    /**
     * Gets application properties
     *
     * @return the application properties/configuration corresponding to the JSON file
     */
    public ApplicationConfiguration getApplicationConfiguration() {
        // TODO: @Shilpi return the appropriate configuration

        return mApplicationConfiguration;
    }

    /**
     * TODO: @Shilpi
     * Read the config file from assets to get configuration JSON
     */
    private void readConfigFile() {
        InputStream inputStream= mContext.getResources().openRawResource(R.raw.gl_foodzilla_config);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int ctr;
        try {
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.v("Text Data", byteArrayOutputStream.toString());
        mApplicationConfiguration= ApplicationConfiguration.getInstance();
        mApplicationConfiguration.parseJson(byteArrayOutputStream.toString());

    }


    /**
     * TODO: @Shilpi
     * Create the Session configuration from the configuration JSON
     */
    private void createSessionConfiguration() {

    }

}

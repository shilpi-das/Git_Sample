package com.gl.newsvolleyparser.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by shilpi.das on 24-09-2016.
 */
public class ApplicationClass extends Application {
    private static  ApplicationClass mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
    }

    public static ApplicationClass getInstance(){
        return mInstance;
    }

    public static Context getAppContext(){
        return mInstance.getApplicationContext();
    }
}

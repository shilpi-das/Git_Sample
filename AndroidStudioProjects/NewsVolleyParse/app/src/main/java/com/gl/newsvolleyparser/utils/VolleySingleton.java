package com.gl.newsvolleyparser.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by shilpi.das on 24-09-2016.
 */
public class VolleySingleton {
    private static VolleySingleton mInstance=null;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoder;

    //VolleySingleton constructor
    private VolleySingleton() {
        mRequestQueue= Volley.newRequestQueue(ApplicationClass.getAppContext());
        mImageLoder=new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
            private LruCache<String,Bitmap>cache=new LruCache<>((int) Runtime.getRuntime().maxMemory()/1024/8);
            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url,bitmap);
            }
        });

    }


    //get Instance
    public static VolleySingleton getInstance(){
        if(mInstance==null)
            mInstance=new VolleySingleton();
        return mInstance;
    }


    //Get request queue

    public RequestQueue getRequestQueue(){
        return mRequestQueue;
    }

    public ImageLoader getImageLoder(){
        return mImageLoder;
    }


}

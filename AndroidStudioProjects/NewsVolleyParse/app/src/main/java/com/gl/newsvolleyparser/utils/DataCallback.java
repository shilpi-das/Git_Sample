package com.gl.newsvolleyparser.utils;

import com.android.volley.VolleyError;

/**
 * Created by shilpi.das on 17-01-2017.
 */

public interface DataCallback {
    void onSuccess(String result);
    void onFailure(VolleyError volleyError,int responseCode);
}

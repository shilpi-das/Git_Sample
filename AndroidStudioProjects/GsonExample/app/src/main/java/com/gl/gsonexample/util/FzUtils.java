package com.gl.gsonexample.util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Created by shilpi.das on 08-12-2016.
 */

public class FzUtils {

    /**
     * Returns the model from based on the model class passed.
     * @param response the json string
     * @param modelClass the Model class
     * @return the model object
     */
    public static Object getModel(String response, Class modelClass) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(response, modelClass);
    }

    /**
     * Returns the Model in json format.
     * @param response the Model object
     * @param classType the Model class
     * @return the json string representing the Model class
     */
    public static String toJson(Object response, Class classType) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String reqBody = gson.toJson(response, classType);
        return reqBody;
    }
}





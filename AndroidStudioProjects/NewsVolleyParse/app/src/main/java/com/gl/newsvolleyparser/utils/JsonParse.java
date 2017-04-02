package com.gl.newsvolleyparser.utils;

import android.util.Log;

import com.gl.newsvolleyparser.model.NewsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by shilpi.das on 25-09-2016.
 */
public class JsonParse {
    public static final String ARTICLES = "articles";
    public static final String AUTHOR = "author";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String URL = "url";
    public static final String URL_TO_IMAGE = "urlToImage";
    public static final String JSON_ERROR = "Json error";
    private static final String LINK = "link";

    public static ArrayList<NewsModel> parseJsonResponse(JSONObject response) {
        NewsModel newsModel = null;
        ArrayList<NewsModel> newsModels = new ArrayList<NewsModel>();
        if (response != null || response.length() != 0) {
            try {
                JSONArray articlesArray = response.getJSONArray(ARTICLES);
                if (articlesArray.length() != 0 && articlesArray != null) {



                    for (int count = 0; count < articlesArray.length(); count++) {

                        //Get the root Json object
                        JSONObject rootJsonObject = articlesArray.getJSONObject(count);
                        if (rootJsonObject != null) {
                            //create new news model object
                            newsModel = new NewsModel();
                            if (rootJsonObject.has(TITLE)) {
                                newsModel.setmTitle(rootJsonObject.getString(TITLE));
                            }
                            if (rootJsonObject.has(DESCRIPTION)) {
                                newsModel.setmDescription(rootJsonObject.getString(DESCRIPTION));
                            }
                            if (rootJsonObject.has(AUTHOR)) {
                                newsModel.setmAuthor(rootJsonObject.getString(AUTHOR));
                            }
                            if (rootJsonObject.has(URL)) {
                                newsModel.setmUrl(rootJsonObject.getString(URL));
                            }
                            if (rootJsonObject.has(URL_TO_IMAGE)) {
                                newsModel.setmImageUrl(rootJsonObject.getString(URL_TO_IMAGE));
                            }
                            newsModels.add(newsModel);
                        }
                    }

                }


            } catch (JSONException e) {
                Log.e(JSON_ERROR, e.toString());

            }
        }

        return newsModels;

    }

}

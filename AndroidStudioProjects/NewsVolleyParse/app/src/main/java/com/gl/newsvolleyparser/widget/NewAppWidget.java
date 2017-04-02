package com.gl.newsvolleyparser.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.gl.newsvolleyparser.R;
import com.gl.newsvolleyparser.activity.NewsShowActivity;
import com.gl.newsvolleyparser.model.NewsModel;
import com.gl.newsvolleyparser.utils.JsonParse;
import com.gl.newsvolleyparser.utils.VolleySingleton;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {
    private ArrayList<NewsModel> mNewsModels;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        ComponentName newsWidget = new ComponentName(context, NewAppWidget.class);

        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(newsWidget);

        getNewsModel(context);

        //For loop to find a particular id

        for (int widgetIds : allWidgetIds) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
           /* if (mNewsModels != null) {*/

                int number = new Random(mNewsModels.size() - 1).nextInt();


                remoteViews.setTextViewText(R.id.tv_appwidget_title, mNewsModels.get(number).getmTitle());
                remoteViews.setImageViewResource(R.id.ivAppWidgetImage, R.drawable.demo);

                // Create an Intent to launch ExampleActivity
                Intent intent = new Intent(context, NewsShowActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

                remoteViews.setOnClickPendingIntent(R.id.ivAppWidgetImage, pendingIntent);
           // } /*else remoteViews.setTextViewText(R.id.tv_appwidget_title, "No net Connection Found");*/

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(widgetIds, remoteViews);


        }
    }


    public void getNewsModel(final Context context) {
        RequestQueue requestQueue = VolleySingleton.getInstance().getRequestQueue();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, NewsShowActivity.URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
                mNewsModels = new JsonParse().parseJsonResponse(response);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();

            }
        });

        requestQueue.add(request);

    }
}


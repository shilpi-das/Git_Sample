package com.gl.newsvolleyparser.activity;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.gl.newsvolleyparser.R;
import com.gl.newsvolleyparser.adapter.RecyclerViewAdapter;
import com.gl.newsvolleyparser.model.NewsModel;
import com.gl.newsvolleyparser.utils.DataCallback;
import com.gl.newsvolleyparser.utils.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class NewsShowActivity extends AppCompatActivity {
    private int mResponseCode = 1;
    private RecyclerView mRecyclerView;
    public static final String GET_ITEMS_URL = "Http://172.18.2.86:8080//foodzilla/v1/getItems";
    public static final String URL = "https://newsapi.org/v1/articles?source=associated-press&sortBy=top&apiKey=39a480b2838e4c47b0f96b9d5d08161b";
    private Exception exception;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_show);
           initialize();
        //startParsingTask();
        //useData();
    }

    public void startParsingTask() {

        Thread threadA = new Thread() {
            public void run() {
                ThreadB threadB = new ThreadB();
                String jsonObject = null;
                try {
                    jsonObject = threadB.execute().get(10, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    exception = e;
                    Log.e("Error", e.toString());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                    exception = e;
                    Log.e("Error", e.toString());
                } catch (TimeoutException e) {
                    e.printStackTrace();
                    exception = e;
                    Log.e("Error", e.toString());
                }
                final String receivedJSONObject = jsonObject;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (receivedJSONObject != null) {
                            Toast.makeText(getApplicationContext(), receivedJSONObject, Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        };
        threadA.start();
    }

    private class ThreadB extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            final RequestFuture<String> futureRequest = RequestFuture.newFuture();
            RequestQueue queue = VolleySingleton.getInstance().getRequestQueue();
            StringRequest jsonArrayRequest = new StringRequest(Request.Method.GET, GET_ITEMS_URL, futureRequest, futureRequest) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put(getResources().getString(R.string.location_name), getResources().getString(R.string.locationName));
                    return params;
                }

            };
            queue.add(jsonArrayRequest);
            try {
                return futureRequest.get(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Log.e("Error", e.toString());
            } catch (ExecutionException e) {
                e.printStackTrace();
                if (e.getCause() instanceof VolleyError) {
                    //grab the volley error from the throwable and cast it back
                    VolleyError volleyError = (VolleyError) e.getCause();
                    if (volleyError instanceof ServerError) {  //now just grab the network response like normal
                        NetworkResponse networkResponse = volleyError.networkResponse;
                        if (networkResponse != null)
                            Log.e("Error", volleyError.toString() + " " + volleyError.networkResponse.statusCode);
                    }
                }
                Log.e("Error", e.toString());
                // if(volleyError instanceof NetworkError||volleyError instanceof AuthFailureError||volleyError instanceof ServerError||volleyError instanceof ParseError||volleyError instanceof NoConnectionError)

            } catch (TimeoutException e) {
                e.printStackTrace();
                Log.e("Error", e.toString());
            }
            return null;
        }
    }


    private void initialize() {
        mRecyclerView = (RecyclerView) findViewById(R.id.tvResponse);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RequestQueue requestQueue = VolleySingleton.getInstance().getRequestQueue();

        final RequestFuture futureRequest = RequestFuture.newFuture();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, GET_ITEMS_URL,futureRequest,futureRequest
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put(getResources().getString(R.string.location_name), getResources().getString(R.string.locationName));
                return params;
            }

        };
        requestQueue.add(jsonArrayRequest);
        try {
            JSONArray jsonArray=(JSONArray) futureRequest.get(1, TimeUnit.MINUTES);
            Log.i("Response",jsonArray.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e("Error", e.toString());
        } catch (ExecutionException e) {
            e.printStackTrace();
            if (e.getCause() instanceof VolleyError) {
                //grab the volley error from the throwable and cast it back
                VolleyError volleyError = (VolleyError) e.getCause();
                if (volleyError instanceof ServerError) {  //now just grab the network response like normal
                    NetworkResponse networkResponse = volleyError.networkResponse;
                    if (networkResponse != null)
                        Log.e("Error", volleyError.toString() + " " + volleyError.networkResponse.statusCode);
                }
            }
            Log.e("Error", e.toString());
            // if(volleyError instanceof NetworkError||volleyError instanceof AuthFailureError||volleyError instanceof ServerError||volleyError instanceof ParseError||volleyError instanceof NoConnectionError)

        } catch (TimeoutException e) {
            e.printStackTrace();
            Log.e("Error", e.toString());
        }






/*        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, URL, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {

            Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
       *//*     ArrayList<NewsModel> newsModels= new JsonParse().parseJsonResponse(response);
            setAdapter(newsModels);*//*





        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

            Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
        }
    });*/

       /* requestQueue.add(jsonArrayRequest);
        try {
           JSONArray jsonArray= (JSONArray)futureRequest.get(1, TimeUnit.MINUTES);
            Log.i("Json",jsonArray.toString());
            Toast.makeText(getApplicationContext(),jsonArray.toString(),Toast.LENGTH_LONG).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            VolleyError volleyError=new VolleyError(e);
            Log.i("Error",e+"   "+volleyError.getMessage());
            Toast.makeText(getApplicationContext(),e+"   "+volleyError.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (TimeoutException e) {
            Toast.makeText(getApplicationContext(),"Time out",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }*/
    }


    private void setAdapter(ArrayList<NewsModel> newsModels) {
        //Create recycler view adapter
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this);
        List<NewsModel> models = newsModels;
        recyclerViewAdapter.setNewsList(models);
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    public void fetchData(final DataCallback callback) {

        StringRequest jsonArrayRequest = new StringRequest(Request.Method.GET, GET_ITEMS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                callback.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                int response = 1;
                if (error.networkResponse != null)
                    response = error.networkResponse.statusCode;
                callback.onFailure(error, response);
            }

        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put(getResources().getString(R.string.location_name), getResources().getString(R.string.locationName));
                return params;
            }

        };
        RequestQueue queue = VolleySingleton.getInstance().getRequestQueue();
        queue.add(jsonArrayRequest);

    }

    public void useData() {
        fetchData(new DataCallback() {
            @Override
            public void onSuccess(String result) {
                Log.i("Data", result);
            }

            @Override
            public void onFailure(VolleyError volleyError, int responseCode) {

                Log.e("Error", volleyError.toString() + " " + responseCode);
            }
        });
    }


}



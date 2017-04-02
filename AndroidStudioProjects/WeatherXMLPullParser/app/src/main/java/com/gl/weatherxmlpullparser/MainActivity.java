package com.gl.weatherxmlpullparser;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mListViewNewsFeeds;
    private Spanned spannedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListViewNewsFeeds = (ListView) findViewById(R.id.listView);
        new NewsItemModelAsyncTask().execute("http://rss.weatherzone.com.au/?u=12994-1285&lt=aploc&lc=15465&obs=1&fc=1&warn=1");
    }

    private class NewsItemModelAsyncTask extends AsyncTask<String, Void, ArrayList<ItemModel>> {


        @Override
        protected ArrayList<ItemModel> doInBackground(String... url) {
            ArrayList<ItemModel> itemModelList = null;
            try {
                itemModelList = downloadUrl(url[0]);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return itemModelList;


        }

        @Override
        protected void onPostExecute(ArrayList<ItemModel> itemModels) {
            ArrayAdapter<ItemModel> adapter = new ArrayAdapter<ItemModel>(MainActivity.this, android.R.layout.simple_list_item_1, itemModels);
//            mListViewNewsFeeds.setAdapter(adapter);
        }
    }


    private ArrayList<ItemModel> downloadUrl(String myurl) throws IOException {
        InputStream is = null;
        ArrayList<ItemModel> itemModelList = null;

        try {
            Log.e("Debug", "The response is: " + myurl);
            URL url = new URL(myurl);
            Log.e("Debug", "The response is: " + myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.e("Debug", "The response is: " + response);
            is = conn.getInputStream();
            itemModelList = xmlParse(is);

        } catch (Exception e) {
            Log.e("Debug", "Exception " + e.toString());

        }

        return itemModelList;
    }

    private ArrayList<ItemModel> xmlParse(InputStream in) {
        ArrayList<ItemModel> itemModelList = new ArrayList<ItemModel>();


        XmlPullParserFactory factory = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            int eventType = parser.getEventType();
            ItemModel itemModel = new ItemModel();
            parser.setInput(in, null);
            String text = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                Log.e(tagname, "tagname");
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("item")) {
                            itemModel = new ItemModel();
                            Log.e("TAG", "Start");
                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        Log.e("TAG", "Text");
                        break;
                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("item")) {
                            itemModelList.add(itemModel);
                        } else if (tagname.equalsIgnoreCase(ItemModel.TITLE)) {
                            itemModel.setTitle(text);
                        } else if (tagname.equalsIgnoreCase(ItemModel.DESCRIPTION)) {
                            itemModel.setDescription(text);

                            new ImageGetterAsyncTask().execute(text);


                        } else if (tagname.equalsIgnoreCase(ItemModel.LINK)) {
                            itemModel.setLink(text);
                        }
                        Log.e("TAG", "End");
                        break;
                    default:
                        break;
                }

                eventType = parser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemModelList;

    }


    private class ImageGet implements Html.ImageGetter {
        @Override
        public Drawable getDrawable(String s) {

            return fetchDrawable(s);
        }
    }


    //Async Task
    private class ImageGetterAsyncTask extends AsyncTask<String, Void, Spanned> {

        @Override
        protected Spanned doInBackground(String... params) {

            Spanned s = Html.fromHtml(params[0],new ImageGet(),null);

            return s;
        }

        @Override
        protected void onPostExecute(Spanned spanned) {
            TextView sampleTextView = (TextView) findViewById(R.id.text);
            sampleTextView.append(spanned);
            sampleTextView.setMovementMethod(new LinkMovementMethod());
        }
    }

    public Drawable fetchDrawable(String urlString) {
        try {
            InputStream is = fetch(urlString);
            Drawable drawable = Drawable.createFromStream(is, "src");
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth()*3,drawable.getIntrinsicHeight()*3);
            return drawable;
        } catch (Exception e) {
            return null;
        }
    }


    //Fetch drawable
    private InputStream fetch(String urlString) throws MalformedURLException, IOException {
        Log.e("Debug", "The response is: " + urlString);
        URL url = new URL(urlString);
        Log.e("Debug", "The response is: " + urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        // Starts the query
        conn.connect();
        int response = conn.getResponseCode();
        Log.e("Debug", "The response is: " + response);
        return conn.getInputStream();


    }
}


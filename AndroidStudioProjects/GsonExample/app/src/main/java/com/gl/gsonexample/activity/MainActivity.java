package com.gl.gsonexample.activity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGImageView;
import com.caverock.androidsvg.SVGParseException;
import com.gl.gsonexample.R;
import com.gl.gsonexample.model.ApplicationConfiguration;
import com.gl.gsonexample.model.ConfigurationManager;
import com.gl.gsonexample.model.HistoryRead;
import com.gl.gsonexample.model.ItemList;
import com.gl.gsonexample.model.LoginRead;
import com.gl.gsonexample.model.NetworkConfiguration;
import com.gl.gsonexample.model.PlaceOrderWrite;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private TextView mTvJson,
            mTvModel,
            mTvJsonOrder,
            mTvJsonModel,
            mtvJsonGetItems,
            mtvModelGetItems,
            mTvPlaceOrderJson,
            mTvPlaceOrderModel,
            mTvFeedbackJson,
            mTvFeedbackModel;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvJson = (TextView) findViewById(R.id.tvjson);
        mTvModel = (TextView) findViewById(R.id.tvmodel);
        mTvJsonOrder = (TextView) findViewById(R.id.tvjsonOrder);
        mTvJsonModel = (TextView) findViewById(R.id.tvmodelOrder);
        mtvJsonGetItems = (TextView) findViewById(R.id.tvjsonGetItems);
        mtvModelGetItems = (TextView) findViewById(R.id.tvmodelGetItems);
        mTvPlaceOrderJson = (TextView) findViewById(R.id.tvjsonPlaceOrder);
        mTvPlaceOrderModel = (TextView) findViewById(R.id.tvmodelPlaceOrder);
        mTvFeedbackJson = (TextView) findViewById(R.id.tvjsonFeedback);
        mTvFeedbackModel = (TextView) findViewById(R.id.tvmodelFeedback);
        mLinearLayout=(LinearLayout)findViewById(R.id.ll);
        SVGImageView svgImageView=new SVGImageView(this);
       // svgImageView.setImageAsset("india.svg");
        AssetManager am = getAssets();
        try {
            InputStream is = am.open("india.svg");
            svgImageView.setSVG(SVG.getFromInputStream(is));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SVGParseException e) {
            e.printStackTrace();
        }

        mLinearLayout.addView(svgImageView,new LinearLayout.LayoutParams(50,50));

        getSetLoginData();
        getSetOrderData();
        getSetGetItems();
        getSetPlaceOrder();
        getSetFeedback();

    }

    private void getSetFeedback() {
        //Get Data From Text Resource File Contains Json Data.
      /*  InputStream inputStream = getResources().openRawResource(R.raw.gl_foodzilla_config);
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
        Log.v("Text Data", byteArrayOutputStream.toString());*/

        ConfigurationManager.init(getApplicationContext());
        ApplicationConfiguration applicationConfiguration=ConfigurationManager.getInstance().getApplicationConfiguration();
        Log.i("Tag",applicationConfiguration.getNetworkConfiguration().getNetworkObjectMap().get("getmenu").toString());

        //(Feedback) mJsonConverter.getModel(ModelEnum.FeedbackModel, byteArrayOutputStream.toString());
        mTvFeedbackModel.setText("FeedbackModel:\n" + applicationConfiguration.toString() + "\n");
       /* mTvFeedbackJson.setText("FeedbackJson:\n" + feedback.toJson() + "\n");*/
    }

    private void getSetPlaceOrder() {
        //Get Data From Text Resource File Contains Json Data.
        InputStream inputStream = getResources().openRawResource(R.raw.json_place_order);
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
        PlaceOrderWrite placeOrderWrite = new PlaceOrderWrite();
        placeOrderWrite.parseJson(byteArrayOutputStream.toString());
        mTvPlaceOrderModel.setText("PlaceOrderModel:\n" + placeOrderWrite.toString() + "\n");
        mTvPlaceOrderJson.setText("PlaceOrderJson:\n" + placeOrderWrite.toJson() + "\n");
    }

    private void getSetGetItems() {
        //Get Data From Text Resource File Contains Json Data.
        InputStream inputStream = getResources().openRawResource(R.raw.json_get_items);
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
        ItemList itemList = new ItemList();
        itemList.parseJson(byteArrayOutputStream.toString());
        StringBuilder stringBuilder = new StringBuilder();
        for (ItemList model : itemList.getmItemLists()) {
            stringBuilder.append(model.toString() + "\n");
        }
        mtvJsonGetItems.setText("GetItemsModel:\n" + stringBuilder + "\n");
        mtvModelGetItems.setText("GetItemsJson:\n" + itemList.toJson() + "\n");
    }

    private void getSetOrderData() {
        //Get Data From Text Resource File Contains Json Data.
        InputStream inputStream = getResources().openRawResource(R.raw.json_order_history);
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
        HistoryRead historyReads = new HistoryRead();
        historyReads.parseJson(byteArrayOutputStream.toString());
        StringBuilder stringBuilder = new StringBuilder();
        for (HistoryRead model : historyReads.getmHistoryReads()) {
            stringBuilder.append(model.toString() + "\n");
        }
        mTvJsonModel.setText("OderModel:\n" + stringBuilder + "\n");
        mTvJsonOrder.setText("OrderJson:\n" + historyReads.toJson() + "\n");
    }

    private void getSetLoginData() {
        //Get Data From Text Resource File Contains Json Data.
        InputStream inputStream = getResources().openRawResource(R.raw.json_login);
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
        LoginRead loginModel = new LoginRead();
        loginModel.parseJson(byteArrayOutputStream.toString());
        mTvJson.setText("LoginRead:\n" + loginModel.toString() + "\n");
        mTvModel.setText("LoginJson:\n" + loginModel.toJson() + "\n");
    }


}

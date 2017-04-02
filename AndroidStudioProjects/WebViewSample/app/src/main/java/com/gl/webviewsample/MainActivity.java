package com.gl.webviewsample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Comunicator{
private TextView mTvMainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvMainActivity=(TextView)findViewById(R.id.tvMainActivity);
    }

    @Override
    public void communicate(String url) {
        mTvMainActivity.setVisibility(View.INVISIBLE);
        //Dynamic Fragment
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        WebViewFragment fragment = new WebViewFragment();
        Bundle bundle=new Bundle();
        bundle.putString(Strings.URL,url);
        fragment.setArguments(bundle);
        fragmentTransaction.add(R.id.framePlaceHolder, fragment);
        fragmentTransaction.commit();

    }
}

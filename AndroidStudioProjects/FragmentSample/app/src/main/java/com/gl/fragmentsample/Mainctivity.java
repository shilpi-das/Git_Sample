package com.gl.fragmentsample;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class Mainctivity extends AppCompatActivity {
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainctivity);
//        if (savedInstanceState == null) {
            //Generating random no
            Random r = new Random();
            number = r.nextInt(10);
            FragmentDisplayNumber fragment = (FragmentDisplayNumber) getFragmentManager().findFragmentById(R.id.fragment_display_no);
            Bundle bundle = new Bundle();
            bundle.putInt(FinalStaticStrings.RANDOM_NUMBER_FRAGMENT, number);
            fragment.setText(bundle);


//        }
    }
}

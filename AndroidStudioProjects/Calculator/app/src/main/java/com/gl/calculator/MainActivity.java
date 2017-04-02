package com.gl.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private int add(int a, int b) {
        if (a < 0 && b < 0)
            return -1;
        else
            return a + b;
    }
}

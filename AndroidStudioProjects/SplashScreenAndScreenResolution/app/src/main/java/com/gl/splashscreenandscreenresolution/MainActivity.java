package com.gl.splashscreenandscreenresolution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import bean.FreshersBean;


public class MainActivity extends AppCompatActivity {
    private FreshersBean freshersBean;
    private static String TAG = "Setting screen done";
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        final Bundle b=savedInstanceState;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b==null)
                {
                    Intent intent=new Intent(MainActivity.this,SettingActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent=new Intent(MainActivity.this,UserActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(TAG,"colour set");
        super.onSaveInstanceState(outState);
    }
}

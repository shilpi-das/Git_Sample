package com.gl.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Runnable mRunnable;
    Handler mHandler;
    private Button btnStart,btnStop;
    NotificationCall mNotificationCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tvStopWatch=(TextView)findViewById(R.id.tvStopWatch);
        btnStart=(Button)findViewById(R.id.btnStart);
        btnStop=(Button)findViewById(R.id.btnStop);
        mNotificationCall=new NotificationCall(new ContactModel(),this);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mNotificationCall.createNotification();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNotificationCall.cancelNotification();
            }
        });



       /* mHandler=new Handler();


        final Long startTime=System.currentTimeMillis();

        mRunnable=new Runnable() {
            @Override
            public void run() {


                long millis=System.currentTimeMillis()-startTime;
                long secs=millis/1000;
                tvStopWatch.setText(String.format("%02d:%02d",secs/60,secs%60));
                mHandler.postDelayed(mRunnable,10L);
            }
        };
        mHandler.postDelayed(mRunnable,10L);*/
    }
}

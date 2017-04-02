package com.gl.backstackapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by shilpi.das on 25-03-2017.
 */

public class Frag2 extends Fragment implements View.OnTouchListener {
    private TextView mTvName;
    String name;
    private int mXDelta,mYDelta;
    private LinearLayout rootLayout;

    public Frag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag2, container, false);
        rootLayout=(LinearLayout)view.findViewById(R.id.root);
        mTvName = (TextView) rootLayout.findViewById(R.id.tvName);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTvName.setText(name);
        mTvName.setOnTouchListener(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(300, 300);
        mTvName.setLayoutParams(layoutParams);
    }

    public void getName(String name,Bundle bundle) {
        this.name = name;
        MyEnum myEnum[]= (MyEnum[]) bundle.getSerializable("key");
        Log.i("myEnum[]",myEnum[0]+" "+myEnum[1]);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) v.getLayoutParams();
                mXDelta=layoutParams.leftMargin;
                mYDelta=layoutParams.topMargin;
                break;
            case MotionEvent.ACTION_MOVE:
                LinearLayout.LayoutParams lParams = (LinearLayout.LayoutParams) v.getLayoutParams();
                lParams.leftMargin=X-mXDelta;
                lParams.topMargin=Y-mYDelta;
                lParams.rightMargin=-250;
                lParams.bottomMargin=-250;
                v.setLayoutParams(lParams);
                break;
        }
        rootLayout.invalidate();
        return true;
    }
}
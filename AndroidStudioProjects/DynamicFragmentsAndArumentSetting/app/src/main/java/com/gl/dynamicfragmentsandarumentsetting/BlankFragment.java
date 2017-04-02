package com.gl.dynamicfragmentsandarumentsetting;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

public static final String KEY="key";
    public TextView tvBlankFragment;
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_blank, container, false);
        if(savedInstanceState==null) {
            Random r = new Random();
            TextView tvBlankFragment = (TextView) view.findViewById(R.id.tvBlankFragment);
            tvBlankFragment.setText(r.nextInt(10) + "");
        }
        else
            tvBlankFragment.setText(savedInstanceState.getString(KEY,"No Value Found"));

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY,tvBlankFragment.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       /* if () {

        }*/
    }
}

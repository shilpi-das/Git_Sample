package com.gl.webviewsample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ButtonFragment extends Fragment {
    private View view;
    private Button mBGlobalLogic, mBWebkit, mBWeather;
    Comunicator comunicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_button, container, false);
        mBGlobalLogic = (Button) view.findViewById(R.id.bGlobalLogic);
        mBWeather = (Button) view.findViewById(R.id.bWeather);
        mBWebkit = (Button) view.findViewById(R.id.bWebkit);
        comunicator = (Comunicator) getActivity();
        mBGlobalLogic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                comunicator.communicate(Strings.GLOBALLOGIC_URL);
            }
        });

        mBWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comunicator.communicate(Strings.WEATHER_URL);
            }
        });

        mBWebkit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comunicator.communicate(Strings.WEBKIT_URL);
            }
        });
        return view;
    }

}

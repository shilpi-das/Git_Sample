package com.gl.fragmentsample;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentDisplayNumber extends Fragment {
    private int randomNumber;
    private View rootView;
    private TextView tvFragment;

    public FragmentDisplayNumber() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_fragment_display_number, container, false);
        return rootView;
    }

    public void setText(Bundle bundle) {
        tvFragment = (TextView) rootView.findViewById(R.id.tvFragment);
        tvFragment.setText(bundle.getInt(FinalStaticStrings.RANDOM_NUMBER_FRAGMENT) + "");
        tvFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creating new intent and starting sub activity
                Intent intent = new Intent(getActivity(), SubActivity.class);
                intent.putExtra("number", tvFragment.getText().toString());
                startActivity(intent);

            }
        });
    }


}

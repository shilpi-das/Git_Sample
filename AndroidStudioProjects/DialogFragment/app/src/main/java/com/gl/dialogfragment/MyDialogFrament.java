package com.gl.dialogfragment;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by shilpi.das on 28-08-2016.
 */
public class MyDialogFrament extends DialogFragment implements View.OnClickListener {
    private Button mYes, mNo;
    private Communicator communicator;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_dialog_layout, null, false);
        setCancelable(false);
        communicator=(Communicator)getActivity();
        mYes = (Button) view.findViewById(R.id.bYes);
        mNo = (Button) view.findViewById(R.id.bNo);
        mYes.setOnClickListener(this);
        mNo.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bYes) {
            dismiss();
            communicator.Communicate("Yes is clicked");
        } else {
            dismiss();
            communicator.Communicate("No is clicked");

        }
    }
}


package com.gl.backstackapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment implements View.OnClickListener{
    private Communicator mCommunicator;
    private EditText mEditText;
    private Button mButton;

    public Frag1() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCommunicator = (Communicator) context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1, container, false);
        // Inflate the layout for this fragment
        mEditText = (EditText) view.findViewById(R.id.etName);
        mButton = (Button) view.findViewById(R.id.button);
        mButton.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        MyEnum myEnums[]=new MyEnum[]{MyEnum.ENUM_KEY_1,MyEnum.ENUM_KEY_2};
        Bundle bundle=new Bundle();
        bundle.putSerializable("key",myEnums);
        mCommunicator.sendName(mEditText.getText().toString(),bundle);
    }
}

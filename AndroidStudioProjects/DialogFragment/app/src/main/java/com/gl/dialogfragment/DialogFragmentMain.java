package com.gl.dialogfragment;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogFragmentMain extends AppCompatActivity implements Communicator {
private  Button bSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment_main);
        bSubmit=(Button)findViewById(R.id.bSubmit);
        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager=getFragmentManager();
                MyDialogFrament myDialogFrament=new MyDialogFrament();
                myDialogFrament.show(manager,"MyDialog");
            }
        });
    }

    @Override
    public void Communicate(String msg) {
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
    }
}

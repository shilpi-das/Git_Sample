package com.gl.backstackapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void sendName(String name,Bundle bundle) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Frag2 frag2 = new Frag2();
// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.rl_container, frag2);
        transaction.addToBackStack("Frag1");
        frag2.getName(name,bundle);

// Commit the transaction
        transaction.commit();
    }
}

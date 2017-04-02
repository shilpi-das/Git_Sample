package com.gl.dynamicfragmentsandarumentsetting;

//import android.support.v4.app.FragmentTransaction;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.place_holder_fragment, new BlankFragment());
        ft.commit();*/

        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        Fragment fragment= new Fragment();
        BlankFragment blankFragment=new BlankFragment();
        //fragmentTransaction.replace(android.R.id.content,blankFragment);
        fragmentTransaction.commit();

    }



}

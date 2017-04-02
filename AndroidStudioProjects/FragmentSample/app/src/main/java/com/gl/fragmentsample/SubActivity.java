package com.gl.fragmentsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    private TextView tvFragment, tvSubActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        //Linking XML components
         tvFragment=(TextView)findViewById(R.id.tvFragment);
        tvSubActivity = (TextView) findViewById(R.id.tvSubActivity);


        //Getting Intent
        Intent intent = getIntent();
        int number = Integer.parseInt(intent.getStringExtra("number"));
        FragmentDisplayNumber fragment = (FragmentDisplayNumber) getSupportFragmentManager().findFragmentById(R.id.fragment_display_no);
        Bundle bundle = new Bundle();
        bundle.putInt(FinalStaticStrings.RANDOM_NUMBER_FRAGMENT, number);
        fragment.setText(bundle);
        tvFragment.setClickable(false);
        //Setting Text View of fragment
        // tvFragment.setText(value+"");

        //Generating table of a no
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            sb.append(number + " * " + i + " = " + (number * i));
            sb.append("\n");
        }
        //Setting text in text View of activity
        tvSubActivity.setText(sb.toString());

    }
}

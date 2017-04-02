package com.gl.calculateweightdifferentplanets;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WeightCalculateMainActivity extends AppCompatActivity {

    private Button mBCalculate;
    private String mSWeight;
    private float mFWeight;
    private EditText mEditTextWeight;
    private TextView mTextViewWeightMercury, mTextViewWeightVenus, mTextViewWeightMoon, mTextViewWeightMars, mTextViewWeightJupiter, mTextViewWeightUranus, mTextViewWeightNeptune, mTextViewWeightPluto, mTextViewWeightSaturn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_calculate_main);
        //Linking all view components
        viewComponentsLink();


        //getting weight from edit text
        mBCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSWeight = mEditTextWeight.getText().toString();
                if (TextUtils.isEmpty(mSWeight)) {
                    Toast.makeText(getApplicationContext(), "Plese Enter some text", Toast.LENGTH_LONG).show();
                } else {
                    mFWeight = Float.parseFloat(mSWeight);
                    ColorDrawable buttonColor = (ColorDrawable) mBCalculate.getBackground();
                    int colorId = buttonColor.getColor();
                    //Setting weight calculated text
                    mTextViewWeightMercury.setText(weightCalculate(mFWeight, 0.38f) + "");
                    mTextViewWeightVenus.setText(weightCalculate(mFWeight, 0.91f) + "");
                    mTextViewWeightMoon.setText(weightCalculate(mFWeight, 0.83f) + "");
                    mTextViewWeightMars.setText(weightCalculate(mFWeight, 0.38f) + "");
                    mTextViewWeightSaturn.setText(weightCalculate(mFWeight, 1.06f) + "");
                    mTextViewWeightUranus.setText(weightCalculate(mFWeight, 0.92f) + "");
                    mTextViewWeightNeptune.setText(weightCalculate(mFWeight, 1.91f) + "");
                    mTextViewWeightJupiter.setText(weightCalculate(mFWeight, 2.34f) + "");
                    mTextViewWeightPluto.setText(weightCalculate(mFWeight, 0.06f) + "");
                    mTextViewWeightPluto.setTextColor(colorId);


                }
            }
        });


    }

    void viewComponentsLink() {


        mTextViewWeightMercury = (TextView) findViewById(R.id.tv_show_weight_mercury);
        mTextViewWeightVenus = (TextView) findViewById(R.id.tv_show_weight_venus);
        mTextViewWeightMoon = (TextView) findViewById(R.id.tv_show_weight_moon);
        mTextViewWeightMars = (TextView) findViewById(R.id.tv_show_weight_mars);
        mTextViewWeightJupiter = (TextView) findViewById(R.id.tv_show_weight_jupiter);
        mTextViewWeightSaturn = (TextView) findViewById(R.id.tv_show_weight_saturn);
        mTextViewWeightUranus = (TextView) findViewById(R.id.tv_show_weight_uranus);
        mTextViewWeightNeptune = (TextView) findViewById(R.id.tv_show_weight_neptune);
        mTextViewWeightPluto = (TextView) findViewById(R.id.tv_show_weight_pluto);


        mEditTextWeight = (EditText) findViewById(R.id.etWeight);
        mBCalculate = (Button) findViewById(R.id.button);

    }


    float weightCalculate(float weight, float surafeceGravity) {
        return weight * surafeceGravity;
    }
}


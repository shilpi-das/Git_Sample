package com.gl.calculatebmi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateBMIMainActivity extends AppCompatActivity {
    private EditText mEditTextHeight;
    private EditText mEditTextWeight;
    private ImageView mImageView;
    private TextView mTextViewShowBMI, mTextViewEnd;
    private Button mButtonCalculateBMI;
    private double mHeight;
    private double mWeight;
    private double mBMIIndex;
    private RelativeLayout mRelativeLayout;
    private boolean mCheckInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmimain);

        //Linking XML components
        linkingXML();

        //Setting on click listener
        mButtonCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Hiding virtual keyboard
                try {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mRelativeLayout.getWindowToken(), 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //Clearing the text
                mTextViewShowBMI.setText("");
                //Calculating BMI
                mBMIIndex = calculateBMI();
                //Checking input value
                mCheckInput = setAndValidateInput();
                if (mCheckInput == true) {  //Setting new font
                    Typeface face = Typeface.createFromAsset(getAssets(), "atmostsphere.ttf");
                    mTextViewEnd.setTypeface(face, Typeface.BOLD);

                    //Rounding BMI index
                    mBMIIndex = Math.round(mBMIIndex * 1000) / 1000.0;
                    if (mBMIIndex < 18.5) {
                        mTextViewShowBMI.setText(mBMIIndex + "\n" + "Under Weight");
                        mTextViewShowBMI.setTextColor(Color.BLUE);
                        mTextViewShowBMI.setTextSize(22);
                        mTextViewShowBMI.setAllCaps(true);
                        mTextViewShowBMI.setTypeface(Typeface.DEFAULT_BOLD, Typeface.BOLD);
                        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.underweight);
                        mImageView.setImageBitmap(bitmap);

                    } else if (mBMIIndex >= 18.5 && mBMIIndex < 25) {
                        mTextViewShowBMI.setText(mBMIIndex + "\n" + "Normal Weight");
                        mTextViewShowBMI.setTextColor(Color.GREEN);
                        mTextViewShowBMI.setTextSize(20);
                        mTextViewShowBMI.setAllCaps(false);
                        mImageView.setImageResource(R.drawable.normal_weight);
                        mTextViewShowBMI.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);

                    } else if (mBMIIndex >= 25 && mBMIIndex < 30) {
                        mTextViewShowBMI.setTextColor(Color.CYAN);
                        mImageView.setImageResource(R.drawable.overweight);
                        mTextViewShowBMI.setAllCaps(false);
                        mTextViewShowBMI.setTextSize(23);
                        mTextViewShowBMI.setText(mBMIIndex + "\n" + "Over Weight");
                        mTextViewShowBMI.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);

                    } else {
                        mTextViewShowBMI.setTextColor(Color.RED);
                        mTextViewShowBMI.setTextSize(30);
                        mImageView.setImageResource(R.drawable.obese);
                        mTextViewShowBMI.setAllCaps(true);
                        mTextViewShowBMI.setText(mBMIIndex + "\n" + "Obese");
                        mTextViewShowBMI.setAllCaps(true);
                        mTextViewShowBMI.setTypeface(Typeface.MONOSPACE, Typeface.BOLD_ITALIC);
                    }
                } else
                    Toast.makeText(getApplicationContext(), "Please Enter some Text", Toast.LENGTH_LONG).show();
            }

        });

    }

    //Linking XML component
    public void linkingXML() {
        mEditTextHeight = (EditText) findViewById(R.id.et_height);
        mEditTextWeight = (EditText) findViewById(R.id.et_weight);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mTextViewShowBMI = (TextView) findViewById(R.id.tv_show_BMI);
        mButtonCalculateBMI = (Button) findViewById(R.id.b_calculate_BMI);
        mTextViewEnd = (TextView) findViewById(R.id.tvEnd);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);


    }

    //Calulate BMI
    public double calculateBMI() {
        return (mWeight / (mHeight * mHeight));
    }


    //Validating and taking input
    public boolean setAndValidateInput() {
        //validating input
        if(TextUtils.isEmpty(mEditTextHeight.getText().toString())||TextUtils.isEmpty(mEditTextWeight.getText().toString()))
       // if (mEditTextHeight.getText().toString().equals("") || mEditTextWeight.getText().toString().equals(""))
            return false;
        else {
            //converting input to double
            mHeight = Double.parseDouble(mEditTextHeight.getText().toString());
            mWeight = Double.parseDouble(mEditTextWeight.getText().toString());
            return true;
        }
    }
}
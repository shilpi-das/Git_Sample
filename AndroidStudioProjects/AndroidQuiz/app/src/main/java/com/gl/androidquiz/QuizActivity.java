package com.gl.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    private RadioGroup mRadioGroupQ1, mRadioGroupQ2, mRadioGroupQ3;
    private int mSelectedId;
    private RadioButton mRadioButtonCorrectAns;
    private StringBuilder sbAns1, sbAns2, sbAns3, sbAns4, sbAns5, sbAns6;
    private Button mButtonSubmit;
    private ArrayList<String> mFinalAnsArrayList;
    private Boolean mArResponse[] = {false, false, false, false, false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //Linking xml components
        xmlLinking();

        //Defining all String Builders
        definitionStringBuilder();

        //Submit button on click listener
        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSelectedId = mRadioGroupQ1.getCheckedRadioButtonId();
                if (mSelectedId != -1) {
                    mRadioButtonCorrectAns = (RadioButton) findViewById(R.id.Q4_Option1);
                    sbAns4.append(mRadioButtonCorrectAns.getText().toString());
                }
                mSelectedId = mRadioGroupQ2.getCheckedRadioButtonId();
                if (mSelectedId != -1) {
                    mRadioButtonCorrectAns = (RadioButton) findViewById(mSelectedId);
                    sbAns5.append(mRadioButtonCorrectAns.getText().toString());
                }

                mSelectedId = mRadioGroupQ3.getCheckedRadioButtonId();
                if (mSelectedId != -1) {
                    mRadioButtonCorrectAns = (RadioButton) findViewById(mSelectedId);
                    sbAns6.append(mRadioButtonCorrectAns.getText().toString());
                }


                Intent intent = new Intent(QuizActivity.this, QuizAnswerActivity.class);
                mFinalAnsArrayList = new ArrayList<String>();
                mFinalAnsArrayList.add(sbAns1.toString());
                mFinalAnsArrayList.add(sbAns2.toString());
                mFinalAnsArrayList.add(sbAns3.toString());
                mFinalAnsArrayList.add(sbAns4.toString());
                mFinalAnsArrayList.add(sbAns5.toString());
                mFinalAnsArrayList.add(sbAns6.toString());

                //Staring new intent and passing array list
                intent.putStringArrayListExtra("final_ans", mFinalAnsArrayList);
                startActivity(intent);
                finish();
            }
        });

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked

        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.Q1_Option1:
                if (checked && (!mArResponse[0])) {
                    sbAns1.append(((CheckBox) view).getText().toString() + " ");
                    mArResponse[0] = true;
                }

                break;
            case R.id.Q1_Option2:
                if (checked && (!mArResponse[1])) {
                    sbAns1.append(((CheckBox) view).getText().toString() + " ");
                    mArResponse[1] = true;
                }
                break;
            case R.id.Q1_Option3:
                if (checked && (!mArResponse[2])) {
                    sbAns1.append(((CheckBox) view).getText().toString() + " ");
                    mArResponse[2] = true;
                }
                break;
            case R.id.Q2_Option1:
                if (checked && (!mArResponse[3])) {
                    sbAns2.append(((CheckBox) view).getText().toString() + " ");
                    mArResponse[3] = true;
                }
                break;

            case R.id.Q2_Option2:

                if (checked && (!mArResponse[4])) {
                    sbAns2.append(((CheckBox) view).getText().toString() + " ");
                    mArResponse[4] = true;
                }
                break;
            case R.id.Q2_Option3:
                if (checked && (!mArResponse[5])) {
                    mArResponse[5] = true;
                }
                break;
            case R.id.Q3_Option1:
                if (checked && (!mArResponse[6])) {
                    sbAns3.append(((CheckBox) view).getText().toString() + " ");
                    mArResponse[6] = true;
                }
                break;
            case R.id.Q3_Option2:
                if (checked && (!mArResponse[7])) {
                    sbAns3.append(((CheckBox) view).getText().toString() + " ");
                    mArResponse[7] = true;
                }
                break;
            case R.id.Q3_Option3:
                if (checked && (!mArResponse[8])) {
                    sbAns3.append(((CheckBox) view).getText().toString() + " ");
                    mArResponse[8] = true;
                }
                break;
        }

    }

    public void xmlLinking() {
        mRadioGroupQ1 = (RadioGroup) findViewById(R.id.rg_Q1);
        mRadioGroupQ2 = (RadioGroup) findViewById(R.id.rg_Q2);
        mRadioGroupQ3 = (RadioGroup) findViewById(R.id.rg_Q3);
        mButtonSubmit = (Button) findViewById(R.id.bSubmit);
    }

    public void definitionStringBuilder() {
        sbAns1 = new StringBuilder("");
        sbAns2 = new StringBuilder("");
        sbAns3 = new StringBuilder("");
        sbAns4 = new StringBuilder("");
        sbAns5 = new StringBuilder("");
        sbAns6 = new StringBuilder("");
    }

}

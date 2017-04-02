package com.gl.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizAnswerActivity extends AppCompatActivity {
    private TextView mTvAns;
    private ArrayList<String> mAlFinalAns;
    private List<String> mAlCorrectAns,mAlQuestions;
    private Button mBRetakeQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_answer);
        //Initialization of arrays and view
        initialize();
        //getting value from intent
        mAlFinalAns=getIntent().getStringArrayListExtra("final_ans");

        //Appending in text view
        for(int i=0;i<mAlQuestions.size();i++)
        {
            mTvAns.append(mAlQuestions.get(i)+"\n"+"Your Ans : "+mAlFinalAns.get(i)+"\nCorrect Ans : "+mAlCorrectAns.get(i)+"\n\n");
        }

        //retake quiz button initialization
        mBRetakeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),QuizActivity.class));
                finish();
            }
        });

    }
    public void initialize()
    {
        mTvAns=(TextView)findViewById(R.id.tvAns);
        mBRetakeQuiz=(Button)findViewById(R.id.bRetake);
        mAlCorrectAns= Arrays.asList(getResources().getStringArray(R.array.ar_answers));
        mAlQuestions= Arrays.asList(getResources().getStringArray(R.array.ar_questions));
        mTvAns.setMovementMethod(new ScrollingMovementMethod());

    }
}

package com.gl.programminglanguagemaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProgrammingLanguageMainActivity extends AppCompatActivity {
    List<String> programmingLaungage;
    Button submit;
    EditText etMonthSelect;
    TextView tvShowString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming_language_main);
        //Adding count value
        final String count[] = getResources().getStringArray(R.array.Count);
        //Adding programming language to arrayList
        programmingLaungage = Arrays.asList(getResources().getStringArray(R.array.Programming_Language));
        //getting month list
        final List<String> month = Arrays.asList(getResources().getStringArray(R.array.Month));

        //Linking all XML components
        submit = (Button) findViewById(R.id.Submit);
        etMonthSelect = (EditText) findViewById(R.id.tv_Month_Select);
        tvShowString = (TextView) findViewById(R.id.tv_String_Display);

        //On click submit button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getMonth = etMonthSelect.getText().toString().trim();
                int index = 0, countValue;
                boolean flag = false;
                StringBuilder displayString = new StringBuilder();
                //matching value of month with array month
                for (int i = 0; i < 12; i++) {
                    if (month.get(i).equalsIgnoreCase(getMonth)) {
                        index = i;
                        flag = true;
                        break;
                    }

                }
                if (flag == false) {
                    tvShowString.setText("Wrong input");
                } else {
                    countValue = Integer.parseInt(count[index]);
                    String message;
                    //getting plural value
                    message = getResources().getQuantityString(R.plurals.Language, countValue, countValue,month.get(index));
                    if (countValue == 0) {
                        tvShowString.setText(displayString);
                    } else {
                        displayString.append(message);

                        //Selecting random number
                        Random r = new Random();

                        displayString.append("\n");
                        displayString.append(programmingLaungage.get(r.nextInt(10)));
                        for (int i = 1; i < countValue; i++) {
                            int ranIndex = r.nextInt(10);
                            displayString.append(", " + programmingLaungage.get(ranIndex) + " ");
                        }
                        tvShowString.setText(displayString);
                    }
                }


            }
        });


    }
}

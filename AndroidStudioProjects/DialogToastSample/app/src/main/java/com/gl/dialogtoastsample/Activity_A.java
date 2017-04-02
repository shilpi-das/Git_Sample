package com.gl.dialogtoastsample;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_A extends AppCompatActivity {
    private Button mBListDialog, mBMultichoiceDialog, mBCustomDialog, mBLaunchActivityB;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private String car[];
    private ArrayList<String> mAlCheckedItems;
    private EditText mEtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Toast.makeText(getApplicationContext(), Strings.ON_CREATE_ACTIVITY_A, Toast.LENGTH_SHORT).show();

        //Linking Buttons
        xmlLinking();
        //creating String array car[]
        car = getResources().getStringArray(R.array.car);

        //Show the alert dialog when the Activity A gets launched successfully with "OK" Button.
        builder = new AlertDialog.Builder(Activity_A.this);
        builder.setMessage(R.string.activity_a_launched);
        builder.setTitle(R.string.title_a);
        builder.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog = builder.create();
        dialog.show();




        //Showing List dialog
        mBListDialog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                builder = new AlertDialog.Builder(Activity_A.this);
                builder.setTitle(R.string.list_dialog);
                builder.setItems(R.array.car, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), car[i] + "", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog = builder.create();
                dialog.show();
            }
        });



        //Creating multi choice dialog
        mBMultichoiceDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAlCheckedItems = new ArrayList<String>();
                builder = new AlertDialog.Builder(Activity_A.this);
                builder.setTitle(R.string.multi_choice_dialog);
                builder.setMultiChoiceItems(R.array.car, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (b) {
                            mAlCheckedItems.add(car[i]);
                        } else if (mAlCheckedItems.contains(i)) {
                            mAlCheckedItems.remove(Integer.valueOf(car[i]));
                        }

                    }
                });
                //Setting positive button
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Selected Strings are: " + mAlCheckedItems.toString(), Toast.LENGTH_LONG).show();
                    }
                });
                //Setting negative button
                builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.setCancelable(false);
                dialog = builder.create();
                dialog.show();

            }
        });




        //Creating custom dialog
        mBCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Inflating layout
                final View mDialogView = LayoutInflater.from(Activity_A.this).inflate(R.layout.activity_name_enter, null);
                builder = new AlertDialog.Builder(Activity_A.this);
                builder.setView(mDialogView);
                builder.setTitle(R.string.custom_dialog);
                //Setting positive response
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mEtName = (EditText) mDialogView.findViewById(R.id.etName);
                        Toast.makeText(getApplicationContext(), "Name is: " + mEtName.getText().toString(), Toast.LENGTH_LONG).show();
                    }
                });
                //Setting negative response
                builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.setCancelable(false);
                dialog = builder.create();
                dialog.show();
            }
        });





        //Dialog for launching Activity B
        mBLaunchActivityB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder = new AlertDialog.Builder(Activity_A.this);
                builder.setTitle(R.string.title_a);
                builder.setMessage(R.string.activity_B_ask);
                //Setting positive response
                builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), Activity_B.class));
                    }
                });
                //Setting negative Response
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(getApplicationContext(), "No new activity launched", Toast.LENGTH_LONG).show();
                        Toast toast =Toast.makeText(getApplicationContext(),"Message",Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setText("hgjh");
                        toast.show();
                    }
                });
                builder.setCancelable(false);
                dialog = builder.create();
                dialog.show();
            }
        });


    }


    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), Strings.ON_STOP_ACTIVITY_A, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), Strings.ON_DESTROY_ACTIVITY_A, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), Strings.ON_START_ACTIVITY_A, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), Strings.ON_RESTART_ACTIVITY_A, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), Strings.ON_RESUME_ACTIVITY_A, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), Strings.ON_PAUSE_ACTIVITY_A, Toast.LENGTH_SHORT).show();
    }

    public void xmlLinking() {
        mBCustomDialog = (Button) findViewById(R.id.bCustomDialog);
        mBLaunchActivityB = (Button) findViewById(R.id.bLaunchActivityB);
        mBListDialog = (Button) findViewById(R.id.bListDialog);
        mBMultichoiceDialog = (Button) findViewById(R.id.bMultiChoiceDialog);
    }

}

package com.gl.dialogtoastsample;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class Activity_B extends AppCompatActivity {
    private AlertDialog dialog;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Toast.makeText(getApplicationContext(), Strings.ON_CREATE_ACTIVITY_B, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), Strings.ON_STOP_ACTIVITY_B, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), Strings.ON_DESTROY_ACTIVITY_B, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), Strings.ON_START_ACTIVITY_B, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), Strings.ON_RESTART_ACTIVITY_B, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), Strings.ON_RESUME_ACTIVITY_B, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), Strings.ON_PAUSE_ACTIVITY_B, Toast.LENGTH_SHORT).show();
    }

    //creating dialog on back button press
    @Override
    public void onBackPressed() {

        builder = new AlertDialog.Builder(Activity_B.this);
        builder.setTitle(R.string.title_b);
        builder.setCancelable(false);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(Activity_B.this, Activity_A.class));
                finish();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "No new activity launched", Toast.LENGTH_LONG).show();
            }
        });
        dialog = builder.create();
        dialog.show();
       // super.onBackPressed();
    }

}

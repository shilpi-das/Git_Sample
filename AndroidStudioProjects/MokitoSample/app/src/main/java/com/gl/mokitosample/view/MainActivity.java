package com.gl.mokitosample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gl.mokitosample.Presenter.Ipresenter;
import com.gl.mokitosample.Presenter.Presenter;
import com.gl.mokitosample.R;
import com.gl.mokitosample.model.EmployeeModel;
import com.gl.mokitosample.view.IActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IActivity {
    private Ipresenter mPresenter;
    private EditText mEtName;
    private TextView mTvName;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter=new Presenter(this);
        init();

    }

    private void init() {
        mEtName=(EditText)findViewById(R.id.etEmployeeName);
        mTvName=(TextView)findViewById(R.id.tvEmployeeName);
        mButton=(Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mPresenter.setEmpName(mEtName.getText().toString());
        mTvName.setText(mPresenter.getEmpName());
    }

    @Override
    public void show(String empName) {
        Toast.makeText(getApplicationContext(),empName+" Saved",Toast.LENGTH_LONG).show();
    }
}

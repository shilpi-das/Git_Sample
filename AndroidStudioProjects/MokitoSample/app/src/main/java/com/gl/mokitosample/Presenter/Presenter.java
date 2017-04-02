package com.gl.mokitosample.Presenter;

import com.gl.mokitosample.model.IEmployeeModel;
import com.gl.mokitosample.view.IActivity;
import com.gl.mokitosample.model.EmployeeModel;

/**
 * Created by shilpi.das on 30-01-2017.
 */

public class Presenter implements Ipresenter {
    private IActivity mView;
    private IEmployeeModel mEmpModel;

    public Presenter(IActivity view,IEmployeeModel model) {
        this.mView = view;
        mEmpModel =model;

    }
    public Presenter(IActivity view) {
        this.mView = view;
        mEmpModel=new EmployeeModel();

    }

    @Override
    public void setEmpName(String empName) {
        mEmpModel.setEmpName(empName);
        mView.show(empName);
    }

    @Override
    public String getEmpName() {
        return mEmpModel.getEmpName();
    }
}

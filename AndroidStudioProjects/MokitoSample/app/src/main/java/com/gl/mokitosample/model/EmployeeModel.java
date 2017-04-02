package com.gl.mokitosample.model;

/**
 * Created by shilpi.das on 30-01-2017.
 */

public class EmployeeModel implements IEmployeeModel {
    private String mEmpName;

    public String getEmpName() {
        return mEmpName;
    }

    public void setEmpName(String empName) {
        this.mEmpName = empName;
    }
}

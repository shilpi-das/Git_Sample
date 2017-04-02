package com.gl.gsonexample.model;

/**
 * Class to store User information after successful login.<br/>.
 * This will also have the encrypted password which needs to send into header of REST call as "x-authBytes".
 * <br/>
 * TODO: TODO: @Shilpi please implement the respective methods for member variables
 */

public class SessionConfiguration {

    private static final String TAG = SessionConfiguration.class.getSimpleName();

    private String mEmployeeEmail;
    private String mEmployeeName;
    private String mEmployeeRole;
    private String mEmployeeId;
    private String mXAuthBytes;

    public SessionConfiguration() {

    }

    public SessionConfiguration(String employeeEmail, String employeeName, String employeeRole, String employeeId, String xAuthBytes) {
        this.mEmployeeEmail = employeeEmail;
        this.mEmployeeName = employeeName;
        this.mEmployeeRole = employeeRole;
        this.mEmployeeId = employeeId;
        this.mXAuthBytes = xAuthBytes;
    }

    public String getEmployeeEmail() {
        return mEmployeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.mEmployeeEmail = employeeEmail;
    }

    public String getEmployeeName() {
        return mEmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.mEmployeeName = employeeName;
    }

    public String getEmployeeRole() {
        return mEmployeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.mEmployeeRole = employeeRole;
    }

    public String getmEmployeeId() {
        return mEmployeeId;
    }

    public void setmEmployeeId(String employeeId) {
        this.mEmployeeId = employeeId;
    }

    public String getXAuthBytes() {
        return mXAuthBytes;
    }

    public void setXAuthBytes(String xAuthBytes) {
        this.mXAuthBytes = xAuthBytes;
    }
}

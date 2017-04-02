package com.gl.mokitosample;

import com.gl.mokitosample.Presenter.Ipresenter;
import com.gl.mokitosample.Presenter.Presenter;
import com.gl.mokitosample.model.EmployeeModel;
import com.gl.mokitosample.model.IEmployeeModel;
import com.gl.mokitosample.view.IActivity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by shilpi.das on 30-01-2017.
 */

public class PresenterTest {
    private Ipresenter mPresenter;
    private IActivity mView;
    private IEmployeeModel mModel;
    private static final String NAME="Shilpi";
    @Before
    public void setUp() throws Exception {

        mModel = mock(IEmployeeModel.class);
        mView = mock(IActivity.class);
        mPresenter = new Presenter(mView,mModel);
    }
    @Test
   public void setEmpTest(){
        mPresenter.setEmpName(NAME);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(mModel, times(1)).setEmpName(argumentCaptor.capture());
        verify(mView, times(1)).show(argumentCaptor.capture());
        Assert.assertEquals(argumentCaptor.getValue().toString(),NAME);
    }
    @Test
    public void getEmpTest(){
        when(mModel.getEmpName()).thenReturn(NAME);
        mPresenter.getEmpName();
        verify(mModel, times(1)).getEmpName();
    }

}

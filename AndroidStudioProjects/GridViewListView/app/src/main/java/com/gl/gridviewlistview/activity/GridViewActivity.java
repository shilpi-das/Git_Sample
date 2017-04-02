package com.gl.gridviewlistview.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.gl.listviewsample.R;

import java.util.ArrayList;
import java.util.List;

import adapter.GridViewAdapter;
import model.RowGridViewModel;

public class GridViewActivity extends AppCompatActivity {
    private GridView mGridView;
    private List<RowGridViewModel> mRowGridViewModelList;
    private TypedArray mTaImgageSpot;
    private String mArraySpots[];
    private Intent intent;
    private int mPosition, count;
    private ArrayList<String> mAlSpotName;
    private RowGridViewModel rowGridViewModel;
    private GridViewAdapter gridViewAdapter;
    private TextView mTvSpotName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        //Initializing all data elements
        intialize();

        //populating array list of spot name
        populateArrayListSpotName();

        //populating grid view
        populateGridView();

        //Setting onClick listener on grid view
        clickListenerGridView();

    }

    private void intialize() {

        mArraySpots = getResources().getStringArray(R.array.famous_locations);
        mTaImgageSpot = getResources().obtainTypedArray(R.array.location_image);
        intent = getIntent();
        mPosition = intent.getIntExtra("POSITION", 0);
        mAlSpotName = new ArrayList<String>();
        mRowGridViewModelList = new ArrayList<RowGridViewModel>();
        mGridView = (GridView) findViewById(R.id.gridview);
    }

    private void populateArrayListSpotName() {
        int count = mPosition * 6;
        for (int i = 0; i < 6; i++, count++) {
            mAlSpotName.add(mArraySpots[count]);
        }
    }

    private void populateGridView() {
        for (int i = 0; i < mTaImgageSpot.length(); i++) {
            rowGridViewModel = new RowGridViewModel(mAlSpotName.get(i), mTaImgageSpot.getResourceId(i, i));
            mRowGridViewModelList.add(rowGridViewModel);
        }

        gridViewAdapter = new GridViewAdapter(GridViewActivity.this, mRowGridViewModelList);
        mGridView.setAdapter(gridViewAdapter);
    }

    private void clickListenerGridView() {
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mTvSpotName = (TextView) view.findViewById(R.id.tvGridViewSpotName);
                Toast.makeText(getApplicationContext(), "Spot Name is: " + mTvSpotName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.gl.gridviewlistview.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gl.listviewsample.R;

import java.util.ArrayList;
import java.util.List;

import adapter.ListViewAdapter;
import model.RowListViewModel;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView;
    private List<RowListViewModel> rowListViewModelList;
    private TypedArray mTaImgageFlag, mTaImageSpot;
    private String mArrayCountry[], mArraySpot[];
    private Intent intent;
    private TextView mTvCountryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initialize();
        populateRowListView();
        clickListener();


    }

    //Initializing all components
    private void initialize() {
        mArrayCountry = getResources().getStringArray(R.array.country_name);
        mArraySpot = getResources().getStringArray(R.array.place);
        mTaImgageFlag = getResources().obtainTypedArray(R.array.flag);
        mTaImageSpot = getResources().obtainTypedArray(R.array.spot);
        //Linkinking xml listview
        listView = (ListView) findViewById(R.id.listView);
        //Initializing model row list
        rowListViewModelList = new ArrayList<RowListViewModel>();
    }

    //Populating array list of row list view
    private void populateRowListView() {

        for (int count = 0; count < mArraySpot.length; count++) {
            RowListViewModel rowListViewModelItem = new RowListViewModel(mArrayCountry[count], mArraySpot[count], mTaImgageFlag.getResourceId(count, count), mTaImageSpot.getResourceId(count, count));
            rowListViewModelList.add(rowListViewModelItem);
            //creating object of adapter class
            ListViewAdapter listViewAdapter = new ListViewAdapter(ListViewActivity.this, rowListViewModelList);
            //setting adapter in list view
            listView.setAdapter(listViewAdapter);

        }
    }

    //Setting On click listener
    private void clickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting view and displaying country selected
                mTvCountryName = (TextView) view.findViewById(R.id.tvCountryName);
                Toast.makeText(getApplicationContext(), "Country Selected is: " + mTvCountryName.getText().toString(), Toast.LENGTH_SHORT).show();
                if (i < 10) {
                    //Starting GridView intent
                    intent = new Intent(ListViewActivity.this, GridViewActivity.class);
                    intent.putExtra("POSITION", i);
                    startActivity(intent);
                } else
                    Toast.makeText(getApplicationContext(), "No data found", Toast.LENGTH_LONG).show();


            }
        });
    }
}

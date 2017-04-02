package com.gl.multichoice;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private DatabaseHelper helperClass;
    private Cursor mCursor;
    private Adapter mAdapter;
    private int mCount = 0;

    private ArrayList<ProductsModel> mProductModelList;
    private ArrayList<ProductsModel> mSelectedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

    }

    private void initialize() {
        mListView = (ListView) findViewById(R.id.listView);
        mSelectedList = new ArrayList<>();
        setCursorAdapter();
    }

    private void setCursorAdapter() {
        helperClass = new DatabaseHelper(MainActivity.this);
        mCursor = helperClass.getData();
        mAdapter = new Adapter(MainActivity.this, mCursor);
        mProductModelList = new ArrayList<>();
        getProductList();
        mListView.setAdapter(mAdapter);
        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        mListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
                if (b) {
                    Log.i("Boolean", b + "");
                    mSelectedList.add(mProductModelList.get(i));
                } else {
                    Log.i("Boolean not", b + "");
                    mSelectedList.remove(mProductModelList.get(i));
                }
                mCount = mCount + 1;
                actionMode.setTitle(mCount + " Items Selected");
                final int checkedCount = mListView.getCheckedItemCount();


                // Set the CAB title according to total checked items
                actionMode.setTitle(checkedCount + " Selected");
                // Calls toggleSelection method from ListViewAdapter Class


            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                MenuInflater inflater = actionMode.getMenuInflater();
                inflater.inflate(R.menu.context_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.selectMultiple:
                        StringBuilder builder = new StringBuilder();
                        for (ProductsModel model : mSelectedList) {
                            builder.append(model.toString());
                        }
                        Log.i("Model selected", builder.toString());
                        mSelectedList.clear();
                        actionMode.finish();
                        return true;
                    default:
                        return false;

                }

            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        });
    }

    private void getProductList() {
        if (mCursor != null) {
            while (mCursor.moveToNext()) {
                ProductsModel productsModel = new ProductsModel();
                productsModel.setmName(mCursor.getString(mCursor.getColumnIndex(TableConstants.COLUMN_PROD_NAME)));
                productsModel.setmId(mCursor.getString(mCursor.getColumnIndex(TableConstants.COLUMN_PROD_ID)));
                productsModel.setmSelectedQuantity(mCursor.getInt(mCursor.getColumnIndex(TableConstants.COLUMN_PROD_QUANTITY)));
                productsModel.setmPrice(mCursor.getInt(mCursor.getColumnIndex(TableConstants.COLUMN_PROD_PRICE)));
                mProductModelList.add(productsModel);

            }

        }
    }
}
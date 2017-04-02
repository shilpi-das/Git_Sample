package com.gl.multichoice;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.gl.multichoice.R;

/**
 * Created by shilpi.das on 30-09-2016.
 */
public class Adapter extends CursorAdapter {
    private TextView tvName,tvPrice;
    public Adapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_view_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        tvName = (TextView) view.findViewById(R.id.tvFavoriteTitle);
        tvPrice = (TextView) view.findViewById(R.id.tvFavoritePrice);
        // Extract properties from cursor
        String name = cursor.getString(cursor.getColumnIndexOrThrow(TableConstants.COLUMN_PROD_NAME));
        String phoneNo = cursor.getString(cursor.getColumnIndexOrThrow(TableConstants.COLUMN_PROD_PRICE));
        // Populate fields with extracted properties
        tvName.setText(name);
        tvPrice.setText(phoneNo);

    }

    @Override
    public void changeCursor(Cursor cursor) {
        super.changeCursor(cursor);
    }
}

package com.gl.multichoice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shilpi.das on 30-09-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TableConstants.SQL_QUERY_CREATE);
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableConstants.COLUMN_PROD_ID, 36);
        contentValues.put(TableConstants.COLUMN_PROD_NAME,"Test");
        contentValues.put(TableConstants.COLUMN_PROD_PRICE,10);
        sqLiteDatabase.insert(TableConstants.TABLE_NAME,null,contentValues);
        contentValues.clear();
        contentValues.put(TableConstants.COLUMN_PROD_ID, 32);
        contentValues.put(TableConstants.COLUMN_PROD_NAME,"Chips");
        contentValues.put(TableConstants.COLUMN_PROD_PRICE,10);
        sqLiteDatabase.insert(TableConstants.TABLE_NAME,null,contentValues);
        contentValues.clear();
        contentValues.put(TableConstants.COLUMN_PROD_ID, 31);
        contentValues.put(TableConstants.COLUMN_PROD_NAME,"Frooti");
        contentValues.put(TableConstants.COLUMN_PROD_PRICE,10);
        sqLiteDatabase.insert(TableConstants.TABLE_NAME,null,contentValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public DatabaseHelper(Context context) {
        super(context, TableConstants.DATABASE, null, VERSION);
    }
    private void getDatabase() {
        if (sqLiteDatabase == null) {
            sqLiteDatabase = getWritableDatabase();
        }

    }
    public Cursor getData(){
        getDatabase();
        return sqLiteDatabase.rawQuery(TableConstants.TABLE_SELECT_QUERY,null);
    }
}

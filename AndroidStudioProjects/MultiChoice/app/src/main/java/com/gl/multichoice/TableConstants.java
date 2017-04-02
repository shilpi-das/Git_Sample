package com.gl.multichoice;

import android.net.Uri;

/**
 * Created by shilpi.das on 29-09-2016.
 */
public class TableConstants {
    public static final String AUTH="com.gl.foodzilla.content_provider.FavouritesContentProvider";
    public static final String DATABASE = "favorite_db";
    public static final String TABLE_NAME = "favorite_table";
    public static final String COLUMN_PROD_NAME = "prod_name";
    public static final String COLUMN_PROD_ID = "prod_id";
    public static final String COLUMN_PROD_PRICE = "prod_price";
    public static final String COLUMN_PROD_QUANTITY = "prod_quantity";
    public static final String ID = "_id";
    public static final String SQL_QUERY_CREATE = "create table " + TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_PROD_NAME + " varchar(45)," + COLUMN_PROD_ID + " integer,"+COLUMN_PROD_QUANTITY+" integer DEFAULT 1,"+COLUMN_PROD_PRICE+" integer);";
    public static final String URL = "content://" + AUTH + "/"+TABLE_NAME;
    public static final Uri CONTENT_URI = Uri.parse(URL);
    public static final String TABLE_SELECT_QUERY="select * from "+TABLE_NAME;
}

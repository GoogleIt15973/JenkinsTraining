package com.fullcreamlowfat.wireless_shory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 11/8/2016.
 */
public class shopDBHandler extends SQLiteOpenHelper{

    private static  final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "shops_list_detail.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ", ";

    private static final String SQL_CREATE_SHOPS_TABLE =
            "CREATE TABLE " + shopsContractSchema.shopsEntry.TABLE_NAME + " (" +
            shopsContractSchema.shopsEntry._ID + " INTEGER PRIMARY KEY," +
            shopsContractSchema.shopsEntry.COLUMN_SHOPNAME + TEXT_TYPE +COMMA_SEP +
            shopsContractSchema.shopsEntry.COLUMN_CATEGORY + TEXT_TYPE + COMMA_SEP +
            shopsContractSchema.shopsEntry.COLUMN_FLOOR + TEXT_TYPE + COMMA_SEP +
            shopsContractSchema.shopsEntry.COLUMN_ABOUT + TEXT_TYPE + COMMA_SEP +
            shopsContractSchema.shopsEntry.COLUMN_PHONENO + TEXT_TYPE + COMMA_SEP +
            shopsContractSchema.shopsEntry.COLUMN_WEBSITE + TEXT_TYPE + COMMA_SEP +
            " )";

    private static final String SQL_DELETE_SHOPS_TABLE = "DROP TABLE IF EXISTS " +
            shopsContractSchema.shopsEntry.TABLE_NAME;

    public shopDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_SHOPS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_SHOPS_TABLE);
        onCreate(db);
    }

    public void addShopDetail(tenantItem details){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(shopsContractSchema.shopsEntry.COLUMN_SHOPNAME, details.getShopName());
        values.put(shopsContractSchema.shopsEntry.COLUMN_CATEGORY, details.getCategory());
        values.put(shopsContractSchema.shopsEntry.COLUMN_FLOOR, details.getFloor());
        values.put(shopsContractSchema.shopsEntry.COLUMN_ABOUT, details.getAbout());
        values.put(shopsContractSchema.shopsEntry.COLUMN_PHONENO, details.getPhoneNo());
        values.put(shopsContractSchema.shopsEntry.COLUMN_WEBSITE, details.getWebsite());

        db.insert(shopsContractSchema.shopsEntry.TABLE_NAME, null, values);
        db.close();
    }
/*
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_SHOP_LIST_DETAIL + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while (!c.isAfterLast()){
            if (c.getString(c.getColumnIndex("shopName")) !=null){
                dbString += c.getString(c.getColumnIndex("shopName"));
                dbString += "/n";
            }
        }
        db.close();
        return  dbString;
    }
    */
}

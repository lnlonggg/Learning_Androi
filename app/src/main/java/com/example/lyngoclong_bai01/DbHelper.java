package com.example.lyngoclong_bai01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class DbHelper extends SQLiteOpenHelper {
    //Tự tạo static final static
    public static final String DB_NAME = "ProductDB";
    public static final int DB_VERSION = 3;
    public static final String TABLE_PRODUCT = "Products";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_DESC = "mota";
    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String taobang = "CREATE TABLE " + TABLE_PRODUCT + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " TEXT, " + COL_DESC + " TEXT)";
        db.execSQL(taobang);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        onCreate(db);
    }

    public boolean them(SanPham sp ){
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(COL_NAME, sp.getName());
        v.put(COL_DESC, sp.getMota());
        long kq = db1.insert(TABLE_PRODUCT, null, v);;
        return kq!=-1;
    }

    public ArrayList<SanPham> layTatCa(){
        ArrayList<SanPham> ds = new ArrayList<>();
        SQLiteDatabase db1 = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_PRODUCT;
        Cursor cursor = db1.rawQuery(sql, null);
        while(cursor.moveToNext()){
            String name = cursor.getString(1);
            String mota = cursor.getString(2);
            SanPham sp = new SanPham(name, mota);
            ds.add(sp);
        }
        return ds;
    }

//    public boolean xoa(SanPham sp) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        long result = db.delete(TABLE_PRODUCT, COL_NAME + " = ?", new String[]{sp.getName()});
//        return result > 0;
//    }
//
//    public ArrayList<SanPham> timKiem(String key) {
//        ArrayList<SanPham> ds = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        String sql = "SELECT * FROM " + TABLE_PRODUCT + " WHERE " + COL_NAME + " LIKE ?";
//        Cursor cursor = db.rawQuery(sql, new String[]{"%" + key + "%"});
//
//        while (cursor.moveToNext()) {
//            String name = cursor.getString(1);
//            String mota = cursor.getString(2);
//            SanPham sp = new SanPham(name, mota);
//            ds.add(sp);
//        }
//        return ds;
//    }

}

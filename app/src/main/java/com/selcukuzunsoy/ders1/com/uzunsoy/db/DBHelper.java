package com.selcukuzunsoy.ders1.com.uzunsoy.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="TELEFONREHBERI";
    public static final String KISI_TABLO="REHBER";
    public static final String KISI_COL_ID="ID";
    public static final String KISI_COL_AD ="AD";
    public static final String KISI_COL_SOYAD="SOYAD";
    public static final String KISI_COL_EMAIL="EMAIL";
    public static final String KISI_COL_TELEFON="TELEFON";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE "+KISI_TABLO+" ("
        + KISI_COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+KISI_COL_AD +" TEXT,"
        + KISI_COL_SOYAD +" TEXT," +KISI_COL_EMAIL+" TEXT,"+KISI_COL_TELEFON+" TEXT)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

       // sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ KISI_TABLO);
       // onCreate(sqLiteDatabase);

    }






}

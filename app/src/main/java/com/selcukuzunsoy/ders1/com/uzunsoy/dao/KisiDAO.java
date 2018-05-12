package com.selcukuzunsoy.ders1.com.uzunsoy.dao;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.util.Log;

import com.selcukuzunsoy.ders1.com.uzunsoy.db.DBHelper;
import com.selcukuzunsoy.ders1.com.uzunsoy.modal.Kisi;
import com.selcukuzunsoy.ders1.com.uzunsoy.tools.AndroTool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class KisiDAO implements BaseDao<Kisi> {
    SQLiteDatabase db = null;


    public KisiDAO() {


    }

    @Override
    public boolean create(Kisi nesne) {
        db = new DBHelper(AndroTool.getApp().getApplicationContext()).getWritableDatabase();

        try {
            ContentValues kisiBilgisi = new ContentValues();
            kisiBilgisi.put(DBHelper.KISI_COL_AD, nesne.getAD());
            kisiBilgisi.put(DBHelper.KISI_COL_SOYAD, nesne.getSOYAD());
            kisiBilgisi.put(DBHelper.KISI_COL_EMAIL, nesne.getEMAIL());
            kisiBilgisi.put(DBHelper.KISI_COL_TELEFON, nesne.getTELEFON());

            db.insert(DBHelper.KISI_TABLO, null, kisiBilgisi);
            return true;
        } catch (Exception e) {
            Log.e("TelefonRehberi", e.getMessage());
        }
        return false;
    }

    @Override
    public Kisi read(int id) {
        db = new DBHelper(AndroTool.getApp().getApplicationContext()).getReadableDatabase();

        Cursor cur = db.rawQuery("SELECT * FROM " + DBHelper.KISI_TABLO
                + " WHERE " + DBHelper.KISI_COL_ID + " = " + id, null);
        Kisi kisi = new Kisi();
        kisi.setID(cur.getInt(0));
        kisi.setAD(cur.getString(1));
        kisi.setSOYAD(cur.getString(2));
        kisi.setEMAIL(cur.getString(3));
        kisi.setTELEFON(cur.getString(4));
        return kisi;
    }

    public Kisi read(String telefon) {
        db = new DBHelper(AndroTool.getApp().getApplicationContext()).getReadableDatabase();

        Cursor cur = db.rawQuery("SELECT * FROM " + DBHelper.KISI_TABLO
                + " WHERE " + DBHelper.KISI_COL_TELEFON + " LIKE '" + telefon + "%' ", null);
        Kisi kisi = new Kisi();
        kisi.setID(cur.getInt(0));
        kisi.setAD(cur.getString(1));
        kisi.setSOYAD(cur.getString(2));
        kisi.setEMAIL(cur.getString(3));
        kisi.setTELEFON(cur.getString(4));
        return kisi;
    }

    public int kisiSay() {
        db = new DBHelper(AndroTool.getApp().getApplicationContext()).getReadableDatabase();

        int kayitSayisi = (int) DatabaseUtils.queryNumEntries(db, DBHelper.KISI_TABLO);
        return kayitSayisi;
    }


    @Override
    public boolean update(Kisi nesne) {
        db = new DBHelper(AndroTool.getApp().getApplicationContext()).getWritableDatabase();

        try {
            ContentValues kisi_bilgisi = new ContentValues();
            kisi_bilgisi.put(DBHelper.KISI_COL_AD, nesne.getAD());
            kisi_bilgisi.put(DBHelper.KISI_COL_SOYAD, nesne.getSOYAD());
            kisi_bilgisi.put(DBHelper.KISI_COL_EMAIL, nesne.getEMAIL());
            kisi_bilgisi.put(DBHelper.KISI_COL_TELEFON, nesne.getTELEFON());
            db.update(DBHelper.KISI_TABLO, kisi_bilgisi, " ID = ? ", new String[]{Integer.toString(nesne.getID())});
            return true;
        } catch (Exception e) {
            Log.e("TelefonRehberi", e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        db = new DBHelper(AndroTool.getApp().getApplicationContext()).getWritableDatabase();

        try {
            db.delete(DBHelper.KISI_TABLO, " ID=? ", new String[]{"" + id});
            return true;
        } catch (Exception e) {
            Log.e("TelefonRehberi", e.getMessage());
        }
        return false;
    }

    public List<Kisi> readAll(Integer count, Integer start){
        db = new DBHelper(AndroTool.getApp().getApplicationContext()).getReadableDatabase();

        List<Kisi> tumKisiler = new ArrayList<>();
        Cursor datalar = db.rawQuery("SELECT * FROM "+ DBHelper.KISI_TABLO +" ORDER BY ID LIMIT "+count+","+start,null);
        datalar.moveToFirst();
        while(datalar.isAfterLast()){

            Integer ID = datalar.getInt(datalar.getColumnIndex(DBHelper.KISI_COL_ID));
            String  AD = datalar.getString(datalar.getColumnIndex(DBHelper.KISI_COL_AD));
            String  SOYAD = datalar.getString(datalar.getColumnIndex(DBHelper.KISI_COL_SOYAD));
            String  EMAIL = datalar.getString(datalar.getColumnIndex(DBHelper.KISI_COL_EMAIL));
            String  TELEFON = datalar.getString(datalar.getColumnIndex(DBHelper.KISI_COL_TELEFON));

            Kisi kisi = new Kisi();
            kisi.setID(ID);
            kisi.setAD(AD);
            kisi.setSOYAD(SOYAD);
            kisi.setEMAIL(EMAIL);
            kisi.setTELEFON(TELEFON);

            tumKisiler.add(kisi);
            datalar.moveToNext();
        }

        return null;
    }



}
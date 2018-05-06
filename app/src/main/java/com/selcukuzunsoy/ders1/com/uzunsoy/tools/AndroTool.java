package com.selcukuzunsoy.ders1.com.uzunsoy.tools;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Android uygulama içinde
 * kullanılacak araçlar burada bulunur.
 *
 */
public class AndroTool {

    public boolean emailYolla(){

        Log.i("BilgeAdamInfo","Email Yollandı");
        return true;
    }


    public boolean smsAt(){

        Log.i("BilgeAdamInfo","Sms Yollandı");
        return true;
    }

    public static void mesajVer(Context context,String mesaj){

        //Ekranın alt kısmında bildirim şeklinde baloncuk çıkmasını
        //sağlayan komuttur.
        Toast.makeText(context,mesaj,Toast.LENGTH_LONG).show();


    }





}

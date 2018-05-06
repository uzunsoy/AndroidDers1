package com.selcukuzunsoy.ders1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.selcukuzunsoy.ders1.com.uzunsoy.modal.Kisi;
import com.selcukuzunsoy.ders1.com.uzunsoy.tools.AndroTool;
import com.selcukuzunsoy.ders1.com.uzunsoy.tools.Ornek;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.i("BilgeAdamInfo", "OnCreate Çalıştı");
        Log.e("BilgeAdamError", "OnCreate Çalıştı");

        try {

            new AndroTool().emailYolla();
            new AndroTool().smsAt();

            Log.i("BilgeAdamInfo", "Try Bloğu" + this.getClass().getName());
        } catch (Exception e) {
            Log.e("BilgeAdamError", "Catch Bloğu");
        } finally {
            Log.w("BilgeAdamWarning", "Finally Bloğu");
        }


    }

    public void KisiKaydet(View view) {

        final String ad = ((EditText) findViewById(R.id.txtAd)).getText().toString();
        final String soyad = ((EditText) findViewById(R.id.txtSoyad)).getText().toString();
        final String telefon = ((EditText) findViewById(R.id.txtTelefon)).getText().toString();
        final String email = ((EditText) findViewById(R.id.txtEmail)).getText().toString();

        final Kisi kisi = new Kisi();
        kisi.setAD(ad);
        kisi.setSOYAD(soyad);
        kisi.setEMAIL(email);
        kisi.setTELEFON(telefon);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
       builder.setMessage("Kayıt ediyorum, emin misin?")
               .setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       //AndroTool.mesajVer(getApplicationContext(),"Kişi Kayıt Edildi");
                       Intent kisiListele = new Intent(getApplicationContext(),KisiListele.class);
                       kisiListele.putExtra("ad",ad);
                       kisiListele.putExtra("soyad",soyad);
                       kisiListele.putExtra("telefon",telefon);
                       kisiListele.putExtra("email",email);
                       startActivity(kisiListele);
                   }
               })
               .setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       AndroTool.mesajVer(getApplicationContext(),"İptal Edildi");

                   }
               }).create();
       builder.show();

       //Dialog açmak için kullanılıyor
       AlertDialog.Builder customAlert = new AlertDialog.Builder(this);

       //Layout çekmek için kullanılıyor
       LayoutInflater inflater = this.getLayoutInflater();

       //Layouth u görsele ayarlamak için kullanılıyor.
       customAlert.setView(inflater.inflate(R.layout.ozellesmis_popup,null))
               .setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       AndroTool.mesajVer(getApplicationContext(),"Kişi Kayıt Edildi");
                   }
               })
                .setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AndroTool.mesajVer(getApplicationContext(),"İptal Edildi");
                    }
                }).create();

        customAlert.show();




       Log.i("BilgeAdamInfo", "Bilgi:" + kisi);
    }


    public void smsGonder(View v) {

        new AndroTool().smsAt();

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("BilgeAdam", "OnStart Çalıştı");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("BilgeAdam", "OnStop Çalıştı");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("BilgeAdam", "OnDestroy Çalıştı");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("BilgeAdam", "OnResume Çalıştı");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("BilgeAdam", "OnPause Çalıştı");
    }
}

package com.selcukuzunsoy.ders1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.selcukuzunsoy.ders1.com.uzunsoy.dao.KisiDAO;
import com.selcukuzunsoy.ders1.com.uzunsoy.modal.Kisi;
import com.selcukuzunsoy.ders1.com.uzunsoy.modal.LoginState;
import com.selcukuzunsoy.ders1.com.uzunsoy.tools.AndroTool;

public class KisiDuzenle extends AppCompatActivity {

    private static Integer secilenKullanici = 0;
    private static Kisi secilenKisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisi_duzenle);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //TODO: Kişinin id bilgisini buraya al
        //TODO: İd bilgisine göre bilgileri çek ve ekranda göster.

        final String id = getIntent().getExtras().getString("kisiid");
        Integer idInt = Integer.parseInt(id);
        secilenKullanici= idInt;
        Kisi kisi = new KisiDAO(this.getApplicationContext()).read(idInt);
        if(kisi!=null) {
            secilenKisi = kisi;
            EditText ad = (EditText) findViewById(R.id.txtAdEdit);
            ad.setText(kisi.getAD());
            EditText soyad = (EditText) findViewById(R.id.txtSoyadEdit);
            soyad.setText(kisi.getSOYAD());
            EditText tel = (EditText) findViewById(R.id.txtTelefonEdit);
            tel.setText(kisi.getTELEFON());
            EditText email = (EditText) findViewById(R.id.txtEmailEdit);
            email.setText(kisi.getEMAIL());
        }



    }

    public void KisiGuncelle(View view){

        EditText ad = (EditText) findViewById(R.id.txtAdEdit);
        secilenKisi.setAD(ad.getText().toString());
        EditText soyad = (EditText) findViewById(R.id.txtSoyadEdit);
        secilenKisi.setSOYAD(soyad.getText().toString());
        EditText tel = (EditText) findViewById(R.id.txtTelefonEdit);
        secilenKisi.setTELEFON(tel.getText().toString());
        EditText email = (EditText) findViewById(R.id.txtEmailEdit);
        secilenKisi.setEMAIL(email.getText().toString());
        if(new KisiDAO(this).update(secilenKisi)){
            AndroTool.mesajVer(this,"Güncelleme Başarılı");
            finish();
        }else{
            AndroTool.mesajVer(this,"Güncelleme Yaplamadı");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(LoginState.timeisup()){
            finish();
            Intent login = new Intent(this, AnaLoginEkrani.class);
            startActivity(login);
        }
        Log.i("BilgeAdam", "OnResume Çalıştı");
    }

}

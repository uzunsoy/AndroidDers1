package com.selcukuzunsoy.ders1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.selcukuzunsoy.ders1.com.uzunsoy.adapters.KisiCustomAdapter;
import com.selcukuzunsoy.ders1.com.uzunsoy.adapters.KisiItem;
import com.selcukuzunsoy.ders1.com.uzunsoy.dao.KisiDAO;
import com.selcukuzunsoy.ders1.com.uzunsoy.modal.Kisi;
import com.selcukuzunsoy.ders1.com.uzunsoy.modal.LoginState;

import java.util.ArrayList;
import java.util.List;

public class KisiListele extends AppCompatActivity {

    ListView LVTumListe;

    ArrayList<KisiItem> listem = new ArrayList<KisiItem>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisi_listele);

        List<Kisi> veriler = new KisiDAO(this).readAll(0,100);
        verileriSetEt(veriler);
        LVTumListe = (ListView) findViewById(R.id.listKisiListesi);
        LVTumListe.setAdapter(new KisiCustomAdapter(listem,this));

    }

    private void verileriSetEt(List<Kisi> veriler){
        listem = new ArrayList<KisiItem>();
        for(Kisi data: veriler){
            KisiItem Ki = new KisiItem();
            Ki.setAD(data.getAD()+" "+data.getSOYAD());
            Ki.setTELEFON(data.getTELEFON());
            Ki.setID(data.getID());
            listem.add(Ki);
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

        List<Kisi> veriler = new KisiDAO(this).readAll(0,100);
        verileriSetEt(veriler);
        LVTumListe = (ListView) findViewById(R.id.listKisiListesi);
        LVTumListe.setAdapter(new KisiCustomAdapter(listem,this));
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

}

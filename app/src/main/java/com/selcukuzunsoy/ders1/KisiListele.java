package com.selcukuzunsoy.ders1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class KisiListele extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisi_listele);




    }
    @Override
    protected void onStart() {
        super.onStart();

        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){

            String ad = bundle.getString("ad");
            String soyad = bundle.getString("soyad");
            String email = bundle.getString("email");
            String telefon = bundle.getString("telefon");

            ((EditText)findViewById(R.id.txtAd)).setText(ad);
            ((EditText)findViewById(R.id.txtSoyad)).setText(soyad);
            ((EditText)findViewById(R.id.txtEmail)).setText(email);
            ((EditText)findViewById(R.id.txtTelefon)).setText(telefon);

            Log.i("Bilgiler","Bilgiler:"+ad +" "+soyad+" "+email+" "+telefon);

        }


    }
}

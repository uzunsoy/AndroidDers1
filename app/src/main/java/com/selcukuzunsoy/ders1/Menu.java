package com.selcukuzunsoy.ders1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.selcukuzunsoy.ders1.com.uzunsoy.modal.LoginState;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    public void yeniKisiEkrani(View view) {

        Intent ekran = new Intent(getApplicationContext(), Home.class);
        startActivity(ekran);

    }

    public void kisileriListele(View view){

        Intent ekran = new Intent(getApplicationContext(), KisiListele.class);
        startActivity(ekran);

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

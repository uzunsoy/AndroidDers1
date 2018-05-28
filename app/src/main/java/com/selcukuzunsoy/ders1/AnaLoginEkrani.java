package com.selcukuzunsoy.ders1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.selcukuzunsoy.ders1.com.uzunsoy.modal.LoginState;
import com.selcukuzunsoy.ders1.com.uzunsoy.tools.AndroTool;

import java.util.Date;

public class AnaLoginEkrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_login_ekrani);
    }

    public void giris(View view){

        String kadi =  ((EditText)findViewById(R.id.txtKadi)).getText().toString();

        String sifre =  ((EditText)findViewById(R.id.txtSifre)).getText().toString();

        if(kadi != null && sifre != null){
            if(kadi.equals("admin") && sifre.equals("123456")){

             //TODO: Ana ekranı çağır
                LoginState.loginTime = new Date().getTime();
                LoginState.geriSayim();
                Intent ekran = new Intent(getApplicationContext(),Menu.class);
                startActivity(ekran);


            }else{
                AndroTool.mesajVer(this,"Bilgiler Hatalı !");
            }

        }else{
            AndroTool.mesajVer(this,"Lütfen Bilgileri Doldurunuz !");
        }
    }
}

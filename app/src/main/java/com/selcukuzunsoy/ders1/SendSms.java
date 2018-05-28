package com.selcukuzunsoy.ders1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.selcukuzunsoy.ders1.com.uzunsoy.tools.AndroTool;

public class SendSms extends AppCompatActivity {

    Button gonderButonu;
    EditText txtTelefon;
    EditText txtMesaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        gonderButonu = (Button) findViewById(R.id.btnSmsGonder);
        txtTelefon   = (EditText) findViewById(R.id.txtTelefonNumarasi);
        txtMesaj     = (EditText) findViewById(R.id.txtMesaj);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String tel = getIntent().getExtras().get("tel").toString();
        txtTelefon.setText(tel);
    }

    public void sendSms(View view){

        final String tel = txtTelefon.getText().toString();
        final String mesaj = txtMesaj.getText().toString();
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(tel,null,mesaj,null,null);

            AndroTool.mesajVer(getApplicationContext(),"Mesaj Gönderildi !");
        }catch (Exception e){
            AndroTool.mesajVer(getApplicationContext(),"Mesaj Gönderilemedi !");
            Log.e("MesajHatalari",e.getMessage());
        }

/*
        DialogInterface.OnClickListener dia = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int secilenButon) {

                switch (secilenButon){
                    case DialogInterface.BUTTON_POSITIVE:
                        try {
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage(tel,null,mesaj,null,null);
                            //Intent sendItem = new Intent(Intent.ACTION_VIEW);
                            //sendItem.putExtra("sms_body",mesaj);
                            //sendItem.setType("vdn.android-dir/mms-sms");
                            //startActivity(sendItem);

                            AndroTool.mesajVer(getApplicationContext(),"Mesaj Gönderildi !");
                        }catch (Exception e){
                            AndroTool.mesajVer(getApplicationContext(),"Mesaj Gönderilemedi !");
                            Log.e("MesajHatalari",e.getMessage());
                        }


                    break;
                    case DialogInterface.BUTTON_NEGATIVE:

                    break;
                }
            }
        };

        AlertDialog.Builder build = new AlertDialog.Builder(getApplicationContext());
        build.setMessage("Sms gönderilecek ! Emin misiniz ?"+ txtTelefon.getText())
                .setPositiveButton("Evet",dia)
                .setNegativeButton("Hayır",dia)
                .show();
*/

    }


}

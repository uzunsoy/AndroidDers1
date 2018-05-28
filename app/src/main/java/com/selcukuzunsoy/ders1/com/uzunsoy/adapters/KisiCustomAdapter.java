package com.selcukuzunsoy.ders1.com.uzunsoy.adapters;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.selcukuzunsoy.ders1.KisiDuzenle;
import com.selcukuzunsoy.ders1.R;
import com.selcukuzunsoy.ders1.SendSms;

import java.util.ArrayList;

public class KisiCustomAdapter extends BaseAdapter {

    //Tüm rehber listesi burada olacak
    ArrayList<KisiItem> listem = new ArrayList<>();

    //Herhangi bir activity den bu listeyi çağırmak için kullanıyorum.
    LayoutInflater layinf;

    static Context context;

    public KisiCustomAdapter(ArrayList<KisiItem> listem, Context contextIn) {
        this.listem = listem;
        context = contextIn;
        this.layinf = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listem.size();
    }

    @Override
    public Object getItem(int pozisyon) {
        return listem.get(pozisyon);
    }

    @Override
    public long getItemId(int pozisyon) {
        return listem.get(pozisyon).getID();
    }

    @Override
    public View getView(final int listeninIndexi, View view, ViewGroup viewGroup) {

       final KisiTutucuSinif viewHolderCustom;

       if(view == null){
          view = layinf.inflate(R.layout.list_item_kisi, null);
           viewHolderCustom = new KisiTutucuSinif();
            view.setTag(viewHolderCustom);
       }else{
            viewHolderCustom = (KisiTutucuSinif) view.getTag();
       }

        viewHolderCustom.kisiId = (TextView) view.findViewById(R.id.ptGenisYazi);
        viewHolderCustom.ad     = (TextView) view.findViewById(R.id.ptIsim);
        viewHolderCustom.tel    = (TextView) view.findViewById(R.id.ptTelefon);
        viewHolderCustom.kisiDuzenle = (ImageView) view.findViewById(R.id.btnDuzenle);
        viewHolderCustom.kisiAra = (ImageView) view.findViewById(R.id.btnAra);
        viewHolderCustom.kisiSms = (ImageView) view.findViewById(R.id.btnSms);

        viewHolderCustom.kisiDuzenle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Düzenleme Ekranı Açılacak - DONE

                Intent duzenleEkrani = new Intent(getContext(), KisiDuzenle.class);
                duzenleEkrani.putExtra("kisiid",listem.get(listeninIndexi).getID().toString());
                getContext().startActivity(duzenleEkrani);

            }
        });

        viewHolderCustom.kisiAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Seçilen Kişiyi Ara- DONE
                DialogInterface.OnClickListener dialogClickLis = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int hangiButon) {

                        switch (hangiButon){

                            case DialogInterface.BUTTON_POSITIVE:
                                Intent kisiAra = new Intent(Intent.ACTION_CALL);
                                kisiAra.setData(Uri.parse("tel:"+viewHolderCustom.tel.getText()));

                                if(ActivityCompat.checkSelfPermission(KisiCustomAdapter.context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    return;
                                }
                                getContext().startActivity(kisiAra);
                            break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                //TODO: NOTHING

                            break;

                        }





                    }
                };


                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Aramak istediğinizden eminmisiniz ! Tel:"+viewHolderCustom.tel.getText())
                        .setPositiveButton("Evet", dialogClickLis)
                        .setNegativeButton("Hayır", dialogClickLis)
                        .show();







            }
        });

        viewHolderCustom.kisiSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Seçilen Kişiye Sms atma ekranını aç

                Intent sendSms = new Intent(getContext(), SendSms.class);
                sendSms.putExtra("tel",viewHolderCustom.tel.getText().toString());
                getContext().startActivity(sendSms);

            }
        });

        viewHolderCustom.ad.setText(listem.get(listeninIndexi).getAD());
        viewHolderCustom.tel.setText(listem.get(listeninIndexi).getTELEFON());
        viewHolderCustom.kisiId.setText(listem.get(listeninIndexi).getID()+"");

        return view;
    }


    public ArrayList<KisiItem> getListem() {
        return listem;
    }

    public void setListem(ArrayList<KisiItem> listem) {
        this.listem = listem;
    }

    public LayoutInflater getLayinf() {
        return layinf;
    }

    public void setLayinf(LayoutInflater layinf) {
        this.layinf = layinf;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        KisiCustomAdapter.context = context;
    }

    private static class KisiTutucuSinif{
        TextView ad;
        TextView tel;
        TextView kisiId;
        ImageView kisiDuzenle;
        ImageView kisiAra;
        ImageView kisiSms;
    }


}

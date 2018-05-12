package com.selcukuzunsoy.ders1.com.uzunsoy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.selcukuzunsoy.ders1.R;

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
    public View getView(int listeninIndexi, View view, ViewGroup viewGroup) {

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
        viewHolderCustom.kisiDuzenle = (Button) view.findViewById(R.id.btnDuzenle);
        viewHolderCustom.kisiAra = (Button) view.findViewById(R.id.btnAra);
        viewHolderCustom.kisiSms = (Button) view.findViewById(R.id.btnSms);

        viewHolderCustom.kisiDuzenle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Düzenleme Ekranı Açılacak
            }
        });

        viewHolderCustom.kisiAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Seçilen Kişiyi Ara
            }
        });

        viewHolderCustom.kisiSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Seçilen Kişiye Sms atma ekranını aç
            }
        });

        viewHolderCustom.ad.setText(listem.get(listeninIndexi).getAD()
                +" "+listem.get(listeninIndexi).getSOYAD());
        viewHolderCustom.tel.setText(listem.get(listeninIndexi).getTELEFON());
        //viewHolderCustom.kisiId.setText(listem.get(listeninIndexi).getID());

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
        Button kisiDuzenle;
        Button kisiAra;
        Button kisiSms;
    }


}

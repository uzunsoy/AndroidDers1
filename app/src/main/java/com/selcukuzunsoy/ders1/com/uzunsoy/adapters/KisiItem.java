package com.selcukuzunsoy.ders1.com.uzunsoy.adapters;

import android.widget.Button;

public class KisiItem {

    private Integer ID;
    private String AD;
    private String SOYAD;
    private String TELEFON;

    private Button kisiDuzenleButonu;
    private Button kisiAraButonu;
    private Button kisiSmsAtButonu;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAD() {
        return AD;
    }

    public void setAD(String AD) {
        this.AD = AD;
    }

    public String getSOYAD() {
        return SOYAD;
    }

    public void setSOYAD(String SOYAD) {
        this.SOYAD = SOYAD;
    }

    public String getTELEFON() {
        return TELEFON;
    }

    public void setTELEFON(String TELEFON) {
        this.TELEFON = TELEFON;
    }

    public Button getKisiDuzenleButonu() {
        return kisiDuzenleButonu;
    }

    public void setKisiDuzenleButonu(Button kisiDuzenleButonu) {
        this.kisiDuzenleButonu = kisiDuzenleButonu;
    }

    public Button getKisiAraButonu() {
        return kisiAraButonu;
    }

    public void setKisiAraButonu(Button kisiAraButonu) {
        this.kisiAraButonu = kisiAraButonu;
    }

    public Button getKisiSmsAtButonu() {
        return kisiSmsAtButonu;
    }

    public void setKisiSmsAtButonu(Button kisiSmsAtButonu) {
        this.kisiSmsAtButonu = kisiSmsAtButonu;
    }
}

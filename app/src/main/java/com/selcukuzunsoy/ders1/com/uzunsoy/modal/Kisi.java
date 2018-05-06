package com.selcukuzunsoy.ders1.com.uzunsoy.modal;

import java.io.Serializable;

/**
 * Telefon rehberi kişisi
 */
public class Kisi implements Serializable {

    private String AD;
    private String SOYAD;
    private String TELEFON;
    private String EMAIL;

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

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    @Override
    public String toString() {
        return "Kisi{" +
                "AD='" + AD + '\'' +
                ", SOYAD='" + SOYAD + '\'' +
                ", TELEFON='" + TELEFON + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                '}';
    }
}

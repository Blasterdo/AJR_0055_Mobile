package com.yohanesweisang.ajr_mobile_0055.models;

import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class Promo {
    @SerializedName("ID_PROMO")
    private Long id_promo;

    @SerializedName("KODE_PROMO")
    private String kode_promo;

    @SerializedName("JENIS")
    private String jenis;

    @SerializedName("KETERANGAN")
    private String keterangan;

    @SerializedName("DISKON")
    private float diskon;

    @SerializedName("STATUS_PROMO")
    private String status_promo;

    public Promo(String kode_promo, String jenis, String keterangan, float diskon, String status_promo) {
        this.kode_promo = kode_promo;
        this.jenis = jenis;
        this.keterangan = keterangan;
        this.diskon = diskon;
        this.status_promo = status_promo;
    }

    public Long getId_promo() {
        return id_promo;
    }

    public void setId_promo(Long id_promo) {
        this.id_promo = id_promo;
    }

    public String getKode_promo() {
        return kode_promo;
    }

    public void setKode_promo(String kode_promo) {
        this.kode_promo = kode_promo;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public float getDiskon() {
        return diskon;
    }

    public void setDiskon(float diskon) {
        this.diskon= diskon;
    }

    public String getStatus_promo() {
        return status_promo;
    }

    public void setStatus_promo(String status_promo) {
        this.status_promo = status_promo;
    }
}

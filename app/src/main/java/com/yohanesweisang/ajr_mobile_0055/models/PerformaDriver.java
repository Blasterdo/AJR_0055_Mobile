package com.yohanesweisang.ajr_mobile_0055.models;

public class PerformaDriver {
    private String id_driver;
    private String nama_driver;
    private int jumlah_transaksi;
    private float rerata_rating_driver;

    public PerformaDriver(String id_driver, String nama_driver, int jumlah_transaksi, float rerata_rating_driver) {
        this.id_driver = id_driver;
        this.nama_driver = nama_driver;
        this.jumlah_transaksi = jumlah_transaksi;
        this.rerata_rating_driver = rerata_rating_driver;
    }

    public String getId_driver() {
        return id_driver;
    }

    public void setId_driver(String id_driver) {
        this.id_driver = id_driver;
    }

    public String getNama_driver() {
        return nama_driver;
    }

    public void setNama_driver(String nama_driver) {
        this.nama_driver = nama_driver;
    }

    public int getJumlah_transaksi() {
        return jumlah_transaksi;
    }

    public void setJumlah_transaksi(int jumlah_transaksi) {
        this.jumlah_transaksi = jumlah_transaksi;
    }

    public float getRerata_rating_driver() {
        return rerata_rating_driver;
    }

    public void setRerata_rating_driver(float rerata_rating_driver) {
        this.rerata_rating_driver = rerata_rating_driver;
    }
}

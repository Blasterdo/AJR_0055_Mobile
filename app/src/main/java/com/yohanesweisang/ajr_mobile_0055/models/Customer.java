package com.yohanesweisang.ajr_mobile_0055.models;

public class Customer {
    private String nama;
    private int jumlah_transaksi;

    public Customer(String nama, int jumlah_transaksi) {
        this.nama = nama;
        this.jumlah_transaksi = jumlah_transaksi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlah_transaksi() {
        return jumlah_transaksi;
    }

    public void setJumlah_transaksi(int jumlah_transaksi) {
        this.jumlah_transaksi = jumlah_transaksi;
    }
}

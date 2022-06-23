package com.yohanesweisang.ajr_mobile_0055.models;

public class Pendapatan {
    private String nama;
    private String nama_mobil;
    private String jenis_transaksi;
    private int jumlah_transaksi;
    private int pendapatan;

    public Pendapatan(String nama, String nama_mobil, String jenis_transaksi, int jumlah_transaksi, int pendapatan) {
        this.nama = nama;
        this.nama_mobil = nama_mobil;
        this.jenis_transaksi = jenis_transaksi;
        this.jumlah_transaksi = jumlah_transaksi;
        this.pendapatan = pendapatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama_mobil() {
        return nama_mobil;
    }

    public void setNama_mobil(String nama_mobil) {
        this.nama_mobil = nama_mobil;
    }

    public String getJenis_transaksi() {
        return jenis_transaksi;
    }

    public void setJenis_transaksi(String jenis_transaksi) {
        this.jenis_transaksi = jenis_transaksi;
    }

    public int getJumlah_transaksi() {
        return jumlah_transaksi;
    }

    public void setJumlah_transaksi(int jumlah_transaksi) {
        this.jumlah_transaksi = jumlah_transaksi;
    }

    public int getPendapatan() {
        return pendapatan;
    }

    public void setPendapatan(int pendapatan) {
        this.pendapatan = pendapatan;
    }
}

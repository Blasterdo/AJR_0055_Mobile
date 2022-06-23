package com.yohanesweisang.ajr_mobile_0055.models;

public class Brosur {
    private Long id_mobil;
    private String nama_mobil;
    private String tipe_mobil;
    private String jenis_transmisi;
    private String jenis_bahan_bakar;
    private String warna;
    private String volume_bagasi;
    private String fasilitas;
    private float harga_sewa;

    public Brosur(String nama_mobil, String tipe_mobil, String jenis_transmisi, String jenis_bahan_bakar, String warna, String volume_bagasi, String fasilitas, float harga_sewa) {
        this.nama_mobil = nama_mobil;
        this.tipe_mobil = tipe_mobil;
        this.jenis_transmisi = jenis_transmisi;
        this.jenis_bahan_bakar = jenis_bahan_bakar;
        this.warna = warna;
        this.volume_bagasi = volume_bagasi;
        this.fasilitas = fasilitas;
        this.harga_sewa = harga_sewa;
    }

    public Long getId_mobil() {
        return id_mobil;
    }

    public void setId_mobil(Long id_mobil) {
        this.id_mobil = id_mobil;
    }

    public String getNama_mobil() {
        return nama_mobil;
    }

    public void setNama_mobil(String nama_mobil) {
        this.nama_mobil = nama_mobil;
    }

    public String getTipe_mobil() {
        return tipe_mobil;
    }

    public void setTipe_mobil(String tipe_mobil) {
        this.tipe_mobil = tipe_mobil;
    }

    public String getJenis_transmisi() {
        return jenis_transmisi;
    }

    public void setJenis_transmisi(String jenis_transmisi) {
        this.jenis_transmisi = jenis_transmisi;
    }

    public String getJenis_bahan_bakar() {
        return jenis_bahan_bakar;
    }

    public void setJenis_bahan_bakar(String jenis_bahan_bakar) {
        this.jenis_bahan_bakar = jenis_bahan_bakar;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getVolume_bagasi() {
        return volume_bagasi;
    }

    public void setVolume_bagasi(String volume_bagasi) {
        this.volume_bagasi = volume_bagasi;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public float getHarga_sewa() {
        return harga_sewa;
    }

    public void setHarga_sewa(float harga_sewa) {
        this.harga_sewa = harga_sewa;
    }
}

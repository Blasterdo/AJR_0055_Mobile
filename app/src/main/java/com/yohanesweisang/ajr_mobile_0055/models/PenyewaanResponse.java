package com.yohanesweisang.ajr_mobile_0055.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PenyewaanResponse {
    private String message;

    @SerializedName("laporan")
    private List<Penyewaan> penyewaanList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Penyewaan> getPenyewaanList() {
        return penyewaanList;
    }

    public void setPenyewaanList(List<Penyewaan> penyewaanList) {
        this.penyewaanList = penyewaanList;
    }
}

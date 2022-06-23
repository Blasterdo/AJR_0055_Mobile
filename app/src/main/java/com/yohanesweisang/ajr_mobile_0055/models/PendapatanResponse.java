package com.yohanesweisang.ajr_mobile_0055.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PendapatanResponse {
    private String message;

    @SerializedName("laporan")
    private List<Pendapatan> pendapatanList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Pendapatan> getPendapatanList() {
        return pendapatanList;
    }

    public void setPendapatanList(List<Pendapatan> pendapatanList) {
        this.pendapatanList = pendapatanList;
    }
}

package com.yohanesweisang.ajr_mobile_0055.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BrosurResponse {
    private String message;

    @SerializedName("brosur")
    private List<Brosur> brosurList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Brosur> getBrosurList() {
        return brosurList;
    }

    public void setBrosurList(List<Brosur> brosurList) {
        this.brosurList = brosurList;
    }
}

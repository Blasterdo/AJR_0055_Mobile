package com.yohanesweisang.ajr_mobile_0055.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PerformaDriverResponse {
    private String message;

    @SerializedName("laporan")
    private List<PerformaDriver> performaDriverList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PerformaDriver> getPerformaDriverList() {
        return performaDriverList;
    }

    public void setPerformaDriverList(List<PerformaDriver> performaDriverList) {
        this.performaDriverList = performaDriverList;
    }
}

package com.yohanesweisang.ajr_mobile_0055.api;

public class AJR_API {
    public static final String BASE_URL = "http://192.168.1.65:8000/api/";

    //login
    public static final String LOGIN_URL = BASE_URL + "login";

    //promo
    public static final String GET_ALL_PROMO_URL = BASE_URL + "promo";

    //brosur
    public static final String GET_ALL_BROSUR_URL = BASE_URL + "brosur";

    //pdf
    public static final String PDF_Penyewaan_URL = BASE_URL + "pdfPenyewaan/";
    public static final String PDF_Detail_Pendapatan_URL = BASE_URL + "pdfDetailPendapatan/";
    public static final String PDF_Driver_Perbulan_URL = BASE_URL + "pdfDriverPerbulan/";
    public static final String PDF_Performa_Driver_URL = BASE_URL + "pdfPerformaDriver/";
    public static final String PDF_Customer_URL = BASE_URL + "pdfCustomer/";

//    public static final String GET_ALL_URL = BASE_URL + "produk";
//    public static final String GET_BY_ID_URL = BASE_URL + "produk/";
//    public static final String ADD_URL = BASE_URL + "produk";
//    public static final String UPDATE_URL = BASE_URL + "produk/";
//    public static final String DELETE_URL = BASE_URL + "produk/";
}

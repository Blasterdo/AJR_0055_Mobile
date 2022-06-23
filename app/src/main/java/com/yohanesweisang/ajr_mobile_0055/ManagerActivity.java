package com.yohanesweisang.ajr_mobile_0055;

import static com.android.volley.Request.Method.GET;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.yohanesweisang.ajr_mobile_0055.api.AJR_API;
import com.yohanesweisang.ajr_mobile_0055.models.Customer;
import com.yohanesweisang.ajr_mobile_0055.models.CustomerResponse;
import com.yohanesweisang.ajr_mobile_0055.models.Driver;
import com.yohanesweisang.ajr_mobile_0055.models.DriverResponse;
import com.yohanesweisang.ajr_mobile_0055.models.Pendapatan;
import com.yohanesweisang.ajr_mobile_0055.models.PendapatanResponse;
import com.yohanesweisang.ajr_mobile_0055.models.Penyewaan;
import com.yohanesweisang.ajr_mobile_0055.models.PenyewaanResponse;
import com.yohanesweisang.ajr_mobile_0055.models.PerformaDriver;
import com.yohanesweisang.ajr_mobile_0055.models.PerformaDriverResponse;


import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ManagerActivity extends AppCompatActivity {
    private EditText et_bulan,et_tahun;
    private Button btnLaporanSewa,btn_Pendapatan,btnDriver,btnPerforma,btnCustomer;
    private RequestQueue queue;
    private MaterialButton materialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        queue = Volley.newRequestQueue(this);
        et_bulan = findViewById(R.id.et_bulan);
        et_tahun = findViewById(R.id.et_tahun);
        btnLaporanSewa = findViewById(R.id.btnLaporanSewa);
        btn_Pendapatan = findViewById(R.id.btnPendapatan);
        btnDriver = findViewById(R.id.btnDriver);
        btnPerforma = findViewById(R.id.btnPerforma);
        btnCustomer = findViewById(R.id.btnCustomer);
        materialButton = findViewById(R.id.btnLogOut);

        btnLaporanSewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int month,year;

                month = Integer.parseInt(et_bulan.getText().toString());
                year = Integer.parseInt(et_tahun.getText().toString());

                if((month>0 && month<13) && (year>2000 && year<2025)){
                    getLaporanPenyewaan(month,year);
                }else{
                    if(!(month>0 && month<13)){
                        et_bulan.setError("Bulan Tidak Valid!");
                    }
                    if(!(year>2000 && year<2025)){
                        et_tahun.setError("Mohon masukkan Tahun dalam jangkauan 2000-2025");
                    }
                }
            }
        });

        btn_Pendapatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int month,year;

                month = Integer.parseInt(et_bulan.getText().toString());
                year = Integer.parseInt(et_tahun.getText().toString());

                if((month>0 && month<13) && (year>2000 && year<2025)){
                    getLaporanPendapatan(month,year);
                }else{
                    if(!(month>0 && month<13)){
                        et_bulan.setError("Bulan Tidak Valid!");
                    }
                    if(!(year>2000 && year<2025)){
                        et_tahun.setError("Mohon masukkan Tahun dalam jangkauan 2000-2025");
                    }
                }
            }
        });

        btnDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int month,year;

                month = Integer.parseInt(et_bulan.getText().toString());
                year = Integer.parseInt(et_tahun.getText().toString());

                if((month>0 && month<13) && (year>2000 && year<2025)){
                    getLaporanDriver(month,year);
                }else{
                    if(!(month>0 && month<13)){
                        et_bulan.setError("Bulan Tidak Valid!");
                    }
                    if(!(year>2000 && year<2025)){
                        et_tahun.setError("Mohon masukkan Tahun dalam jangkauan 2000-2025");
                    }
                }
            }
        });

        btnPerforma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int month,year;

                month = Integer.parseInt(et_bulan.getText().toString());
                year = Integer.parseInt(et_tahun.getText().toString());

                if((month>0 && month<13) && (year>2000 && year<2025)){
                    getLaporanPerforma(month,year);
                }else{
                    if(!(month>0 && month<13)){
                        et_bulan.setError("Bulan Tidak Valid!");
                    }
                    if(!(year>2000 && year<2025)){
                        et_tahun.setError("Mohon masukkan Tahun dalam jangkauan 2000-2025");
                    }
                }
            }
        });

        btnCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int month,year;

                month = Integer.parseInt(et_bulan.getText().toString());
                year = Integer.parseInt(et_tahun.getText().toString());

                if((month>0 && month<13) && (year>2000 && year<2025)){
                    getLaporanCustomer(month,year);
                }else{
                    if(!(month>0 && month<13)){
                        et_bulan.setError("Bulan Tidak Valid!");
                    }
                    if(!(year>2000 && year<2025)){
                        et_tahun.setError("Mohon masukkan Tahun dalam jangkauan 2000-2025");
                    }
                }
            }
        });

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ManagerActivity.this, "Sampai Jumpa!"  ,Toast.LENGTH_SHORT).show();
                Intent moveHome = new Intent(ManagerActivity.this, MainActivity.class);
                startActivity(moveHome);
                finish();
            }
        });
    }

    private void getLaporanPenyewaan(int month, int year) {
        StringRequest stringRequest = new StringRequest(GET, AJR_API.PDF_Penyewaan_URL + month + "/" +year, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Gson gson = new Gson();
                PenyewaanResponse PenyewaanResponse = gson.fromJson(response, PenyewaanResponse.class);
                List<Penyewaan> Penyewaan = PenyewaanResponse.getPenyewaanList();
                try {
                    cetakPdfLaporanPenyewaan(Penyewaan);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        try
                        {
                            String responseBody = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                            JSONObject errors = new JSONObject(responseBody);
                            Toast.makeText(ManagerActivity.this, errors.getString("message"), Toast.LENGTH_SHORT).show();
                        }
                        catch (Exception e) {
                            Toast.makeText(ManagerActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
        {
            // Menambahkan header pada request
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                return headers;
            }
        };

        // Menambahkan request ke request queue
        queue.add(stringRequest);
    }

    private void getLaporanPendapatan(int month, int year) {
        StringRequest stringRequest = new StringRequest(GET, AJR_API.PDF_Detail_Pendapatan_URL + month + "/" +year, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Gson gson = new Gson();
                PendapatanResponse PenyewaanResponse = gson.fromJson(response, PendapatanResponse.class);
                List<Pendapatan> Pendapatan = PenyewaanResponse.getPendapatanList();
                try {
                    cetakPdfLaporanPendapatan(Pendapatan);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }


            }
        },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {

                        try
                        {
                            String responseBody = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                            JSONObject errors = new JSONObject(responseBody);
                            Toast.makeText(ManagerActivity.this, errors.getString("message"), Toast.LENGTH_SHORT).show();
                        }
                        catch (Exception e) {
                            Toast.makeText(ManagerActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
        {
            // Menambahkan header pada request
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                return headers;
            }
        };

        // Menambahkan request ke request queue
        queue.add(stringRequest);
    }

    private void getLaporanDriver(int month, int year) {
        StringRequest stringRequest = new StringRequest(GET, AJR_API.PDF_Driver_Perbulan_URL + month + "/" +year, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Gson gson = new Gson();
                DriverResponse DriverResponse = gson.fromJson(response, DriverResponse.class);
                List<Driver> Driver = DriverResponse.getDriverList();
                try {
                    cetakPdfLaporanDriver(Driver);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }


            }
        },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {

                        try
                        {
                            String responseBody = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                            JSONObject errors = new JSONObject(responseBody);
                            Toast.makeText(ManagerActivity.this, errors.getString("message"), Toast.LENGTH_SHORT).show();
                        }
                        catch (Exception e) {
                            Toast.makeText(ManagerActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
        {
            // Menambahkan header pada request
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                return headers;
            }
        };

        // Menambahkan request ke request queue
        queue.add(stringRequest);
    }


    private void getLaporanPerforma(int month, int year) {
        StringRequest stringRequest = new StringRequest(GET, AJR_API.PDF_Performa_Driver_URL + month + "/" +year, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Gson gson = new Gson();
                PerformaDriverResponse PerformaDriverResponse = gson.fromJson(response, PerformaDriverResponse.class);
                List<PerformaDriver> PerformaDriver = PerformaDriverResponse.getPerformaDriverList();
                try {
                    cetakPdfLaporanPerforma(PerformaDriver);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }


            }
        },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {

                        try
                        {
                            String responseBody = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                            JSONObject errors = new JSONObject(responseBody);
                            Toast.makeText(ManagerActivity.this, errors.getString("message"), Toast.LENGTH_SHORT).show();
                        }
                        catch (Exception e) {
                            Toast.makeText(ManagerActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
        {
            // Menambahkan header pada request
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                return headers;
            }
        };

        // Menambahkan request ke request queue
        queue.add(stringRequest);

    }



    private void cetakPdfLaporanPenyewaan(List<Penyewaan> Penyewaan) throws FileNotFoundException, DocumentException {
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        if (!folder.exists())
        {
            folder.mkdir();
        }

        Date currentTime = Calendar.getInstance().getTime();
        String pdfName = currentTime.getTime() + ".pdf";
        File pdfFile = new File(folder.getAbsolutePath(), pdfName);
        OutputStream outputStream = new FileOutputStream(pdfFile);
        com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4);
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // bagian header
        Paragraph judul = new Paragraph("LAPORAN PENYEWAAN MOBIL PADA BULAN TERTENTU \n\n", new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK));
        judul.setAlignment(Element.ALIGN_CENTER);
        document.add(judul);

        // Buat tabel
        PdfPTable tables = new PdfPTable(new float[]{16, 8});

        // Settingan ukuran tabel
        tables.getDefaultCell().setFixedHeight(50);
        tables.setTotalWidth(PageSize.A4.getWidth());
        tables.setWidthPercentage(100);
        tables.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        PdfPCell cellSupplier = new PdfPCell();
        cellSupplier.setPaddingLeft(20);
        cellSupplier.setPaddingBottom(10);
        cellSupplier.setBorder(Rectangle.NO_BORDER);
        Paragraph kepada = new Paragraph("Kepada Yth: \n" + "Manager AJR" + "\n", new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK));
        cellSupplier.addElement(kepada);
        tables.addCell(cellSupplier);

        Paragraph NomorTanggal = new Paragraph(
                "Tanggal : " + new SimpleDateFormat("dd/MM/yyyy",
                        Locale.getDefault()).format(currentTime) + "\n",
                new
                        com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10,
                        com.itextpdf.text.Font.NORMAL, BaseColor.BLACK));
        NomorTanggal.setPaddingTop(5);
        tables.addCell(NomorTanggal);
        document.add(tables);
        com.itextpdf.text.Font f = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);


        PdfPTable tableHeader = new PdfPTable(new float[]{4, 4, 4, 4});

        tableHeader.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        tableHeader.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        tableHeader.getDefaultCell().setFixedHeight(30);
        tableHeader.setTotalWidth(PageSize.A4.getWidth());
        tableHeader.setWidthPercentage(100);

        // Setup Column
        PdfPCell h1 = new PdfPCell(new Phrase("Tipe Mobil"));
        h1.setHorizontalAlignment(Element.ALIGN_CENTER);
        h1.setPaddingBottom(5);

        PdfPCell h2 = new PdfPCell(new Phrase("Nama Mobil"));
        h2.setHorizontalAlignment(Element.ALIGN_CENTER);
        h2.setPaddingBottom(5);

        PdfPCell h3 = new PdfPCell(new Phrase("Jumlah Peminjaman"));
        h3.setHorizontalAlignment(Element.ALIGN_CENTER);
        h3.setPaddingBottom(5);

        PdfPCell h4 = new PdfPCell(new Phrase("Pendapatan"));
        h4.setHorizontalAlignment(Element.ALIGN_CENTER);
        h4.setPaddingBottom(5);



        tableHeader.addCell(h1);
        tableHeader.addCell(h2);
        tableHeader.addCell(h3);
        tableHeader.addCell(h4);
        // Beri warna untuk kolumn
        for (PdfPCell cells : tableHeader.getRow(0).getCells()) {
            cells.setBackgroundColor(BaseColor.PINK);
        }
        document.add(tableHeader);
        PdfPTable tableData = new PdfPTable(new float[]{4, 4, 4, 4});

        tableData.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        tableData.getDefaultCell().setFixedHeight(30);
        tableData.setTotalWidth(PageSize.A4.getWidth());
        tableData.setWidthPercentage(100);
        tableData.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

        // masukan data pegawai jadi baris
        for (Penyewaan L : Penyewaan)
        {
            tableData.addCell(L.getTipe_mobil());
            tableData.addCell(L.getNama_mobil());
            tableData.addCell(String.valueOf(L.getJumlah_peminjaman()));
            tableData.addCell(String.valueOf(L.getPendapatan()));

        }
        document.add(tableData);
        com.itextpdf.text.Font h = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10, com.itextpdf.text.Font.NORMAL);
        String tglDicetak = currentTime.toLocaleString();
        Paragraph P = new Paragraph("\nDicetak pada tanggal " + tglDicetak, h);
        P.setAlignment(Element.ALIGN_RIGHT);
        document.add(P);
        document.close();
        previewPdf(pdfFile);
        Toast.makeText(this, "PDF berhasil dicetak!", Toast.LENGTH_SHORT).show();

    }

    private void cetakPdfLaporanPendapatan(List<Pendapatan> Pendapatan) throws FileNotFoundException, DocumentException {
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        if (!folder.exists())
        {
            folder.mkdir();
        }

        Date currentTime = Calendar.getInstance().getTime();
        String pdfName = currentTime.getTime() + ".pdf";
        File pdfFile = new File(folder.getAbsolutePath(), pdfName);
        OutputStream outputStream = new FileOutputStream(pdfFile);
        com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4);
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // bagian header
        Paragraph judul = new Paragraph("LAPORAN DETAIL PENDAPATAN MOBIL PADA BULAN TERTENTU \n\n", new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK));
        judul.setAlignment(Element.ALIGN_CENTER);
        document.add(judul);

        // Buat tabel
        PdfPTable tables = new PdfPTable(new float[]{16, 8});

        // Settingan ukuran tabel
        tables.getDefaultCell().setFixedHeight(50);
        tables.setTotalWidth(PageSize.A4.getWidth());
        tables.setWidthPercentage(100);
        tables.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        PdfPCell cellSupplier = new PdfPCell();
        cellSupplier.setPaddingLeft(20);
        cellSupplier.setPaddingBottom(10);
        cellSupplier.setBorder(Rectangle.NO_BORDER);
        Paragraph kepada = new Paragraph("Kepada Yth: \n" + "Manager AJR" + "\n", new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK));
        cellSupplier.addElement(kepada);
        tables.addCell(cellSupplier);

        Paragraph NomorTanggal = new Paragraph(
                "Tanggal : " + new SimpleDateFormat("dd/MM/yyyy",
                        Locale.getDefault()).format(currentTime) + "\n",
                new
                        com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10,
                        com.itextpdf.text.Font.NORMAL, BaseColor.BLACK));
        NomorTanggal.setPaddingTop(5);
        tables.addCell(NomorTanggal);
        document.add(tables);
        com.itextpdf.text.Font f = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);


        PdfPTable tableHeader = new PdfPTable(new float[]{5, 5, 5, 5, 5});

        tableHeader.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        tableHeader.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        tableHeader.getDefaultCell().setFixedHeight(30);
        tableHeader.setTotalWidth(PageSize.A4.getWidth());
        tableHeader.setWidthPercentage(100);

        // Setup Column
        PdfPCell h1 = new PdfPCell(new Phrase("Nama Customer"));
        h1.setHorizontalAlignment(Element.ALIGN_CENTER);
        h1.setPaddingBottom(5);

        PdfPCell h2 = new PdfPCell(new Phrase("Nama Mobil"));
        h2.setHorizontalAlignment(Element.ALIGN_CENTER);
        h2.setPaddingBottom(5);

        PdfPCell h3 = new PdfPCell(new Phrase("Jenis Transaksi"));
        h3.setHorizontalAlignment(Element.ALIGN_CENTER);
        h3.setPaddingBottom(5);

        PdfPCell h4 = new PdfPCell(new Phrase("Jumlah Transaksi"));
        h4.setHorizontalAlignment(Element.ALIGN_CENTER);
        h4.setPaddingBottom(5);

        PdfPCell h5 = new PdfPCell(new Phrase("Pendapatan"));
        h4.setHorizontalAlignment(Element.ALIGN_CENTER);
        h4.setPaddingBottom(5);

        tableHeader.addCell(h1);
        tableHeader.addCell(h2);
        tableHeader.addCell(h3);
        tableHeader.addCell(h4);
        tableHeader.addCell(h5);

        // Beri warna untuk kolumn
        for (PdfPCell cells : tableHeader.getRow(0).getCells()) {
            cells.setBackgroundColor(BaseColor.PINK);
        }
        document.add(tableHeader);
        PdfPTable tableData = new PdfPTable(new float[]{5, 5, 5, 5, 5});

        tableData.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        tableData.getDefaultCell().setFixedHeight(30);
        tableData.setTotalWidth(PageSize.A4.getWidth());
        tableData.setWidthPercentage(100);
        tableData.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

        // masukan data pegawai jadi baris
        for (Pendapatan L : Pendapatan)
        {
            tableData.addCell(L.getNama());
            tableData.addCell(L.getNama_mobil());
            tableData.addCell(L.getJenis_transaksi());
            tableData.addCell(String.valueOf(L.getJumlah_transaksi()));
            tableData.addCell(String.valueOf(L.getPendapatan()));

        }
        document.add(tableData);
        com.itextpdf.text.Font h = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10, com.itextpdf.text.Font.NORMAL);
        String tglDicetak = currentTime.toLocaleString();
        Paragraph P = new Paragraph("\nDicetak pada tanggal " + tglDicetak, h);
        P.setAlignment(Element.ALIGN_RIGHT);
        document.add(P);
        document.close();
        previewPdf(pdfFile);
        Toast.makeText(this, "PDF berhasil dicetak!", Toast.LENGTH_SHORT).show();

    }

    private void cetakPdfLaporanDriver(List<Driver> Driver) throws FileNotFoundException, DocumentException{
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        if (!folder.exists())
        {
            folder.mkdir();
        }

        Date currentTime = Calendar.getInstance().getTime();
        String pdfName = currentTime.getTime() + ".pdf";
        File pdfFile = new File(folder.getAbsolutePath(), pdfName);
        OutputStream outputStream = new FileOutputStream(pdfFile);
        com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4);
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // bagian header
        Paragraph judul = new Paragraph("LAPORAN DETAIL PENDAPATAN MOBIL PADA BULAN TERTENTU \n\n", new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK));
        judul.setAlignment(Element.ALIGN_CENTER);
        document.add(judul);

        // Buat tabel
        PdfPTable tables = new PdfPTable(new float[]{16, 8});

        // Settingan ukuran tabel
        tables.getDefaultCell().setFixedHeight(50);
        tables.setTotalWidth(PageSize.A4.getWidth());
        tables.setWidthPercentage(100);
        tables.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        PdfPCell cellSupplier = new PdfPCell();
        cellSupplier.setPaddingLeft(20);
        cellSupplier.setPaddingBottom(10);
        cellSupplier.setBorder(Rectangle.NO_BORDER);
        Paragraph kepada = new Paragraph("Kepada Yth: \n" + "Manager AJR" + "\n", new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK));
        cellSupplier.addElement(kepada);
        tables.addCell(cellSupplier);

        Paragraph NomorTanggal = new Paragraph(
                "Tanggal : " + new SimpleDateFormat("dd/MM/yyyy",
                        Locale.getDefault()).format(currentTime) + "\n",
                new
                        com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10,
                        com.itextpdf.text.Font.NORMAL, BaseColor.BLACK));
        NomorTanggal.setPaddingTop(5);
        tables.addCell(NomorTanggal);
        document.add(tables);
        com.itextpdf.text.Font f = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);


        PdfPTable tableHeader = new PdfPTable(new float[]{3, 3, 3});

        tableHeader.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        tableHeader.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        tableHeader.getDefaultCell().setFixedHeight(30);
        tableHeader.setTotalWidth(PageSize.A4.getWidth());
        tableHeader.setWidthPercentage(100);

        // Setup Column
        PdfPCell h1 = new PdfPCell(new Phrase("ID Driver"));
        h1.setHorizontalAlignment(Element.ALIGN_CENTER);
        h1.setPaddingBottom(5);

        PdfPCell h2 = new PdfPCell(new Phrase("Nama Driver"));
        h2.setHorizontalAlignment(Element.ALIGN_CENTER);
        h2.setPaddingBottom(5);

        PdfPCell h3 = new PdfPCell(new Phrase("Jumlah Transaksi"));
        h3.setHorizontalAlignment(Element.ALIGN_CENTER);
        h3.setPaddingBottom(5);


        tableHeader.addCell(h1);
        tableHeader.addCell(h2);
        tableHeader.addCell(h3);

        // Beri warna untuk kolumn
        for (PdfPCell cells : tableHeader.getRow(0).getCells()) {
            cells.setBackgroundColor(BaseColor.PINK);
        }
        document.add(tableHeader);
        PdfPTable tableData = new PdfPTable(new float[]{3, 3, 3});

        tableData.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        tableData.getDefaultCell().setFixedHeight(30);
        tableData.setTotalWidth(PageSize.A4.getWidth());
        tableData.setWidthPercentage(100);
        tableData.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

        // masukan data pegawai jadi baris
        for (Driver L : Driver)
        {
            tableData.addCell(L.getId_driver());
            tableData.addCell(L.getNama_driver());
            tableData.addCell(String.valueOf(L.getJumlah_transaksi()));


        }
        document.add(tableData);
        com.itextpdf.text.Font h = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10, com.itextpdf.text.Font.NORMAL);
        String tglDicetak = currentTime.toLocaleString();
        Paragraph P = new Paragraph("\nDicetak pada tanggal " + tglDicetak, h);
        P.setAlignment(Element.ALIGN_RIGHT);
        document.add(P);
        document.close();
        previewPdf(pdfFile);
        Toast.makeText(this, "PDF berhasil dicetak!", Toast.LENGTH_SHORT).show();
    }

    private void cetakPdfLaporanPerforma(List<PerformaDriver> PerformaDriver) throws FileNotFoundException, DocumentException {
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        if (!folder.exists())
        {
            folder.mkdir();
        }

        Date currentTime = Calendar.getInstance().getTime();
        String pdfName = currentTime.getTime() + ".pdf";
        File pdfFile = new File(folder.getAbsolutePath(), pdfName);
        OutputStream outputStream = new FileOutputStream(pdfFile);
        com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4);
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // bagian header
        Paragraph judul = new Paragraph("LAPORAN PERFORMA DRIVER MOBIL PADA BULAN TERTENTU \n\n", new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK));
        judul.setAlignment(Element.ALIGN_CENTER);
        document.add(judul);

        // Buat tabel
        PdfPTable tables = new PdfPTable(new float[]{16, 8});

        // Settingan ukuran tabel
        tables.getDefaultCell().setFixedHeight(50);
        tables.setTotalWidth(PageSize.A4.getWidth());
        tables.setWidthPercentage(100);
        tables.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        PdfPCell cellSupplier = new PdfPCell();
        cellSupplier.setPaddingLeft(20);
        cellSupplier.setPaddingBottom(10);
        cellSupplier.setBorder(Rectangle.NO_BORDER);
        Paragraph kepada = new Paragraph("Kepada Yth: \n" + "Manager AJR" + "\n", new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK));
        cellSupplier.addElement(kepada);
        tables.addCell(cellSupplier);

        Paragraph NomorTanggal = new Paragraph(
                "Tanggal : " + new SimpleDateFormat("dd/MM/yyyy",
                        Locale.getDefault()).format(currentTime) + "\n",
                new
                        com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10,
                        com.itextpdf.text.Font.NORMAL, BaseColor.BLACK));
        NomorTanggal.setPaddingTop(5);
        tables.addCell(NomorTanggal);
        document.add(tables);
        com.itextpdf.text.Font f = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);


        PdfPTable tableHeader = new PdfPTable(new float[]{4, 4, 4, 4});

        tableHeader.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        tableHeader.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        tableHeader.getDefaultCell().setFixedHeight(30);
        tableHeader.setTotalWidth(PageSize.A4.getWidth());
        tableHeader.setWidthPercentage(100);

        // Setup Column
        PdfPCell h1 = new PdfPCell(new Phrase("ID Driver"));
        h1.setHorizontalAlignment(Element.ALIGN_CENTER);
        h1.setPaddingBottom(5);

        PdfPCell h2 = new PdfPCell(new Phrase("Nama Driver"));
        h2.setHorizontalAlignment(Element.ALIGN_CENTER);
        h2.setPaddingBottom(5);

        PdfPCell h3 = new PdfPCell(new Phrase("Jumlah Transaksi"));
        h3.setHorizontalAlignment(Element.ALIGN_CENTER);
        h3.setPaddingBottom(5);

        PdfPCell h4 = new PdfPCell(new Phrase("Rerata Rating"));
        h4.setHorizontalAlignment(Element.ALIGN_CENTER);
        h4.setPaddingBottom(5);


        tableHeader.addCell(h1);
        tableHeader.addCell(h2);
        tableHeader.addCell(h3);
        tableHeader.addCell(h4);

        // Beri warna untuk kolumn
        for (PdfPCell cells : tableHeader.getRow(0).getCells()) {
            cells.setBackgroundColor(BaseColor.PINK);
        }
        document.add(tableHeader);
        PdfPTable tableData = new PdfPTable(new float[]{4, 4, 4, 4});

        tableData.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        tableData.getDefaultCell().setFixedHeight(30);
        tableData.setTotalWidth(PageSize.A4.getWidth());
        tableData.setWidthPercentage(100);
        tableData.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

        // masukan data pegawai jadi baris
        for (PerformaDriver L : PerformaDriver)
        {
            tableData.addCell(L.getId_driver());
            tableData.addCell(L.getNama_driver());
            tableData.addCell(String.valueOf(L.getJumlah_transaksi()));
            tableData.addCell(String.valueOf(L.getRerata_rating_driver()));


        }
        document.add(tableData);
        com.itextpdf.text.Font h = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10, com.itextpdf.text.Font.NORMAL);
        String tglDicetak = currentTime.toLocaleString();
        Paragraph P = new Paragraph("\nDicetak pada tanggal " + tglDicetak, h);
        P.setAlignment(Element.ALIGN_RIGHT);
        document.add(P);
        document.close();
        previewPdf(pdfFile);
        Toast.makeText(this, "PDF berhasil dicetak!", Toast.LENGTH_SHORT).show();
    }

    private void previewPdf(File pdfFile) {
        PackageManager packageManager = getPackageManager();
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        testIntent.setType("application/pdf");
        List<ResolveInfo> list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);

        if (list.size() > 0)
        {
            Uri uri;
            uri = FileProvider.getUriForFile(this, getPackageName() + ".provider", pdfFile);
            Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
            pdfIntent.setDataAndType(uri, "application/pdf");
            pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            pdfIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            pdfIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            pdfIntent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
            pdfIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            this.grantUriPermission(getPackageName(), uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(pdfIntent);
        }
    }

    private void getLaporanCustomer(int month, int year) {
        StringRequest stringRequest = new StringRequest(GET, AJR_API.PDF_Customer_URL + month + "/" +year, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Gson gson = new Gson();
                CustomerResponse CustomerResponse = gson.fromJson(response, CustomerResponse.class);
                List<Customer> Customer = CustomerResponse.getCustomerList();
                try {
                    cetakPdfLaporan5Customer(Customer);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }


            }
        },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {

                        try
                        {
                            String responseBody = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                            JSONObject errors = new JSONObject(responseBody);
                            Toast.makeText(ManagerActivity.this, errors.getString("message"), Toast.LENGTH_SHORT).show();
                        }
                        catch (Exception e) {
                            Toast.makeText(ManagerActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
        {
            // Menambahkan header pada request
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError
            {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                return headers;
            }
        };

        // Menambahkan request ke request queue
        queue.add(stringRequest);

    }
    
    private void cetakPdfLaporan5Customer(List<Customer> Customer) throws FileNotFoundException, DocumentException {
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        if (!folder.exists())
        {
            folder.mkdir();
        }

        Date currentTime = Calendar.getInstance().getTime();
        String pdfName = currentTime.getTime() + ".pdf";
        File pdfFile = new File(folder.getAbsolutePath(), pdfName);
        OutputStream outputStream = new FileOutputStream(pdfFile);
        com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4);
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // bagian header
        Paragraph judul = new Paragraph("LAPORAN 5 CUSTOMER DENGAN JUMLAH TRANSAKSI TERBANYAK PADA BULAN TERTENTU \n\n", new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK));
        judul.setAlignment(Element.ALIGN_CENTER);
        document.add(judul);

        // Buat tabel
        PdfPTable tables = new PdfPTable(new float[]{16, 8});

        // Settingan ukuran tabel
        tables.getDefaultCell().setFixedHeight(50);
        tables.setTotalWidth(PageSize.A4.getWidth());
        tables.setWidthPercentage(100);
        tables.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        PdfPCell cellSupplier = new PdfPCell();
        cellSupplier.setPaddingLeft(20);
        cellSupplier.setPaddingBottom(10);
        cellSupplier.setBorder(Rectangle.NO_BORDER);
        Paragraph kepada = new Paragraph("Kepada Yth: \n" + "Manager AJR" + "\n", new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK));
        cellSupplier.addElement(kepada);
        tables.addCell(cellSupplier);

        Paragraph NomorTanggal = new Paragraph(
                "Tanggal : " + new SimpleDateFormat("dd/MM/yyyy",
                        Locale.getDefault()).format(currentTime) + "\n",
                new
                        com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10,
                        com.itextpdf.text.Font.NORMAL, BaseColor.BLACK));
        NomorTanggal.setPaddingTop(5);
        tables.addCell(NomorTanggal);
        document.add(tables);
        com.itextpdf.text.Font f = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);


        PdfPTable tableHeader = new PdfPTable(new float[]{2, 2});

        tableHeader.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        tableHeader.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        tableHeader.getDefaultCell().setFixedHeight(30);
        tableHeader.setTotalWidth(PageSize.A4.getWidth());
        tableHeader.setWidthPercentage(100);

        // Setup Column
        PdfPCell h1 = new PdfPCell(new Phrase("Nama Customer"));
        h1.setHorizontalAlignment(Element.ALIGN_CENTER);
        h1.setPaddingBottom(5);

        PdfPCell h2 = new PdfPCell(new Phrase("Jumlah Transaksi"));
        h2.setHorizontalAlignment(Element.ALIGN_CENTER);
        h2.setPaddingBottom(5);

        tableHeader.addCell(h1);
        tableHeader.addCell(h2);

        // Beri warna untuk kolumn
        for (PdfPCell cells : tableHeader.getRow(0).getCells()) {
            cells.setBackgroundColor(BaseColor.PINK);
        }
        document.add(tableHeader);
        PdfPTable tableData = new PdfPTable(new float[]{2, 2});

        tableData.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        tableData.getDefaultCell().setFixedHeight(30);
        tableData.setTotalWidth(PageSize.A4.getWidth());
        tableData.setWidthPercentage(100);
        tableData.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

        // masukan data pegawai jadi baris
        for (Customer L : Customer)
        {
            tableData.addCell(L.getNama());
            tableData.addCell(String.valueOf(L.getJumlah_transaksi()));
        }
        document.add(tableData);
        com.itextpdf.text.Font h = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10, com.itextpdf.text.Font.NORMAL);
        String tglDicetak = currentTime.toLocaleString();
        Paragraph P = new Paragraph("\nDicetak pada tanggal " + tglDicetak, h);
        P.setAlignment(Element.ALIGN_RIGHT);
        document.add(P);
        document.close();
        previewPdf(pdfFile);
        Toast.makeText(this, "PDF berhasil dicetak!", Toast.LENGTH_SHORT).show();

    }
}
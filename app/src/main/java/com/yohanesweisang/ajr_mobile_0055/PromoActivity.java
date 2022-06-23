package com.yohanesweisang.ajr_mobile_0055;

import static com.android.volley.Request.Method.GET;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.yohanesweisang.ajr_mobile_0055.adapters.PromoAdapter;
import com.yohanesweisang.ajr_mobile_0055.adapters.PromoAdapter;
import com.yohanesweisang.ajr_mobile_0055.api.AJR_API;
import com.yohanesweisang.ajr_mobile_0055.models.PromoResponse;
import com.yohanesweisang.ajr_mobile_0055.models.PromoResponse;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PromoActivity extends AppCompatActivity {

    private SwipeRefreshLayout srPromo;
    private PromoAdapter adapter;
    private SearchView svPromo;
    private RequestQueue queue;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);
        getSupportActionBar().hide();

        // Pendeklarasian request queue
        queue = Volley.newRequestQueue(this);
        srPromo = findViewById(R.id.sr_promo);
        svPromo = findViewById(R.id.sv_promo);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.Promo);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Home:
                        startActivity(new Intent(PromoActivity.this, CustomerActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.Brosur:
                        startActivity(new Intent(PromoActivity.this, BrosurActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.Promo:
                        return true;
                }
                return false;
            }
        });


        srPromo.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAllPromo();
            }
        });
        svPromo.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });


        RecyclerView rvPromo = findViewById(R.id.rv_promo);
        adapter = new PromoAdapter(new ArrayList<>(), this);
        rvPromo.setLayoutManager(new LinearLayoutManager(PromoActivity.this,
                LinearLayoutManager.VERTICAL, false));
        rvPromo.setAdapter(adapter);
        getAllPromo();
    }

    private void getAllPromo() {
        srPromo.setRefreshing(true);
        StringRequest stringRequest = new StringRequest(GET,
                AJR_API.GET_ALL_PROMO_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
 /* Deserialiasai data dari response JSON dari API
 menjadi java object PromoResponse menggunakan Gson */
                PromoResponse promoResponse =
                        gson.fromJson(response, PromoResponse.class);
                adapter.setPromoList(promoResponse.getPromoList());
                adapter.getFilter().filter(svPromo.getQuery());
                Toast.makeText(PromoActivity.this,
                        promoResponse.getMessage(), Toast.LENGTH_SHORT).show();
                srPromo.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                srPromo.setRefreshing(false);
                try {
                    String responseBody = new String(error.networkResponse.data,
                            StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);
                    Toast.makeText(PromoActivity.this,
                            errors.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(PromoActivity.this, e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        }) {
            // Menambahkan header pada request
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                return headers;
            }
        };
        // Menambahkan request ke request queue
        queue.add(stringRequest);
    }
}
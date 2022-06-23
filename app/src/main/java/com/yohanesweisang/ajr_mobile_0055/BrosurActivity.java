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
import com.yohanesweisang.ajr_mobile_0055.adapters.BrosurAdapter;
import com.yohanesweisang.ajr_mobile_0055.adapters.PromoAdapter;
import com.yohanesweisang.ajr_mobile_0055.api.AJR_API;
import com.yohanesweisang.ajr_mobile_0055.models.BrosurResponse;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BrosurActivity extends AppCompatActivity {
    private SwipeRefreshLayout srBrosur;
    private BrosurAdapter adapter;
    private SearchView svBrosur;
    private LinearLayout layoutLoading;
    private RequestQueue queue;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brosur);
        getSupportActionBar().hide();

        queue = Volley.newRequestQueue(this);

        layoutLoading = findViewById(R.id.layout_loading);
        srBrosur = findViewById(R.id.sr_brosur);
        svBrosur = findViewById(R.id.sv_brosur);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.Brosur);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Home:
                        startActivity(new Intent(BrosurActivity.this, CustomerActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.Brosur:
                        return true;
                    case R.id.Promo:
                        startActivity(new Intent(BrosurActivity.this, PromoActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                }
                return false;
            }
        });

        srBrosur.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAllBrosur();
            }
        });

        svBrosur.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

        RecyclerView rvBrosur = findViewById(R.id.rv_brosur);
        adapter = new BrosurAdapter(new ArrayList<>(), this);
        rvBrosur.setLayoutManager(new LinearLayoutManager(BrosurActivity.this,
                LinearLayoutManager.VERTICAL, false));
        rvBrosur.setAdapter(adapter);
        getAllBrosur();
    }

    private void getAllBrosur() {
        srBrosur.setRefreshing(true);
        StringRequest stringRequest = new StringRequest(GET,
                AJR_API.GET_ALL_BROSUR_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                BrosurResponse brosurResponse = gson.fromJson(response, BrosurResponse.class);
                adapter.setBrosurList(brosurResponse.getBrosurList());
                adapter.getFilter().filter(svBrosur.getQuery());
                Toast.makeText(BrosurActivity.this, brosurResponse.getMessage(), Toast.LENGTH_SHORT).show();
                srBrosur.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                srBrosur.setRefreshing(false);
                try
                {
                    String responseBody = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);
                    Toast.makeText(BrosurActivity.this, errors.getString("message"), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(BrosurActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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
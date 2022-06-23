package com.yohanesweisang.ajr_mobile_0055;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.yohanesweisang.ajr_mobile_0055.api.AJR_API;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {
    private EditText email, password;
    private Button btnLogin, btnClr;
    private Intent intent;
    private LinearLayout layoutLoading;
    private RequestQueue queue;

    private static String URL_LOGIN = AJR_API.LOGIN_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        queue = Volley.newRequestQueue(this);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        btnLogin=findViewById(R.id.btnLogin);
        btnClr=findViewById(R.id.btnClr);
        layoutLoading = findViewById(R.id.layout_loading);

        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email.getText().clear();
                password.getText().clear();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailET, passwordET;
                emailET = email.getText().toString().trim();
                passwordET = password.getText().toString().trim();
                //if(email.getText().toString().equals(""))
                if(!emailET.isEmpty() && !passwordET.isEmpty()){
                    Login(emailET, passwordET);
                }else{
                    if(emailET.isEmpty()){
                        email.setError("Masukkan Username!");
                    }
                    if(passwordET.isEmpty()){
                        password.setError("Masukkan Password!");
                    }
                }
            }
        });
    }

    private void Login(final String email, final String password) {
        setLoading(true);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String message = jsonObject.getString("message");
                            if (message.equals("Customer Authenticated")) {//liat brosur, promo, dan transaksi
                                setLoading(false);
                                Toast.makeText(MainActivity.this, "Login Sukses"  ,Toast.LENGTH_SHORT).show();
                                Intent moveHome = new Intent(MainActivity.this,CustomerActivity.class);
                                startActivity(moveHome);
                                finish();
                            }else if(message.equals("Driver Authenticated")){//update profil, status, cek rating
                                setLoading(false);
                                Toast.makeText(MainActivity.this, "Login sukses sebagai Driver"  ,Toast.LENGTH_SHORT).show();
                                Intent moveHome = new Intent(MainActivity.this,DriverActivity.class);
                                startActivity(moveHome);
                                finish();
                            }else if(message.equals("Manager Authenticated")){//manager cetak pdf
                                setLoading(false);
                                Toast.makeText(MainActivity.this, "Login sukses sebagai Manager"  ,Toast.LENGTH_SHORT).show();
                                Intent moveHome = new Intent(MainActivity.this,ManagerActivity.class);
                                startActivity(moveHome);
                                finish();
                            }else{
                                setLoading(false);
                                Toast.makeText(MainActivity.this, "Username atau Password Salah"  ,Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        setLoading(false);
                        Toast.makeText(MainActivity.this, "Error! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        //stringRequest.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 1, 1.0f));

        queue.add(stringRequest);
    }

    private void setLoading(boolean isLoading) {
        if (isLoading) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            layoutLoading.setVisibility(View.VISIBLE);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            layoutLoading.setVisibility(View.GONE);
        }
    }
}
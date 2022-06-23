package com.yohanesweisang.ajr_mobile_0055;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

public class CustomerActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private MaterialButton materialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        getSupportActionBar().hide();

        materialButton = findViewById(R.id.btnLogOut);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.Home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Home:
                        return true;
                    case R.id.Brosur:
                        startActivity(new Intent(CustomerActivity.this, BrosurActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.Promo:
                        startActivity(new Intent(CustomerActivity.this, PromoActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                }
                return false;
            }
        });

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CustomerActivity.this, "Sampai Jumpa!"  ,Toast.LENGTH_SHORT).show();
                Intent moveHome = new Intent(CustomerActivity.this,MainActivity.class);
                startActivity(moveHome);
                finish();
            }
        });
    }
}
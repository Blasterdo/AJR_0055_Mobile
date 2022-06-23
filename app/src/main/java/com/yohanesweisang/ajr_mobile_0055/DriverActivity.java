package com.yohanesweisang.ajr_mobile_0055;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class DriverActivity extends AppCompatActivity {
    private MaterialButton btnLogOut, btnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        getSupportActionBar().hide();

        btnLogOut = findViewById(R.id.btnLogOut);
        btnEdit = findViewById(R.id.btnEdit);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DriverActivity.this, "Sampai Jumpa!"  ,Toast.LENGTH_SHORT).show();
                Intent moveHome = new Intent(DriverActivity.this,MainActivity.class);
                startActivity(moveHome);
                finish();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DriverActivity.this, "Fitur ini sedang maintenance!"  ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
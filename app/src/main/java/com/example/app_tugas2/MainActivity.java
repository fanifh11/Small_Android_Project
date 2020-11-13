package com.example.app_tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bbi(View view) {

        startActivity(new Intent(this, BbiActivity.class));
    }

    public void bangun_datar(View view) {
        startActivity(new Intent(this, BangunDatarActivity.class));
    }


    public void bangun_ruang(View view) {
        startActivity(new Intent(this,BangunRuangActivity.class));
    }

    public void konversi_suhu(View view) {
        startActivity(new Intent(this,SuhuActivity.class));

    }

    public void konversi_nilai(View view) {
       startActivity(new Intent(this,NilaiActivity.class));
    }


}
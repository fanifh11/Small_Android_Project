package com.example.app_tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class BangunDatarActivity extends AppCompatActivity {
    TextView txtHasilLingkaran, txtHasilSegitiga, txtHasilPersegi;
    TextInputEditText inputJari2, inputAlasSegitiga, inputTinggiSegitiga , inputSisiPersegi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangun_datar);

        inisialisasi();
    }

    private void inisialisasi() {
        txtHasilLingkaran = findViewById(R.id.txtHasilLingkaran);
        inputJari2 = findViewById(R.id.inputJari2);

        txtHasilSegitiga = findViewById(R.id.txtHasilSegitiga);
        inputAlasSegitiga = findViewById(R.id.inputAlasSegitiga);
        inputTinggiSegitiga = findViewById(R.id.inputTinggiSegitiga);

        txtHasilPersegi = findViewById(R.id.txtHasilPersegi);
        inputSisiPersegi = findViewById(R.id.inputSisiPersegi);
    }


    public void KelLingkaran(View view) {
        try {
            Double valueJari2 = Double.parseDouble(inputJari2.getText().toString() );
            double hasilPerhitungan = 2 * 3.14 * valueJari2;

            txtHasilLingkaran.setText(Double.toString(hasilPerhitungan));
        } catch (Exception e){
            alert ("Jari - jari masih kosong !");
        }
    }


    public void LuasLingkaran(View view) {
        try {
            double valueJari2 = Double.parseDouble((inputJari2.getText().toString()));
            double hasilPeritungan = 3.14 *(Math.pow(valueJari2,2));

            txtHasilLingkaran.setText(Double.toString(hasilPeritungan));
        } catch (Exception e){
            alert ("Jari - jari masih kosong !");
        }
    }


    public void LuasSegitiga(View view) {
        try {
            Double valueAlas = Double.parseDouble(inputAlasSegitiga.getText().toString());
            Double valueTinggi = Double.parseDouble(inputTinggiSegitiga.getText().toString());

            double hasilPerhitungan = (valueAlas * valueTinggi) / 2 ;

            txtHasilSegitiga.setText(Double.toString(hasilPerhitungan));
        } catch (Exception e) {
            if (inputAlasSegitiga.getText().toString().isEmpty()) {
                alert("Sisi alas masih kosong");
            } else if (inputTinggiSegitiga.getText().toString().isEmpty()) {
                alert("Sisi tinggi masih kosong");
            }
        }
    }

    public void KelSegitiga(View view) {

        try {
            inputTinggiSegitiga.setEnabled(false);
            double valueAlas = Double.parseDouble(inputAlasSegitiga.getText().toString());
            double hasilPerhitungan = valueAlas * 3;

            txtHasilSegitiga.setText((Double.toString(hasilPerhitungan)));
        } catch (Exception e){
            alert("Sisi alas masih kosong !");
        }
    }

    public void LuasPersegi(View view) {
        try {
            Double valueSisi = Double.parseDouble(inputSisiPersegi.getText().toString());
            double hasilPerhitungan = Math.pow(valueSisi,2);

            txtHasilPersegi.setText(Double.toString(hasilPerhitungan));
        } catch (Exception e){
            alert("Sisi masih kosong !");
        }
    }

    public void KelilingPersegi(View view) {
        try {
            Double valueSisi = Double.parseDouble(inputSisiPersegi.getText().toString());
            double hasilPerhitungn = 4 * valueSisi;

            txtHasilPersegi.setText(Double.toString(hasilPerhitungn));
        }catch (Exception e){
           alert("Sisi masih kosong ! ");
        }

    }

    private void alert(String teks_alert) {
        Toast.makeText(this,teks_alert, Toast.LENGTH_SHORT).show();
    }

}
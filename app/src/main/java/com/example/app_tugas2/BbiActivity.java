package com.example.app_tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;

public class BbiActivity extends AppCompatActivity {
    TextInputEditText inputTinggiBadan;
    TextView txtHasil;
    RadioGroup pilJenisKelamin;
    Integer onJenisKelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbi);

        initialize();
    }

    private void initialize() {
        inputTinggiBadan = findViewById(R.id.inputTinggiBadan);
        txtHasil = findViewById(R.id.txtHasil);

        pilJenisKelamin =findViewById(R.id.radioGrup);

        pilJenisKelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                onJenisKelamin = checkedId == R.id.pilLaki ? 1 : 2 ;
            }
        }); 
    }

    public void Hitung(View v) {
        try {
            int tinggiBadan = Integer.parseInt(inputTinggiBadan.getText().toString());

            double JenisKelamin = onJenisKelamin == 1 ? 0.1 : 0.15;

            double hasil = ((tinggiBadan - 100) - ((tinggiBadan-100) * JenisKelamin));
            txtHasil.setText(Double.toString(hasil) + " Kg");
        } catch (Exception e){
           if (inputTinggiBadan.getText().toString().isEmpty()){
               alert( "Tinggi belum diinputkan");
           }
        }

    }

    private void alert(String teks_error) {
        Toast.makeText(this,teks_error,Toast.LENGTH_SHORT).show();
    }


}
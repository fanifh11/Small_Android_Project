package com.example.app_tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.zip.DeflaterOutputStream;

public class NilaiActivity extends AppCompatActivity {

    TextInputEditText inputTugas, inputKehadiran, inputUAS, inputUTS;
    TextView txtResult, txtKeterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai);


        inisialisasi();
    }


    private void inisialisasi() {
        inputTugas = findViewById(R.id.inputTugas);
        inputKehadiran = findViewById(R.id.inputKehadiran);
        inputUAS = findViewById(R.id.inputUAS);
        inputUTS = findViewById(R.id.inputUTS);

        txtResult = findViewById(R.id.txtResult);
    }

    public void hitung(View view) {


        double valueRerataTugas = Double.parseDouble(inputTugas.getText().toString());
        double valueRerataKehadiran = Double.parseDouble(inputKehadiran.getText().toString());
        double valueUAS = Double.parseDouble(inputUAS.getText().toString());
        double valueUTS = Double.parseDouble(inputUTS.getText().toString());

       try {
           double hasilTugas = valueRerataTugas * 0.2;
           double hasilKehadiran = valueRerataKehadiran * 0.2;
           double hasilUAS = valueUAS * 0.3 ;
           double hasilUTS = valueUTS * 0.3 ;

           double hasilIP = ((hasilTugas + hasilKehadiran + hasilUAS + hasilUTS ) / 25);

           if (isValidValue(valueRerataKehadiran, "Kehadiran") && isValidValue (valueRerataTugas, "Nilai Tugas") && isValidValue(valueUAS, "Nilai UAS") && isValidValue(valueUTS,"Nilai UTS")) {
                    txtResult.setText(hasilIP + " / " + konvert(hasilIP));

           } else {
               alert("tidak keluar hasil");
           }


       }catch (Exception e){
           alert("Harap dicek lagi ! ");
       }


    }

    private String konvert(double hasilIP) {

        String hasil = "",keterangan =" " ;

        if (hasilIP <= 4 && hasilIP > 3.66){
            hasil = "A";
        } else if (hasilIP <= 3.66 && hasilIP> 3.33){
            hasil = "A-" ;
        } else if (hasilIP <= 3.33 && hasilIP > 3){
            hasil = "B+" ;
        } else if (hasilIP <= 3 && hasilIP > 2.66){
            hasil = "B" ;
        } else if (hasilIP <= 2.66 && hasilIP > 2.33){
            hasil = "B-" ;
        } else if (hasilIP <= 2.33 && hasilIP > 2){
            hasil = "C+" ;
        } else if (hasilIP <= 2 && hasilIP > 1.66){
            hasil = "C" ;
        } else if (hasilIP <= 1.66 && hasilIP > 0){
            hasil = "D" ;
        } else if (hasilIP <= 0){
            hasil = "E" ;
        }

        return hasil ;

    }


    private boolean isValidValue(double val, String teks) {
        if (val <= 100){
            return true ;
        } else {
            alert("Harap mengisi nilai " + teks + " dengan benar");
            return false ;
        }
    }

    private void alert(String alert_message) {
        Toast.makeText(this,alert_message, Toast.LENGTH_SHORT).show();
    }
}
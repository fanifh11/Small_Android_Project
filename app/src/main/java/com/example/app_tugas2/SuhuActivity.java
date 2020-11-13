package com.example.app_tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SuhuActivity extends AppCompatActivity {
    TextInputEditText inputSuhu ;
    TextView txtHasilKonversi,txtKonversiSuhu;
    Spinner spinnerSuhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suhu);

        inisialisasi();
    }

    private void inisialisasi() {
        inputSuhu = findViewById(R.id.inputSuhu);
        txtHasilKonversi = findViewById(R.id.txtHasilKonversi);
        spinnerSuhu= findViewById(R.id.spinnerSuhu);
        txtKonversiSuhu = findViewById(R.id.txtKonversiSuhu);


    }

    public void konvertSuhu(View view) {
        double hasil = 0.00;
        String suffix = "";

        try {
            double valueSuhu= Double.parseDouble(inputSuhu.getText().toString());
            int konversi = spinnerSuhu.getSelectedItemPosition();

            switch (konversi){
                case 1:
                    hasil = (4 * valueSuhu) / 5;
                    suffix =  "Reamur";
                    break;
                case 2:
                    hasil = valueSuhu + 273;
                    suffix = "Kelvin";
                    break;
                case 3:
                    hasil =(( 9 * valueSuhu) / 5 ) + 32 ;
                    suffix = "Farenheit";
                    break;
                case 5:
                    hasil = (5 * valueSuhu) /4 ;
                    suffix = " Celcius";
                    break;
                case 6:
                    hasil = ((5 * valueSuhu) /4) + 273 ;
                    suffix = " Kelvin";
                    break;
                case 7:
                    hasil = ((9 * valueSuhu) /4 )+ 32 ;
                    suffix = " Farenheit ";
                    break;
                case 9:
                    hasil = Math.floor((5*(valueSuhu-32)/9));
                    suffix = " Celcius";
                    break;
                case 10:
                    hasil =Math.floor((4*(valueSuhu-32))/9);
                    suffix = " Reamur";
                    break;
                case 11:
                    hasil =Math.floor((5*(valueSuhu-32)/9)+273);
                    suffix= " Kelvin";
                    break;
                default:
                    alert ( "Silahkan dipilih dahulu ") ;
            }
        } catch (Exception e){
            if (inputSuhu.getText().toString().isEmpty()){
                alert("Suhu awal anda masih kosong");
            }
        }

        txtKonversiSuhu.setText(("Hasil Konversi ") + spinnerSuhu.getSelectedItem().toString()+ " adalah ");
        txtHasilKonversi.setText(Double.toString(hasil) + " °" + suffix);
    }

    private void alert(String teks_alert) {
        Toast.makeText(this, teks_alert,Toast.LENGTH_SHORT).show();

    }


}
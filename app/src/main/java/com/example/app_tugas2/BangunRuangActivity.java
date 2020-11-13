package com.example.app_tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class BangunRuangActivity extends AppCompatActivity {

    TextView txtHasilBola,txtHasilBalok,txtHasilTabung ;
    TextInputEditText inputJari2, inputPanjangBalok, inputLebarBalok, inputTinggiBalok, inputJariTabung, inputTinggiTabung  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangun_ruang);

        inisialisasi();
    }

    private void inisialisasi() {

        txtHasilBola = findViewById(R.id.txtHasilBola);
        inputJari2 = findViewById(R.id.inputJari2);

        txtHasilBalok =findViewById(R.id.txtHasilBalok);
        inputPanjangBalok = findViewById(R.id.inputPanjangBalok);
        inputLebarBalok = findViewById(R.id.inputLebarBalok);
        inputTinggiBalok = findViewById(R.id.inputTinggiBalok);

        txtHasilTabung=findViewById(R.id.txtHasilTabung);
        inputJariTabung = findViewById(R.id.inputJariTabung);
        inputTinggiTabung = findViewById(R.id.inputTinggiTabung);

    }


    public void LPBola(View view) {
        try {
            double valueJari2 = Double.parseDouble(inputJari2.getText().toString());
            double hasil = 4 * 3.14 * (Math.pow(valueJari2,2));

            txtHasilBola.setText(Double.toString(hasil));

        } catch ( Exception e) {
            alert (" Jari - jari masih kosong ! ");
        }

    }



    public void VolBola(View view) {
        try {
            double valueJari2= Double.parseDouble(inputJari2.getText().toString());
            double hasil = (4 * 3.14 * Math.pow(valueJari2,3))/3;

            txtHasilBola.setText(Double.toString(Math.floor(hasil)));
        } catch (Exception e){
            alert("Jari - jari masih kosong !");
        }

    }

    public void LPbalok(View view) {

        try {
            double valuePanjang = Double.parseDouble(inputPanjangBalok.getText().toString());
            double valueLebar = Double.parseDouble(inputLebarBalok.getText().toString());
            double valueTinggi = Double.parseDouble(inputTinggiBalok.getText().toString());

            if (valueLebar < 5000){
                alert("Duwit Kurang bos");
            }


            double hasil = 2 * ( (valuePanjang * valueLebar) + (valuePanjang * valueTinggi) + (valueLebar * valueTinggi) ) ;

            txtHasilBalok.setText(Double.toString(hasil));

        } catch (Exception e){
            if (inputPanjangBalok.getText().toString().isEmpty()){
                alert("Panjang balok masih kosong ! ");
            } else  if (inputLebarBalok.getText().toString().isEmpty()){
                alert("Lebar balok masih kosong ! " );
            } else  if (inputTinggiBalok.getText().toString().isEmpty()){
                alert("Tinggi balok masih kosong ! ");
            }

        }
    }

    public void VolBalok(View view) {
        try {
            double valuePanjang = Double.parseDouble(inputPanjangBalok.getText().toString());
            double valueLebar = Double.parseDouble(inputLebarBalok.getText().toString());
            double valueTinggi = Double.parseDouble(inputTinggiBalok.getText().toString());

            double hasil = valuePanjang * valueLebar * valueTinggi;

            txtHasilBalok.setText(Double.toString(hasil));
        } catch (Exception e){
            if (inputPanjangBalok.getText().toString().isEmpty()){
                alert("Panjang balok masih kosong ! ");
            } else if (inputLebarBalok.getText().toString().isEmpty()){
                alert("Lebar balok masih kosong ! ");
            } else if (inputTinggiBalok.getText().toString().isEmpty()){
                alert("Tinggi balok masih kosong ! ");
            }
        }
    }

    public void LPtabung(View view) {
        try {
            double valueJari2 = Double.parseDouble(inputJariTabung.getText().toString());
            double valueTinggi = Double.parseDouble(inputTinggiTabung.getText().toString());

            double hasil = 3.14 * Math.pow(valueJari2, 2) * valueTinggi;

            txtHasilTabung.setText(Double.toString(hasil));
        } catch (Exception e) {
            if (inputJariTabung.getText().toString().isEmpty()){
                alert("Jari-jari tabung masih kosong !");
            } else if (inputTinggiTabung.getText().toString().isEmpty()){
                alert("Tinggi tabung masih kosong ! ");
            }
        }
    }

    public void VolTabung(View view) {
        try {
            double valueJari2 = Double.parseDouble(inputJariTabung.getText().toString());
            double valueTinggi = Double.parseDouble(inputTinggiTabung.getText().toString());

            double hasil = 2 * 3.14 * valueJari2 * (valueJari2 + valueTinggi);

            txtHasilTabung.setText(Double.toString(hasil));
        } catch (Exception e){
            if (inputJariTabung.getText().toString().isEmpty()){
                alert("Jari-jari tabung masih kosong ! ");
            } else if (inputTinggiTabung.getText().toString().isEmpty()){
                alert("Tinggi tabung masih kosong !");
            }
        }
    }

    private void alert(String teks_alert) {
        Toast.makeText(this,teks_alert,Toast.LENGTH_SHORT).show();
    }

}
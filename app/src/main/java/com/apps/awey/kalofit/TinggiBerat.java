package com.apps.awey.kalofit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by sabiqxs on 30/10/2017.
 */

public class TinggiBerat extends AppCompatActivity {
    String kelamin;
    int usia;
    double hasil1;
    double hasil2;
    double aktivitas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinggi_berat);
        SharedPreferences sharedPref = getSharedPreferences("file", MODE_PRIVATE);
        kelamin = sharedPref.getString("kelamin", "p");
        usia = sharedPref.getInt("usia", 10);
        aktivitas = (double) sharedPref.getFloat("aktivitas",1);

        final EditText etTinggi = (EditText) findViewById(R.id.TinggiBadan);
        final EditText etBerat = (EditText) findViewById(R.id.BeratBadan);
        //final TextView tvHasil1 = (TextView) findViewById(R.id.tv_hasil1);
        //final TextView tvHasil2 = (TextView) findViewById(R.id.tv_hasil2);
        Button bHitung = (Button) findViewById(R.id.b_hitung);
//        bHitung.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Double tinggi = Double.parseDouble(etTinggi.getText().toString());
//                Double berat  = Double.parseDouble(etBerat.getText().toString());
//                tvHasil1.setText("Kebutuhan kalori Anda ialah "+
//                        hitungBMR(tinggi,berat, usia, aktivitas)+" kkal");
//                tvHasil2.setText("BMI Anda ialah "+
//                        hitungBMI(tinggi,berat)+"");
////                Toast.makeText(getApplicationContext(),hitungBMI(tinggi, berat) + ""
////                        ,Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    private int hitungBMR(Double tinggi, Double berat, int usia, double aktivitas){
        if (kelamin.equals("p")){
            hasil1 = 66.4730 + (13.7516 * berat) + (5.0033 * tinggi) - (6.7550 * (double) usia);
        } else {
            hasil1 = 655.0955 + (9.5634 * berat) + (1.8496 * tinggi) - (4.6756 * (double) usia);
        }

        hasil1 = hasil1 * aktivitas;
        return (int) Math.round(hasil1);
    }
    private int hitungBMI(Double tinggi, Double berat){
        hasil2 = berat / Math.pow(tinggi/100, 2);
        return (int) hasil2;
    }
}

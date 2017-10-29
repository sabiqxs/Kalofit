package com.apps.awey.kalofit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

/**
 * Created by sabiqxs on 30/10/2017.
 */

public class level_aktivitas extends AppCompatActivity {
    double aktivitas;
    // int usia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_aktivitas);
        Button bnext = (Button)findViewById(R.id.b_next2);
        bnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("file", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("aktivitas",(float)aktivitas);
                editor.commit();
                Intent i = new Intent(getApplicationContext(),TinggiBerat.class);
                startActivity(i);
            }
        });


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.r_taktif:
                if (checked)
                    aktivitas=1.2;
                break;
            case R.id.r_ringan:
                if (checked)
                    aktivitas=1.375;
                break;
            case R.id.r_sedang:
                if (checked)
                    aktivitas=1.55;
                break;
            case R.id.r_berat:
                if (checked)
                    aktivitas=1.725;
                break;
            case R.id.r_sberat:
                if (checked)
                    aktivitas=1.9;
                break;


        }
    }
}

package com.apps.awey.kalofit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    String kelamin;
    // int usia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bnext = (Button)findViewById(R.id.b_next);
        final EditText etUsia = (EditText) findViewById(R.id.r_usia);
        bnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getSharedPreferences("file", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("kelamin", kelamin);
                editor.putInt("usia", Integer.parseInt(etUsia.getText().toString()));
                editor.commit();
                Intent i = new Intent(getApplicationContext(),level_aktivitas.class);
                startActivity(i);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.r_pria:
                if (checked)
                    kelamin="p";
                break;
            case R.id.r_wanita:
                if (checked)
                    kelamin="w";
                break;


        }
    }
}

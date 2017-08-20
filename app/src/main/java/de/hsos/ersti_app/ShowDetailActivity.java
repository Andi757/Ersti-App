package de.hsos.ersti_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ShowDetailActivity extends AppCompatActivity {

    Button gps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String test = getIntent().getStringExtra("taskID");
        if (test.equals("mensa")) {
            setContentView(R.layout.activity_mensa);
        }else if(test.equals("bib")){
            setContentView(R.layout.activity_bibliothek);
        }else if(test.equals("sl")){
            setContentView(R.layout.activity_sl);
        }else if(test.equals("si")){
            setContentView(R.layout.activity_si);
        }else if(test.equals("val")){
            setContentView(R.layout.activity_validierungsautomat);
        }else if(test.equals("fit")){
            setContentView(R.layout.activity_fitnessstudio);
        }else if(test.equals("bus")){
            setContentView(R.layout.activity_bushaltestelle);
        }else if(test.equals("aa")){
            setContentView(R.layout.activity_aa);
        }else if(test.equals("aula")){
            setContentView(R.layout.activity_aula);
        }else if(test.equals("sek")){
            setContentView(R.layout.activity_studiensekreteriat);
        }else {
            Toast.makeText(this, "No Layout loaded.", Toast.LENGTH_SHORT).show();
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void gps(View view){
        Intent gps = new Intent(this,MapsActivity.class);
        startActivity(gps);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}

package de.hsos.ersti_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ShowDetailActivity extends AppCompatActivity {

    Intent intent=null;
    Button gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String layout = getIntent().getStringExtra("taskID");
        super.onCreate(savedInstanceState);
        if (layout.equals("mensa")) {
            setContentView(R.layout.activity_mensa);
        }else if(layout.equals("bib")){
            setContentView(R.layout.activity_bibliothek);
        }else if(layout.equals("sl")){
            setContentView(R.layout.activity_sl);
        }else if(layout.equals("si")){
            setContentView(R.layout.activity_si);
        }else if(layout.equals("val")){
            setContentView(R.layout.activity_validierungsautomat);
        }else if(layout.equals("fit")){
            setContentView(R.layout.activity_fitnessstudio);
        }else if(layout.equals("bus")){
            setContentView(R.layout.activity_bushaltestelle);
        }else if(layout.equals("aa")){
            setContentView(R.layout.activity_aa);
        }else if(layout.equals("aula")){
            setContentView(R.layout.activity_aula);
        }else if(layout.equals("sek")){
            setContentView(R.layout.activity_studiensekreteriat);
        }else {
            Toast.makeText(this, "No Layout loaded.", Toast.LENGTH_SHORT).show();
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void mapView(View view){
        String layout = getIntent().getStringExtra("taskID");
        if (layout.equals("mensa")) {
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "mensa");
            startActivity(gps);
        }else if(layout.equals("bib")){
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "bib");
            startActivity(gps);
        }else if(layout.equals("si")){
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "si");
            startActivity(gps);
        }else if(layout.equals("sl")){
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "sl");
            startActivity(gps);
        }else if(layout.equals("aula")){
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "aula");
            startActivity(gps);
        }else if(layout.equals("bus")){
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "bus");
            startActivity(gps);
        }else if(layout.equals("aa")){
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "aa");
            startActivity(gps);
        }else if(layout.equals("val")){
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "val");
            startActivity(gps);
        }else if(layout.equals("sek")){
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "sek");
            startActivity(gps);
        }else if(layout.equals("fit")){
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "fit");
            startActivity(gps);
        }else {
            Toast.makeText(this, "No extra for GPS.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}

package de.hsos.ersti_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ShowDetailActivity extends AppCompatActivity {

    Intent intent = null;
    Button gps;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String layout = getIntent().getStringExtra("taskID");
        super.onCreate(savedInstanceState);
        if (layout.equals("mensa")) {
            setContentView(R.layout.activity_mensa);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Mensa");
            setSupportActionBar(toolbar);


            //Button um die MensaApp zu downloaden
            Button mensaButton = (Button) findViewById(R.id.button_downloadMensa);
            mensaButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uri = Uri.parse("https://play.google.com/store/apps/details?id=de.mensaplan.app.android.osnabrueck");
                    Intent mensaDownload = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(mensaDownload);
                }
            });
        } else if (layout.equals("bib")) {
            setContentView(R.layout.activity_bibliothek);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Bibliothek");
            setSupportActionBar(toolbar);
            //Button um die Bibliothek-Seite zu öffnen
            Button bibButton = (Button) findViewById(R.id.button_openBib);
            bibButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uri = Uri.parse("https://www.bib.hs-osnabrueck.de");
                    Intent bibOpen = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(bibOpen);
                }
            });
        } else if (layout.equals("sl")) {
            setContentView(R.layout.activity_sl);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("SL-Gebäude");
            setSupportActionBar(toolbar);
        } else if (layout.equals("si")) {
            setContentView(R.layout.activity_si);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("SI-Gebäude");
            setSupportActionBar(toolbar);
        } else if (layout.equals("val")) {
            setContentView(R.layout.activity_validierungsautomat);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Validierungsautomat");
            setSupportActionBar(toolbar);
        } else if (layout.equals("fit")) {
            setContentView(R.layout.activity_fitnessstudio);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Fitnessstudio");
            setSupportActionBar(toolbar);

            //Button um IN-MOVE Seite zu öffnen
            Button inMove = (Button) findViewById(R.id.button_openIN_MOVE);
            inMove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uri = Uri.parse("https://www.inapo.hs-osnabrueck.de/de/weitere-angebote/in-move/");
                    Intent InMoveOpen = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(InMoveOpen);
                }
            });
        } else if (layout.equals("bus")) {
            setContentView(R.layout.activity_bushaltestelle);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Bushaltestelle");
            setSupportActionBar(toolbar);

            //Button um VOS-Pilot zu downloaden
            Button vos_download = (Button) findViewById(R.id.button_downloadVOS);
            vos_download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    uri = Uri.parse("https://play.google.com/store/apps/details?id=de.hafas.android.vos");
                    Intent bibOpen = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(bibOpen);
                }
            });
        } else if (layout.equals("aa")) {
            setContentView(R.layout.activity_aa);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("AA-Gebäude");
            setSupportActionBar(toolbar);
        } else if (layout.equals("aula")) {
            setContentView(R.layout.activity_aula);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Aula");
            setSupportActionBar(toolbar);
        } else if (layout.equals("sek")) {
            setContentView(R.layout.activity_studiensekreteriat);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Studiensekretariat");
            setSupportActionBar(toolbar);
        } else {
            Toast.makeText(this, "No Layout loaded.", Toast.LENGTH_SHORT).show();
        }
    }

    public void mapView(View view) {
        String layout = getIntent().getStringExtra("taskID");
        if (layout.equals("mensa")) {
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "mensa");
            startActivity(gps);
        } else if (layout.equals("bib")) {
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "bib");
            startActivity(gps);
        } else if (layout.equals("si")) {
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "si");
            startActivity(gps);
        } else if (layout.equals("sl")) {
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "sl");
            startActivity(gps);
        } else if (layout.equals("aula")) {
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "aula");
            startActivity(gps);
        } else if (layout.equals("bus")) {
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "bus");
            startActivity(gps);
        } else if (layout.equals("aa")) {
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "aa");
            startActivity(gps);
        } else if (layout.equals("val")) {
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "val");
            startActivity(gps);
        } else if (layout.equals("sek")) {
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "sek");
            startActivity(gps);
        } else if (layout.equals("fit")) {
            Intent gps = new Intent(this, MapsActivity.class);
            gps.putExtra("gps", "fit");
            startActivity(gps);
        } else {
            Toast.makeText(this, "No extra for GPS.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
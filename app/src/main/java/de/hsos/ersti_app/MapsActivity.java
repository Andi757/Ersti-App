package de.hsos.ersti_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        String title = getIntent().getStringExtra("gps");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        if (title.equals("mensa")) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Mensa");
            setSupportActionBar(toolbar);
        }else if(title.equals("bib")){
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Bibliothek");
            setSupportActionBar(toolbar);
        }else if(title.equals("sl")){
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("SL-Gebäude");
            setSupportActionBar(toolbar);
        }else if(title.equals("si")){
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("SI-Gebäude");
            setSupportActionBar(toolbar);
        }else if(title.equals("val")){
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Validierungsautomat");
            setSupportActionBar(toolbar);
        }else if(title.equals("fit")){
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Fitnessstudio");
            setSupportActionBar(toolbar);
        }else if(title.equals("bus")){
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Bushaltestelle");
            setSupportActionBar(toolbar);
        }else if(title.equals("aa")){
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("AA-Gebäude");
            setSupportActionBar(toolbar);
        }else if(title.equals("aula")){
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Aula");
            setSupportActionBar(toolbar);
        }else if(title.equals("sek")){
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Studierendensekretariat");
            setSupportActionBar(toolbar);
        }else {
            Toast.makeText(this, "No Layout loaded.", Toast.LENGTH_SHORT).show();
        }
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        float zoomLevel = 16;
        LatLng mensa = new LatLng(52.28450293, 8.02225113);
        LatLng bus = new LatLng(52.28259298,8.02595794);
        LatLng bib = new LatLng(52.28615684,8.02249789);
        LatLng sl = new LatLng(52.28499517,8.02242279);
        LatLng si = new LatLng(52.2838991,8.02321672);
        LatLng fit = new LatLng(52.28678689,8.01837802);
        LatLng aa = new LatLng(52.28288177,8.02489579);
        LatLng val = new LatLng(52.28263892,8.02400529);
        LatLng sek = new LatLng(52.28254703,8.02390873);
        LatLng aula = new LatLng(52.28228449,8.02443445);
        String location = getIntent().getStringExtra("gps");

        if (location.equals("mensa")){
            mMap.addMarker(new MarkerOptions().position(mensa).title("Hier ist die Mensa!"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mensa,zoomLevel));
        }else if(location.equals("bib")){
            mMap.addMarker(new MarkerOptions().position(bib).title("Hier ist die Bibliothek!"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bib,zoomLevel));
        }else if(location.equals("bus")) {
            mMap.addMarker(new MarkerOptions().position(bus).title("Hier ist die Bushaltestelle!"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bus,zoomLevel));
        }else if(location.equals("si")) {
            mMap.addMarker(new MarkerOptions().position(si).title("Hier ist das SI-Gebäude!"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(si,zoomLevel));
        }else if(location.equals("sl")) {
            mMap.addMarker(new MarkerOptions().position(sl).title("Hier ist Das SL-Gebäude!"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sl,zoomLevel));
        }else if(location.equals("aa")) {
            mMap.addMarker(new MarkerOptions().position(aa).title("Hier ist AA-Gebäude!"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(aa,zoomLevel));
        }else if(location.equals("fit")) {
            mMap.addMarker(new MarkerOptions().position(fit).title("Hier ist das Fitnessstudio!"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fit,zoomLevel));
        }else if(location.equals("val")) {
            mMap.addMarker(new MarkerOptions().position(val).title("Hier ist der Validierungsautomat!"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(val,zoomLevel));
        }else if(location.equals("sek")) {
            mMap.addMarker(new MarkerOptions().position(sek).title("Hier ist das Studierendensekretariat!"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sek,zoomLevel));
        }else if(location.equals("aula")) {
            mMap.addMarker(new MarkerOptions().position(aula).title("Hier ist die Aula!"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(aula,zoomLevel));
        }
    }
}
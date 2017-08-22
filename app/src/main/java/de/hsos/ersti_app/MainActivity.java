package de.hsos.ersti_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static de.hsos.ersti_app.R.id.image;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Scanning fab-Button
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //onClickQR();
                Intent intent = new Intent(v.getContext(), ScannerActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onResume(){
        int fortschritt = ((MyVariable)this.getApplication()).getStudentVariable();
        if (fortschritt==0){
            ImageView testView = (ImageView)findViewById(R.id.studentView);
            testView.setImageResource(R.drawable.student_0);
            TextView testText = (TextView)findViewById(R.id.studentText);
            testText.setText("0% Fortschritt - du hast noch viel vor dir!");
        }else if(fortschritt==10) {
            ImageView testView = (ImageView)findViewById(R.id.studentView);
            testView.setImageResource(R.drawable.student_10);
            TextView testText = (TextView)findViewById(R.id.studentText);
            testText.setText("10% Fortschritt - der Anfang ist am schwersten!");
        }else if(fortschritt==20) {
            ImageView testView = (ImageView)findViewById(R.id.studentView);
            testView.setImageResource(R.drawable.student_20);
            TextView testText = (TextView)findViewById(R.id.studentText);
            testText.setText("20% Fortschritt - so langsam wird's was!");
        }else if(fortschritt==30) {
            ImageView testView = (ImageView)findViewById(R.id.studentView);
            testView.setImageResource(R.drawable.student_30);
            TextView testText = (TextView)findViewById(R.id.studentText);
            testText.setText("30% Fortschritt - Super, mach weiter so!");
        }else if(fortschritt==40) {
            ImageView testView = (ImageView)findViewById(R.id.studentView);
            testView.setImageResource(R.drawable.student_40);
            TextView testText = (TextView)findViewById(R.id.studentText);
            testText.setText("40% Fortschritt - die hälfte is bald geschafft!");
        }else if(fortschritt==50) {
            ImageView testView = (ImageView)findViewById(R.id.studentView);
            testView.setImageResource(R.drawable.student_50);
            TextView testText = (TextView)findViewById(R.id.studentText);
            testText.setText("50% Fortschritt - die hälfte ist geschafft!");
        }else if(fortschritt==60) {
            ImageView testView = (ImageView)findViewById(R.id.studentView);
            testView.setImageResource(R.drawable.student_60);
            TextView testText = (TextView)findViewById(R.id.studentText);
            testText.setText("60% Fortschritt - du bist ein Naturtalent!");
        }else if(fortschritt==70) {
            ImageView testView = (ImageView)findViewById(R.id.studentView);
            testView.setImageResource(R.drawable.student_70);
            TextView testText = (TextView)findViewById(R.id.studentText);
            testText.setText("70% Fortschritt - man kann schon fast das Ziel sehen!");
        }else if(fortschritt==80) {
            ImageView testView = (ImageView)findViewById(R.id.studentView);
            testView.setImageResource(R.drawable.student_80);
            TextView testText = (TextView)findViewById(R.id.studentText);
            testText.setText("80% Fortschritt - du schaffst das!");
        }else if(fortschritt==90) {
            ImageView testView = (ImageView)findViewById(R.id.studentView);
            testView.setImageResource(R.drawable.student_90);
            TextView testText = (TextView)findViewById(R.id.studentText);
            testText.setText("90% Fortschritt - nur noch ein Ort!");
        }else if(fortschritt==100) {
            ImageView testView = (ImageView)findViewById(R.id.studentView);
            testView.setImageResource(R.drawable.student_100);
            TextView testText = (TextView)findViewById(R.id.studentText);
            testText.setText("100% Fortschritt - du kannst stolz auf dich sein!");
        }
        super.onResume();
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.aufgaben_offen) {
            Intent aufgaben_offen = new Intent(this, OpenTasksActivity.class);
            startActivity(aufgaben_offen);
        } else if (id == R.id.apps) {
            Intent apps = new Intent(this, AppActivity.class);
            startActivity(apps);
        } else if (id == R.id.einstellungen) {
            Intent einstellungen = new Intent(this, SettingsActivity.class);
            startActivity(einstellungen);
        } else if (id == R.id.nachtleben_os) {
            Uri uri = Uri.parse("http:www.nachtleben-os.de");
            Intent www_nachtleben = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(www_nachtleben);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}

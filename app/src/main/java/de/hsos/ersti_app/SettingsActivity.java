package de.hsos.ersti_app;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Context context = getApplicationContext();

        Button btn1 = (Button) findViewById(R.id.delete_pref);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                deleteAll();
                Toast toast = Toast.makeText(context, R.string.deleted_prefs, Toast.LENGTH_LONG);
                toast.show();
                finish();
            }
        });
    }

    public void deleteAll(){
        ((MyVariable) this.getApplication()).DeleteInt();
    }
}

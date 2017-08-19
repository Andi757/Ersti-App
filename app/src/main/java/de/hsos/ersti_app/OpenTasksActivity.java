package de.hsos.ersti_app;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;


public class OpenTasksActivity extends AppCompatActivity{

    ListView simpleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_tasks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Resources r = getResources();
        String[] opentasks = r.getStringArray(R.array.app_names);

        simpleList = (ListView) findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.opentasks_list_view,R.id.textView, opentasks);
        simpleList.setAdapter(adapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String value = (String) simpleList.getItemAtPosition(position);
                Toast.makeText(OpenTasksActivity.this, "" + value, Toast.LENGTH_SHORT).show();

                Intent intent = null;
                switch (position) {
                    // Mensa
                    case 0:
                        intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    // Bibliothek
                    case 1:
                        intent = new Intent(getApplicationContext(), DoneTasksActivity.class);
                        startActivity(intent);
                        finish();
                     // SL-Gebäude
                     // SI-Gebäude
                     // Validierungsautomat
                     // Fitnessstudio
                     // Bushaltestelle
                     // AA-Gebäude
                     // Aula
                     // Studiensekreteriat

                }

                /*Intent show_detail = new Intent(view.getContext(), ShowDetailActivity.class);
                startActivity(show_detail);
                finish();*/
            }}
        );
    }
}

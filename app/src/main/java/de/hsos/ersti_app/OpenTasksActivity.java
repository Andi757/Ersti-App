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
        String[] opentasks = r.getStringArray(R.array.app_tasks);

        simpleList = (ListView) findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.opentasks_list_view,R.id.textView, opentasks);
        simpleList.setAdapter(adapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    // Mensa
                    case 0:
                        intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                        intent.putExtra("taskID", "mensa");
                        startActivity(intent);
                        break;
                    // Bibliothek
                    case 1:
                        intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                        intent.putExtra("taskID", "bib");
                        startActivity(intent);
                        break;
                     // SL-Gebäude
                    case 2:
                        intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                        intent.putExtra("taskID", "sl");
                        startActivity(intent);
                        break;
                     // SI-Gebäude
                    case 3:
                        intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                        intent.putExtra("taskID", "si");
                        startActivity(intent);
                        break;
                     // Validierungsautomat
                    case 4:
                        intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                        intent.putExtra("taskID", "val");
                        startActivity(intent);
                        break;
                    // Fitnessstudio
                    case 5:
                        intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                        intent.putExtra("taskID", "fit");
                        startActivity(intent);
                        break;
                     // Bushaltestelle
                    case 6:
                        intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                        intent.putExtra("taskID", "bus");
                        startActivity(intent);
                        break;
                     // AA-Gebäude
                    case 7:
                        intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                        intent.putExtra("taskID", "aa");
                        startActivity(intent);
                        break;
                     // Aula
                    case 8:
                        intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                        intent.putExtra("taskID", "aula");
                        startActivity(intent);
                        break;
                     // Studiensekreteriat
                    case 9:
                        intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                        intent.putExtra("taskID", "sek");
                        startActivity(intent);
                        break;

                }
            }}
        );
    }
}

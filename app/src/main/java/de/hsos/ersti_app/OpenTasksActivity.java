package de.hsos.ersti_app;

import android.app.ListActivity;
import android.content.Intent;
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
    String[] opentasks=new String[]{
            "Mensa",
            "Bibliothek",
            "SL-Gebäude",
            "SI-Gebäude",
            "Validierungsautomat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_tasks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        simpleList = (ListView) findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.opentasks_list_view,R.id.textView, opentasks);
        simpleList.setAdapter(adapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String value = (String) simpleList.getItemAtPosition(position);
                Toast.makeText(OpenTasksActivity.this, "" + value, Toast.LENGTH_SHORT).show();

                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                        startActivity(intent);
                        finish();
                        //break;
                    case 2:
                        intent = new Intent(getApplicationContext(), SettingsActivity.class);
                        startActivity(intent);
                        finish();

                }

                /*Intent show_detail = new Intent(view.getContext(), ShowDetailActivity.class);
                startActivity(show_detail);
                finish();*/
            }}
        );
    }
}

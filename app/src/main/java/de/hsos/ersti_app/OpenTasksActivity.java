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
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            int itemposition = position;

                String value =(String) simpleList.getItemAtPosition(position);
                Toast.makeText(OpenTasksActivity.this,""+value,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

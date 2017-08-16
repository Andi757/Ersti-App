package de.hsos.ersti_app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;


public class OpenTasksActivity extends AppCompatActivity{

    ListView simpleList;
    String opentasks[]={
            "Mensa",
            "Bibloothek",
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
    }

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

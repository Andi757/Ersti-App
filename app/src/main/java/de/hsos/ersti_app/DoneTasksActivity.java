package de.hsos.ersti_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DoneTasksActivity extends AppCompatActivity {

    ListView simpleList;
    String donetasks[]={
            "Fitnesstudio",
            "Bushaltestelle",
            "AA-Gebäude",
            "Aula",
            "Studiensekreteriat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done_tasks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        simpleList = (ListView) findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.donetasks_list_view,R.id.textView, donetasks);
        simpleList.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {

        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

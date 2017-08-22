package de.hsos.ersti_app;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Simon on 22.08.2017.
 */

public class DoneTasksActivity extends AppCompatActivity {
    ListView doneList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done_tasks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Set<String> myset = ((MyVariable)this.getApplication()).getCheckedList();
        String donetasks[] = myset.toArray(new String[myset.size()]);
        //String doneT[]=((MyVariable)this.getApplication()).listToString();

        doneList = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.donetasks_list_view,R.id.doneText, donetasks);
        doneList.setAdapter(adapter);

    }
}

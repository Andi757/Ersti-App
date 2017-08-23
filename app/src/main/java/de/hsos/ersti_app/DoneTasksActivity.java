package de.hsos.ersti_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;



public class DoneTasksActivity extends AppCompatActivity {
    ListView doneList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done_tasks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Set<String> myset = ((MyVariable)this.getApplication()).getCheckedList();

        //String doneT[]=((MyVariable)this.getApplication()).listToString();

        doneList = (ListView) findViewById(R.id.list_view);
        TextView emptylist = (TextView) findViewById(R.id.empty_list_view);

        if(myset == null){
            doneList.setEmptyView(emptylist);
            doneList.setVisibility(View.INVISIBLE);
            Toast toast = Toast.makeText(getApplicationContext(), "myset ist leer", Toast.LENGTH_LONG);
            toast.show();
        }else {
            String donetasks[] = myset.toArray(new String[myset.size()]);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.donetasks_list_view,R.id.doneText, donetasks);
            doneList.setAdapter(adapter);
        }

    }
}

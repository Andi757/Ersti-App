package de.hsos.ersti_app;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class OpenTasksActivity extends AppCompatActivity{

    ListView simpleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_tasks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Resources r = getResources();
        String[] opentasks = r.getStringArray(R.array.tasks);
        List<String> opentaskList = Arrays.asList(opentasks);

        Set<String> donetask = ((MyVariable) this.getApplication()).getCheckedList();
        ArrayList<String> donetaskList = new ArrayList<String>();
        if(donetask != null){
            for (String str : donetask){
                donetaskList.add(str);
            }
        }

        ArrayList<String> task = new ArrayList<String>();
        if(donetaskList != null){
            for(String str: opentaskList){
                if (!donetaskList.contains(str)){
                    task.add(str);
                }
            }
        }

        simpleList = (ListView) findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.opentasks_list_view,R.id.tasksText, task);
        simpleList.setAdapter(adapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = null;
                if (simpleList.getItemAtPosition(position).equals("Mensa")){
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "mensa");
                    startActivity(intent);
                }else if(simpleList.getItemAtPosition(position).equals("Bibliothek")){
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "bib");
                    startActivity(intent);
                }else if(simpleList.getItemAtPosition(position).equals("SL-Gebäude")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "sl");
                    startActivity(intent);
                }else if(simpleList.getItemAtPosition(position).equals("Bushaltestelle")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "bus");
                    startActivity(intent);
                }else if(simpleList.getItemAtPosition(position).equals("SI-Gebäude")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "si");
                    startActivity(intent);
                }else if(simpleList.getItemAtPosition(position).equals("Validierungsautomat")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "val");
                    startActivity(intent);
                }else if(simpleList.getItemAtPosition(position).equals("Fitnessstudio")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "fit");
                    startActivity(intent);
                }else if(simpleList.getItemAtPosition(position).equals("AA-Gebäude")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "aa");
                    startActivity(intent);
                }else if(simpleList.getItemAtPosition(position).equals("Aula")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "aula");
                    startActivity(intent);
                }else if(simpleList.getItemAtPosition(position).equals("Studierendensekretariat")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "sek");
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_done) {
            Intent intent = new Intent(getApplicationContext(), DoneTasksActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
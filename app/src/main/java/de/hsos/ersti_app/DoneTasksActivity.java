package de.hsos.ersti_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
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

        doneList = (ListView) findViewById(R.id.list_view);
        TextView emptylist = (TextView) findViewById(R.id.empty_list_view);

        if(myset == null||myset.isEmpty()){
            doneList.setEmptyView(emptylist);
            doneList.setVisibility(View.INVISIBLE);
            Toast toast = Toast.makeText(getApplicationContext(), "Keine Einträge vorhanden.", Toast.LENGTH_LONG);
            toast.show();
        }else {
            String donetasks[] = myset.toArray(new String[myset.size()]);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.donetasks_list_view,R.id.doneText, donetasks);
            doneList.setAdapter(adapter);
        }

        doneList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = null;
                if (doneList.getItemAtPosition(position).equals("Mensa")){
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "mensa");
                    startActivity(intent);
                }else if(doneList.getItemAtPosition(position).equals("Bibliothek")){
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "bib");
                    startActivity(intent);
                }else if(doneList.getItemAtPosition(position).equals("SL-Gebäude")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "sl");
                    startActivity(intent);
                }else if(doneList.getItemAtPosition(position).equals("Bushaltestelle")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "bus");
                    startActivity(intent);
                }else if(doneList.getItemAtPosition(position).equals("SI-Gebäude")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "si");
                    startActivity(intent);
                }else if(doneList.getItemAtPosition(position).equals("Validierungsautomat")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "val");
                    startActivity(intent);
                }else if(doneList.getItemAtPosition(position).equals("Fitnessstudio")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "fit");
                    startActivity(intent);
                }else if(doneList.getItemAtPosition(position).equals("AA-Gebäude")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "aa");
                    startActivity(intent);
                }else if(doneList.getItemAtPosition(position).equals("Aula")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "aula");
                    startActivity(intent);
                }else if(doneList.getItemAtPosition(position).equals("Studiensekretariat")) {
                    intent = new Intent(getApplicationContext(), ShowDetailActivity.class);
                    intent.putExtra("taskID", "sek");
                    startActivity(intent);
                }
            }
        });
    }
}
package de.hsos.ersti_app;

import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class AppActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        //TO BE DONE ---------------------------------------------------------------------->
        Button button = (Button) findViewById(R.id.button1);
        ListView lv = (ListView) findViewById(R.id.list_view);

        Context ctx = getApplicationContext();
        Resources res = ctx.getResources();

        String[] names = res.getStringArray(R.array.app_names);
        TypedArray icons = res.obtainTypedArray(R.array.app_icons);
        final String[] uris = res.getStringArray(R.array.app_uris);

        setListAdapter(new ImageAndTextAdapter(ctx, R.layout.app_item, names, icons, uris));



        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int position = (Integer)v.getTag();
                String UriString = uris[0].toString();
                Uri uri = Uri.parse(UriString);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browserIntent);
            }
        });


        /*
        //TO BE DONE ---------------------------------------------------------------------->
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String UriString = uris[position].toString();
                Uri uri = Uri.parse(UriString);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browserIntent);
            }
        });
        */


    }



}

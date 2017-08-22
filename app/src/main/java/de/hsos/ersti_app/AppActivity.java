package de.hsos.ersti_app;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class AppActivity extends AppCompatActivity {

    ListView appList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Resources res = getResources();
        String[] apps = res.getStringArray(R.array.app_names);

        appList = (ListView) findViewById(R.id.app_listView);

        appList.setAdapter(new ArrayAdapter<String>(this, R.layout.app_listview, R.id.app_textView, apps) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View row = super.getView(position, convertView, parent);
                if(getItem(position).getClass().equals("checked")){
                    row.setBackgroundColor(Color.RED);
                }
                return row;
            }
        });

        appList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                Uri uri;
                switch (position){
                    //OSCA
                    case 0:
                        uri = Uri.parse("https://play.google.com/store/apps/details?id=de.datenlotsen.campusnet.hsos");
                        intent = new Intent (Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        break;
                    //Mensaplan
                    case 1:
                        uri = Uri.parse("https://play.google.com/store/apps/details?id=de.mensaplan.app.android.osnabrueck");
                        intent = new Intent (Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        break;
                    case 2:
                        uri = Uri.parse("https://play.google.com/store/apps/details?id=de.lazyheroproductions.campuscardreader");
                        intent = new Intent (Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        break;
                    case 3:
                        uri = Uri.parse("https://play.google.com/store/apps/details?id=eu.flasskamp.hsosnabrckgebude_finder");
                        intent = new Intent (Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        break;
                    case 4:
                        uri = Uri.parse("https://play.google.com/store/apps/details?id=de.hsos.netcase.android");
                        intent = new Intent (Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        break;
                    case 5:
                        uri = Uri.parse("https://play.google.com/store/apps/details?id=de.hafas.android.vos");
                        intent = new Intent (Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        break;
                }
            }
        });
        /*
        //TO BE DONE ---------------------------------------------------------------------->

        Context ctx = getApplicationContext();
        Resources res = ctx.getResources();

        String[] names = res.getStringArray(R.array.app_names);
        TypedArray icons = res.obtainTypedArray(R.array.app_icons);

        setListAdapter(new ImageAndTextAdapter(ctx, R.layout.content_app, names, icons, uris));
        */


    }

    public void addClassChecked(ListView view, int position){

    }


}

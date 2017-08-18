package de.hsos.ersti_app;

import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

public class AppActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        Context ctx = getApplicationContext();
        Resources res = ctx.getResources();

        String[] options = res.getStringArray(R.array.app_names);
        TypedArray icons = res.obtainTypedArray(R.array.app_icons);

        setListAdapter(new ImageAndTextAdapter(ctx, R.layout.app_item, options, icons));
    }



}

package de.hsos.ersti_app;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Andrej on 18.08.2017.
 */

public class ImageAndTextAdapter extends ArrayAdapter<String> {

    private LayoutInflater mInflater;

    private String[] mStrings;
    private TypedArray mIcons;
    private String[] mUris;

    private int mViewResourceId;

    public ImageAndTextAdapter(Context ctx, int viewResourceId,String[] names, TypedArray icons) {
        super(ctx, viewResourceId, names);

        mInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mStrings = names;
        mIcons = icons;

        mViewResourceId = viewResourceId;
    }

    @Override
    public int getCount() {
        return mStrings.length;
    }

    @Override
    public String getItem(int position) {
        return mStrings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);
/*
        ImageView iv = (ImageView)convertView.findViewById(R.id.app_imageView);
        iv.setImageDrawable(mIcons.getDrawable(position));

        TextView tv = (TextView)convertView.findViewById(R.id.app_textView);
        tv.setText(mStrings[position]);
        tv.setTextColor(Color.parseColor("#000000"));
*/
        return convertView;
    }
}

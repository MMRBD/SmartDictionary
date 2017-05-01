package com.example.mokle.smartdictionary;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by mokle on 4/22/2017.
 */

public class GridAdapter extends BaseAdapter {

    private Context context;
    private String[] letterList;
    private LayoutInflater inflater;


    public GridAdapter(Context context, String[] letterList) {
        this.context = context;
        this.letterList = letterList;
    }

    @Override
    public int getCount() {
        return letterList.length;
    }

    @Override
    public Object getItem(int position) {
        return letterList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView = convertView;
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);

        int randomColor = Color.rgb(r,g,b);

        if (convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.custom_layout, null);

            gridView.setBackgroundColor(randomColor);

        }

        TextView textView = (TextView) gridView.findViewById(R.id.letterTextView);
        textView.setText(letterList[position]);

        return gridView;
    }
}

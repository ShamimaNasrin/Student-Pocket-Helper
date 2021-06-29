package com.example.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeAdapter extends BaseAdapter {
    Context home_sub_activity;
    int[] featurephotos;
    String[] featurenames;
    LayoutInflater inflater;

    public HomeAdapter(Context home_sub_activity, int[] featurephotos, String[] featurenames) {
        this.home_sub_activity = home_sub_activity;
        this.featurephotos = featurephotos;
        this.featurenames = featurenames;
    }

    @Override
    public int getCount() {
       return featurenames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            inflater = (LayoutInflater)this.home_sub_activity.getSystemService(home_sub_activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.home_sample_view
            ,viewGroup,false);
        }
        ImageView imageView =(ImageView)view.findViewById(R.id.homeImageViewID);
        TextView textView =(TextView)view.findViewById(R.id.homeTextViewID);
        imageView.setImageResource(featurephotos[i]);
        textView.setText(featurenames[i]);
        return view;
    }
}

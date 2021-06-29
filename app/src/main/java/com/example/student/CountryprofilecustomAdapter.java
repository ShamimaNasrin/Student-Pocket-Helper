package com.example.student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CountryprofilecustomAdapter extends BaseAdapter {
    Context context;
    int[] Countryphotos;
    String[] Countrynames;
    LayoutInflater inflater;

    public CountryprofilecustomAdapter(Context context, int[] countryphotos, String[] countrynames) {
        this.context = context;
        this.Countryphotos = countryphotos;
        this.Countrynames = countrynames;
    }

    @Override
    public int getCount() {
        return Countrynames.length;
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
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.countryprofile_sampleview,viewGroup,false);
        }
        ImageView imageView =(ImageView)view.findViewById(R.id.countrysampleimageviewID);
        TextView text =(TextView) view.findViewById(R.id.sampletextviewID);
        imageView.setImageResource(Countryphotos[i]);
        text.setText(Countrynames[i]);
        return view;
    }
}

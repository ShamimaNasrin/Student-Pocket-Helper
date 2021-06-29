package com.example.student;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CountryProfileActivity extends AppCompatActivity {
       ListView countrylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_profile);
        getSupportActionBar().hide();
        countrylistview = (ListView)findViewById(R.id.countrylistviewID);
        final String[] Countrynames = getResources().getStringArray(R.array.County_names);
        final String[] Countrydetails = getResources().getStringArray(R.array.County_details);
        int[] CountryFlagsPhotos = {R.drawable.bangladesh,R.drawable.india,R.drawable.pakistan,R.drawable.argentina,R.drawable.greece,R.drawable.japan};
        CountryprofilecustomAdapter CountryAdapter = new CountryprofilecustomAdapter(CountryProfileActivity.this,CountryFlagsPhotos,Countrynames);
        countrylistview.setAdapter(CountryAdapter);

        countrylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder countryAlertdialog = new AlertDialog.Builder(CountryProfileActivity.this);
                LayoutInflater inflater = LayoutInflater.from(CountryProfileActivity.this);
                View CountryAlertView = inflater.inflate(R.layout.custom_country_dialog,null);
                TextView CountryViewTV = (TextView)CountryAlertView.findViewById(R.id.customCountryTVID);
                CountryViewTV.setText(Countrydetails[i]);
                countryAlertdialog.setView(CountryAlertView);
                countryAlertdialog.create();
                countryAlertdialog.show();

            }
        });

    }
}
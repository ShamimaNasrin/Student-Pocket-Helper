package com.example.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeSubActivity extends Fragment {
    GridView gridView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View ViewOfHome = inflater.inflate(R.layout.home_layout,container,false);
        gridView = (GridView)ViewOfHome.findViewById(R.id.HomeGridViewID);
        int[] FeaturePhotos = {R.drawable.country,R.drawable.clock,R.drawable.counter,R.drawable.gallery,R.drawable.calculator,R.drawable.currency};
        String[] FeatureNames = getResources().getStringArray(R.array.Featured_name);
        HomeAdapter homeAdapter = new HomeAdapter(getActivity(),FeaturePhotos,FeatureNames);
        gridView.setAdapter(homeAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int selectedlistvalue = i;
                if(selectedlistvalue == 0){
                    Intent intent = new Intent(getActivity(),CountryProfileActivity.class);
                    startActivity(intent);
                }if(selectedlistvalue == 1){
                    Intent intent = new Intent(getActivity(), ClockActivity.class);
                    startActivity(intent);
                }if(selectedlistvalue == 2){
                    Intent intent = new Intent(getActivity(),CounterActivity.class);
                    startActivity(intent);
                }if(selectedlistvalue == 3){
                    Intent intent = new Intent(getActivity(),GalleryActivity.class);
                    startActivity(intent);
                }if(selectedlistvalue == 4){
                    Intent intent = new Intent(getActivity(),CalculatorActivity.class);
                    startActivity(intent);
                }if(selectedlistvalue == 5){
                    Intent intent = new Intent(getActivity(),CurrencyConverterActivity.class);
                    startActivity(intent);
                }
            }
        });
        return ViewOfHome;
    }
}

package com.example.student;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ZoomControls;

public class GalleryActivity extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_gallery);
        gridView = (GridView)findViewById(R.id.galleryGVID);
        final int[] galleryphotos ={R.drawable.blue,R.drawable.sunflowerone,R.drawable.daisies,R.drawable.sunflowertwo,R.drawable.pinkblossom,R.drawable.lily,R.drawable.tulip,R.drawable.purple,R.drawable.railway,R.drawable.eiffelblossom,R.drawable.santorini,R.drawable.cherryblossom};

        final GalleryAdapter galleryAdapter = new GalleryAdapter(this,galleryphotos);
        gridView.setAdapter(galleryAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder gallerydialog = new AlertDialog.Builder(GalleryActivity.this);
                LayoutInflater inflater = LayoutInflater.from(GalleryActivity.this);
                View galleryAlerview = inflater.inflate(R.layout.gallery_custom_dialog,null);
                final ImageView galleryimageview = (ImageView) galleryAlerview.findViewById(R.id.imageviewcustomID);
                ZoomControls zoomControls = (ZoomControls) galleryAlerview.findViewById(R.id.zoomcontrolID);
                zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        float x = galleryimageview.getScaleX();
                        float y = galleryimageview.getScaleY();

                        galleryimageview.setScaleX(x+1);
                        galleryimageview.setScaleY(y+1);
                    }
                });
                zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        float x = galleryimageview.getScaleX();
                        float y = galleryimageview.getScaleY();

                        if (x>1 && y>1){
                            galleryimageview.setScaleX(x-1);
                            galleryimageview.setScaleY(y-1);
                        }
                    }
                });

                galleryimageview.setImageResource(galleryphotos[i]);
                gallerydialog.setView(galleryAlerview);
                gallerydialog.create();
                gallerydialog.show();
            }
        });


    }
}
package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockActivity extends AppCompatActivity {
       TextView clocktextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_clock);
        clocktextview = (TextView) findViewById(R.id.ClockTVID);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-YYYY\nhh:mm:ss");
        String s = simpleDateFormat.format(calendar.getTime());
        clocktextview.setText(s);
    }


}
package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {
          TextView textView;
          Button countbtn,resetbtn,decrementbtn;
          int i = 0,dec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_counter);
        textView = (TextView)findViewById(R.id.textviewID);
        countbtn = (Button)findViewById(R.id.countbtnID);
        resetbtn = (Button)findViewById(R.id.resetbtnID);
        decrementbtn = (Button)findViewById(R.id.decrementbtnID);

         countbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                i = i+1;
                dec = i;
                String value = Integer.toString(i);
                textView.setText(value);
             }
         });

         resetbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 i=0;
                 textView.setText(Integer.toString(i));
             }
         });

         decrementbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
              if (dec > 0){
                  dec = dec-1;
                  i= dec;
                  String value = Integer.toString(dec);
                  textView.setText(value);
              }
             }
         });
    }
}
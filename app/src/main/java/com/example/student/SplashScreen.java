package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressBar =(ProgressBar)findViewById(R.id.Progressid);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                progressMethod();
                Intent intent = new Intent(SplashScreen.this,Login_activity.class);
                startActivity(intent);
                finish();
            }
        });
        thread.start();
    }
      private void progressMethod(){
          for (int progress = 20;progress<=100;progress=progress+20){
              try {
                  Thread.sleep(1000);
                  progressBar.setProgress(progress);
              }catch (InterruptedException e){
                  e.printStackTrace();
              }
          }

      }
}
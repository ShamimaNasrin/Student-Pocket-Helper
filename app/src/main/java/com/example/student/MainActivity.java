package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    AlertDialog.Builder exitalertdialog,logoutalertdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottombarID);

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameViewID,new HomeSubActivity()).commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                int flag = 0;
                if (menuItem.getItemId()==R.id.homeID){
                    flag =1;
                  fragment = new HomeSubActivity();
                }
                if (menuItem.getItemId()==R.id.exitID){
                    exitalertdialog = new AlertDialog.Builder(MainActivity.this);
                    exitalertdialog.setTitle("Exit");
                    exitalertdialog.setMessage("Do You Want To Exit?");
                    exitalertdialog.setIcon(R.drawable.exit);
                    exitalertdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                           finish();
                        }
                    });
                    exitalertdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog alertDialog = exitalertdialog.create();
                    alertDialog.show();
                }
                if (flag ==1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameViewID,fragment).commit();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.OptionmenuShareID){
            OptionmenuShareMethod();
        } else if (item.getItemId()==R.id.OptionmenuHelpID){
            OptionmenuHelpMethod();
        } else if (item.getItemId()==R.id.OptionmenuLogoutID){
            OptionmenuLogoutMethod();
        }
        return super.onOptionsItemSelected(item);
    }

        public void OptionmenuShareMethod(){
        AlertDialog.Builder sharealertdialog = new AlertDialog.Builder(MainActivity.this);
        sharealertdialog.setTitle("Share on");
            View Shareview = getLayoutInflater().inflate(R.layout.optionmenu_sharedialog,null);
            ImageView imgone = (ImageView) Shareview.findViewById(R.id.shareIVfacebookID);
            ImageView imgtwo = (ImageView)Shareview.findViewById(R.id.shareIVwhatsappID);
            ImageView imgthree = (ImageView) Shareview.findViewById(R.id.shareIVtwitterID);
            imgone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Shared on facebook", Toast.LENGTH_SHORT).show();
                }
            });
            imgtwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Shared on WhatsApp", Toast.LENGTH_SHORT).show();
                }
            });
            imgthree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Shared on Twitter", Toast.LENGTH_SHORT).show();
                }
            });
            sharealertdialog.setView(Shareview);
            AlertDialog alertDialog = sharealertdialog.create();
            alertDialog.show();
        }

        public void OptionmenuHelpMethod(){
         AlertDialog.Builder helpalertdialog = new AlertDialog.Builder(MainActivity.this);
            View HelpView = getLayoutInflater().inflate(R.layout.optionmenu_helpdialog,null);
            helpalertdialog.setView(HelpView);
            AlertDialog alertDialog = helpalertdialog.create();
            alertDialog.show();
        }

        public void OptionmenuLogoutMethod(){
        logoutalertdialog = new AlertDialog.Builder(MainActivity.this);
        logoutalertdialog.setTitle("Log out");
        logoutalertdialog.setMessage("Do you want to logout?");
        logoutalertdialog.setIcon(R.drawable.logout);
        logoutalertdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MainActivity.this,Login_activity.class);
                startActivity(intent);
            }
        });

        logoutalertdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
            AlertDialog alertDialog = logoutalertdialog.create();
            alertDialog.show();
        }

}
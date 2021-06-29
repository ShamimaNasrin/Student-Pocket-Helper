package com.example.student;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_activity extends AppCompatActivity {
     EditText username,password;
     Button login,signup;
     DatabaseHelper databaseHelper;
     UserDetails userDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        username =(EditText)findViewById(R.id.usernameET);
        password =(EditText)findViewById(R.id.passwordET);
        login =(Button) findViewById(R.id.loginButtonID);
        signup =(Button)findViewById(R.id.signUpButtonID);
        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        userDetails= new UserDetails();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameGiven = username.getText().toString();
                String passwordGiven = password.getText().toString();

                if(usernameGiven.equals("") && passwordGiven.equals("")){
                    Toast.makeText(Login_activity.this, "Please give username and password", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean isUpdated = databaseHelper.findPassword(usernameGiven,passwordGiven);

                    if(isUpdated == true){
                        Intent intent = new Intent(Login_activity.this,MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(Login_activity.this, "no matched", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder sighnupAlertdialog = new AlertDialog.Builder(Login_activity.this);
                LayoutInflater inflater = LayoutInflater.from(Login_activity.this);
                View signupview = inflater.inflate(R.layout.signup_custom_alertdialog,null);
                final EditText signupUsername = (EditText) signupview.findViewById(R.id.UsernameETID);
                final EditText signupPassword = (EditText) signupview.findViewById(R.id.PasswordETID);
                final EditText signupEmail = (EditText) signupview.findViewById(R.id.EmailETID);
                final EditText signupConfirmpass = (EditText) signupview.findViewById(R.id.ConfirmPassETID);
                Button signupSubmit = (Button) signupview.findViewById(R.id.SubmitbtnID);



                signupSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String username = signupUsername.getText().toString();
                        String password = signupPassword.getText().toString();
                        String ConfirmPassword = signupConfirmpass.getText().toString();

                        if(password.equals(ConfirmPassword)){
                            userDetails.setUsername(username);
                            userDetails.setPassword(password);
                            long rowID = databaseHelper.insertData(userDetails);
                            if(rowID>0){
                                Toast.makeText(Login_activity.this, "Signup successful", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(Login_activity.this, "Signup failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(Login_activity.this, "Sorry! Password is not confirmed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                sighnupAlertdialog.setView(signupview);
                sighnupAlertdialog.create();
                sighnupAlertdialog.show();

            }
        });
    }
}
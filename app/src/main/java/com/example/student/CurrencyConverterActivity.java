package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CurrencyConverterActivity extends AppCompatActivity {
    EditText amountET;
    TextView resultTV;
    Button convertbtn;
    Spinner fromspinner, tospinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_currency_converter);
        amountET = (EditText) findViewById(R.id.AmountETID);
        resultTV = (TextView) findViewById(R.id.resultTVID);
        convertbtn = (Button) findViewById(R.id.convertbtnID);
        fromspinner = (Spinner) findViewById(R.id.fromSpinnerID);
        tospinner = (Spinner) findViewById(R.id.toSpinnerID);

        String[] Fromstr = {"BDT","INR","USD"};
        String[] Tostr = {"BDT","INR","USD"};
        ArrayAdapter<String> Fromadapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, Fromstr);
        fromspinner.setAdapter(Fromadapter);
        ArrayAdapter<String> Toadapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, Tostr);
        tospinner.setAdapter(Toadapter);

        convertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast toast = Toast.makeText(CurrencyConverterActivity.this,"converted",Toast.LENGTH_SHORT);
                //toast.show();
                ResultshowMethod();
            }
        });
    }

    private void ResultshowMethod() {
        Double inputamount = Double.parseDouble(amountET.getText().toString());
        Double x;
        String fromcurrencyname = fromspinner.getSelectedItem().toString();
        String tocurrencyname = tospinner.getSelectedItem().toString();
        if (fromcurrencyname == "BDT" && tocurrencyname == "INR") {
            x = inputamount * 0.86;
            String convertedamount = Double.toString(x);
            resultTV.setText(convertedamount);
        } else if (fromcurrencyname == "BDT" && tocurrencyname == "USD") {
            x = inputamount * 0.012;
            String convertedamount = Double.toString(x);
            resultTV.setText(convertedamount);
        } else if (fromcurrencyname == "INR" && tocurrencyname == "BDT") {
            x = inputamount * 1.17;
            String convertedamount = Double.toString(x);
            resultTV.setText(convertedamount);
        } else if (fromcurrencyname == "INR" && tocurrencyname == "USD") {
            x = inputamount * 0.014;
            String convertedamount = Double.toString(x);
            resultTV.setText(convertedamount);
        } else if (fromcurrencyname == "USD" && tocurrencyname == "BDT") {
            x = inputamount * 84.59;
            String convertedamount = Double.toString(x);
            resultTV.setText(convertedamount);
        } else if (fromcurrencyname == "USD" && tocurrencyname == "INR") {
            x = inputamount * 72.44;
            String convertedamount = Double.toString(x);
            resultTV.setText(convertedamount);
          }
      }

}
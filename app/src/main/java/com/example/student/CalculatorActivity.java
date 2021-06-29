package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    EditText InputOne,InputTwo;
    TextView Answer;
    GridView OperatorGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getSupportActionBar().hide();
        InputOne = (EditText)findViewById(R.id.FirstinputETID);
        InputTwo = (EditText)findViewById(R.id.SecondinputETID);
        Answer = (TextView) findViewById(R.id.AnswerTVID);
        OperatorGV = (GridView) findViewById(R.id.calculatorGVID);

        final String[] operatorlist = getResources().getStringArray(R.array.Operator);
        ArrayAdapter<String> adapter = new ArrayAdapter(CalculatorActivity.this,R.layout.sample_listview,R.id.operatorGVTVID,operatorlist);
        OperatorGV.setAdapter(adapter);

        OperatorGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = operatorlist[i];
                Double x = Double.parseDouble(InputOne.getText().toString());
                Double y = Double.parseDouble(InputTwo.getText().toString());
                if (s == operatorlist[0]){
                    Double ans = x + y;
                    String add = Double.toString(ans);
                    Answer.setText(add);
                } else if (s == operatorlist[1]){
                    Double ans = x - y;
                    String add = Double.toString(ans);
                    Answer.setText(add);
                } else if (s == operatorlist[2]){
                    Double ans = x * y;
                    String add = Double.toString(ans);
                    Answer.setText(add);
                } else {
                    Double ans = x / y;
                    String add = Double.toString(ans);
                    Answer.setText(add);
                }
            }
        });

    }

}
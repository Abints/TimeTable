package com.example.abin.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    String day;
    EditText pd1,pd2,pd3,pd4,pd5,pd6;
    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBaseHelper=new DataBaseHelper(this);
        spinner=(Spinner)findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(this,R.array.planets_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" is selected",Toast.LENGTH_SHORT).show();
                day=parent.getItemAtPosition(position).toString();
                //Toast.makeText(MainActivity.this,day,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void addBase(View view)
    {
        String first,sec,third,fourth,fifth,sixth;
        pd1=(EditText)findViewById(R.id.p1);
        pd2=(EditText)findViewById(R.id.p2);
        pd3=(EditText)findViewById(R.id.p3);
        pd4=(EditText)findViewById(R.id.p4);
        pd5=(EditText)findViewById(R.id.p5);
        pd6=(EditText)findViewById(R.id.p6);
        first=pd1.getText().toString();
Log.e("first",first);
        sec=pd2.getText().toString();
        third=pd3.getText().toString();
        fourth=pd4.getText().toString();
        fifth=pd5.getText().toString();
        sixth=pd6.getText().toString();
        boolean isInsert=dataBaseHelper.insertData(day,first,sec,third,fourth,fifth,sixth);
        if(isInsert)
            Toast.makeText(MainActivity.this,"Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this,"not Inserted",Toast.LENGTH_LONG).show();


    }
    public void show(View view)
    {
        Intent i=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(i);
    }

}

package com.example.abin.timetable;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
DataBaseHelper dataBaseHelper=new DataBaseHelper(this);
    ListView list;
    ArrayAdapter<String>array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        showList();


    }
    public void showList()
    {
         String[] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        list=(ListView)findViewById(R.id.list);
       array=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, day);
        list.setAdapter(array);
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String days=parent.getItemAtPosition(position).toString();
                showTime(days);

                return false;
            }
        });

    }
    public void showTime(String days)
    {
        Cursor c=dataBaseHelper.showT(days);
        if(c.getCount()==0)
        {
            Toast.makeText(this,"Please insert data",Toast.LENGTH_SHORT).show();
        }
        else {
            StringBuffer str = new StringBuffer();
            str.append("Period1: " + c.getString(1) + "\n");
            str.append("period2: " + c.getString(2) + "\n");
            str.append("period3: " + c.getString(3) + "\n");
            str.append("period4: " + c.getString(4) + "\n");
            str.append("period5: " + c.getString(5) + "\n");
            str.append("period6: " + c.getString(6) + "\n");

            showmessage(days, str.toString());
        }
    }
    public void showmessage(String data,String arrays)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(data);
        builder.setMessage(arrays);
        builder.show();
    }
    public void clearData(View view)
    {
        DataBaseHelper dataBaseHelper=new DataBaseHelper(this);
        dataBaseHelper.clearAll();
    }
    public void first(View view)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}

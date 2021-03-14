package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;


public class MainActivity extends AppCompatActivity {
    GridView gridView;
    TextView textView;
    int count=1;
    String data[]={"","","","","","","","",""};
    boolean checked[]={false,false,false,false,false,false,false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridview);

        String names[]={"...","...","...","...","...","...","...","...","..."};

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.view,names);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(count%2!=0) {
                    if(!checked[position]) {
                        checked[position]=true;
                        textView = view.findViewById(R.id.text);
                        textView.setText("RED");
                        view.setBackgroundColor(Color.RED);
                        data[position] = "RED";
                        boolean won = checkPlayerOne();
                        if (won)
                            reload();
                        count++;
                        if(count>9)
                        {
                            Toast.makeText(getApplicationContext(),"MATCH DRAW",Toast.LENGTH_LONG).show();
                            reload();
                        }
                    }
                }
                else {
                    if(!checked[position]) {
                        checked[position]=true;
                        textView = view.findViewById(R.id.text);
                        textView.setText("GREEN");
                        data[position] = "GREEN";
                        view.setBackgroundColor(Color.GREEN);
                        boolean won = checkPlayerTwo();
                        if (won)
                            reload();
                        count++;
                        if(count>9)
                        {
                            Toast.makeText(getApplicationContext(),"MATCH DRAW",Toast.LENGTH_LONG).show();
                            reload();
                        }
                    }
                }
            }
        });


    }
    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }
    public boolean checkPlayerTwo()
    {
        if(data[0].equals("GREEN")&&data[1].equals("GREEN")&&data[2].equals("GREEN")){
            Toast.makeText(getApplicationContext(),"PLAYER TWO WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(data[0].equals("GREEN")&&data[3].equals("GREEN")&&data[6].equals("GREEN")){
            Toast.makeText(getApplicationContext(),"PLAYER TWO WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(data[6].equals("GREEN")&&data[7].equals("GREEN")&&data[8].equals("GREEN")){
            Toast.makeText(getApplicationContext(),"PLAYER TWO WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(data[2].equals("GREEN")&&data[5].equals("GREEN")&&data[8].equals("GREEN")) {
            Toast.makeText(getApplicationContext(),"PLAYER TWO WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(data[0].equals("GREEN")&&data[4].equals("GREEN")&&data[8].equals("GREEN")) {
            Toast.makeText(getApplicationContext(),"PLAYER TWO WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(data[2].equals("GREEN")&&data[4].equals("GREEN")&&data[6].equals("GREEN")) {
            Toast.makeText(getApplicationContext(),"PLAYER TWO WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(data[3].equals("GREEN")&&data[4].equals("GREEN")&&data[5].equals("GREEN")) {
            Toast.makeText(getApplicationContext(),"PLAYER TWO WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(data[1].equals("GREEN")&&data[4].equals("GREEN")&&data[7].equals("GREEN")) {
            Toast.makeText(getApplicationContext(),"PLAYER TWO WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else
            return false;

    }
    public boolean checkPlayerOne()
    {
        if(data[0].equals("RED")&&data[1].equals("RED")&&data[2].equals("RED")) {
            Toast.makeText(getApplicationContext(), "PLAYER ONE WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(data[0].equals("RED")&&data[3].equals("RED")&&data[6].equals("RED")) {
            Toast.makeText(getApplicationContext(), "PLAYER ONE WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(data[6].equals("RED")&&data[7].equals("RED")&&data[8].equals("RED")) {
            Toast.makeText(getApplicationContext(), "PLAYER ONE WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(data[2].equals("RED")&&data[5].equals("RED")&&data[8].equals("RED")) {
            Toast.makeText(getApplicationContext(), "PLAYER ONE WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(data[0].equals("RED")&&data[4].equals("RED")&&data[8].equals("RED")) {
            Toast.makeText(getApplicationContext(), "PLAYER ONE WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(data[2].equals("RED")&&data[4].equals("RED")&&data[6].equals("RED")) {
            Toast.makeText(getApplicationContext(), "PLAYER ONE WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(data[3].equals("RED")&&data[4].equals("RED")&&data[5].equals("RED")) {
            Toast.makeText(getApplicationContext(), "PLAYER ONE WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(data[1].equals("RED")&&data[4].equals("RED")&&data[7].equals("RED")) {
            Toast.makeText(getApplicationContext(), "PLAYER ONE WIN", Toast.LENGTH_LONG).show();
            return  true;
        }
        else
            return false;
    }

}

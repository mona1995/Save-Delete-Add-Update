package com.example.mona.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TimeMangmetnt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_mangmetnt);
    }
    public void AddDectorr(View V){

        Intent i=new Intent(this,AddDector.class);
        startActivity(i);
        finish();
    }
}

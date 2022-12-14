package com.example.pearlsociety;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import pearlsociety.R;

public class amenitiesinfo extends AppCompatActivity {
    Button bt1, bt2, bt3, bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amenitiesinfo);
    }


    public void gym(View view) {
        Intent i= new Intent(amenitiesinfo.this, com.example.pearlsociety.gym.class);
        startActivity(i);

    }

    public void clubhouse(View view) {
        Intent i= new Intent(amenitiesinfo.this,clubhouse.class);
        startActivity(i);
    }

    public void park(View view) {
        Intent i= new Intent(amenitiesinfo.this,park.class);
        startActivity(i);
    }

    public void swimmingpool(View view) {
        Intent i= new Intent(amenitiesinfo.this,swimmingpool.class);
        startActivity(i);
    }
}
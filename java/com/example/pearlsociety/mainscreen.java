package com.example.pearlsociety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import pearlsociety.R;

public class mainscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);


    }
    public void qr(View view) {
        Intent i=new Intent(mainscreen.this,payment.class);
        startActivity(i);

    }

    public void comp(View view) {
        Intent i=new Intent(mainscreen.this,complaint.class);
        startActivity(i);


    }

    public void viewcomp(View view) {
        Intent i=new Intent(mainscreen.this,viewcomplaints.class);
        startActivity(i);

    }

    public void guestvisit(View view) {
        Intent i=new Intent(mainscreen.this,guestvisitform.class);
        startActivity(i);

    }

    public void viewguestvisit(View view) {
        Intent i=new Intent(mainscreen.this,viewvisitingForm.class);
        startActivity(i);
    }

    public void viewapprovedguestvisit(View view) {
        Intent i=new Intent(mainscreen.this,approvedform.class);
        startActivity(i);
        finish();
    }
}
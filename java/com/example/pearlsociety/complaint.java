package com.example.pearlsociety;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import pearlsociety.R;

public class complaint extends AppCompatActivity {

    TextInputLayout xname, xroom, xphone, xcomplaint;
    Button b;
    FirebaseDatabase rootNode;
    String MobilePattern = "[0-9]{10}";

    String flatnopattern = "[A-Z0-9]{2,3}";
    String namepattern = "[a-zA-Z ]+";
    DatabaseReference reference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_complaint);
        b=(Button)findViewById(R.id.submit);
        xname = findViewById(R.id.name);
        xroom = findViewById(R.id.room);
        xphone = findViewById(R.id.phone);

        xcomplaint = findViewById(R.id.comp);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isConnected(complaint.this)) {
                    showcustomalert();
                }

                if (!validatename()  | !validatecompaint() | !validatephone() | !validateroom()) {
                    return;
                }

                String name = xname.getEditText().getText().toString().trim();
                String phone = xphone.getEditText().getText().toString().trim();

                String room = xroom.getEditText().getText().toString().trim();
                String complaint = xcomplaint.getEditText().getText().toString().trim();


                Date c = Calendar.getInstance().getTime();


                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                String formattedDate = df.format(c);
                String filleddate=formattedDate.toString().trim();

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

                // User does not exist. NOW call createUserWithEmailAndPassword


                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("complaint");


                Complaintuserhelperclass userhelperclass = new Complaintuserhelperclass(name, phone, room, complaint,filleddate);
                reference.child(room).setValue(userhelperclass);

                done();

            }
        });


    }








    private boolean isConnected(complaint complaint) {

        ConnectivityManager connectivityManager = (ConnectivityManager) complaint.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wificonn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileconn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wificonn != null && wificonn.isConnected()) || (mobileconn != null && mobileconn.isConnected())) {
            return true;
        } else {

            return false;
        }

    }


    private void showcustomalert() {

        AlertDialog.Builder builder = new AlertDialog.Builder(complaint.this);
        builder.setMessage("Please connect to a network")
                .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), complaint.class));
                        finish();
                    }
                }).show();


    }

    public Boolean validatename() {
        String nameval = xname.getEditText().getText().toString();
        if (nameval.isEmpty()) {
            xname.setError("Field cannot be empty");
            return false;
        } else if (!nameval.matches(namepattern)) {
            xname.setError("Invalid Format");
            return false;
        } else {
            xname.setError(null);
            return true;
        }


    }
    public Boolean validateroom(){
        String nameval = xroom.getEditText().getText().toString();
        if(nameval.isEmpty()){
            xroom.setError("Field cannot be empty");
            return false;
        } else if(!nameval.matches(flatnopattern)){
            xroom.setError("Invalid Format");
            return false;
        }

        else {
            xroom.setError(null);
            return true;
        }

    }
    public Boolean validatephone(){
        String nameval = xphone.getEditText().getText().toString();
        if(nameval.isEmpty()){
            xphone.setError("Field cannot be empty");
            return false;
        } else if(!nameval.matches(MobilePattern)){
            xphone.setError("Invalid Format");
            return false;
        }
        else {
            xphone.setError(null);
            return true;
        }

    }

    private boolean validatecompaint() {
        String nameval = xcomplaint.getEditText().getText().toString();
        if (nameval.isEmpty()) {
            xcomplaint.setError("Field cannot be empty");
            return false;

        } else {
            xcomplaint.setError(null);
            return true;
        }

    }
    public void done(){

        Toast.makeText(this,"Complent filled Successfully.......",Toast.LENGTH_LONG).show();
        Intent i=new Intent(complaint.this,login.class);
        startActivity(i);

    }



}
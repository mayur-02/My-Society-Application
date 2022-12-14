package com.example.pearlsociety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import pearlsociety.R;

public class login extends AppCompatActivity {
    TextInputLayout xflat,xpassword;
    CheckBox remember;
    Button goo;
    String FlatPattern = "[A-Z0-9]{2,3}";
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        xpassword=findViewById(R.id.password);
        xflat=findViewById(R.id.flat);
        remember=(CheckBox)findViewById(R.id.remember);
        goo=(Button)findViewById(R.id.submit);

        goo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String upassword=xpassword.getEditText().getText().toString();
                String uflat=xflat.getEditText().getText().toString();




                if(!validateFlat() | !validatepassword()){ return; }

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("register");
                Query checkuser=reference.orderByChild("room").equalTo(uflat);
                checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){

                            String Dpassword = dataSnapshot.child(uflat).child("password").getValue().toString().trim();
                            String Dname = dataSnapshot.child(uflat).child("name").getValue().toString().trim();

                            String Dstatus = dataSnapshot.child(uflat).child("status").getValue().toString().trim();

                            if(Dpassword.equals(upassword)){

                                if(remember.isChecked()){
                                    session();
                                }else { removesession();}
                                if(Dstatus.equals("0")){

                                    xpassword.getEditText().setText("");
                                    Intent i = new Intent(login.this,members_homepage.class);
                                    i.putExtra("name",Dname);
                                    startActivity(i);}
                                else if (Dstatus.equals("1")){

                                    xpassword.getEditText().setText("");
                                    Intent i = new Intent(login.this,admin_home.class);
                                    i.putExtra("name",Dname);
                                    startActivity(i);

                                    //ADMIN MODULE OR DASHBOARD


                                }


                            }
                            else {
                                passworderror();
                            }



                        }
                        else {
                            usererror();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }




        });


    }
    private void removesession() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(login.this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user","");
        editor.putString("password","");
        editor.apply();
    }

    private void session() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(login.this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",xflat.getEditText().getText().toString().trim());
        editor.putString("password",xpassword.getEditText().getText().toString().trim());
        editor.apply();

    }

    public Boolean validateFlat(){
        String nameval = xflat.getEditText().getText().toString();
        if(nameval.isEmpty()){
            xflat.setError("Field cannot be empty");
            return false;
        } else if(!nameval.matches(FlatPattern)){
            xflat.setError("Invalid Format");
            return false;
        }
        else {
            xflat.setError(null);
            return true;
        }
    }


    public Boolean validatepassword(){
        String nameval = xpassword.getEditText().getText().toString();
        if(nameval.isEmpty()){
            xpassword.setError("Field cannot be empty");
            return false;
        } else if(nameval.length() < 6){
            xpassword.setError("should be greater than 6 digits");
            return false;
        }
        else {
            xpassword.setError(null);
            return true;
        }

    }
    public void usererror(){
        Toast.makeText(this,"Please check the Flat number",Toast.LENGTH_LONG).show();
        xflat.getEditText().setText("");
        xflat.setError("Please enter correct Flat number");
        xpassword.getEditText().setText("");
    }

    public void passworderror(){
        Toast.makeText(this,"Please check the password",Toast.LENGTH_LONG).show();
        xpassword.getEditText().setText("");
        xpassword.setError("Please enter correct Password");
    }
    public void next(View v){
        Intent i=new Intent(login.this,signup.class);
        startActivity(i);
    }
}
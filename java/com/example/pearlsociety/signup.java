package com.example.pearlsociety;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pearlsociety.R;

public class signup extends AppCompatActivity {
    TextInputLayout xname,xflat,xemail,xphone,xpassword;
    Button go,loginbutton;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String MobilePattern = "[0-9]{10}";
    String roompattern = "[A-Z0-9]{2,3}";
    String namepattern = "[a-zA-Z ]+";
    final String status="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        xname=findViewById(R.id.name);
        xflat=findViewById(R.id.room);
        xemail=findViewById(R.id.email);
        xphone=findViewById(R.id.phone);
        xpassword=findViewById(R.id.password);
        go=(Button)findViewById(R.id.go);
        loginbutton=(Button)findViewById(R.id.loginbutton);
    }

    public Boolean validatename(){
        String nameval = xname.getEditText().getText().toString();
        if(nameval.isEmpty()){
            xname.setError("Field cannot be empty");
            return false;
        } else if(!nameval.matches(namepattern)){
            xname.setError("Invalid Format");
            return false;
        }
        else {
            xname.setError(null);
            return true;
        }

    }
    public Boolean validateemail(){
        String nameval = xemail.getEditText().getText().toString();
        if(nameval.isEmpty()){
            xemail.setError("Field cannot be empty");
            return false;
        } else if(!nameval.matches(emailPattern)){
            xemail.setError("Invalid Format");
            return false;
        }
        else {
            xemail.setError(null);
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
    public Boolean validateroom(){
        String nameval = xflat.getEditText().getText().toString();
        if(nameval.isEmpty()){
            xflat.setError("Field cannot be empty");
            return false;
        } else if(!nameval.matches(roompattern)){
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
    public void go(View v){


        if(!validatename() | !validateemail() | !validatepassword() | !validatephone() | !validateroom()){ return; }


        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("register").child(xflat.getEditText().getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    phoneExist();

                } else {


                    // User does not exist. NOW call createUserWithEmailAndPassword


                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("register");


                    String name, password, room, phone, email;
                    name = xname.getEditText().getText().toString();
                    password = xpassword.getEditText().getText().toString();
                    room = xflat.getEditText().getText().toString();
                    phone = xphone.getEditText().getText().toString();
                    email = xemail.getEditText().getText().toString();


                    Userhelperclass userhelperclass = new Userhelperclass(name, email, phone, password, room, status);
                    reference.child(room).setValue(userhelperclass);

                    done();

                    // Your previous code here.

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void phoneExist() {
        Toast.makeText(this,"Flat Registration ALREADY PRESENT !!",Toast.LENGTH_LONG).show();
        xphone.setError("Flat Already Present");
        xphone.getEditText().setText("");
        xname.getEditText().setText("");
        xflat.getEditText().setText("");
        xpassword.getEditText().setText("");
        xemail.getEditText().setText("");

    }

    public void done(){
        Toast.makeText(this,"Registration Done Successfully",Toast.LENGTH_LONG).show();
        Intent i=new Intent(signup.this,login.class);
        startActivity(i);
    }

    public void back(View v){
        Intent i=new Intent(signup.this,login.class);
        startActivity(i);
    }



}
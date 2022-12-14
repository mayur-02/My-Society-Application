package com.example.pearlsociety;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import pearlsociety.R;

public class addNotice extends AppCompatActivity {
TextInputLayout note;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnotice);
        note=findViewById(R.id.note);
    }
    public void addanotice(View v){
        String notice=note.getEditText().getText().toString().trim();
        Date cc = Calendar.getInstance().getTime();
        String c=cc.toString();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String formattedDate = df.format(cc);
        String filleddate=formattedDate.toString().trim();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("notice");
        noticeuserhelperclass userhelperclass = new noticeuserhelperclass(filleddate,notice,c);
        reference.child(c).setValue(userhelperclass);
        System.out.println("Done");
        done();
    }
    public void done(){
        Toast.makeText(this,"Notice Added Successfully.......",Toast.LENGTH_LONG).show();
       finish();
    }
}
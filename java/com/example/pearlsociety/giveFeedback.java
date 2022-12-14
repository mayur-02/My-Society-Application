package com.example.pearlsociety;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import pearlsociety.R;

public class giveFeedback extends AppCompatActivity {
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    EditText e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_givefeedback);
        e2=(EditText)findViewById(R.id.e2);
    }

    public void ask(View view) {
        String notice=e2.getText().toString().trim();
        Date cc = Calendar.getInstance().getTime();
        String c=cc.toString();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String formattedDate = df.format(cc);
        String filleddate=formattedDate.toString().trim();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("feedback");
        noticeuserhelperclass userhelperclass = new noticeuserhelperclass(filleddate,notice,c);
        reference.child(c).setValue(userhelperclass);
        System.out.println("Done");
        Toast.makeText(getApplicationContext(), "Feedback has been given..!!\nThankYou for your valuable time..!!", Toast.LENGTH_SHORT).show();
        finish();

    }
}
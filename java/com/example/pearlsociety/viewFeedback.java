package com.example.pearlsociety;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import pearlsociety.R;

public class viewFeedback extends AppCompatActivity  {
    RecyclerView recyclerView1;
    com.example.pearlsociety.myfirebaseadapter02 myadapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfeedback);
        recyclerView1=(RecyclerView)findViewById(R.id.recview3);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<noticeuserhelperclass> options = new FirebaseRecyclerOptions.Builder<noticeuserhelperclass>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("feedback"), noticeuserhelperclass.class)
                .build();
        myadapter1= new com.example.pearlsociety.myfirebaseadapter02(options);
        recyclerView1.setAdapter(myadapter1);

    }
    @Override
    protected void onStart() {
        super.onStart();
        myadapter1.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        myadapter1.stopListening();
    }
}
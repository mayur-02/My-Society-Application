package com.example.pearlsociety;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import pearlsociety.R;

public class viewNotice extends AppCompatActivity {
    RecyclerView recyclerView;
    com.example.pearlsociety.myfirebaseadapter01 myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewnotice);
        recyclerView=(RecyclerView)findViewById(R.id.recview2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<noticeuserhelperclass> options = new FirebaseRecyclerOptions.Builder<noticeuserhelperclass>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("notice"), noticeuserhelperclass.class)
                        .build();
        myadapter= new com.example.pearlsociety.myfirebaseadapter01(options);
        recyclerView.setAdapter(myadapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        myadapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        myadapter.stopListening();
    }
}
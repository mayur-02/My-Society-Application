package com.example.pearlsociety;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import pearlsociety.R;

public class myfirebaseadapter02 extends FirebaseRecyclerAdapter<noticeuserhelperclass, myfirebaseadapter02.myviewholder> {
    public myfirebaseadapter02(@NonNull FirebaseRecyclerOptions<noticeuserhelperclass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull noticeuserhelperclass model) {


        holder.filleddate.append(model.getFilleddate());
        holder.name.append(model.getNotice());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singledoubtrow,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView name,filleddate;
        Button approve;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.tv2);
            filleddate=(TextView)itemView.findViewById(R.id.tv1);
        }
    }

}

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import pearlsociety.R;

public class myfirebaseadapter extends FirebaseRecyclerAdapter<model,myfirebaseadapter.myviewholder> {
    public myfirebaseadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {

        holder.name.append(model.getName());
        holder.phone.append(model.getPhone());
        holder.nameofguest.append(model.getNameofguest());
        holder.noguest.append(model.getNoguest());
        holder.room.append(model.getRoom());
        holder.reason.append(model.getReason());
        holder.filleddate.append(model.getFilleddate());
        holder.lastdate.append(model.getLastdate());
        String statusno=model.getStatus();
        if(statusno.equals("APPROVED")){
            holder.approve.setText("Approved");
            holder.approve.setEnabled(false);
        }

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView name, phone, nameofguest, room, reason,filleddate,lastdate,noguest;
        Button approve;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.tv1);
            phone=(TextView)itemView.findViewById(R.id.tv2);
            nameofguest=(TextView)itemView.findViewById(R.id.tv3);
            noguest=(TextView)itemView.findViewById(R.id.tv8);
            room=(TextView)itemView.findViewById(R.id.tv4);
            reason=(TextView)itemView.findViewById(R.id.tv5);
            filleddate=(TextView)itemView.findViewById(R.id.tv6);
            lastdate=(TextView)itemView.findViewById(R.id.tv7);
            approve=(Button) itemView.findViewById(R.id.btn);
            approve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    rootNode = FirebaseDatabase.getInstance();
                    String uphone=phone.getText().toString().substring(6).trim();
                    reference = rootNode.getReference("visiting");
                    reference.child(uphone).child("status").setValue("APPROVED");

                }
            });


        }

    }
}

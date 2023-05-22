package com.example.madpractical2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
    List<User> users;

    public MyAdapter(List<User> users) {
        this.users = users;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_itms,parent,false));
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.userName.setText(users.get(position).getName());
        holder.userDesc.setText(users.get(position).getDescription());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenAlertBox(position,v);
            }
        });
    }

    private void OpenAlertBox(int position, View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setTitle("Profile");
        builder.setMessage("Name");
        builder.setCancelable(false);
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Initialize and define myIntent here
                Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(myIntent);
            }


        });
        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public int getItemCount() {
        return users.size();
    }
}

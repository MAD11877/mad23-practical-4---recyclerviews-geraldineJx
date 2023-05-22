package com.example.madpractical2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    String TITLE = "ListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.v(TITLE, "On Create!");

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        //Recyclerview
        List<User> users = new ArrayList<>();
        users.add(new User("123", "1234", null, true));
        users.add(new User("123A", "1234A", null, true));
        users.add(new User("123B", "1234B", null, true));
        users.add(new User("123C", "1234D", null, true));

        MyAdapter myAdapter = new MyAdapter(users);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);
    }
}
















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
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    String TITLE = "ListActivity";
    ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.v(TITLE, "On Create!");

        makingList(); //call to make userlist

        //Recyclerview
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        MyAdapter myAdapter = new MyAdapter(users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);
    }
    private void makingList() {
        for (int i = 0; i <= 20; i++) {
            users.add(new User("Name" + generateNum(), "Description" + generateNum()
                    , i, generateBoolen()));
        }
    }

    //Generate num for name
    private int generateNum() {
        Random ran = new Random();
        int myNumber = ran.nextInt(999999999);
        return myNumber;
    }
    public boolean generateBoolen() {
        Random rd = new Random(); // creating Random object
        boolean myBoolean = rd.nextBoolean();
        return myBoolean;
    }
}
















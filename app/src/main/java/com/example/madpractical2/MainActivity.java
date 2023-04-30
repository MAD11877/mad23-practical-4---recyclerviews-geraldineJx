package com.example.madpractical2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    final String TITLE = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TITLE, "On Create!");

        User myUser = new User();
        String name = myUser.getName();
        String description = myUser.getDescription();
        final Boolean[] followed = {myUser.getFollowed()};

        // Set the text of the follow button based on the "followed" variable
        final Button[] followButton = {findViewById(R.id.button2)};

        followButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, "Follow button is pressed");
                if (followed[0] ==false) {
                    followButton[0].setText("Unfollow");
                    followed[0] = true;
                } else {
                    followButton[0].setText("Follow");
                    followed[0] = false;
                }
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "On Start!");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TITLE, "On Pause!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TITLE, "On Resume!");

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TITLE, "On Stop!");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TITLE, "On Destroy!");
    }

}


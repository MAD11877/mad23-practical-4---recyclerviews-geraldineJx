package com.example.madpractical2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    final String TITLE = "Main Activity";
    User myUser = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TITLE, "On Create!");

        // Restore the followed state from savedInstanceState, if available
        if (savedInstanceState != null) {
            myUser = (User) savedInstanceState.get("myUser");
        }

        // Set the text of the follow button based on the "followed" variable
        final Button followButton = findViewById(R.id.button2);
        if (myUser.getFollowed()) {
            followButton.setText("Unfollow");
        } else {
            followButton.setText("Follow");
        }

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, "Follow button is pressed");
                if (followButton.getText().equals("Follow")) {
                    followButton.setText("Unfollow");
                    myUser.setFollowed(true);
                } else {
                    followButton.setText("Follow");
                    myUser.setFollowed(false);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putSerializable("myUser", myUser);
        super.onSaveInstanceState(savedInstanceState);
        Log.v(TITLE, "On SaveInstanceState!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TITLE, "On Start!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TITLE, "On Pause!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TITLE, "On Resume!");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TITLE, "On Stop!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TITLE, "On Destroy!");
    }

}


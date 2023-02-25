package com.example.cardquiz;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoggedIn extends AppCompatActivity {

    private Button playButton;    // Button object to start the game
    private Button previousScore; // Button object to show previous score

    private int oldScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        playButton = findViewById(R.id.playbutton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play = new Intent(LoggedIn.this, QuestionOne.class);
                startActivity(play);
            }
        });
        previousScore = findViewById(R.id.previousScore);

        // Retrieve the previous score from shared preferences
        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        oldScore = sharedPref.getInt("previousScore", 0);

        previousScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Start the PreviousScoreActivity to show the previous score
                Intent previousScore = new Intent(LoggedIn.this, PreviousScoreActivity.class);
                previousScore.putExtra("finalscore", oldScore);
                startActivity(previousScore);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

        // Store the previous score in shared preferences when the activity is paused
        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("finalscore", oldScore);
        editor.apply();
    }
}

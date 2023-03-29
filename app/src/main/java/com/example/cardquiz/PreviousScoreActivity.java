package com.example.cardquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PreviousScoreActivity extends AppCompatActivity {
    private Button home;
    private int previous_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_score);

        // Display the previous score in a TextView
        TextView previousScoreTextView = findViewById(R.id.textView2);

        // Get the final score from the intent
        Intent intent = getIntent();
        previous_score = intent.getIntExtra("finalscore", 0);

        // Add the final score to the previous score
        previousScoreTextView.setText("Your previous score is: " + previous_score);

        home = findViewById(R.id.resumePlay);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takeMeHome = new Intent(PreviousScoreActivity.this, LoggedIn.class);
                startActivity(takeMeHome);
            }
        });
    }
}

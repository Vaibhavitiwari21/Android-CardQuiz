package com.example.cardquiz;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalScoreActivity extends AppCompatActivity {
    private Button playAgain;
    private int finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        // Get the final score from the intent
        Intent intent = getIntent();
        finalScore = intent.getIntExtra("score", 0);

        // Display the final score in the TextView
        TextView scoreTextView = findViewById(R.id.textView3);
        scoreTextView.setText("Your final score is: " + finalScore);

        playAgain = findViewById(R.id.resumePlay);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Save the final score in SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("previousScore", finalScore);
                editor.apply();

                // Pass the new score to the LoggedIn activity
                Intent goBack = new Intent(FinalScoreActivity.this, LoggedIn.class);
                goBack.putExtra("finalscore", finalScore);
                startActivity(goBack);
            }
        });
    }

}

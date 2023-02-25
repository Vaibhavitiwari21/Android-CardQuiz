package com.example.cardquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionFive extends AppCompatActivity {
    private Button submitQ5;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_five);
        // Get the score from the previous activity
        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        submitQ5 = findViewById(R.id.btn_Q1);

        submitQ5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected answer
                RadioGroup radioGroup = findViewById(R.id.R5Q5);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedId);
                String answer = radioButton.getText().toString();

                // Check the answer and update the score
                if (answer.equals("Gravity")) {
                    score++;
                }

                // Create the confirmation dialog box
                AlertDialog.Builder builder = new AlertDialog.Builder(QuestionFive.this);
                builder.setMessage("Are you sure you want to submit your answer?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Show a small toast message based on the answer
                        if (answer.equals("Gravity")) {
                            Toast.makeText(QuestionFive.this, "Correct!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(QuestionFive.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                        }
                        // Navigate to the next activity
                        Intent answerFive = new Intent(QuestionFive.this, FinalScoreActivity.class);
                        answerFive.putExtra("score", score);
                        startActivity(answerFive);
                    }
                });
                builder.setNegativeButton("No", null);
                builder.show();
            }
        });
    }
}
package com.example.cardquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionThree extends AppCompatActivity {

    private Button submitQ3;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_three);
        // Get the score from the previous activity
        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);

        submitQ3 = findViewById(R.id.btn_Q1);

        submitQ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected answers
                CheckBox checkBox1 = findViewById(R.id.Q1A1);
                CheckBox checkBox2 = findViewById(R.id.Q1A2);
                CheckBox checkBox3 = findViewById(R.id.Q1A3);
                CheckBox checkBox4 = findViewById(R.id.Q1A4);
                boolean answer1 = checkBox1.isChecked();
                boolean answer2 = checkBox2.isChecked();
                boolean answer3 = checkBox3.isChecked();
                boolean answer4 = checkBox4.isChecked();

                // Check the answers and update the score
                if (answer1 && answer2 && answer4 && !answer3) {
                    score++;
                }

                // Create the confirmation dialog box
                AlertDialog.Builder builder = new AlertDialog.Builder(QuestionThree.this);
                builder.setMessage("Are you sure you want to submit your answer?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Show a small toast message based on the answer
                        if (answer1 && answer2 && answer4 && !answer3) {
                            Toast.makeText(QuestionThree.this, "Correct!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(QuestionThree.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                        }
                        // Navigate to the next activity
                        Intent answerThree = new Intent(QuestionThree.this, QuestionFour.class);
                        answerThree.putExtra("score", score);
                        startActivity(answerThree);
                    }
                });
                builder.setNegativeButton("No", null);
                builder.show();
            }
        });
    }
}
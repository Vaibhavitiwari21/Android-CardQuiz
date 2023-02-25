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

public class QuestionOne extends AppCompatActivity {

    private Button submitQ1;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);
        submitQ1 = findViewById(R.id.btn_Q1);

        submitQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected answer
                RadioGroup radioGroup = findViewById(R.id.R1Q1);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedId);
                String answer = radioButton.getText().toString();
                // Check the answer and update the score
                if (answer.equals("Vegan")) {
                    score++;

                }
                // Create the confirmation dialog box
                AlertDialog.Builder builder = new AlertDialog.Builder(QuestionOne.this);
                builder.setMessage("Are you sure you want to submit your answer?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Show a small toast message based on the answer
                        if (answer.equals("Vegan")) {
                            Toast.makeText(QuestionOne.this, "Correct!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(QuestionOne.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                        }
                        // Navigate to the next activity
                        Intent answerOne = new Intent(QuestionOne.this, QuestionTwo.class);
                        answerOne.putExtra("score", score);
                        startActivity(answerOne);
                    }
                });
                builder.setNegativeButton("No", null);
                builder.show();
            }
        });
    }
}

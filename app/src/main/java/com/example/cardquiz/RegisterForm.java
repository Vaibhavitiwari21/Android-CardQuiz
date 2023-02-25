package com.example.cardquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * This is the activity class for the registration form in the app.
 * It extends the AppCompatActivity class and implements the functionality to validate user inputs and
 * redirect to next activity (in this case the login page) on successful validation.
 */
public class RegisterForm extends AppCompatActivity {
    // Variables to store references to the EditText views for user input
    private EditText firstName;
    private EditText familyName;
    private EditText dateOfBirth;
    private EditText emailID;
    private EditText password;
    // Button to initiate the registration process
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);

        // Assign the EditText views to their corresponding variables
        firstName = findViewById(R.id.email);
        familyName = findViewById(R.id.pwd);
        dateOfBirth = findViewById(R.id.dob);
        emailID = findViewById(R.id.EmailAddress);
        password = findViewById(R.id.Password);

        // Assign the Register button to its corresponding variable
        registerButton = findViewById(R.id.registered);
        // Add an OnClickListener to the register button to handle user input
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call the validateInput method to verify the user's input
                if (validateInput()) {
                    Toast.makeText(RegisterForm.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent registered = new Intent();
                    setResult(RESULT_OK, registered);
                    finish();
                }
            }
        });
    }

    /**
     * This method validates the user input fields and returns a boolean indicating the success of validation.
     * @return A boolean indicating the success of input validation
     */
    private boolean validateInput() {
        String Name = firstName.getText().toString().trim();
        String lastName = familyName.getText().toString().trim();
        String dob = dateOfBirth.getText().toString().trim();
        String email = emailID.getText().toString().trim();
        String pwd = password.getText().toString().trim();

        // Check if the first name field is not empty and within the character limit (3-30 characters)
        if (TextUtils.isEmpty((CharSequence) Name) || Name.length() < 3 || Name.length() > 30) {
            firstName.setError("Enter a valid first name (3-30 characters)");
            return false;
        }

        // Check if the last name field is not empty
        if (TextUtils.isEmpty(lastName)) {
            familyName.setError("Enter a valid last name");
            return false;
        }

        if (TextUtils.isEmpty(dob) || (!dob.matches("^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/[0-9]{4}$"))) {
            dateOfBirth.setError("Enter a valid date of birth. Use MM/DD/YYYY.");
            return false;
        }

        // Check if the date of birth field is not empty and matches the expected format (MM/DD/YYYY)
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailID.setError("Enter a valid email address");
            return false;
        }

        // Check if the password field is not empty
        if (TextUtils.isEmpty(pwd)) {
            password.setError("Enter a valid password");
            return false;
        }

        return true;
    }
}

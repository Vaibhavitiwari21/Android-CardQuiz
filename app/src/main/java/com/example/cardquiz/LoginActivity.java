// This class represents the activity that is displayed after the splash screen.
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

public class LoginActivity extends AppCompatActivity {

    private EditText emailID;      // EditText object for the email input field
    private EditText password;     // EditText object for the password input field
    private Button loginButton;    // Button object for the login button
    private Button registerButton; // Button object for the register button

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize the EditText and Button objects with the corresponding UI elements
        emailID = findViewById(R.id.email);
        password = findViewById(R.id.pwd);
        loginButton = findViewById(R.id.btn_login);
        loginButton.setEnabled(false); // Disable the login button by default

        // Set an OnClickListener on the login button to check the validity of the email and password inputs
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent loggedin = new Intent(LoginActivity.this, LoggedIn.class);
                    startActivity(loggedin);
                }
            }
        });

        registerButton = findViewById(R.id.btn_register);
        // Set an OnClickListener on the register button to navigate to the RegisterForm activity
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(LoginActivity.this, RegisterForm.class);
                LoginActivity.this.startActivityForResult(register, 1);
            }
        });
    }

    // Callback method that listens for the result from the RegisterForm activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                loginButton.setEnabled(true); // Enable the login button if the registration was successful
            }
        }
    }

    // Method to validate the email and password inputs
    private boolean validateInput() {

        String email = emailID.getText().toString().trim();
        String pwd = password.getText().toString().trim();

        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailID.setError("Enter a valid email address");
            return false;
        }

        if (TextUtils.isEmpty(pwd)) {
            password.setError("Enter a valid password");
            return false;
        }

        return true;
    }
}
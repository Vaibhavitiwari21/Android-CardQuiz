/*
 This code is part of the MainActivity class in the com.example.cardquiz package.
 Import statements to access the necessary classes and interfaces from the Android framework:
*/
package com.example.cardquiz;

import androidx.appcompat.app.AppCompatActivity; // Import the AppCompatActivity class to provide a consistent user experience across all Android versions.

import android.content.Intent; // Import the Intent class to launch a new activity (LoginActivity).
import android.os.Bundle; // Import the Bundle class to pass data between activities.
import android.os.Handler; // Import the Handler class to schedule actions in the future.

// The MainActivity class extends the AppCompatActivity class and serves as the starting activity for the application.

public class MainActivity extends AppCompatActivity {
    // Define a constant integer SPLASH_LENGTH to represent the duration of the splash screen in milliseconds.
    private final int SPLASH_LENGTH = 5000;
    // Override the onCreate method to set up the MainActivity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call the onCreate method of the superclass.
        super.onCreate(savedInstanceState);
        // Set the content view of the MainActivity to the activity_main layout file.
        setContentView(R.layout.activity_main);

        // Create a new Handler object.
        new Handler().postDelayed(new Runnable() {
            // Override the run method to specify the actions to be performed after the SPLASH_LENGTH delay.
            @Override
            public void run() {
                // Create a new Intent to start the LoginActivity.
                Intent mainIntent = new Intent(MainActivity.this, LoginActivity.class);
                // Start the LoginActivity using the created Intent.
                MainActivity.this.startActivity(mainIntent);
                // Finish the MainActivity so that the user cannot go back to it using the back button.
                MainActivity.this.finish();
            }
        }, SPLASH_LENGTH);
    }
}
package com.example.wandergo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.wandergo.R;


// src/main/java/com.example.yourapp/ReviewActivity.java
import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RatingBar;
        import android.widget.Toast;

// In the ReviewActivity.java file

import android.content.Context;
import android.content.SharedPreferences;


public class ReviewActivity extends AppCompatActivity {

    private static final String PREF_NAME = "ReviewPrefs";
    private static final String PREF_KEY_RATING = "rating";
    private static final String PREF_KEY_COMMENT = "comment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        final RatingBar ratingBar = findViewById(R.id.ratingBar);
        final EditText commentEditText = findViewById(R.id.commentEditText);
        Button submitButton = findViewById(R.id.submitButton);

        // Load previously saved data
        //SharedPreferences prefs = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
       // ratingBar.setRating(prefs.getFloat(PREF_KEY_RATING, 0));
        //commentEditText.setText(prefs.getString(PREF_KEY_COMMENT, ""));

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rating = ratingBar.getRating();
                String comment = commentEditText.getText().toString();

                // Save the review data using SharedPreferences
                SharedPreferences.Editor editor = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit();
                editor.putFloat(PREF_KEY_RATING, rating);
                editor.putString(PREF_KEY_COMMENT, comment);
                editor.apply();

                // Show a toast message with the rating and comment
                String message = "Rating: " + rating + "\nComment: " + comment;
                Toast.makeText(ReviewActivity.this, message, Toast.LENGTH_SHORT).show();

                // Optionally, you can finish the activity or navigate to another screen
                finish();
            }
        });
    }
}


package com.example.wandergo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wandergo.R;

public class googleMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);
        EditText textView = findViewById(R.id.text);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = textView.getText().toString();

                if (source.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter source", Toast.LENGTH_SHORT).show();
                } else {
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/" + source);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setPackage("com.google.android.app.maps");

                    // Check if there's an app available to handle the intent
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        // If Google Maps is not available, open the map in a web browser
                        Uri webUri = Uri.parse("https://www.google.com/maps/dir/" + source);
                        Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);
                        startActivity(webIntent);
                    }
                }
            }
        });
    }
}
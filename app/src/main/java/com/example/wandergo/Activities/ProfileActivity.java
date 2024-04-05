package com.example.wandergo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.wandergo.R;

        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

        import com.example.wandergo.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Retrieve user information from SharedPreferences
//        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
//        String email = sharedPreferences.getString("email", "");
//        String name = sharedPreferences.getString("name", "");
//        String phone = sharedPreferences.getString("phone", "");

        // Display user information in TextViews
        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView phoneTextView = findViewById(R.id.phoneTextView);

//        emailTextView.setText("Email: " + email);
//        nameTextView.setText("Name: " + name);
//        phoneTextView.setText("Phone: " + phone);
//        Intent intent=getIntent();
//        String c1=intent.getStringExtra("Email").toString();
//        String c2=intent.getStringExtra("Name").toString();
//        String c3=intent.getStringExtra("Phone").toString();
//        emailTextView.setText("Email: " + c1);
//        nameTextView.setText("Name: " + c2);
//        phoneTextView.setText("Phone: " + c3);
    }
}

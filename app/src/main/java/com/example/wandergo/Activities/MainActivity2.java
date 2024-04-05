package com.example.wandergo.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wandergo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    private Button button1;
    private EditText email1,name;
    private EditText password1;
    private TextView textView1;
    private FirebaseAuth mAuth;
    private SharedPreferencesManager sharedPreferencesManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mAuth=FirebaseAuth.getInstance();
        sharedPreferencesManager = new SharedPreferencesManager(this);
        button1=findViewById(R.id.button1);
        email1=findViewById(R.id.editText1);
        password1=findViewById(R.id.password1);
        textView1=findViewById(R.id.textView1);
        name=findViewById(R.id.Uname);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent2);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();



            }
        });

        if (sharedPreferencesManager.isLoggedIn()) {
            // User is logged in, navigate to the home screen
            Intent intent = new Intent(MainActivity2.this, Login_activity.class);
            startActivity(intent);
            finish();
        }


    }

    private void userLogin() {
        String email=email1.getText().toString().trim();
        String username = name.getText().toString().trim();
        String password=password1.getText().toString().trim();
        if(email.isEmpty()){
            email1.setError("Please input Email");
            email1.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            email1.setError("Enter proper email address");
            email1.requestFocus();
            return;
        }
        if(password.isEmpty()){
            password1.setError("Please input password");
            password1.requestFocus();
            return;
        }
        if(password.length()<6){
            password1.setError("Wrong Password");
            password1.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Intent intent3=new Intent(MainActivity2.this, Login_activity.class);
                    intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent3);

                }
                else{
                    Toast.makeText(getApplicationContext(),"couldnot sign in",Toast.LENGTH_SHORT).show();
                }
            }
        });
        if (!username.isEmpty()) {
            // Save login details and navigate to the next screen
            sharedPreferencesManager.saveLoginDetails(username);

        } else {
            Toast.makeText(MainActivity2.this, "Please enter a username", Toast.LENGTH_SHORT).show();
        }
    }
}
package com.example.multigaming;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    TextView loginbutton;
    Button registerbutton;
    EditText pass ;
    EditText uemail;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        loginbutton = findViewById(R.id.loginbutton);
        pass = findViewById(R.id.pass);
        uemail = findViewById(R.id.uemail);
        registerbutton = findViewById(R.id.registerbutton);

        registerbutton.setOnClickListener((view)->{
            createUser();
        });

        loginbutton.setOnClickListener(view ->{
            Intent intent = new Intent(getApplicationContext(),SignInActivity.class);
            startActivity(intent);
        });
    }

    private void createUser(){
        String email = uemail.getText().toString();
        String password = pass.getText().toString();

        if (TextUtils.isEmpty(email)){
            uemail.setError("Email cannot be empty");
            uemail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            pass.setError("Password cannot be empty");
            pass.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),SignInActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(RegisterActivity.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}
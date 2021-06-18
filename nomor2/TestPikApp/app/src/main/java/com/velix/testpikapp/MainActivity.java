package com.velix.testpikapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnSignUp;
    EditText edtEmail, edtPass;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();
        edtEmail = findViewById(R.id.edtEmail);
        edtPass= findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        mAuth = FirebaseAuth.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    edtEmail.setError("Email Required");
                    edtEmail.requestFocus();
                } else if(TextUtils.isEmpty(pass)){
                    edtPass.setError("Password Required");
                    edtPass.requestFocus();
                }else{
                    mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(MainActivity
                                .this,"User Signup done",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(MainActivity.this,"Signup error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    edtEmail.setError("Email Required");
                    edtEmail.requestFocus();
                } else if(TextUtils.isEmpty(pass)){
                    edtPass.setError("Password Required");
                    edtPass.requestFocus();
                }else{
                    mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(MainActivity
                                        .this,"User Login done",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this,SuccessActivity.class));
                            }else {
                                Toast.makeText(MainActivity.this,"Login error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

}
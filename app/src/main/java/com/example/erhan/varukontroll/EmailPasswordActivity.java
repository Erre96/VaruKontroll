package com.example.erhan.varukontroll;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EmailPasswordActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    public User person = new User();
    public String message;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_password);
        mAuth = FirebaseAuth.getInstance();
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        setButtonText();
    }

    public void setButtonText() {
        Log.d("Anus",message);
        Button button = findViewById(R.id.proceedButton);
        if (message.equals("Sign In")) {
            button.setText(getResources().getString(R.string.signIn));
            Log.d("Anus",message);
        } else if (message.equals("Create Account")){
            button.setText(getResources().getString(R.string.createAccount));
            Log.d("Anus",message);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
       // updateUI(currentUser);
    }

    public void createAccount(String email, String password)
    {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("AccountCreation", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                          //  updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("AccountCreation", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                          //  updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void signIn(String email, String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Log in attempt", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                           // updateUI(user);
                            goToStock();
                        } else {
                            goToStock();
                            // If sign in fails, display a message to the user.
                            Log.w("Log in attempt", "signInWithEmail:failure", task.getException());
                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                           // updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void getCurrentUser()
    {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            person.setName(user.getDisplayName());
            person.setEmail(user.getEmail());
            Uri photoUrl = user.getPhotoUrl();

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            String uid = user.getUid();
        }
    }

    public void signIn() {

        EditText emailText = findViewById((R.id.email));
        EditText passwordText = findViewById((R.id.password));

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        signIn(email, password);
    }

    public void createAccount() {
        EditText emailText = findViewById((R.id.email));
        EditText passwordText = findViewById((R.id.password));

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        createAccount(email,password);
    }

    public void proceed(View v)
    {
        if(message.equals("Sign In"))
        {
            signIn();
        }

        if(message.equals("Create Account"))
        {
            createAccount();
        }
    }

    public void goToStock() {
        Intent intent = new Intent(this, ProductTypeActivity.class);
        startActivity(intent);
    }
}

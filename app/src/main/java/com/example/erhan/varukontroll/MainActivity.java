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

public class MainActivity extends AppCompatActivity {
    private static Context mContext;
    private FirebaseAuth mAuth;
    //public User person = new User();
    public static Stock stock = new Stock();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        mContext = this;
        //resetAllData below will only be used to set or restore default values on Firebase. And shall NEVER be used otherwise.
        stock.initializeData();
        //stock.resetAllData(0);
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
                            // If sign in fails, display a message to the user.
                            goToStock();
                            Log.w("Log in attempt", "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            // updateUI(null);
                        }

                        // ...
                    }
                });
    }

     void getEmailAndPassword() {

        EditText emailText = findViewById((R.id.email));
        EditText passwordText = findViewById((R.id.password));

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        signIn(email, password);
    }

    public void proceed(View v)
    {
      getEmailAndPassword();
    }

    public void goToStock() {
        Intent intent = new Intent(this, ProductTypeActivity.class);
        startActivity(intent);
    }

    public static void goToLoginActivity() {
        Intent login = new Intent(mContext, MainActivity.class);
        mContext.startActivity(login);
    }

    @Override
    public void onBackPressed() {

        return;
    }
}

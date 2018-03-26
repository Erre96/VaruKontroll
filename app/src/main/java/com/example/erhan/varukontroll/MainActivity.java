package com.example.erhan.varukontroll;

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

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public User person = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Implement the OnClickListener callback
    public void createAccount(View v) {
        Intent intent = new Intent(this, EmailPasswordActivity.class);
        String message = "Create Account";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void logIn(View v) {
        Intent intent = new Intent(this, EmailPasswordActivity.class);
        String message = "Sign In";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}


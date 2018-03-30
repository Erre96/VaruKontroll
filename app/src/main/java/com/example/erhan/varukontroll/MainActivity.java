package com.example.erhan.varukontroll;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.ArrayList;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static Stock stock = new Stock();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stock.initializeData();
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


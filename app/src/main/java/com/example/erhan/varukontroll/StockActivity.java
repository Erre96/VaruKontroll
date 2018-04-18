package com.example.erhan.varukontroll;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class StockActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public static String openCategory;
    public static String action; //Increase or Decrease

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        setStartUp();
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        getListCategory();


    }

    void getListCategory() {
        switch (openCategory) {
            case "Kött":
                createMeatList();
                break;

            case "Korv":
                createSausageList();
                break;

            case "Ost":
                createCheeseList();
                break;

            case "Såser / Dressing":
                createSauceList();
                break;

            case "Kryddor":
                createSpiceList();
                break;

            case "Bröd":
                createBreadList();
                break;

            case "Ingredienser":
                createIngredientsList();
                break;

            case "Förpackningar":
                createPackingsList();
                break;
        }
    }

    void createMeatList() {
        List<String> input = new ArrayList<>();
        List<String> q = new ArrayList<>();

        for (int i = 0; i < MainActivity.stock.meats.length; i++) {
            input.add(MainActivity.stock.meats[i].getName());
            q.add(Integer.toString(MainActivity.stock.meats[i].getQuantity()));

        }// define an adapter
        mAdapter = new MyAdapter(input, q, action);
        recyclerView.setAdapter(mAdapter);
    }

    void createSausageList() {
        List<String> input = new ArrayList<>();
        List<String> q = new ArrayList<>();
        for (int i = 0; i < MainActivity.stock.sausages.length; i++) {
            input.add(MainActivity.stock.sausages[i].getName());
            q.add(Integer.toString(MainActivity.stock.sausages[i].getQuantity()));

        }// define an adapter
        mAdapter = new MyAdapter(input, q, action);
        recyclerView.setAdapter(mAdapter);
    }

    void createCheeseList() {
        List<String> input = new ArrayList<>();
        List<String> q = new ArrayList<>();
        for (int i = 0; i < MainActivity.stock.cheeses.length; i++) {
            input.add(MainActivity.stock.cheeses[i].getName());
            q.add(Integer.toString(MainActivity.stock.cheeses[i].getQuantity()));

        }// define an adapter
        mAdapter = new MyAdapter(input, q, action);
        recyclerView.setAdapter(mAdapter);
    }


    void createSauceList() {
        List<String> input = new ArrayList<>();
        List<String> q = new ArrayList<>();
        for (int i = 0; i < MainActivity.stock.sauces.length; i++) {
            input.add(MainActivity.stock.sauces[i].getName());
            q.add(Integer.toString(MainActivity.stock.sauces[i].getQuantity()));

        }// define an adapter
        mAdapter = new MyAdapter(input, q, action);
        recyclerView.setAdapter(mAdapter);
    }

    void createSpiceList() {
        List<String> input = new ArrayList<>();
        List<String> q = new ArrayList<>();
        for (int i = 0; i < MainActivity.stock.spices.length; i++) {
            input.add(MainActivity.stock.spices[i].getName());
            q.add(Integer.toString(MainActivity.stock.spices[i].getQuantity()));

        }// define an adapter
        mAdapter = new MyAdapter(input, q, action);
        recyclerView.setAdapter(mAdapter);
    }

    void createBreadList() {
        List<String> input = new ArrayList<>();
        List<String> q = new ArrayList<>();
        for (int i = 0; i < MainActivity.stock.breads.length; i++) {
            input.add(MainActivity.stock.breads[i].getName());
            q.add(Integer.toString(MainActivity.stock.breads[i].getQuantity()));

        }// define an adapter
        mAdapter = new MyAdapter(input, q, action);
        recyclerView.setAdapter(mAdapter);
    }

    void createIngredientsList() {
        List<String> input = new ArrayList<>();
        List<String> q = new ArrayList<>();
        for (int i = 0; i < MainActivity.stock.ingredients.length; i++) {
            input.add(MainActivity.stock.ingredients[i].getName());
            q.add(Integer.toString(MainActivity.stock.ingredients[i].getQuantity()));

        }// define an adapter
        mAdapter = new MyAdapter(input, q, action);
        recyclerView.setAdapter(mAdapter);
    }

    void createPackingsList() {
        List<String> input = new ArrayList<>();
        List<String> q = new ArrayList<>();
        for (int i = 0; i < MainActivity.stock.packings.length; i++) {
            input.add(MainActivity.stock.packings[i].getName());
            q.add(Integer.toString(MainActivity.stock.packings[i].getQuantity()));

        }// define an adapter
        mAdapter = new MyAdapter(input, q, action);
        recyclerView.setAdapter(mAdapter);
    }


    public static void refreshMeatListFirebase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Stock");
        DatabaseReference myRef2 = myRef.child("Meat");
        for (int i = 0; i < MainActivity.stock.meats.length; i++) {
            DatabaseReference myRef3 = myRef2.child(MainActivity.stock.meats[i].getName());
            myRef3.child("Quantity").setValue(MainActivity.stock.meats[i].getQuantity());
            myRef3.child("Varning").setValue(MainActivity.stock.meats[i].getVarningValue());
        }
    }

    public static void refreshSausageList() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Stock");
        DatabaseReference myRef2 = myRef.child("Korv");
        for (int i = 0; i < MainActivity.stock.sausages.length; i++) {
            DatabaseReference myRef3 = myRef2.child(MainActivity.stock.sausages[i].getName());
            myRef3.child("Quantity").setValue(MainActivity.stock.sausages[i].getQuantity());
            myRef3.child("Varning").setValue(MainActivity.stock.sausages[i].getVarningValue());
        }
    }

    public static void refreshCheeseList() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Stock");
        DatabaseReference myRef2 = myRef.child("Ost");
        for (int i = 0; i < MainActivity.stock.cheeses.length; i++) {
            DatabaseReference myRef3 = myRef2.child(MainActivity.stock.cheeses[i].getName());
            myRef3.child("Quantity").setValue(MainActivity.stock.cheeses[i].getQuantity());
            myRef3.child("Varning").setValue(MainActivity.stock.cheeses[i].getVarningValue());
        }
    }

    public void setIncrease(View v) {

        Button incButton = findViewById(R.id.increaseButton);
        Button decButton = findViewById(R.id.decreaseButton);

        incButton.setTextColor(Color.WHITE);
        decButton.setTextColor(Color.BLACK);
        action = "Öka";
        getListCategory();
    }


    public void setDecrease(View v) {

        Button incButton = findViewById(R.id.increaseButton);
        Button decButton = findViewById(R.id.decreaseButton);

        incButton.setTextColor(Color.BLACK);
        decButton.setTextColor(Color.WHITE);

        action = "Minska";
        getListCategory();
    }

    public void setStartUp()
    {
        Button incButton = findViewById(R.id.increaseButton);
        Button decButton = findViewById(R.id.decreaseButton);

        incButton.setTextColor(Color.BLACK);
        decButton.setTextColor(Color.WHITE);

        action = "Minska";

    }
}
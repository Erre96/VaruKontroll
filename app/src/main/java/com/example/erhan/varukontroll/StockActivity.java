package com.example.erhan.varukontroll;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.design.widget.TabItem;
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

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        getFirebaseData();
        String a = Integer.toString(MainActivity.stock.meats[0].getQuantity());
        Log.d("motherfucker",a);
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
        //getListCategory();
        Log.d("motherfucker",a);
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


    public static void refreshFirebaseData(String name, String number) {
        Log.d("viktigt",name+"  "+number);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Stock").child(StockActivity.openCategory);
        DatabaseReference myRef2 = myRef.child(name).child("Antal");
        myRef2.setValue(number);

    }

    public static void uploadStockToFirebase() {
        //Just to get the class template up to Firebase quick, and to set default values, or restore them
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference meatRef = database.getReference("Stock").child("Kött");
        DatabaseReference sausageRef = database.getReference("Stock").child("Korv");
        DatabaseReference cheeseRef = database.getReference("Stock").child("Ost");
        DatabaseReference sauceRef = database.getReference("Stock").child("Såser");
        DatabaseReference breadRef = database.getReference("Stock").child("Bröd");
        DatabaseReference spiceRef = database.getReference("Stock").child("Krydda");
        DatabaseReference ingredientsRef = database.getReference("Stock").child("Ingredienser");
        DatabaseReference packingsRef = database.getReference("Stock").child("Förpackningar");


        for (int i = 0; i < MainActivity.stock.meats.length; i++)
        {
            String loc = MainActivity.stock.meats[i].getName();
            DatabaseReference locRef = meatRef.child(loc).child("Antal");
            DatabaseReference locRef2 = meatRef.child(loc).child("Namn");
            locRef.setValue(3);
            locRef2.setValue(MainActivity.stock.meats[i].getName());
        }

        for (int i = 0; i < MainActivity.stock.sausages.length; i++)
        {
            String loc = MainActivity.stock.sausages[i].getName();
            DatabaseReference locRef = sausageRef.child(loc).child("Antal");
            DatabaseReference locRef2 = sausageRef.child(loc).child("Namn");
            locRef.setValue(3);
            locRef2.setValue(MainActivity.stock.sausages[i].getName());
        }

        for (int i = 0; i < MainActivity.stock.cheeses.length; i++)
        {
            String loc = MainActivity.stock.cheeses[i].getName();
            DatabaseReference locRef = cheeseRef.child(loc).child("Antal");
            DatabaseReference locRef2 = cheeseRef.child(loc).child("Namn");
            locRef.setValue(3);
            locRef2.setValue(MainActivity.stock.cheeses[i].getName());
        }

        for (int i = 0; i < MainActivity.stock.sauces.length; i++)
        {
            String loc = MainActivity.stock.sauces[i].getName();
            DatabaseReference locRef = sauceRef.child(loc).child("Antal");
            DatabaseReference locRef2 = sauceRef.child(loc).child("Namn");
            locRef.setValue(3);
            locRef2.setValue(MainActivity.stock.sauces[i].getName());
        }

        for (int i = 0; i < MainActivity.stock.breads.length; i++)
        {
            String loc = MainActivity.stock.breads[i].getName();
            DatabaseReference locRef = breadRef.child(loc).child("Antal");
            DatabaseReference locRef2 = breadRef.child(loc).child("Namn");
            locRef.setValue(3);
            locRef2.setValue(MainActivity.stock.breads[i].getName());
        }

        for (int i = 0; i < MainActivity.stock.spices.length; i++)
        {
            String loc = MainActivity.stock.spices[i].getName();
            DatabaseReference locRef = spiceRef.child(loc).child("Antal");
            DatabaseReference locRef2 = spiceRef.child(loc).child("Namn");
            locRef.setValue(3);
            locRef2.setValue(MainActivity.stock.spices[i].getName());
        }

        for (int i = 0; i < MainActivity.stock.ingredients.length; i++)
        {
            String loc = MainActivity.stock.ingredients[i].getName();
            DatabaseReference locRef = ingredientsRef.child(loc).child("Antal");
            DatabaseReference locRef2 = ingredientsRef.child(loc).child("Namn");
            locRef.setValue(3);
            locRef2.setValue(MainActivity.stock.ingredients[i].getName());
        }

        for (int i = 0; i < MainActivity.stock.packings.length; i++)
        {
            String loc = MainActivity.stock.packings[i].getName();
            DatabaseReference locRef = packingsRef.child(loc).child("Antal");
            DatabaseReference locRef2 = packingsRef.child(loc).child("Namn");
            locRef.setValue(3);
            locRef2.setValue(MainActivity.stock.packings[i].getName());
        }
    }

    public void setIncrease(View v) {

        TabItem incButton = findViewById(R.id.increaseButton);
        TabItem decButton = findViewById(R.id.decreaseButton);

       // incButton.setTextColor(Color.WHITE);
       // decButton.setTextColor(Color.BLACK);
        action = "Öka";
        getListCategory();
    }


    public void setDecrease(View v) {

        TabItem incButton = findViewById(R.id.increaseButton);
        TabItem decButton = findViewById(R.id.decreaseButton);

       // incButton.setTextColor(Color.BLACK);
       // decButton.setTextColor(Color.WHITE);

        action = "Minska";
        getListCategory();
    }

    public void setStartUp()
    {
        TabItem incButton = findViewById(R.id.increaseButton);
        TabItem decButton = findViewById(R.id.decreaseButton);

        //incButton.setTextColor(Color.BLACK);
        //decButton.setTextColor(Color.WHITE);

        action = "Minska";
    }

    public void getFirebaseData()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mRef = database.getReference("Stock").child(openCategory);

        final List<String> stockValues;
        final List<String> nameValues;

        stockValues = new ArrayList();
        nameValues = new ArrayList();

            mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot stockSnapshot : dataSnapshot.getChildren())
                    {
                        String name = (stockSnapshot.child("Namn").getValue().toString());
                        String value = (stockSnapshot.child("Antal").getValue().toString());
                        stockValues.add(value);
                        nameValues.add(name);
                    }
                    //setFirebaseDataToStock(stockValues);
                    mAdapter = new MyAdapter(nameValues, stockValues, action);
                    recyclerView.setAdapter(mAdapter);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
package com.example.erhan.varukontroll;

import android.content.ClipData;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class StockActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public static String openCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        getListCategory(openCategory);



    }

    void getListCategory(String o)
    {
        o = openCategory;
        switch (o){
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

    void createMeatList()
    {
        List<String> input = new ArrayList<>();
        for (int i = 0; i < MainActivity.stock.meats.length; i++) {
            input.add(MainActivity.stock.meats[i].getName()+"   x "+MainActivity.stock.meats[i].getQuantity());
        }// define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }

    void createSausageList()
    {
        List<String> input = new ArrayList<>();
        for (int i = 0; i < MainActivity.stock.sausages.length; i++) {
            input.add(MainActivity.stock.sausages[i].getName()+"   x "+MainActivity.stock.sausages[i].getQuantity());
        }// define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }

    void createCheeseList()
    {
        List<String> input = new ArrayList<>();
        for (int i = 0; i < MainActivity.stock.cheeses.length; i++) {
            input.add(MainActivity.stock.cheeses[i].getName()+"   x "+MainActivity.stock.cheeses[i].getQuantity());
        }// define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }


    void createSauceList()
    {
        List<String> input = new ArrayList<>();
        for (int i = 0; i < MainActivity.stock.sauces.length; i++) {
            input.add(MainActivity.stock.sauces[i].getName()+"   x "+MainActivity.stock.sauces[i].getQuantity());
        }// define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }

    void createSpiceList()
    {
        List<String> input = new ArrayList<>();
        for (int i = 0; i < MainActivity.stock.spices.length; i++) {
            input.add(MainActivity.stock.spices[i].getName()+"   x "+MainActivity.stock.spices[i].getQuantity());
        }// define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }

    void createBreadList()
    {
        List<String> input = new ArrayList<>();
        for (int i = 0; i < MainActivity.stock.breads.length; i++) {
            input.add(MainActivity.stock.breads[i].getName()+"   x "+MainActivity.stock.breads[i].getQuantity());
        }// define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }

    void createIngredientsList()
    {
        List<String> input = new ArrayList<>();
        for (int i = 0; i < MainActivity.stock.ingredients.length; i++) {
            input.add(MainActivity.stock.ingredients[i].getName()+"   x "+MainActivity.stock.ingredients[i].getQuantity());
        }// define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }

    void createPackingsList()
    {
        List<String> input = new ArrayList<>();
        for (int i = 0; i < MainActivity.stock.packings.length; i++) {
            input.add(MainActivity.stock.packings[i].getName()+"   x "+MainActivity.stock.packings[i].getQuantity());
        }// define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }


    public void Add(View v) {
        MainActivity.stock.meats[6].addOne();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Stock");
        DatabaseReference myRef2 = myRef.child("Meat");
        DatabaseReference myRef3 = myRef2.child(MainActivity.stock.meats[6].getName());
        myRef3.child("Quantity").setValue(MainActivity.stock.meats[6].getQuantity());
        myRef3.child("Varning").setValue(MainActivity.stock.meats[6].getVarningValue());
    }
}
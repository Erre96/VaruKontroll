package com.example.erhan.varukontroll;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ProductTypeActivity extends AppCompatActivity {
    /*
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;*/
    private String[] categories = new String[8];

    private Button meatButton;
    private Button sausageButton;
    private Button cheeseButton;
    private Button breadButton;
    private Button sauceButton;
    private Button spiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_type);

        setButtons();

        /*setCategories();


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<String> input = new ArrayList<>();
        for (int i = 0; i < categories.length; i++) {
            input.add(categories[i]);
        }// define an adapter
        mAdapter = new CategoryAdapter(input);
        recyclerView.setAdapter(mAdapter);*/
    }

    void setCategories()
    {
        categories[0] = "Kött";        categories[4] = "Bröd";
        categories[1] = "Korv";        categories[5] = "Kryddor";
        categories[2] = "Ost";        categories[6] = "Ingredienser";
        categories[3] = "Såser / Dressing"; categories[7] = "Förpackningar";

    }

    void setButtons()
    {
        meatButton = findViewById(R.id.meatPic);
        sausageButton = findViewById(R.id.sausagePic);
        cheeseButton = findViewById(R.id.cheesePic);
        sauceButton = findViewById(R.id.saucePic);
        breadButton = findViewById(R.id.breadPic);
        //spiceButton = findViewById(R.id.spicePic);
    }

    public void openMeatCategory(View v) {
        StockActivity.openCategory = "Kött";
        Intent intent = new Intent(this, StockActivity.class);
        startActivity(intent);
    }
    public void openSausageCategory(View v) {
        StockActivity.openCategory = "Korv";
        Intent intent = new Intent(this, StockActivity.class);
        startActivity(intent);
    }

    public void openCheeseCategory(View v) {
        StockActivity.openCategory = "Ost";
        Intent intent = new Intent(this, StockActivity.class);
        startActivity(intent);
    }
    public void openBreadCategory(View v) {
        StockActivity.openCategory = "Bröd";
        Intent intent = new Intent(this, StockActivity.class);
        startActivity(intent);
    }

    public void openSauceCategory(View v) {
        StockActivity.openCategory = "Såser / Dressing";
        Intent intent = new Intent(this, StockActivity.class);
        startActivity(intent);
    }
    public void openSpiceCategory(View v) {
        StockActivity.openCategory = "Kryddor";
        Intent intent = new Intent(this, StockActivity.class);
        startActivity(intent);
    }

}

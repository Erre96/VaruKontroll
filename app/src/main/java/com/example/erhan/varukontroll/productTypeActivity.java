package com.example.erhan.varukontroll;

/**
 * Created by Erhan on 2018-04-03.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ProductTypeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    public static String[] categories = new String[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_type);
        setCategories();

        recyclerView = findViewById(R.id.my_recycler_view);
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
        recyclerView.setAdapter(mAdapter);

        final ImageView logOutIcon = findViewById(R.id.logOutButton);
        logOutIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.goToLoginActivity();
            }
        });
    }

    void setCategories() {
        categories[0] = "Kött";
        categories[1] = "Korv";
        categories[2] = "Ost";
        categories[3] = "Såser";
        categories[4] = "Bröd";
        categories[5] = "Kryddor";
        categories[6] = "Ingredienser";
        categories[7] = "Förpackningar";
        categories[8] = "Allt med 0-1";

    }
}
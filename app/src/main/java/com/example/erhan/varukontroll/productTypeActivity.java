package com.example.erhan.varukontroll;

/**
 * Created by Erhan on 2018-04-03.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

public class ProductTypeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] categories = new String[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_type);
        setCategories();

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
        recyclerView.setAdapter(mAdapter);
    }

    void setCategories() {
        categories[0] = "Kött";
        categories[4] = "Bröd";
        categories[1] = "Korv";
        categories[5] = "Kryddor";
        categories[2] = "Ost";
        categories[6] = "Ingredienser";
        categories[3] = "Såser / Dressing";
        categories[7] = "Förpackningar";

    }
}
package com.example.erhan.varukontroll;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StockActivity extends AppCompatActivity {
    public static String openCategory;

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new RemoveProductFragment(), "Minska");
        viewPagerAdapter.addFragments(new AddProductFragment(), "Öka");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        final ImageView logOutIcon = findViewById(R.id.logOutButton);
        logOutIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.goToLoginActivity();
            }
        });
    }


    public static void refreshFirebaseData(String name, String number) {
        //Log.d("viktigt", name + "  " + number);
        //name is the corresponding products name, and number is it's value
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        if (!openCategory.equals(ProductTypeActivity.categories[8]))
        {
            DatabaseReference myRefQuantity = database.getReference("Stock").child(StockActivity.openCategory).child(name).child("Antal");
            myRefQuantity.setValue(number);
        }

        else if (openCategory.equals(ProductTypeActivity.categories[8])) //Low value section
        {
            for(int i = 0; i < LowStockOnlyActivity.categories.size(); i++)
            {
                if(name.equals(LowStockOnlyActivity.names.get(i)))
                {
                    String category = LowStockOnlyActivity.categories.get(i);
                    DatabaseReference myRefQuantity = database.getReference("Stock").child(category).child(name).child("Antal");
                    myRefQuantity.setValue(number);

                }
            }
        }
    }
}
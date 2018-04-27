package com.example.erhan.varukontroll;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LowStockOnlyActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public static List<String> categories = new ArrayList<>();
    final static List<String> names = new ArrayList<>();
    final static List<String> values = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_stock_only);

        recyclerView = findViewById(R.id.my_recycler_view);
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        getFireBaseData();

        final ImageView logOutIcon = findViewById(R.id.logOutButton);
        logOutIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.goToLoginActivity();
            }
        });
    }


    //Adds item to the lists if it is low in stock
    public void getFireBaseData() {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        final DatabaseReference databaseReference = database.getReference("Stock");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot stockSnapShot) {

                names.clear();
                values.clear();
                categories.clear();
                for (int i = 0; i < ProductTypeActivity.categories.length; i++) {
                    String category = ProductTypeActivity.categories[i];
                    List<String> items = MainActivity.stock.getListNames(i);

                    for(int j = 0; j < items.size(); j++)
                    {
                        //Log.d("hejhej",databaseReference.child(category).child(items.get(j)).toString());
                        String name = (stockSnapShot.child(category).child(items.get(j)).child("Namn").getValue().toString());
                        String value = (stockSnapShot.child(category).child(items.get(j)).child("Antal").getValue().toString());
                        int valueInt = Integer.parseInt(value);

                        if (valueInt <= 1)
                        {
                            names.add(name);
                            values.add(value);
                            categories.add(category);
                        }
                    }
                }
                mAdapter = new MyAdapter(names, values, "Öka");
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}

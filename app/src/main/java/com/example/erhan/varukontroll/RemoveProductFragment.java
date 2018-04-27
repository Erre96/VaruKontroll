package com.example.erhan.varukontroll;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RemoveProductFragment extends Fragment {
    RecyclerView rv;
    RecyclerView.Adapter mAdapter;

    public RemoveProductFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_remove_product, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        rv = view.findViewById(R.id.my_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        rv.setLayoutManager(linearLayoutManager);
        getFirebaseData();
    }

    public void getFirebaseData()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mRefRealTime = database.getReference("Stock").child(StockActivity.openCategory);

        final List<String> stockValues = new ArrayList<>();
        final List<String> nameValues = new ArrayList<>();

        mRefRealTime.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                stockValues.clear();
                nameValues.clear();
                for(DataSnapshot stockSnapshot : dataSnapshot.getChildren())
                {
                    String name = (stockSnapshot.child("Namn").getValue().toString());
                    String value = (stockSnapshot.child("Antal").getValue().toString());
                    stockValues.add(value);
                    nameValues.add(name);
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mAdapter = new MyAdapter(nameValues, stockValues, "Minska");
        rv.setAdapter(mAdapter);
    }
}
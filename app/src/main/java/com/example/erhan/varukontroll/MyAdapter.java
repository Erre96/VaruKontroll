package com.example.erhan.varukontroll;

/**
 * Created by Erhan on 2018-03-30.
 */

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
//import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> values;
    private List<String> quantity;
    private String actionText;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public RelativeLayout rel;
        public TextView txtHeader;
        public TextView txtFooter;
        public Button actionButton;
        public EditText inputX;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = v.findViewById(R.id.firstLine);
            txtFooter = v.findViewById(R.id.secondLine);
            rel = v.findViewById(R.id.rel);
            actionButton = v.findViewById(R.id.actionButton);
            inputX = v.findViewById(R.id.inputX);
        }
    }

    public void add(int position, String item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<String> myDataset, List<String> q, String act) {
        values = myDataset;
        quantity = q;
        actionText = act;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int i) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final String name = values.get(i);
        final String num = quantity.get(i);
        //Log.d("nameValue ",values.get(i)+"   "+i);

        holder.txtHeader.setText(name);
        holder.txtFooter.setText(num);
        holder.actionButton.setText(actionText);

        //sets color
        int x = Integer.parseInt(quantity.get(i).toString());

        if(x >= 2)
        {
            holder.rel.setBackgroundColor(Color.parseColor("#1565C0"));
            //holder.rel.setBackgroundColor(0xffff0000);
            //holder.rel.setBackgroundColor(Color.rgb(100,0,0));
        }

        if(x <= 1)
        {
            holder.rel.setBackgroundColor(Color.parseColor("#C62828"));
            //holder.rel.setBackgroundColor(Color.rgb(0,0,100));
            //holder.rel.setBackgroundColor(0xff0000ff);
        }



        holder.actionButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("asshole",holder.inputX.gette);
                String number = "";
                if(holder.inputX.getText().toString().equals(""))
                {
                    if(StockActivity.action == "Öka")
                    {
                        number = increaseValue (holder.txtHeader.getText().toString(),holder.txtFooter.getText().toString(),1);
                    }
                    else
                    //number = decreaseStock(i,1, holder.txtHeader.getText().toString());
                       number = decreaseValue(holder.txtHeader.getText().toString(), holder.txtFooter.getText().toString(),1);
                }
               else
                {
                    int x = Integer.parseInt(holder.inputX.getText().toString());
                    if(StockActivity.action == "Öka")
                    {
                        number = increaseValue (holder.txtHeader.getText().toString(),holder.txtFooter.getText().toString(),x);
                    }
                    else
                        //number = decreaseStock(i,x,holder.txtHeader.getText().toString());
                        number = decreaseValue(holder.txtHeader.getText().toString(), holder.txtFooter.getText().toString(),x);
                }

                holder.inputX.setText("");

                //refreshes text info
                Log.d("newvalue", number);
                quantity.set(i, number);
                onBindViewHolder(holder, i);
            }
        });
    }

    public String decreaseValue(String name, String value, int shrinkValue)
    {
        int curValue = Integer.parseInt(value);
        int sumValue = curValue - shrinkValue;

        if(sumValue < 0)
        {
            sumValue = 0;
        }

        String retValue = Integer.toString(sumValue);
        StockActivity.refreshFirebaseData(name,retValue);
        Log.d("CurValue",value);
        Log.d("retValue",retValue);
        return retValue;
    }

    public String increaseValue(String name, String value, int raiseValue)
    {
        int curValue = Integer.parseInt(value);
        int sumValue = curValue + raiseValue;

        if(sumValue > 100)
        {
            sumValue = 100;
        }

        String retValue = Integer.toString(sumValue);
        StockActivity.refreshFirebaseData(name,retValue);
        Log.d("CurValue",value);
        Log.d("retValue",retValue);
        return retValue;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }
}


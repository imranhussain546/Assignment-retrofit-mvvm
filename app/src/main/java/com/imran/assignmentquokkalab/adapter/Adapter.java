package com.imran.assignmentquokkalab.adapter;

import android.content.Context;
import android.content.Entity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.imran.assignmentquokkalab.R;
import com.imran.assignmentquokkalab.model.Entry;
import com.imran.assignmentquokkalab.view.Fragment1;
import com.imran.assignmentquokkalab.view.Fragment2;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    public Context context;
    public ArrayList<Entry> entryListView;

    public Adapter(Context context, ArrayList<Entry> entryListView) {
        this.context = context;
        this.entryListView = entryListView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Log.d("Adapter", "onBindViewHolder: "+entryListView.get(position).getApi());
        holder.tv.setText(entryListView.get(position).getApi());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment2 fragment2=(Fragment2)((AppCompatActivity) context).getSupportFragmentManager().findFragmentById(R.id.fragment2);
                fragment2.setDesc(entryListView.get(position).getDescription());



            }
        });
    }

    @Override
    public int getItemCount() {
        return entryListView.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv=itemView.findViewById(R.id.card);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}

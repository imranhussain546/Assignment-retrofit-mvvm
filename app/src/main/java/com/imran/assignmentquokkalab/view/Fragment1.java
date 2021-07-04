package com.imran.assignmentquokkalab.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.imran.assignmentquokkalab.R;
import com.imran.assignmentquokkalab.adapter.Adapter;
import com.imran.assignmentquokkalab.model.Data;
import com.imran.assignmentquokkalab.model.Entry;
import com.imran.assignmentquokkalab.viewmodel.Connect;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {
    private Connect viewmodel;
    private ArrayList<Entry> entry;
    private RecyclerView recyclerView;
    ProgressBar pg;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_1, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        viewmodel=new ViewModelProvider(this).get(Connect.class);
        viewmodel.getDatalist().observe(getActivity(), new Observer<Data>() {
            @Override
            public void onChanged(Data data) {
                if (data!=null)
                {

                    entry=  data.getEntries();
                    Log.d("dataaaaaaa",entry.get(0).getApi());
                    Adapter adapter=new Adapter(getContext(),entry);
                    recyclerView.setAdapter(adapter);

                }
            }
        });

    }


}
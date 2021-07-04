package com.imran.assignmentquokkalab.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imran.assignmentquokkalab.R;

public class Fragment2 extends Fragment {
TextView tv;
    String des;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_2, container, false);
        tv=view.findViewById(R.id.textview2);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //tv.setText(getArguments().getString("des"));


    }
    public void setDesc(String s)//for change version
    {
        tv.setText(s);
    }


}
package com.example.fragmentdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class TopFragment extends Fragment {
Button button;
TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_top, container, false);
        button = view.findViewById(R.id.clicker);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = view.findViewById(R.id.top_text);
                textView.setText("Clicked");
            }
        });
        // Inflate the layout for this fragment
        return view;

    }
}

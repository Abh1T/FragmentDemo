package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements BottonFragment.SendInfo{

    Button replaceButton;
    FragmentTransaction fragmentTransaction;
    FragmentTransaction fragmentTransaction2;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceButton = findViewById(R.id.button);

        fragmentManager = getSupportFragmentManager();

        //Begin first transaction
        fragmentTransaction = fragmentManager.beginTransaction();

        //Create bottom fragment and add to layout on bottom of XML
        final BottonFragment bottonFragment = new BottonFragment();
        fragmentTransaction.add(R.id.id_bottom,bottonFragment);

        //commit the transaction (end)
        fragmentTransaction.commit();

        replaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction2 = fragmentManager.beginTransaction();
                TopFragment topFragment = new TopFragment();
                fragmentTransaction2.remove(bottonFragment);
                fragmentTransaction2.add(R.id.id_bottom, topFragment);
                fragmentTransaction2.commit();
            }
        });
    }
    public void update(String str){
        replaceButton.setText(str);
    }
}

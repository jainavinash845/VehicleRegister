package com.example.avinash.vehicleregister;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements BlankFragment.MComplete {


    TextView tv_make,tv_year,tv_model,tv_colour,tv_seatbealts,tv_door;
    public enum VehicleDetails{
        YEAR,
        MAKE,
        MODEL,
        COLOUR,
        SEATBEALTS,
        DOOR;


    }

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        tv_make = findViewById(R.id.textlist_make);
        tv_year = findViewById(R.id.textlist_year);
        tv_model = findViewById(R.id.textlist_model);
        tv_colour = findViewById(R.id.textlist_colour);
        tv_seatbealts = findViewById(R.id.textlist_seatbelats);
        tv_door =findViewById(R.id.textlist_doors);



        tv_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BlankFragment blankFragment = new BlankFragment().newInstance(new String[]{"2010","2011","2012","2013","2014"},VehicleDetails.YEAR);
                FragmentManager fragmentManager = getSupportFragmentManager();
                blankFragment.show(fragmentManager,"dialog");

            }
        });
        tv_make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BlankFragment blankFragment = new BlankFragment().newInstance(new String[]{"Toyota","maruti","audi","mercedes","Hyundai","BMW,suzuki"},VehicleDetails.MAKE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                blankFragment.show(fragmentManager,"dialog");

            }
        });
        tv_model.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlankFragment blankFragment = new BlankFragment().newInstance(new String[]{"camry","yaris","prius","fortuner","innova"},VehicleDetails.MODEL);
                FragmentManager fragmentManager = getSupportFragmentManager();
                blankFragment.show(fragmentManager,"dialog");
            }
        });
        tv_colour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlankFragment blankFragment = new BlankFragment().newInstance(new String[]{"Super White","Gray Metallic","Aqua Mica","Black Send Pearl"},VehicleDetails.COLOUR);
                FragmentManager fragmentManager = getSupportFragmentManager();
                blankFragment.show(fragmentManager,"dialog");
            }
        });
        tv_seatbealts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlankFragment blankFragment = new BlankFragment().newInstance(new String[]{"2","3","4"},VehicleDetails.SEATBEALTS);
                FragmentManager fragmentManager = getSupportFragmentManager();
                blankFragment.show(fragmentManager,"dialog");
            }
        });
        tv_door.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlankFragment blankFragment = new BlankFragment().newInstance(new String[]{"2","4","5"},VehicleDetails.DOOR);
                FragmentManager fragmentManager = getSupportFragmentManager();
                blankFragment.show(fragmentManager,"dialog");
            }
        });


    }

    @Override
    public void onComplete(String str, VehicleDetails vehicleDetails) {

    switch (vehicleDetails){
        case MAKE: tv_make.setText(str);
        break;
        case YEAR: tv_year.setText(str);
        break;
        case MODEL:tv_model.setText(str);
        break;
        case COLOUR:tv_colour.setText(str);
        break;
        case SEATBEALTS:tv_seatbealts.setText(str);
        break;
        case DOOR:tv_door.setText(str);
        break;

    }


    }



}
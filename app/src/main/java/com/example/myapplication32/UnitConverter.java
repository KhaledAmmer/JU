package com.example.myapplication32;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class UnitConverter extends AppCompatActivity implements AdapterView.OnItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {


    RecyclerView mrecycleview;
    Intent my;
    myadapter12 mAdapter;
    RecyclerView.LayoutManager manager;
    ArrayList<unitadd> Addresses;

    int num = 1;
    int num1 = 1;
    String[] String_Array;
    String[] String_Array_ar;

    int p2 = 0;
    double k2;
    NumberFormat formatter, formatter1;
    ArrayAdapter<CharSequence> adapter;
    Spinner s;
    EditText editText;
    int l = 0;
    private AdView mAdView;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_unit_converter);


        formatter = new DecimalFormat("#0.0000000");
        formatter1 = new DecimalFormat("#,##0.000");
        NavigationView navigationView = findViewById(R.id.navi);
        navigationView.setNavigationItemSelectedListener(this);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        BottomNavigationView bottomNav = findViewById(R.id.botnav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        BottomNavigationView bottomNav1 = findViewById(R.id.botnav1);
        bottomNav1.setOnNavigationItemSelectedListener(navListener);

        mrecycleview = findViewById(R.id.rv);
        mrecycleview.setHasFixedSize(true);


        editText = findViewById(R.id.text4);
        s = findViewById(R.id.spinner);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.length, R.layout.text1);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(this);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {


                createExampleList(s.getItemAtPosition(num1).toString());


            }
        });


        getads();
    }

    public void getads() {

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

    }

    public void createExampleList(String sym) {

        Addresses = new ArrayList<>();
        switch (num) {
            case 0:
                String_Array = getResources().getStringArray(R.array.length);
                String_Array_ar = getResources().getStringArray(R.array.length_num);
                break;
            case 1:
                String_Array = getResources().getStringArray(R.array.mass);
                String_Array_ar = getResources().getStringArray(R.array.mass_num);
                break;
            case 2:
                String_Array = getResources().getStringArray(R.array.volume);
                String_Array_ar = getResources().getStringArray(R.array.volume_num);
                break;
            case 3:
                String_Array = getResources().getStringArray(R.array.Area);
                String_Array_ar = getResources().getStringArray(R.array.Area_num);
                break;
            case 4:
                String_Array = getResources().getStringArray(R.array.time);
                String_Array_ar = getResources().getStringArray(R.array.time_num);
                break;
            case 5:
                String_Array = getResources().getStringArray(R.array.pressure);
                String_Array_ar = getResources().getStringArray(R.array.pressure_num);
                break;
            case 6:
                String_Array = getResources().getStringArray(R.array.Temperature);
                String_Array_ar = getResources().getStringArray(R.array.Temperature_num);
                break;
            case 7:
                String_Array = getResources().getStringArray(R.array.force);
                String_Array_ar = getResources().getStringArray(R.array.force_num);
                break;
            case 8:
                String_Array = getResources().getStringArray(R.array.work);
                String_Array_ar = getResources().getStringArray(R.array.work_num);
                break;
            case 9:
                String_Array = getResources().getStringArray(R.array.power);
                String_Array_ar = getResources().getStringArray(R.array.power_num);
                break;
        }


        switch (sym) {
            case "pm":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 1000000000000.0);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;


                        default:
                            if ((Double.parseDouble(String_Array_ar[i]) / 1000000000000.0) > 0.0 & (Double.parseDouble(String_Array_ar[i]) / 1000000000000.0) < 1.0) {
                                String_Array_ar[i] = formatter.format((parseDouble(String_Array_ar[i])) * parseDouble(editText.getText().toString()) / (1000000000000.0));
                                Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            } else {
                                String_Array_ar[i] = formatter.format((parseDouble(String_Array_ar[i])) * parseDouble(editText.getText().toString()) / (1000000000000.0));
                                Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            }
                            break;
                    }

                }
                break;
            case "um":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 1000000.0);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        case "1":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 1000000.0);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            if ((Double.parseDouble(String_Array_ar[i]) / 1000000.0) > 0.0 & (Double.parseDouble(String_Array_ar[i]) / 1000000.0) < 1.0) {
                                String_Array_ar[i] = formatter.format((parseDouble(String_Array_ar[i])) * parseDouble(editText.getText().toString()) / (1000000.0));
                                Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            } else {
                                String_Array_ar[i] = formatter.format((parseDouble(String_Array_ar[i])) * parseDouble(editText.getText().toString()) / (1000000.0));
                                Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            }
                            break;
                    }
                }
                break;
            case "mm":
                for (int i = 0; i < String_Array.length; i++) {

                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 1000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            switch (String_Array[i]) {
                                case "inch":
                                    String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 1000);
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case "ft":
                                    String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 1000);
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case "yd":
                                    String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 1000);
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                default:
                                    String_Array_ar[i] = String.valueOf(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 1000);
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            }

                    }
                }
                break;

            case "cm":

                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 100);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            switch (String_Array[i]) {
                                case "inch":
                                    String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 100);
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case "ft":
                                    String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 100);
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case "yd":
                                    String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 100);
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                default:
                                    String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 100);
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            }

                    }

                }
                break;

            case "dm":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 10.0);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            if ((Double.parseDouble(String_Array_ar[i]) / 10.0) > 0.0 & (Double.parseDouble(String_Array_ar[i]) / 10.0) < 1.0) {
                                String_Array_ar[i] = formatter.format((parseDouble(String_Array_ar[i])) * parseDouble(editText.getText().toString()) / (10.0));
                                Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            } else {
                                String_Array_ar[i] = formatter1.format((parseDouble(String_Array_ar[i])) * parseDouble(editText.getText().toString()) / (10.0));
                                Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            }
                            break;
                    }
                }

                break;
            case "m":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] =formatter.format(parseDouble(String_Array_ar[i]));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;

                    }
                }
                break;
            case "km":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * 1000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) * 1000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;

            case "inch":

                for (int i = 0; i < String_Array.length; i++) {
                    formatter = new DecimalFormat("#0.0000000");
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 39.370079);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;

                        default:
                            String_Array_ar[i] = String.valueOf(formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 39.370079));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;


                    }


                }

            case "ft":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 3.280839);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 3.280839);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;

            case "yd":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 1.0936133);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 1.0936133);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "mile":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 0.00062137119);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 0.00062137119);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "kg":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;

            case "g":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 1000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 1000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;

            case "mg":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 1000000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 1000000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "metric ton":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * 1000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) * 1000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;

            case "Ibm":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 2.204623);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 2.204623);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;

            case "oz":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 35.273962);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 35.273962);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "L":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "cm^3":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = String.valueOf(parseDouble(String_Array_ar[i]) / 1000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 1000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "dm^3":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = String.valueOf(parseDouble(String_Array_ar[i]));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "m^3":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = String.valueOf(parseDouble(String_Array_ar[i]) * 1000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) * 1000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "in^3":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 61.023744);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 61.023744);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "ft^3":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 0.035315);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 0.035315);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "yd^3":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 0.001308);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 0.001308);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "gal(UK)":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 0.219969);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 0.219969);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "gal(US)":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 0.264172);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 0.264172);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;


            case "in^2":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 1550.0031);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 1550.0031);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "m^2":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "dm^2":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 100);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 100);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "cm^2":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 10000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 10000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "mm^2":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 1000000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 1000000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "yd^2":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 1.19599);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 1.19599);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "ft^2":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 10.76391);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 10.76391);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "km^2":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 0.000001);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 0.000001);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "year":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "s":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 31536000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 31536000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "min":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 525600);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 525600);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "hour":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 8760);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 8760);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "day":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 365);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 365);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "week":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 52.142857);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 52.142857);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "month":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 12);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 12);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "bar":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "atm":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 0.986923);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 0.986923);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "MPa":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 0.1);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 0.1);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "kPa":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 1000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 1000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "Pa":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 100000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 100000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "mmHg":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 750.061683);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 750.061683);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "psi":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) / 14.503775);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) / 14.503775);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "K":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]));
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            switch (i) {
                                case 0:
                                    String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()));
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case 1:
                                    String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) + parseDouble(editText.getText().toString()));
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case 2:
                                    String_Array_ar[i] = formatter.format(parseDouble(editText.getText().toString())*1.8-459.67 ) ;
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case 3:
                                    String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()));
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                            }
                    }
                }
                break;
            case "C":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = "Enter any number above";
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            switch (i) {
                                case 0:
                                    String_Array_ar[i] = formatter.format(273.15+ parseDouble(editText.getText().toString()));
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case 1:
                                    String_Array_ar[i] =formatter.format(parseDouble(editText.getText().toString()));
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case 2:
                                    String_Array_ar[i] = formatter.format((273.15+parseDouble(editText.getText().toString()))*1.8-459.67 ) ;
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case 3:
                                    String_Array_ar[i] =  formatter.format ((parseDouble(editText.getText().toString())+273.15)*1.8);
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                            }
                    }
                }
                break;
            case "F":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = "Enter any number above";
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            switch (i) {
                                case 0:
                                    String_Array_ar[i] = formatter.format((459.67+ parseDouble(editText.getText().toString()))/1.8);
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case 1:
                                    String_Array_ar[i] =formatter.format((459.67+parseDouble(editText.getText().toString()))/1.8-273.15);
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case 2:
                                    String_Array_ar[i] = formatter.format((parseDouble(editText.getText().toString())) ) ;
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case 3:
                                    String_Array_ar[i] =  formatter.format ((parseDouble(editText.getText().toString())+459.67));
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                            }
                    }
                }
                break;
            case "R":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = "Enter any number above";
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            switch (i) {
                                case 0:
                                    String_Array_ar[i] = formatter.format( parseDouble(editText.getText().toString())/1.8);
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case 1:
                                    String_Array_ar[i] =formatter.format(parseDouble(editText.getText().toString())/1.8-273.15);
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case 2:
                                    String_Array_ar[i] = formatter.format((parseDouble(editText.getText().toString()))-459.67 ) ;
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                                case 3:
                                    String_Array_ar[i] =  formatter.format (parseDouble(editText.getText().toString()));
                                    Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                                    break;
                            }
                    }
                }
                break;
            case "N":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) );
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) );
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "dyn":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i])/100000 );
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString())/100000 );
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "kgf":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) /0.101972);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) /0.101972);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "Ibf":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) /0.224800);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString())  /0.224800);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "J":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) );
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) );
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "kJ":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) *1000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString())*1000 );
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;

            case "cal":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) /0.2390060);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString())/0.2390060 );
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "BTU":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) /0.0009478);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString())/0.0009478);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "kW.h":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) /0.000000277778);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString())/0.000000277778);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "ft.Ibf":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) /0.737562);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString())/0.737562);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "in.Ibf":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) /8.850746);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString())/8.850746);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;

            case "W":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) );
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) );
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "kW":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i])*1000 );
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString())*1000 );
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "MW":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i])*1000000 );
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) *1000000);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "kcal/h":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) /0.860421);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) /0.860421);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "hp":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i])/0.00134102);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString()) /0.00134102);
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;
            case "BTU/h":
                for (int i = 0; i < String_Array.length; i++) {
                    switch (editText.getText().toString()) {
                        case "":
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i])/3.412142 );
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                        default:
                            String_Array_ar[i] = formatter.format(parseDouble(String_Array_ar[i]) * parseDouble(editText.getText().toString())/3.412142 );
                            Addresses.add(new unitadd(String_Array_ar[i], String_Array[i]));
                            break;
                    }
                }
                break;

        }
        manager = new LinearLayoutManager(this);
        mAdapter = new myadapter12(Addresses);
        mrecycleview.setLayoutManager(manager);
        mrecycleview.setAdapter(mAdapter);


    }

    public void build(int p2) {
        switch (p2) {
            case 0:
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.length, R.layout.text1);
                break;
            case 1:
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.mass, R.layout.text1);
                break;
            case 2:
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.volume, R.layout.text1);
                break;
            case 3:
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.Area, R.layout.text1);
            case 4:
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.time, R.layout.text1);
                break;
            case 5:
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.pressure, R.layout.text1);
                break;
            case 6:
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.Temperature, R.layout.text1);
                break;
            case 7:
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.force, R.layout.text1);
                break;
            case 8:
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.work, R.layout.text1);
                break;
            case 9:
                adapter = ArrayAdapter.createFromResource(this,
                        R.array.power, R.layout.text1);
                break;
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(this);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.length:
                            build(0);
                            num = 0;
                            break;
                        case R.id.mass:
                            build(1);
                            num = 1;
                            break;

                        case R.id.volume1:
                            build(2);
                            num = 2;
                            break;

                        case R.id.area:
                            build(3);
                            num = 3;
                            break;
                        case R.id.time1:
                            build(4);
                            num = 4;
                            break;
                        case R.id.pressure2:
                            build(5);
                            num = 5;
                            break;
                        case R.id.temperature12:
                            build(6);
                            num = 6;
                            break;
                        case R.id.force:
                            build(7);
                            num = 7;
                            break;
                        case R.id.work:
                            build(8);
                            num = 8;
                            break;
                        case R.id.power:
                            build(9);
                            num = 9;
                            break;
                    }

                    return true;
                }
            };

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        createExampleList(s.getItemAtPosition(position).toString());
        num1 = position;

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        createExampleList(s.getItemAtPosition(num).toString());
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.satp:
                my = new Intent(this, ThermoSolver.class);
                startActivity(my);
                break;

            case R.id.dew_bubble:
                my = new Intent(this, Bubble_Dew.class);
                startActivity(my);
                break;
            case R.id.Eos:
                my = new Intent(this, Equations_Of_State.class);
                startActivity(my);

                break;
            case R.id.fugs:
                my = new Intent(this, Fugacity_Calculation.class);
                startActivity(my);

                break;
            case R.id.unit:
                my = new Intent(this, UnitConverter.class);
                startActivity(my);

                break;
            case R.id.chee:
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer1221.CEJU"));
                startActivity(my);

                break;
            case R.id.tasjel:
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer.ju"));
                startActivity(my);

                break;
            case R.id.checkupdate:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer.test"));
                startActivity(my);
                break;
            case R.id.giveyourfeedback:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer.test"));
                startActivity(my);
                break;



        }
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    ;

    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
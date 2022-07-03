package com.example.myapplication32;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.navigation.NavigationView;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class A7sbM3dlk1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {
    double ss;
    TextView Trakmy, Hours, Fasly, textView;
    NumberFormat formatter;
    ImageView imageView;
    EditText sa3a, mo3dl;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8;
    CheckBox checkBox1r, checkBox2r, checkBox3r, checkBox4r, checkBox5r, checkBox6r, checkBox7r, checkBox8r;
    double sumh1 = 0, sum1 = 0;
    double sum = 0.0;
    double kh = 0.0;
    double k2h = 0.0;
    double dr3 = 0.0;
    double dr4 = 0.0;
    double dr5 = 0.0;
    double dr6 = 0.0;
    double dr7 = 0.0;
    double dr8 = 0.0;
    double h1 = 0.0;
    double h2 = 0.0;
    double h3 = 0.0;
    double h4 = 0.0;
    double h5 = 0.0;
    double h6 = 0.0;
    double h7 = 0.0;
    double h8 = 0.0;
    double h20 = 0.0;
    double rh20 = 0.0;
    double s20 = 0.0;
    double s21 = 0.0;
    double old_houre, old_Trakomy, sumh, s1, s2;
    LinearLayout l, l2, l3;
    Drawable less, more;
    double[] total, total1;
    Spinner sp1, sp12, sp13, sp2, sp22, sp23, sp3, sp32, sp33, sp4, sp42, sp43, sp5, sp52, sp53, sp6, sp62, sp63, sp7, sp72, sp73, sp8, sp82, sp83;
    private DrawerLayout drawer;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_a7sbm3dlk2);

        formatter = new DecimalFormat("#0.0000");

        findid();
        getads();
        openDialog();
        NavigationView navigationView = findViewById(R.id.navi);
        navigationView.setNavigationItemSelectedListener(this);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        total1 = new double[]{0.0, 0.0};
        mo3dl = findViewById(R.id.mo3adltrakomy);
        sa3a = findViewById(R.id.sa3atrakomy);
        setCheckBox();
        SetAdaptar();

    }

    public void openDialog() {
        DialogClass dialogClass = new DialogClass();
        dialogClass.show(getSupportFragmentManager(), "example dialog");
    }

    public void openDialog1() {
        DialogClass1 dialogClass = new DialogClass1();
        dialogClass.show(getSupportFragmentManager(), "example dialog");
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

    public void findid() {
        less = getResources().getDrawable(R.drawable.ic_baseline_expand_less_24);
        more = getResources().getDrawable(R.drawable.ic_baseline_expand_more_24);
        imageView = findViewById(R.id.updown);
        l3 = findViewById(R.id.lin);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
        checkBox7 = (CheckBox) findViewById(R.id.checkBox7);
        checkBox8 = (CheckBox) findViewById(R.id.checkBox8);
        checkBox1r = (CheckBox) findViewById(R.id.checkBox1E);
        checkBox2r = (CheckBox) findViewById(R.id.checkBox2E);
        checkBox3r = (CheckBox) findViewById(R.id.checkBox3E);
        checkBox4r = (CheckBox) findViewById(R.id.checkBox4E);
        checkBox5r = (CheckBox) findViewById(R.id.checkBox5E);
        checkBox6r = (CheckBox) findViewById(R.id.checkBox6E);
        checkBox7r = (CheckBox) findViewById(R.id.checkBox7E);
        checkBox8r = (CheckBox) findViewById(R.id.checkBox8E);
        sp1 = findViewById(R.id.s1);
        sp12 = findViewById(R.id.s12);
        sp13 = findViewById(R.id.s13);
        sp2 = findViewById(R.id.s2);
        sp22 = findViewById(R.id.s22);
        sp23 = findViewById(R.id.s23);
        sp3 = findViewById(R.id.s3);
        sp32 = findViewById(R.id.s32);
        sp33 = findViewById(R.id.s33);
        sp4 = findViewById(R.id.s4);
        sp42 = findViewById(R.id.s42);
        sp43 = findViewById(R.id.s43);
        sp5 = findViewById(R.id.s5);
        sp52 = findViewById(R.id.s52);
        sp53 = findViewById(R.id.s53);
        sp6 = findViewById(R.id.s6);
        sp62 = findViewById(R.id.s62);
        sp63 = findViewById(R.id.s63);
        sp7 = findViewById(R.id.s7);
        sp72 = findViewById(R.id.s72);
        sp73 = findViewById(R.id.s73);
        sp8 = findViewById(R.id.s8);
        sp82 = findViewById(R.id.s82);
        sp83 = findViewById(R.id.s83);
        textView = findViewById(R.id.textview22);


    }

    public void SetAdaptar() {

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz, R.layout.text1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter1);
        sp1.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.sa3at, R.layout.text1);
        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp12.setAdapter(adapter12);
        sp12.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz_mo3ada, R.layout.text1);
        adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp13.setAdapter(adapter13);
        sp13.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz, R.layout.text1);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);
        sp2.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter22 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.sa3at, R.layout.text1);
        adapter22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp22.setAdapter(adapter22);
        sp22.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter23 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz_mo3ada, R.layout.text1);
        adapter23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp23.setAdapter(adapter23);
        sp23.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz, R.layout.text1);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(adapter3);
        sp3.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter32 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.sa3at, R.layout.text1);
        adapter32.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp32.setAdapter(adapter32);
        sp32.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter33 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz_mo3ada, R.layout.text1);
        adapter33.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp33.setAdapter(adapter33);
        sp33.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz, R.layout.text1);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp4.setAdapter(adapter4);
        sp4.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter42 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.sa3at, R.layout.text1);
        adapter42.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp42.setAdapter(adapter42);
        sp42.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter43 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz_mo3ada, R.layout.text1);
        adapter43.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp43.setAdapter(adapter43);
        sp43.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz, R.layout.text1);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp5.setAdapter(adapter5);
        sp5.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter52 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.sa3at, R.layout.text1);
        adapter52.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp52.setAdapter(adapter52);
        sp52.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter53 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz_mo3ada, R.layout.text1);
        adapter53.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp53.setAdapter(adapter53);
        sp53.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz, R.layout.text1);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp6.setAdapter(adapter6);
        sp6.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter62 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.sa3at, R.layout.text1);
        adapter62.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp62.setAdapter(adapter62);
        sp62.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter63 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz_mo3ada, R.layout.text1);
        adapter63.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp63.setAdapter(adapter63);
        sp63.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz, R.layout.text1);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp7.setAdapter(adapter7);
        sp7.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter72 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.sa3at, R.layout.text1);
        adapter72.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp72.setAdapter(adapter72);
        sp72.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter73 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz_mo3ada, R.layout.text1);
        adapter73.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp73.setAdapter(adapter73);
        sp73.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz, R.layout.text1);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp8.setAdapter(adapter8);
        sp8.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter82 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.sa3at, R.layout.text1);
        adapter82.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp82.setAdapter(adapter82);
        sp82.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter83 = ArrayAdapter.createFromResource(A7sbM3dlk1.this,
                R.array.rmoz_mo3ada, R.layout.text1);
        adapter83.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp83.setAdapter(adapter83);
        sp83.setOnItemSelectedListener(this);


    }

    public void setCheckBox() {
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = findViewById(R.id.v1);
                l2 = findViewById(R.id.v1R);
                if (checkBox1.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {

                    l.setVisibility(View.INVISIBLE);
                    checkBox1r.setChecked(false);
                    l = findViewById(R.id.v1R);
                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);

                }
            }
        });
        checkBox1r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = findViewById(R.id.v1R);
                if (checkBox1r.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {
                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);
                }


            }
        });


        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = findViewById(R.id.v2);

                if (checkBox2.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {

                    l.setVisibility(View.INVISIBLE);
                    checkBox2r.setChecked(false);
                    l = findViewById(R.id.v2R);
                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);
                }
            }
        });
        checkBox2r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = findViewById(R.id.v2R);
                if (checkBox2r.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {
                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);
                }


            }
        });


        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = findViewById(R.id.v3);
                if (checkBox3.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {

                    l.setVisibility(View.INVISIBLE);
                    checkBox3r.setChecked(false);
                    l = findViewById(R.id.v3R);
                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);
                }
            }
        });

        checkBox3r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = findViewById(R.id.v3R);
                if (checkBox3r.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {
                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);
                }

            }
        });


        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                l = findViewById(R.id.v4);
                if (checkBox4.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {

                    l.setVisibility(View.INVISIBLE);
                    checkBox4r.setChecked(false);
                    l = findViewById(R.id.v4R);
                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);
                }
            }
        });


        checkBox4r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = findViewById(R.id.v4R);
                if (checkBox4r.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {
                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);
                }
            }
        });

        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = findViewById(R.id.v5);

                if (checkBox5.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {
                    l.setVisibility(View.INVISIBLE);
                    checkBox5r.setChecked(false);
                    l = findViewById(R.id.v5R);
                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);
                }

            }
        });

        checkBox5r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = findViewById(R.id.v5R);
                if (checkBox5r.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {
                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);
                }
            }
        });


        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                l = findViewById(R.id.v6);

                if (checkBox6.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {

                    l.setVisibility(View.INVISIBLE);
                    checkBox6r.setChecked(false);
                    l = findViewById(R.id.v6R);
                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);
                }
            }
        });


        checkBox6r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = findViewById(R.id.v6R);

                if (checkBox6r.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {

                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);

                }
            }
        });


        checkBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                l = findViewById(R.id.v7);

                if (checkBox7.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {

                    l.setVisibility(View.INVISIBLE);
                    checkBox7r.setChecked(false);
                    l = findViewById(R.id.v7R);
                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);
                }
            }
        });


        checkBox7r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = findViewById(R.id.v7R);

                if (checkBox7r.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {

                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);
                }
            }
        });


        checkBox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = findViewById(R.id.v8);

                if (checkBox8.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {

                    l.setVisibility(View.INVISIBLE);
                    checkBox8r.setChecked(false);
                    l = findViewById(R.id.v8R);
                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);
                }
            }
        });

        checkBox8r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l = findViewById(R.id.v8R);
                if (checkBox8r.isChecked()) {
                    l.setVisibility(View.VISIBLE);
                } else {
                    h20 = 0.0;
                    rh20 = 0.0;
                    l.setVisibility(View.INVISIBLE);
                }
            }
        });


    }


    public double[] getResultsR(CheckBox c) {


        if (c == checkBox1r & checkBox1r.isChecked()) {
            h1 = Double.parseDouble(sp12.getSelectedItem().toString());
            switch (sp13.getSelectedItem().toString()) {
                case "----":
                    h1 = 0.0;
                    kh = 0.0;
                    break;
                case "A":
                    kh = 4.0 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;

                case "A-":
                    kh = 3.75 * Double.parseDouble(sp12.getSelectedItem().toString());

                    break;

                case "B+":
                    kh = 3.5 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;
                case "B":
                    kh = 3.0 * Double.parseDouble(sp12.getSelectedItem().toString());

                    break;

                case "B-":
                    kh = 2.75 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;

                case "C+":
                    kh = 2.5 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;
                case "C":

                    kh = 2.0 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;
                case "C-":
                    kh = 1.75 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;
                case "D+":
                    kh = 1.5 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;


                case "D":
                    kh = 1.0 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;
                case "D-":
                    kh = 0.75 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;

                case "F":
                    kh = 0.0 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;

            }
        } else {
            h1 = 0.0;
            kh = 0.0;
        }
        if (c == checkBox2r & checkBox2r.isChecked()) {
            h2 = Double.parseDouble(sp22.getSelectedItem().toString());
            switch (sp23.getSelectedItem().toString()) {

                case "----":
                    h2 = 0.0;
                    k2h = 0.0;
                    break;

                case "A":
                    k2h = 4.0 * Double.parseDouble(sp22.getSelectedItem().toString());

                    break;

                case "A-":
                    k2h = 3.75 * Double.parseDouble(sp22.getSelectedItem().toString());

                    break;

                case "B+":
                    k2h = 3.5 * Double.parseDouble(sp22.getSelectedItem().toString());

                    break;
                case "B":
                    k2h = 3.0 * Double.parseDouble(sp22.getSelectedItem().toString());

                    break;

                case "B-":
                    k2h = 2.75 * Double.parseDouble(sp22.getSelectedItem().toString());

                    break;


                case "C+":
                    k2h = 2.5 * Double.parseDouble(sp22.getSelectedItem().toString());
                    break;
                case "C":
                    k2h = 2.0 * Double.parseDouble(sp22.getSelectedItem().toString());

                    break;
                case "C-":
                    k2h = 1.75 * Double.parseDouble(sp22.getSelectedItem().toString());

                    break;
                case "D+":
                    k2h = 1.5 * Double.parseDouble(sp22.getSelectedItem().toString());
                    break;


                case "D":
                    k2h = 1.0 * Double.parseDouble(sp22.getSelectedItem().toString());
                    break;
                case "D-":
                    k2h = 0.75 * Double.parseDouble(sp22.getSelectedItem().toString());
                    break;

                case "F":
                    k2h = 0.0 * Double.parseDouble(sp22.getSelectedItem().toString());
                    break;


            }
        } else {
            h2 = 0.0;
            k2h = 0.0;

        }

        if (c == checkBox3r & checkBox3r.isChecked()) {
            h3 = Double.parseDouble(sp32.getSelectedItem().toString());
            switch (sp33.getSelectedItem().toString()) {

                case "----":
                    h3 = 0.0;
                    dr3 = 0.0;
                    break;

                case "A":
                    dr3 = 4.0 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;

                case "A-":
                    dr3 = 3.75 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;

                case "B+":
                    dr3 = 3.5 * Double.parseDouble(sp32.getSelectedItem().toString());

                    break;
                case "B":
                    dr3 = 3.0 * Double.parseDouble(sp32.getSelectedItem().toString());

                    break;

                case "B-":
                    dr3 = 2.75 * Double.parseDouble(sp32.getSelectedItem().toString());

                    break;
                case "C+":
                    dr3 = 2.5 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;
                case "C":
                    dr3 = 2.0 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;
                case "C-":
                    dr3 = 1.75 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;
                case "D+":
                    dr3 = 1.5 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;

                case "D":
                    dr3 = 1.0 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;
                case "D-":
                    dr3 = 0.75 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;

                case "F":
                    dr3 = 0.0 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;


            }
        } else {
            h3 = 0.0;
            dr3 = 0.0;
        }

        if (c == checkBox4r & checkBox4r.isChecked()) {
            h4 = Double.parseDouble(sp42.getSelectedItem().toString());
            switch (sp43.getSelectedItem().toString()) {

                case "----":
                    h4 = 0.0;
                    dr4 = 0.0;
                    break;

                case "A":
                    dr4 = 4.0 * h4;

                    break;

                case "A-":
                    dr4 = 3.75 * h4;

                    break;

                case "B+":
                    dr4 = 3.5 * h4;

                    break;
                case "B":
                    dr4 = 3.0 * h4;

                    break;

                case "B-":
                    dr4 = 2.75 * h4;

                    break;

                case "C+":
                    dr4 = 2.5 * h4;
                    break;
                case "C":
                    dr4 = 2.0 * h4;
                    break;
                case "C-":
                    dr4 = 1.75 * h4;
                    break;
                case "D+":
                    dr4 = 1.5 * h4;
                    break;

                case "D":
                    dr4 = 1.0 * h4;
                    break;
                case "D-":
                    dr4 = 0.75 * h4;
                    break;

                case "F":
                    dr4 = 0.0 * h4;
                    break;


            }
        } else {
            h4 = 0.0;
            dr4 = 0.0;
        }

        if (c == checkBox5r & checkBox5r.isChecked()) {
            h5 = Double.parseDouble(sp52.getSelectedItem().toString());
            switch (sp53.getSelectedItem().toString()) {

                case "----":
                    h5 = 0.0;
                    dr5 = 0.0;
                    break;
                case "A":
                    dr5 = 4.0 * h5;
                    break;

                case "A-":
                    dr5 = 3.75 * h5;
                    break;

                case "B+":
                    dr5 = 3.5 * h5;
                    break;
                case "B":
                    dr5 = 3.0 * h5;
                    break;

                case "B-":
                    dr5 = 2.75 * h5;

                    break;


                case "C+":
                    dr5 = 2.5 * h5;
                    break;
                case "C":
                    dr5 = 2.0 * h5;
                    break;
                case "C-":
                    dr5 = 1.75 * h5;
                    break;
                case "D+":
                    dr5 = 1.5 * h5;
                    break;

                case "D":
                    dr5 = 1.0 * h5;
                    break;
                case "D-":
                    dr5 = 0.75 * h5;
                    break;

                case "F":
                    dr5 = 0.0 * h5;
                    break;


            }
        } else {
            h5 = 0.0;
            dr5 = 0.0;
        }

        if (c == checkBox6r & checkBox6r.isChecked()) {
            h6 = Double.parseDouble(sp62.getSelectedItem().toString());
            switch (sp63.getSelectedItem().toString()) {

                case "----":
                    h6 = 0.0;
                    dr6 = 0.0;
                    break;

                case "A":
                    dr6 = 4.0 * h6;
                    break;

                case "A-":
                    dr6 = 3.75 * h6;

                    break;

                case "B+":
                    dr6 = 3.5 * h6;

                    break;
                case "B":
                    dr6 = 3.0 * h6;

                    break;

                case "B-":
                    dr6 = 2.75 * h6;

                    break;

                case "C+":
                    dr6 = 2.5 * h6;
                    break;
                case "C":
                    dr6 = 2.0 * h6;
                    break;
                case "C-":
                    dr6 = 1.75 * h6;
                    break;
                case "D+":
                    dr6 = 1.5 * h6;
                    break;

                case "D":
                    dr6 = 1.0 * h6;
                    break;
                case "D-":
                    dr6 = 0.75 * h6;
                    break;

                case "F":
                    dr6 = 0.0 * h6;
                    break;


            }
        } else {
            h6 = 0.0;
            dr6 = 0.0;
        }

        if (c == checkBox7r & checkBox7r.isChecked()) {
            h7 = Double.parseDouble(sp72.getSelectedItem().toString());
            switch (sp73.getSelectedItem().toString()) {

                case "----":
                    h7 = 0.0;
                    dr7 = 0.0;
                    break;

                case "A":
                    dr7 = 4.0 * h7;

                    break;

                case "A-":
                    dr7 = 3.75 * h7;

                    break;

                case "B+":
                    dr7 = 3.5 * h7;

                    break;
                case "B":
                    dr7 = 3.0 * h7;

                    break;

                case "B-":
                    dr7 = 2.75 * h7;

                    break;
                case "C+":
                    dr7 = 2.5 * h7;
                    break;
                case "C":
                    dr7 = 2.0 * h7;
                    break;
                case "C-":
                    dr7 = 1.75 * h7;
                    break;
                case "D+":
                    dr7 = 1.5 * h7;
                    break;

                case "D":
                    dr7 = 1.0 * h7;
                    break;
                case "D-":
                    dr7 = 0.75 * h7;
                    break;

                case "F":
                    dr7 = 0.0 * h7;
                    break;


            }
        } else {
            h7 = 0.0;
            dr7 = 0.0;
        }

        if (c == checkBox8r & checkBox8r.isChecked()) {
            h8 = Double.parseDouble(sp82.getSelectedItem().toString());
            switch (sp83.getSelectedItem().toString()) {

                case "----":
                    h8 = 0.0;
                    dr8 = 0.0;
                    break;

                case "A":
                    dr8 = 4.0 * h8;
                    break;

                case "A-":
                    dr8 = 3.75 * h8;
                    break;

                case "B+":
                    dr8 = 3.5 * h8;
                    break;
                case "B":
                    dr8 = 3.0 * h8;
                    break;

                case "B-":
                    dr8 = 2.75 * h8;
                    break;

                case "C+":
                    dr8 = 2.5 * h8;
                    break;
                case "C":
                    dr8 = 2.0 * h8;
                    break;
                case "C-":
                    dr8 = 1.75 * h8;
                    break;
                case "D+":
                    dr8 = 1.5 * h8;
                    break;

                case "D":
                    dr8 = 1.0 * h8;
                    break;
                case "D-":
                    dr8 = 0.75 * h8;
                    break;

                case "F":
                    dr8 = 0.0 * h8;
                    break;


            }
        } else {
            h8 = 0.0;
            dr8 = 0.0;
        }


        sumh1 = h1 + h2 + h3 + h4 + h5 + h6 + h7 + h8;

        sum1 = k2h + kh + dr3 + dr4 + dr5 + dr6 + dr7 + dr8;
        total1 = new double[]{sum1, sumh1};

        return total1;


    }

    public double[] getResults1(CheckBox c) {


        if (c == checkBox1 & checkBox1.isChecked()) {
            h1 = Double.parseDouble(sp12.getSelectedItem().toString());
            switch (sp1.getSelectedItem().toString()) {
                case "----":
                    h1 = 0.0;
                    kh = 0.0;
                    break;
                case "A":
                    kh = 4.0 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;

                case "A-":
                    kh = 3.75 * Double.parseDouble(sp12.getSelectedItem().toString());

                    break;

                case "B+":
                    kh = 3.5 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;
                case "B":
                    kh = 3.0 * Double.parseDouble(sp12.getSelectedItem().toString());

                    break;

                case "B-":
                    kh = 2.75 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;

                case "C+":
                    kh = 2.5 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;
                case "C":

                    kh = 2.0 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;
                case "C-":
                    kh = 1.75 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;
                case "D+":
                    kh = 1.5 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;


                case "D":
                    kh = 1.0 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;
                case "D-":
                    kh = 0.75 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;

                case "F":
                    kh = 0.0 * Double.parseDouble(sp12.getSelectedItem().toString());
                    break;

            }
        } else {
            h1 = 0.0;
            kh = 0.0;
        }
        if (c == checkBox2 & checkBox2.isChecked()) {
            h2 = Double.parseDouble(sp22.getSelectedItem().toString());
            switch (sp2.getSelectedItem().toString()) {

                case "----":
                    h2 = 0.0;
                    k2h = 0.0;
                    break;

                case "A":
                    k2h = 4.0 * Double.parseDouble(sp22.getSelectedItem().toString());

                    break;

                case "A-":
                    k2h = 3.75 * Double.parseDouble(sp22.getSelectedItem().toString());

                    break;

                case "B+":
                    k2h = 3.5 * Double.parseDouble(sp22.getSelectedItem().toString());

                    break;
                case "B":
                    k2h = 3.0 * Double.parseDouble(sp22.getSelectedItem().toString());

                    break;

                case "B-":
                    k2h = 2.75 * Double.parseDouble(sp22.getSelectedItem().toString());

                    break;


                case "C+":
                    k2h = 2.5 * Double.parseDouble(sp22.getSelectedItem().toString());
                    break;
                case "C":
                    k2h = 2.0 * Double.parseDouble(sp22.getSelectedItem().toString());

                    break;
                case "C-":
                    k2h = 1.75 * Double.parseDouble(sp22.getSelectedItem().toString());

                    break;
                case "D+":
                    k2h = 1.5 * Double.parseDouble(sp22.getSelectedItem().toString());
                    break;


                case "D":
                    k2h = 1.0 * Double.parseDouble(sp22.getSelectedItem().toString());
                    break;
                case "D-":
                    k2h = 0.75 * Double.parseDouble(sp22.getSelectedItem().toString());
                    break;

                case "F":
                    k2h = 0.0 * Double.parseDouble(sp22.getSelectedItem().toString());
                    break;


            }
        } else {
            h2 = 0.0;
            k2h = 0.0;

        }

        if (c == checkBox3 & checkBox3.isChecked()) {
            h3 = Double.parseDouble(sp32.getSelectedItem().toString());
            switch (sp3.getSelectedItem().toString()) {

                case "----":
                    h3 = 0.0;
                    dr3 = 0.0;
                    break;

                case "A":
                    dr3 = 4.0 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;

                case "A-":
                    dr3 = 3.75 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;

                case "B+":
                    dr3 = 3.5 * Double.parseDouble(sp32.getSelectedItem().toString());

                    break;
                case "B":
                    dr3 = 3.0 * Double.parseDouble(sp32.getSelectedItem().toString());

                    break;

                case "B-":
                    dr3 = 2.75 * Double.parseDouble(sp32.getSelectedItem().toString());

                    break;
                case "C+":
                    dr3 = 2.5 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;
                case "C":
                    dr3 = 2.0 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;
                case "C-":
                    dr3 = 1.75 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;
                case "D+":
                    dr3 = 1.5 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;

                case "D":
                    dr3 = 1.0 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;
                case "D-":
                    dr3 = 0.75 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;

                case "F":
                    dr3 = 0.0 * Double.parseDouble(sp32.getSelectedItem().toString());
                    break;


            }
        } else {
            h3 = 0.0;
            dr3 = 0.0;
        }

        if (c == checkBox4 & checkBox4.isChecked()) {
            h4 = Double.parseDouble(sp42.getSelectedItem().toString());
            switch (sp4.getSelectedItem().toString()) {

                case "----":
                    h4 = 0.0;
                    dr4 = 0.0;
                    break;

                case "A":
                    dr4 = 4.0 * h4;

                    break;

                case "A-":
                    dr4 = 3.75 * h4;

                    break;

                case "B+":
                    dr4 = 3.5 * h4;

                    break;
                case "B":
                    dr4 = 3.0 * h4;

                    break;

                case "B-":
                    dr4 = 2.75 * h4;

                    break;

                case "C+":
                    dr4 = 2.5 * h4;
                    break;
                case "C":
                    dr4 = 2.0 * h4;
                    break;
                case "C-":
                    dr4 = 1.75 * h4;
                    break;
                case "D+":
                    dr4 = 1.5 * h4;
                    break;

                case "D":
                    dr4 = 1.0 * h4;
                    break;
                case "D-":
                    dr4 = 0.75 * h4;
                    break;

                case "F":
                    dr4 = 0.0 * h4;
                    break;


            }
        } else {
            h4 = 0.0;
            dr4 = 0.0;
        }

        if (c == checkBox5 & checkBox5.isChecked()) {
            h5 = Double.parseDouble(sp52.getSelectedItem().toString());
            switch (sp5.getSelectedItem().toString()) {

                case "----":
                    h5 = 0.0;
                    dr5 = 0.0;
                    break;
                case "A":
                    dr5 = 4.0 * h5;
                    break;

                case "A-":
                    dr5 = 3.75 * h5;
                    break;

                case "B+":
                    dr5 = 3.5 * h5;
                    break;
                case "B":
                    dr5 = 3.0 * h5;
                    break;

                case "B-":
                    dr5 = 2.75 * h5;

                    break;


                case "C+":
                    dr5 = 2.5 * h5;
                    break;
                case "C":
                    dr5 = 2.0 * h5;
                    break;
                case "C-":
                    dr5 = 1.75 * h5;
                    break;
                case "D+":
                    dr5 = 1.5 * h5;
                    break;

                case "D":
                    dr5 = 1.0 * h5;
                    break;
                case "D-":
                    dr5 = 0.75 * h5;
                    break;

                case "F":
                    dr5 = 0.0 * h5;
                    break;


            }
        } else {
            h5 = 0.0;
            dr5 = 0.0;
        }

        if (c == checkBox6 & checkBox6.isChecked()) {
            h6 = Double.parseDouble(sp62.getSelectedItem().toString());
            switch (sp6.getSelectedItem().toString()) {

                case "----":
                    h6 = 0.0;
                    dr6 = 0.0;
                    break;

                case "A":
                    dr6 = 4.0 * h6;
                    break;

                case "A-":
                    dr6 = 3.75 * h6;

                    break;

                case "B+":
                    dr6 = 3.5 * h6;

                    break;
                case "B":
                    dr6 = 3.0 * h6;

                    break;

                case "B-":
                    dr6 = 2.75 * h6;

                    break;

                case "C+":
                    dr6 = 2.5 * h6;
                    break;
                case "C":
                    dr6 = 2.0 * h6;
                    break;
                case "C-":
                    dr6 = 1.75 * h6;
                    break;
                case "D+":
                    dr6 = 1.5 * h6;
                    break;

                case "D":
                    dr6 = 1.0 * h6;
                    break;
                case "D-":
                    dr6 = 0.75 * h6;
                    break;

                case "F":
                    dr6 = 0.0 * h6;
                    break;


            }
        } else {
            h6 = 0.0;
            dr6 = 0.0;
        }

        if (c == checkBox7 & checkBox7.isChecked()) {
            h7 = Double.parseDouble(sp72.getSelectedItem().toString());
            switch (sp7.getSelectedItem().toString()) {

                case "----":
                    h7 = 0.0;
                    dr7 = 0.0;
                    break;

                case "A":
                    dr7 = 4.0 * h7;

                    break;

                case "A-":
                    dr7 = 3.75 * h7;

                    break;

                case "B+":
                    dr7 = 3.5 * h7;

                    break;
                case "B":
                    dr7 = 3.0 * h7;

                    break;

                case "B-":
                    dr7 = 2.75 * h7;

                    break;
                case "C+":
                    dr7 = 2.5 * h7;
                    break;
                case "C":
                    dr7 = 2.0 * h7;
                    break;
                case "C-":
                    dr7 = 1.75 * h7;
                    break;
                case "D+":
                    dr7 = 1.5 * h7;
                    break;

                case "D":
                    dr7 = 1.0 * h7;
                    break;
                case "D-":
                    dr7 = 0.75 * h7;
                    break;

                case "F":
                    dr7 = 0.0 * h7;
                    break;


            }
        } else {
            h7 = 0.0;
            dr7 = 0.0;
        }

        if (c == checkBox8 & checkBox8.isChecked()) {
            h8 = Double.parseDouble(sp82.getSelectedItem().toString());
            switch (sp8.getSelectedItem().toString()) {

                case "----":
                    h8 = 0.0;
                    dr8 = 0.0;
                    break;

                case "A":
                    dr8 = 4.0 * h8;
                    break;

                case "A-":
                    dr8 = 3.75 * h8;
                    break;

                case "B+":
                    dr8 = 3.5 * h8;
                    break;
                case "B":
                    dr8 = 3.0 * h8;
                    break;

                case "B-":
                    dr8 = 2.75 * h8;
                    break;

                case "C+":
                    dr8 = 2.5 * h8;
                    break;
                case "C":
                    dr8 = 2.0 * h8;
                    break;
                case "C-":
                    dr8 = 1.75 * h8;
                    break;
                case "D+":
                    dr8 = 1.5 * h8;
                    break;

                case "D":
                    dr8 = 1.0 * h8;
                    break;
                case "D-":
                    dr8 = 0.75 * h8;
                    break;

                case "F":
                    dr8 = 0.0 * h8;
                    break;


            }
        } else {
            h8 = 0.0;
            dr8 = 0.0;
        }

        double sumh1 = 0, sum1 = 0;
        sumh1 = h1 + h2 + h3 + h4 + h5 + h6 + h7 + h8;

        sum1 = k2h + kh + dr3 + dr4 + dr5 + dr6 + dr7 + dr8;


        total = new double[]{sum1, sumh1};

        return total;


    }


    public void A7sb(View view) {
        getads();
        l3.setVisibility(View.VISIBLE);
        imageView.setImageDrawable(less);
        if (mo3dl.getText().toString().equals("") || mo3dl.getText().toString().equals(".") || sa3a.getText().toString().equals("")) {
            openDialog1();
        } else {

            if (Double.parseDouble(mo3dl.getText().toString()) > 4) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast,
                        (ViewGroup) findViewById(R.id.toast_layout_root));
                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("الرجاء الانتباه إلى أن المعدل التراكمي المدخل أكبر من 4");
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
                old_Trakomy = Double.parseDouble(mo3dl.getText().toString());
                old_houre = Double.parseDouble(sa3a.getText().toString());
            }
            if (Double.parseDouble(mo3dl.getText().toString()) > 0 & Double.parseDouble(sa3a.getText().toString()) == 0) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast,
                        (ViewGroup) findViewById(R.id.toast_layout_root));
                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("الرجاء التأكد من الساعات التراكمية المدخلة");
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            } else {
                old_Trakomy = Double.parseDouble(mo3dl.getText().toString());
                old_houre = Double.parseDouble(sa3a.getText().toString());
            }

            Fasly = findViewById(R.id.fasly);
            Fasly.setText("0.0");
            Trakmy = findViewById(R.id.trakmy);
            Trakmy.setText(("0.0"));
            ss = sumh + old_houre;
            Hours = findViewById(R.id.hours);
            Hours.setText("0.0");
            ;


            s20 = old_Trakomy;
            s21 = old_houre;
            s1 = 0.0;
            s2 = 0.0;
            rh20 = 0;
            h20 = 0;


            if (checkBox1.isChecked()) {
                total = getResults1(checkBox1);
                s1 = s1 + total[0];
                s2 = s2 + total[1];
            } else {
                l = findViewById(R.id.v1);
                l.setVisibility(View.INVISIBLE);
            }

            if (checkBox2.isChecked()) {
                total = getResults1(checkBox2);
                s1 = s1 + total[0];
                s2 = s2 + total[1];
            } else {
                l = findViewById(R.id.v2);
                l.setVisibility(View.INVISIBLE);
            }

            if (checkBox3.isChecked()) {
                total = getResults1(checkBox3);
                s1 = s1 + total[0];
                s2 = s2 + total[1];
            } else {
                l = findViewById(R.id.v3);
                l.setVisibility(View.INVISIBLE);
            }
            if (checkBox4.isChecked()) {
                total = getResults1(checkBox4);
                s1 = s1 + total[0];
                s2 = s2 + total[1];
            } else {
                l = findViewById(R.id.v4);
                l.setVisibility(View.INVISIBLE);
            }

            if (checkBox5.isChecked()) {
                total = getResults1(checkBox5);
                s1 = s1 + total[0];
                s2 = s2 + total[1];
            } else {
                l = findViewById(R.id.v5);
                l.setVisibility(View.INVISIBLE);
            }

            if (checkBox6.isChecked()) {
                total = getResults1(checkBox6);
                s1 = s1 + total[0];
                s2 = s2 + total[1];
            } else {
                l = findViewById(R.id.v6);
                l.setVisibility(View.INVISIBLE);
            }

            if (checkBox7.isChecked()) {
                total = getResults1(checkBox7);
                s1 = s1 + total[0];
                s2 = s2 + total[1];
            } else {
                l = findViewById(R.id.v7);
                l.setVisibility(View.INVISIBLE);
            }
            if (checkBox8.isChecked()) {
                total = getResults1(checkBox8);
                s1 = s1 + total[0];
                s2 = s2 + total[1];
            } else {
                l = findViewById(R.id.v8);
                l.setVisibility(View.INVISIBLE);
            }


            if (checkBox1r.isChecked()) {

                total1 = getResultsR(checkBox1r);
                rh20 = total1[1];
                h20 = h20 + total1[0];

            }

            if (checkBox2r.isChecked()) {

                total1 = getResultsR(checkBox2r);
                rh20 = total1[1];
                h20 = h20 + total1[0];

            }

            if (checkBox3r.isChecked()) {

                total1 = getResultsR(checkBox3r);
                rh20 = total1[1];
                h20 = h20 + total1[0];

            }

            if (checkBox4r.isChecked()) {

                total1 = getResultsR(checkBox4r);
                rh20 = total1[1];
                h20 = h20 + total1[0];

            }

            if (checkBox5r.isChecked()) {

                total1 = getResultsR(checkBox5r);
                rh20 = total1[1];
                h20 = h20 + total1[0];

            }


            if (checkBox6r.isChecked()) {

                total1 = getResultsR(checkBox6r);
                rh20 = total1[1];
                h20 = h20 + total1[0];

            }

            if (checkBox7r.isChecked()) {

                total1 = getResultsR(checkBox7r);
                rh20 = total1[1];
                h20 = h20 + total1[0];

            }

            if (checkBox8r.isChecked()) {

                total1 = getResultsR(checkBox8r);
                rh20 = total1[1];
                h20 = h20 + total1[0];

            }

            sum = s1;
            sumh = s2;


            if (rh20 == 0) {
                ss = sum / sumh;
                Fasly.setText(formaate(String.valueOf(ss)));
                ss = (old_Trakomy * old_houre + sum) / (sumh + old_houre);
                Trakmy.setText(formaate(String.valueOf(ss)));
                ss = sumh + old_houre;
                Hours.setText(String.valueOf(ss));
            } else {
                if (rh20 == 0) {

                }
                ss = sum / sumh;
                Fasly.setText(formaate(String.valueOf(ss)));
                ss = (old_Trakomy * old_houre + sum - h20) / (sumh + old_houre - rh20);
                if (ss > 4 || (rh20 == old_houre & h20 != old_houre * old_Trakomy)) {
                    Toast.makeText(this, "يوجد خطأ في إدخال الرموز للمواد المعادة الرجاء التأكد والمحاولة لمرة إخرى ", Toast.LENGTH_LONG).show();
                } else {
                    Trakmy.setText(formaate(String.valueOf(ss)));
                    ss = sumh + old_houre - rh20;
                    Hours.setText(String.valueOf(ss));


                }
            }
        }

    }


    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        Intent my;
        switch (item.getItemId()) {

            case R.id.search:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=2Zv8UoN8yUE"));
                startActivity(my);
                break;
            case R.id.thermo:
                my = new Intent(this,Home.class);
                startActivity(my);
                break;

            case R.id.com:
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/1HeFJXW4DfFAQApyd1o0DwDEXylyEHPXy/view?usp=sharing"));
                startActivity(my);
                break;

            case R.id.ju:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("http://ju.edu.jo/home.aspx"));
                startActivity(my);
                break;


            case R.id.email:
                my = new Intent(this, A7sbM3dlk1.class);
                startActivity(my);
                break;

            case R.id.tasjel:
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("https://regweb2.ju.edu.jo:4443/selfregapp/home.xhtml"));
                startActivity(my);
                break;

            case R.id.elearning:
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("https://elearning.ju.edu.jo/"));
                startActivity(my);
                break;

            case R.id.checkupdate:
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer1221.CEJU&hl=en"));
                startActivity(my);
                break;

            case R.id.giveyourfeedback:
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer1221.CEJU&hl=en"));
                startActivity(my);
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void image(View view) {
        if(imageView.getDrawable().equals(less)){
            l3.setVisibility(View.GONE);
            imageView.setImageDrawable(more);
        }else{
            l3.setVisibility(View.VISIBLE);
            imageView.setImageDrawable(less);
        }


    }
    private String formaate(String s){
        if(s.length()>6){
            s=s.substring(0,5);
        }
        return s;
    }


}
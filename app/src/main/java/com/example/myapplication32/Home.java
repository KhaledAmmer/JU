package com.example.myapplication32;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

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

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Intent my;
    private DrawerLayout drawer;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.home);

        NavigationView navigationView = findViewById(R.id.navi);
        navigationView.setNavigationItemSelectedListener(this);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

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



    public void Unit_Converter(View view) {
        my=new Intent(Home.this,UnitConverter.class);
        startActivity(my);
    }

    public void Saturation_Pressure(View view) {
        my=new Intent(Home.this,ThermoSolver.class);
        startActivity(my);
    }

    public void Bubble_Dew(View view) {
        my=new Intent(Home.this,Bubble_Dew.class);
        startActivity(my);
    }

    public void Equations_Of_State(View view) {
        my=new Intent(Home.this,Equations_Of_State.class);
        startActivity(my);
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.satp:
                my = new Intent(this,ThermoSolver.class);
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

            case R.id.dew_bubble:
                my = new Intent(this,Bubble_Dew.class);
                startActivity(my);
                break;
            case R.id.Eos:
                my = new Intent(this,Equations_Of_State.class);
                startActivity(my);

                break;
            case R.id.chee:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer1221.CEJU"));
                startActivity(my);

                break;
            case R.id.tasjel:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer.ju"));
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

    };
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void Fugacity_Solver(View view) {
        my=new Intent(Home.this,Fugacity_Calculation.class);
        startActivity(my);
    }

    public void download(View view) {
        my = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer.test"));
        startActivity(my);
    }
}
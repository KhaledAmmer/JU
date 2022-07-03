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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    int l;
    Intent my;
    Uri uriUrl;
    private AdView mAdView;

    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getads();
        NavigationView navigationView = findViewById(R.id.navi);
        navigationView.setNavigationItemSelectedListener(this);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


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
    public void Bu_Jam3_Ejb(View view) {
        l = 1;
        my = new Intent(MainActivity.this, Mta_Klia_Ejbary.class);
        my.putExtra("p", l);
        startActivity(my);

    }

    public void Bu_Jame_E5ty(View view) {
        l = 0;
        my = new Intent(MainActivity.this, Mta_Klia_Ejbary.class);
        my.putExtra("p", l);
        startActivity(my);

    }

    public void Bu_Klia_ej(View view) {
        l = 3;
        my = new Intent(MainActivity.this, Mta_Klia_Ejbary.class);
        my.putExtra("p", l);
        startActivity(my);
    }

    public void Bu_T599_Ej(View view) {
        l = 2;
        my = new Intent(MainActivity.this, Mta_Klia_Ejbary.class);
        my.putExtra("p", l);
        startActivity(my);
    }

    public void Bu_T599_E5Tur(View view) {
        l = 4;
        my = new Intent(MainActivity.this, Mta_Klia_Ejbary.class);
        my.putExtra("p", l);
        startActivity(my);
    }

    public void Bu_3AM_Ej(View view) {
        l = 5;
        my = new Intent(MainActivity.this, Mta_Klia_Ejbary.class);
        my.putExtra("p", l);
        startActivity(my);
    }

    public void Bu_Dafater(View view) {
        uriUrl = Uri.parse("https://docs.google.com/document/d/1J2p4UqhubtRAMlUV1-q2YJbWYAIFkVR5ufpoJTbfyG8/edit?usp=sharing");
        my = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(my);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            break;
                        case R.id.nav_favorites:
                            my = new Intent(MainActivity.this, Softwares.class);
                            my.putExtra("p1", 1);
                            startActivity(my);

                            break;

                        case R.id.nav_search:
                            my = new Intent(MainActivity.this, Softwares.class);
                            my.putExtra("p1", 0);
                            startActivity(my);
                            break;

                        case R.id.nav_Youtube:
                            my = new Intent(MainActivity.this, Softwares.class);
                            my.putExtra("p1", 2);
                            startActivity(my);
                            break;
                        case R.id.nav_Other:
                            my = new Intent(MainActivity.this, Softwares.class);
                            my.putExtra("p1", 3);
                            startActivity(my);
                            break;
                    }

                    return true;
                }
            };
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
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

            case R.id.favoraite:
                my = new Intent(MainActivity.this, Contacte_Me.class);
                startActivity(my);
                break;

            case R.id.email:
                my = new Intent(MainActivity.this, A7sbM3dlk1.class);
                startActivity(my);
                break;

            case R.id.ju:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("http://ju.edu.jo/home.aspx"));
                startActivity(my);
                break;

            case R.id.tasjel:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("https://regweb2.ju.edu.jo:4443/selfregapp/home.xhtml"));
                startActivity(my);
                break;

            case R.id.elearning:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("https://elearning.ju.edu.jo/"));
                startActivity(my);
                break;

            case R.id.checkupdate:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer1221.CEJU&hl=en"));
                startActivity(my);
                break;

            case R.id.giveyourfeedback:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer1221.CEJU&hl=en"));
                startActivity(my);
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;

    };


}
package com.example.myapplication32;

import android.annotation.SuppressLint;
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

import java.util.ArrayList;

public class Mta_Klia_Ejbary extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView mrecycleview;
    myadapter mAdapter;
    RecyclerView.LayoutManager manager;
    ArrayList<addresses> Addresses;
    Uri uriUrl;
    Intent my;
    private DrawerLayout drawer;
    String[] String_Array;
    String[] String_Array_ar;
    private AdView mAdView;
    int i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mta__klia__ejbary);

     i=getIntent().getExtras().getInt("p");

        createExampleList(i);
        buildRecyclerView();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

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

    @SuppressLint("ResourceType")
    public void createExampleList(int p) {
        int l=0;

        mrecycleview = findViewById(R.id.rv);
        mrecycleview.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        mrecycleview.setHasFixedSize(true);
        String_Array=new String[]{};
        String_Array_ar=new String[]{};
        Addresses = new ArrayList<>();

        if (p == l) {

            String_Array=getResources().getStringArray(R.array.Jam3a_Ej);
            String_Array_ar=getResources().getStringArray(R.array.Jam3a_Ejar);
            for(int i=0;i<String_Array.length;i++) {
                Addresses.add(new addresses(String_Array[i], String_Array_ar[i]));}
            mrecycleview.setPadding(90, 5, 90, 0);
        }
        if (p == l+1) {

            String_Array=getResources().getStringArray(R.array.Jam3a_E5Ty);
            String_Array_ar=getResources().getStringArray(R.array.Jam3a_E5Tyar);
            for(int i=0;i<String_Array.length;i++) {
                Addresses.add(new addresses(String_Array[i],String_Array_ar[i]));}
            mrecycleview.setPadding(90, 5, 90, 0);
        }
        if (p == l+2) {
            String_Array_ar=getResources().getStringArray(R.array.Klia_Ejar);
            String_Array=getResources().getStringArray(R.array.Klia_Ej);
            for(int i=0;i<String_Array.length;i++) {
                Addresses.add(new addresses(String_Array[i], String_Array_ar[i]));}
            mrecycleview.setPadding(90, 5, 90, 0);
        }
        if (p == l+3) {
            String_Array=getResources().getStringArray(R.array.T599_Ej);
            String_Array_ar=getResources().getStringArray(R.array.T599_Ejar);
            for(int i=0;i<String_Array.length;i++) {
                Addresses.add(new addresses(String_Array[i], String_Array_ar[i]));}
            mrecycleview.setPadding(90, 5, 90, 0);

        }
        if (p == l+4) {
            String_Array_ar=getResources().getStringArray(R.array.T599_E5Ty_S1ar);
            String_Array=getResources().getStringArray(R.array.T599_E5Ty_S1);
            for(int i=0;i<String_Array.length;i++) {
                Addresses.add(new addresses(String_Array[i],String_Array_ar[i]));}
            mrecycleview.setPadding(90, 5, 90, 0);
        }
        if (p == l+5) {
            String_Array_ar=getResources().getStringArray(R.array.Ej_3amar);
            String_Array=getResources().getStringArray(R.array.Ej_3am);
            for(int i=0;i<String_Array.length;i++) {
                Addresses.add(new addresses(String_Array[i], String_Array_ar[i]));}
            mrecycleview.setPadding(90, 5, 90, 0);

        }

    }

    public void buildRecyclerView() {
        manager = new LinearLayoutManager(this);
        mAdapter = new myadapter(Addresses,1);
        mrecycleview.setLayoutManager(manager);
        mrecycleview.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new myadapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                switch (position) {
                    default:
                        Intent my = new Intent(Mta_Klia_Ejbary.this, Mwaad.class);
                        my.putExtra("p1", i);
                        my.putExtra("p2", position);
                        startActivity(my);



                }
            }
        });
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            Intent my = new Intent(Mta_Klia_Ejbary.this, MainActivity.class);
                            startActivity(my);
                            break;
                        case R.id.nav_favorites:
                            my = new Intent(Mta_Klia_Ejbary.this, Softwares.class);
                            my.putExtra("p1",1);
                            startActivity(my);
                            break;
                        case R.id.nav_search:
                            my = new Intent(Mta_Klia_Ejbary.this, Softwares.class);
                            my.putExtra("p1",0);
                            startActivity(my);
                            break;

                        case R.id.nav_Youtube:
                            my = new Intent(Mta_Klia_Ejbary.this, Softwares.class);
                            my.putExtra("p1",2);
                            startActivity(my);
                            break;
                        case R.id.nav_Other:
                            my = new Intent(Mta_Klia_Ejbary.this, Softwares.class);
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

            case R.id.com:
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/1HeFJXW4DfFAQApyd1o0DwDEXylyEHPXy/view?usp=sharing"));
                startActivity(my);
                break;

            case R.id.email:
                my = new Intent(Mta_Klia_Ejbary.this, A7sbM3dlk1.class);
                startActivity(my);
                break;
            case R.id.thermo:
                my = new Intent(this,Home.class);
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





package com.example.myapplication32;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
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

public class Softwares extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView mrecycleview;
    Intent my;
    myadapter1 mAdapter;
    myadapter2 mAdapter2;
    RecyclerView.LayoutManager manager;
    ArrayList<addresses> Addresses;
    Uri uriUrl;
    int[] image_id;
    String[] String_Array;
    String[] String_Array_ar;
    String[] String_Array_Uri;
    int p2;
    private AdView mAdView;
private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_softwares);
        p2 = getIntent().getExtras().getInt("p1");
        createExampleList();
        switch (p2){

            case 2:buildRecyclerView2();
            break;
            default: buildRecyclerView();
            break;
        }


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


    public void createExampleList() {
        mrecycleview = findViewById(R.id.rv);
        mrecycleview.setHasFixedSize(true);
        String_Array = new String[]{};
        Addresses = new ArrayList<>();
        switch (p2) {
            case 0:
                image_id = new int[]{R.drawable.matlab, R.drawable.octave, R.drawable.chemcad_logo, R.drawable.hysys, R.drawable.dwsim, R.drawable.thermosolver
                        , R.drawable.autocad, R.drawable.humiditychart, R.drawable.minitab, R.drawable.minirefprop, R.drawable.codeblocks, R.drawable.office, R.drawable.edx,
                        R.drawable.unitconverter, R.drawable.symbolab, R.drawable.desmos, R.drawable.slader, R.drawable.gephi, R.drawable.hiperscalc,R.drawable.m3dl};

                String_Array = getResources().getStringArray(R.array.software);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], image_id[i]));
                }
                break;

            case 1:
                image_id = new int[]{R.drawable.madar, R.drawable.cooper, R.drawable.union, R.drawable.dep, R.drawable.z4, R.drawable.blog,
                        R.drawable.c1, R.drawable.analy, R.drawable.organic, R.drawable.dep, R.drawable.dep,R.drawable.dep,R.drawable.dep,R.drawable.dep};

                String_Array = getResources().getStringArray(R.array.Social_Media);
                String_Array_Uri = getResources().getStringArray(R.array.Social_Media_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], image_id[i]));
                }

                break;

            case 2:
                image_id = new int[]{R.drawable.calc1, R.drawable.calc2, R.drawable.calc3, R.drawable.analy, R.drawable.organic, R.drawable.physics1
                        , R.drawable.physics2, R.drawable.math, R.drawable.stat, R.drawable.fluid, R.drawable.heat, R.drawable.learn
                };

                String_Array = getResources().getStringArray(R.array.Youtube);
                String_Array_ar = getResources().getStringArray(R.array.Youtube_ar);
                String_Array_Uri = getResources().getStringArray(R.array.Youtube_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], String_Array_ar[i], image_id[i]));
                }

                break;
            case 3:
                String_Array_Uri = getResources().getStringArray(R.array.OtherUri);
                String_Array = getResources().getStringArray(R.array.Other);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], R.drawable.dep));
                }

                break;

        }


    }

    public void buildRecyclerView() {
        mrecycleview = findViewById(R.id.rv);
        mrecycleview.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        mAdapter = new myadapter1(Addresses);
        mrecycleview.setLayoutManager(manager);
        mrecycleview.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new myadapter1.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                switch (p2){
                    case 0:
                        my = new Intent(Softwares.this, SoftwareFun.class);
                        my.putExtra("p", position);
                        startActivity(my);
                        break;
                    case 1:
                        switch (position) {
                            case 0:
                                uriUrl = Uri.parse(String_Array_Uri[0]);
                                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(my);
                                break;
                            case 1:
                                uriUrl = Uri.parse(String_Array_Uri[1]);
                                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(my);
                                break;
                            case 2:
                                uriUrl = Uri.parse(String_Array_Uri[2]);
                                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(my);
                                break;
                            case 3:
                                uriUrl = Uri.parse(String_Array_Uri[3]);
                                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(my);
                                break;
                            case 4:
                                uriUrl = Uri.parse(String_Array_Uri[4]);
                                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(my);
                                break;
                            case 5:
                                uriUrl = Uri.parse(String_Array_Uri[5]);
                                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(my);
                                break;
                            case 6:
                                uriUrl = Uri.parse(String_Array_Uri[6]);
                                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(my);
                                break;
                            case 7:
                                uriUrl = Uri.parse(String_Array_Uri[7]);
                                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(my);
                                break;
                            case 8:
                                uriUrl = Uri.parse(String_Array_Uri[8]);
                                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(my);
                                break;
                            case 9:
                                uriUrl = Uri.parse(String_Array_Uri[9]);
                                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(my);
                                break;
                            case 10:
                                uriUrl = Uri.parse(String_Array_Uri[10]);
                                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(my);
                                break;
                            case 11:
                                uriUrl = Uri.parse(String_Array_Uri[11]);
                                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(my);
                                break;

                            case 12:
                                uriUrl = Uri.parse(String_Array_Uri[12]);
                                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(my);
                                break;

                            case 13:
                                uriUrl = Uri.parse(String_Array_Uri[13]);
                                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(my);
                                break;
                            case 14:
                                uriUrl = Uri.parse(String_Array_Uri[14]);
                                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                startActivity(my);
                                break;


                        }
                        break;
                    case 3:
                        switch (String_Array_Uri[position]) {
                            case "Not":
                                my = new Intent(Softwares.this, other.class);
                                my.putExtra("po", position);
                                startActivity(my);
                                break;
                            default:
                                switch (position) {
                                    case 0:
                                        uriUrl = Uri.parse(String_Array_Uri[0]);
                                        my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(my);
                                        break;
                                    case 1:
                                        uriUrl = Uri.parse(String_Array_Uri[1]);
                                        my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(my);
                                        break;
                                    case 2:
                                        uriUrl = Uri.parse(String_Array_Uri[2]);
                                        my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(my);
                                        break;
                                    case 3:
                                        uriUrl = Uri.parse(String_Array_Uri[3]);
                                        my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(my);
                                        break;
                                    case 4:
                                        uriUrl = Uri.parse(String_Array_Uri[4]);
                                        my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(my);
                                        break;
                                    case 5:
                                        uriUrl = Uri.parse(String_Array_Uri[5]);
                                        my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(my);
                                        break;
                                    case 6:
                                        uriUrl = Uri.parse(String_Array_Uri[6]);
                                        my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(my);
                                        break;
                                    case 7:
                                        uriUrl = Uri.parse(String_Array_Uri[7]);
                                        my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(my);
                                        break;
                                    case 8:
                                        uriUrl = Uri.parse(String_Array_Uri[8]);
                                        my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(my);
                                        break;
                                    case 9:
                                        uriUrl = Uri.parse(String_Array_Uri[9]);
                                        my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(my);
                                        break;
                                    case 10:
                                        uriUrl = Uri.parse(String_Array_Uri[10]);
                                        my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(my);
                                        break;
                                    case 11:
                                        uriUrl = Uri.parse(String_Array_Uri[11]);
                                        my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(my);
                                        break;

                                    case 12:
                                        uriUrl = Uri.parse(String_Array_Uri[12]);
                                        my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(my);
                                        break;

                                    case 13:
                                        uriUrl = Uri.parse(String_Array_Uri[13]);
                                        my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(my);
                                        break;
                                    case 14:
                                        uriUrl = Uri.parse(String_Array_Uri[14]);
                                        my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                        startActivity(my);
                                        break;


                                }
                                break;
                        }
                    break;
                }


            }
        });
    }

    public void buildRecyclerView2() {
        mrecycleview = findViewById(R.id.rv);
        mrecycleview.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        mAdapter2 = new myadapter2(Addresses);
        mrecycleview.setLayoutManager(manager);
        mrecycleview.setAdapter(mAdapter2);
        mAdapter2.setOnItemClickListener(new myadapter2.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (p2 == 2) {
                    switch (String_Array_Uri[position]) {
                        case "Not":
                            my = new Intent(Softwares.this, YoutubeFun.class);
                            my.putExtra("p", position);
                            startActivity(my);
                            break;
                        default:
                            switch (position) {
                                case 0:
                                    uriUrl = Uri.parse(String_Array_Uri[0]);
                                    my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(my);
                                    break;
                                case 1:
                                    uriUrl = Uri.parse(String_Array_Uri[1]);
                                    my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(my);
                                    break;
                                case 2:
                                    uriUrl = Uri.parse(String_Array_Uri[2]);
                                    my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(my);
                                    break;
                                case 3:
                                    uriUrl = Uri.parse(String_Array_Uri[3]);
                                    my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(my);
                                    break;
                                case 4:
                                    uriUrl = Uri.parse(String_Array_Uri[4]);
                                    my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(my);
                                    break;
                                case 5:
                                    uriUrl = Uri.parse(String_Array_Uri[5]);
                                    my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(my);
                                    break;
                                case 6:
                                    uriUrl = Uri.parse(String_Array_Uri[6]);
                                    my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(my);
                                    break;
                                case 7:
                                    uriUrl = Uri.parse(String_Array_Uri[7]);
                                    my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(my);
                                    break;
                                case 8:
                                    uriUrl = Uri.parse(String_Array_Uri[8]);
                                    my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(my);
                                    break;
                                case 9:
                                    uriUrl = Uri.parse(String_Array_Uri[9]);
                                    my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(my);
                                    break;
                                case 10:
                                    uriUrl = Uri.parse(String_Array_Uri[10]);
                                    my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(my);
                                    break;
                                case 11:
                                    uriUrl = Uri.parse(String_Array_Uri[11]);
                                    my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(my);
                                    break;

                                case 12:
                                    uriUrl = Uri.parse(String_Array_Uri[12]);
                                    my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(my);
                                    break;

                                case 13:
                                    uriUrl = Uri.parse(String_Array_Uri[13]);
                                    my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(my);
                                    break;
                                case 14:
                                    uriUrl = Uri.parse(String_Array_Uri[14]);
                                    my = new Intent(Intent.ACTION_VIEW, uriUrl);
                                    startActivity(my);
                                    break;


                            }
                            break;

                    }
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
                            my = new Intent(Softwares.this, MainActivity.class);
                            startActivity(my);
                            break;
                        case R.id.nav_favorites:
                            my = new Intent(Softwares.this, Softwares.class);
                            my.putExtra("p1", 1);
                            startActivity(my);

                            break;
                        case R.id.nav_search:
                            my = new Intent(Softwares.this, Softwares.class);
                            my.putExtra("p1", 0);
                            startActivity(my);
                            break;

                        case R.id.nav_Youtube:
                            my = new Intent(Softwares.this, Softwares.class);
                            my.putExtra("p1", 2);
                            startActivity(my);
                            break;
                        case R.id.nav_Other:
                            my = new Intent(Softwares.this, Softwares.class);
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
                my = new Intent(Softwares.this, A7sbM3dlk1.class);
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

            case R.id.thermo:
                my = new Intent(this,Home.class);
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


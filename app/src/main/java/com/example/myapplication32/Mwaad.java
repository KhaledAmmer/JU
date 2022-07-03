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

public class Mwaad extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView mrecycleview;
    Intent my;
    myadapter mAdapter;
    RecyclerView.LayoutManager manager;
    ArrayList<addresses> Addresses;
    Uri uriUrl;
    int p1, p2, p3;
    int l1 = 0;
    int l2 = 0;
    int l3 = 0;
    String[] String_Array;
    String[] String_Array_Uri;
    String[] String_Array_ar;
    private AdView mAdView;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mwaad);
        p1 = getIntent().getExtras().getInt("p1");
        p2 = getIntent().getExtras().getInt("p2");
        createExampleList(p1, p2);
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


    public void createExampleList(int P1, int P2) {
        int l1 = 0;
        int l2 = 0;
        mrecycleview = findViewById(R.id.rv);
        mrecycleview.setHasFixedSize(true);
        mrecycleview.setPadding(90, 5, 90, 0);
        String_Array = new String[]{};
        String_Array_ar = new String[]{};
        Addresses = new ArrayList<>();

        if (P1 == l1) {
            if (P2 == l2) {
                String_Array_Uri = getResources().getStringArray(R.array.Al3lom_Al3skrya_Uri);
                String_Array = getResources().getStringArray(R.array.Al3lom_Al3skrya);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));
                }
            }

            if (P2 == l2 + 1) {
                String_Array_Uri = getResources().getStringArray(R.array.watnia_Uri);
                String_Array = getResources().getStringArray(R.array.watnia);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));
                }
            }

            if (P2 == l2 + 2) {
                String_Array_Uri = getResources().getStringArray(R.array.Learning_skills_Uri);
                String_Array = getResources().getStringArray(R.array.Learning_skills);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));
                }
            }
            if (P2 == l2 + 3) {
                String_Array_Uri = getResources().getStringArray(R.array.Communication_skills_Uri);
                String_Array = getResources().getStringArray(R.array.Communication_skills);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));
                }
            }
            if (P2 == l2 + 4) {
                String_Array_Uri = getResources().getStringArray(R.array.philosophy_Uri);
                String_Array = getResources().getStringArray(R.array.philosophy);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));
                }
            }


        }
        if (P1 == l1 + 1) {
            if (P2 == l2) {
                String_Array_ar = getResources().getStringArray(R.array.E5TY_Jam3a_G1ar);
                String_Array = getResources().getStringArray(R.array.E5TY_Jam3a_G1);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], String_Array_ar[i]));
                }
            }

            if (P2 == l2 + 1) {
                String_Array_ar = getResources().getStringArray(R.array.E5TY_Jam3a_G2ar);
                String_Array = getResources().getStringArray(R.array.E5TY_Jam3a_G2);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], String_Array_ar[i]));
                }
            }

            if (P2 == l2 + 2) {
                String_Array_ar = getResources().getStringArray(R.array.E5TY_Jam3a_G3ar);
                String_Array = getResources().getStringArray(R.array.E5TY_Jam3a_G3);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], String_Array_ar[i]));
                }
            }


        }
        if (P1 == l1 + 2) {
            if (P2 == l2) {
                String_Array = getResources().getStringArray(R.array.C_Plus_Plus);
                String_Array_Uri = getResources().getStringArray(R.array.C_Plus_Plus_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 + 1) {
                String_Array = getResources().getStringArray(R.array.Calculus_I);
                String_Array_Uri = getResources().getStringArray(R.array.Calculus_I_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 + 2) {
                String_Array = getResources().getStringArray(R.array.Calculus_II);
                String_Array_Uri = getResources().getStringArray(R.array.Calculus_II_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 + 3) {
                String_Array = getResources().getStringArray(R.array.Physics_I);
                String_Array_Uri = getResources().getStringArray(R.array.Physics_I_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 + 4) {
                String_Array = getResources().getStringArray(R.array.Physics_I_Lab);
                String_Array_Uri = getResources().getStringArray(R.array.Physics_I_Lab_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }

            if (P2 == l2 + 5) {
                String_Array = getResources().getStringArray(R.array.Technical_Writing);
                String_Array_Uri = getResources().getStringArray(R.array.Technical_Writing_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 + 6) {
                String_Array = getResources().getStringArray(R.array.Engineering_Economy);
                String_Array_Uri = getResources().getStringArray(R.array.Engineering_Economy_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 + 7) {
                String_Array = getResources().getStringArray(R.array.Engineering_Workshop);
                String_Array_Uri = getResources().getStringArray(R.array.Engineering_Workshop_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 + 8) {
                String_Array = getResources().getStringArray(R.array.Introduction_To_Engineering);
                String_Array_Uri = getResources().getStringArray(R.array.Introduction_To_Engineering_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 + 9) {
                String_Array = getResources().getStringArray(R.array.Engineering_Graphics);
                String_Array_Uri = getResources().getStringArray(R.array.Engineering_Graphics_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }

        }
        if (P1 == l1 + 3) {
            if (P2 == l2) {
                String_Array_ar = getResources().getStringArray(R.array.T599_Ej_S1ar);

                String_Array = getResources().getStringArray(R.array.T599_Ej_S1);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], String_Array_ar[i]));
                }
            }

            if (P2 == l2 + 1) {
                String_Array_ar = getResources().getStringArray(R.array.T599_Ej_S2ar);
                String_Array = getResources().getStringArray(R.array.T599_Ej_S2);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], String_Array_ar[i]));
                }
            }

            if (P2 == l2 + 2) {
                String_Array_ar = getResources().getStringArray(R.array.T599_Ej_S3ar);
                String_Array = getResources().getStringArray(R.array.T599_Ej_S3);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], String_Array_ar[i]));
                }
            }

            if (P2 == l2 + 3) {
                String_Array_ar = getResources().getStringArray(R.array.T599_Ej_S4ar);
                String_Array = getResources().getStringArray(R.array.T599_Ej_S4);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], String_Array_ar[i]));
                }
            }


            if (P2 == l2 + 4) {
                String_Array_ar = getResources().getStringArray(R.array.T599_Ej_S5ar);
                String_Array = getResources().getStringArray(R.array.T599_Ej_S5);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], String_Array_ar[i]));
                }
            }
            if (P2 == l2 + 5) {
                String_Array_ar = getResources().getStringArray(R.array.Labs);
                String_Array = getResources().getStringArray(R.array.Labs);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));
                }
            }


        }
        if (P1 == l1 + 4) {
            if (P2 == l2) {
                String_Array = getResources().getStringArray(R.array.Management);
                String_Array_Uri = getResources().getStringArray(R.array.Management_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }

            if (P2 == l2 + 1) {
                String_Array = getResources().getStringArray(R.array.Air_Pollution);
                String_Array_Uri = getResources().getStringArray(R.array.Air_Pollution_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }

            if (P2 == l2 + 2) {
                String_Array = getResources().getStringArray(R.array.Quality_Control);
                String_Array_Uri = getResources().getStringArray(R.array.Quality_Control_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }

            if (P2 == l2 + 3) {
                String_Array = getResources().getStringArray(R.array.Special_Topic);
                String_Array_Uri = getResources().getStringArray(R.array.Special_Topic_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }

            if (P2 == l2 + 4) {
                String_Array = getResources().getStringArray(R.array.Materials_Science);
                String_Array_Uri = getResources().getStringArray(R.array.Materials_Science_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }

            if (P2 == l2 + 5) {
                String_Array = getResources().getStringArray(R.array.Separation);
                String_Array_Uri = getResources().getStringArray(R.array.Separation_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }

            if (P2 == l2 + 6) {
                String_Array = getResources().getStringArray(R.array.Solid_Wast_Management);
                String_Array_Uri = getResources().getStringArray(R.array.Solid_Wast_Management_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
            if (P2 == l2 + 7) {
                String_Array = getResources().getStringArray(R.array.BioChemical_Engineering);
                String_Array_Uri = getResources().getStringArray(R.array.BioChemical_Engineering_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }

            if (P2 == l2 + 8) {
                String_Array = getResources().getStringArray(R.array.Corrosion_Engineering);
                String_Array_Uri = getResources().getStringArray(R.array.Corrosion_Engineering_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }

            if (P2 == l2 + 9) {
                String_Array = getResources().getStringArray(R.array.Process_Optimization);
                String_Array_Uri = getResources().getStringArray(R.array.Process_Optimization_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 + 10) {
                String_Array = getResources().getStringArray(R.array.Water_Desalination);
                String_Array_Uri = getResources().getStringArray(R.array.Water_Desalination_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }

            if (P2 == l2 + 11) {
                String_Array = getResources().getStringArray(R.array.Wast_Water_Treatment);
                String_Array_Uri = getResources().getStringArray(R.array.Wast_Water_Treatment_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 + 12) {
                String_Array = getResources().getStringArray(R.array.Metal_Extraction);
                String_Array_Uri = getResources().getStringArray(R.array.Metal_Extraction_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }


            if (P2 == l2 + 13) {
                String_Array = getResources().getStringArray(R.array.Polymer_Plastic_Engineering);
                String_Array_Uri = getResources().getStringArray(R.array.Polymer_Plastic_Engineering_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 + 14) {
                String_Array = getResources().getStringArray(R.array.Process_Analysis_Simulation);
                String_Array_Uri = getResources().getStringArray(R.array.Process_Analysis_Simulation_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }


        }
        if (P1 == l1 + 5) {
            if (P2 == l2) {
                String_Array = getResources().getStringArray(R.array.Computer_basics);
                String_Array_Uri = getResources().getStringArray(R.array.Computer_basics_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 + 1) {
                String_Array = getResources().getStringArray(R.array.Arabic_basics);
                String_Array_Uri = getResources().getStringArray(R.array.Arabic_basics_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 + 2) {
                String_Array = getResources().getStringArray(R.array.Arabic_Skills);
                String_Array_Uri = getResources().getStringArray(R.array.Arabic_Skills_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 + 3) {
                String_Array = getResources().getStringArray(R.array.English_basics);
                String_Array_Uri = getResources().getStringArray(R.array.English_basics_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 + 4) {
                String_Array = getResources().getStringArray(R.array.English_Skills);
                String_Array_Uri = getResources().getStringArray(R.array.English_Skills_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }


        }

    }


    public void buildRecyclerView() {
        mrecycleview = findViewById(R.id.rv);
        mrecycleview.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        mAdapter = new myadapter(Addresses, 1);
        mrecycleview.setLayoutManager(manager);
        mrecycleview.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new myadapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (p1 != 1 && p1 != 3) {
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
                        case 15:
                            uriUrl = Uri.parse(String_Array_Uri[14]);
                            my = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(my);
                            break;
                        case 16:
                            uriUrl = Uri.parse(String_Array_Uri[14]);
                            my = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(my);
                            break;
                        case 17:
                            uriUrl = Uri.parse(String_Array_Uri[14]);
                            my = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(my);
                            break;
                        case 18:
                            uriUrl = Uri.parse(String_Array_Uri[14]);
                            my = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(my);
                            break;
                        case 19:
                            uriUrl = Uri.parse(String_Array_Uri[14]);
                            my = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(my);
                            break;
                        case 20:
                            uriUrl = Uri.parse(String_Array_Uri[14]);
                            my = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(my);
                            break;
                        case 21:
                            uriUrl = Uri.parse(String_Array_Uri[14]);
                            my = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(my);
                            break;
                        case 22:
                            uriUrl = Uri.parse(String_Array_Uri[14]);
                            my = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(my);
                            break;
                        case 23:
                            uriUrl = Uri.parse(String_Array_Uri[14]);
                            my = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(my);
                            break;
                        case 24:
                            uriUrl = Uri.parse(String_Array_Uri[14]);
                            my = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(my);
                            break;
                        case 25:
                            uriUrl = Uri.parse(String_Array_Uri[14]);
                            my = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(my);
                            break;
                        case 26:
                            uriUrl = Uri.parse(String_Array_Uri[14]);
                            my = new Intent(Intent.ACTION_VIEW, uriUrl);
                            startActivity(my);
                            break;


                    }
                } else {
                    Intent my = new Intent(Mwaad.this, T599_Mwad.class);
                    my.putExtra("p1", p1);
                    my.putExtra("p2", p2);
                    my.putExtra("p3", position);
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
                            Intent my = new Intent(Mwaad.this, MainActivity.class);
                            startActivity(my);
                            break;
                        case R.id.nav_favorites:
                            my = new Intent(Mwaad.this, Softwares.class);
                            my.putExtra("p1", 1);
                            startActivity(my);
                            break;
                        case R.id.nav_search:
                            my = new Intent(Mwaad.this, Softwares.class);
                            my.putExtra("p1", 0);
                            startActivity(my);
                            break;

                        case R.id.nav_Youtube:
                            my = new Intent(Mwaad.this, Softwares.class);
                            my.putExtra("p1", 2);
                            startActivity(my);
                            break;

                        case R.id.nav_Other:
                            my = new Intent(Mwaad.this, Softwares.class);
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
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=2Zv8UoN8yUE"));
                startActivity(my);
                break;

            case R.id.thermo:
                my = new Intent(this, Home.class);
                startActivity(my);
                break;

            case R.id.com:
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/1HeFJXW4DfFAQApyd1o0DwDEXylyEHPXy/view?usp=sharing"));
                startActivity(my);
                break;

            case R.id.email:
                my = new Intent(Mwaad.this, A7sbM3dlk1.class);
                startActivity(my);
                break;

            case R.id.ju:
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ju.edu.jo/home.aspx"));
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

    ;
}
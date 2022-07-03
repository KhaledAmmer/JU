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

public class T599_Mwad extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView mrecycleview;
    myadapter mAdapter;
    RecyclerView.LayoutManager manager;
    ArrayList<addresses> Addresses;
    Uri uriUrl;
    int p1, p2,p3;
    int l1 = 0;
    int l2 = 0;
    int l3=0;
    String[] String_Array;
    String[] String_Array_Uri;
    Intent my;
    private DrawerLayout drawer;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t599__mwad);
        p1 = getIntent().getExtras().getInt("p1");
        p2= getIntent().getExtras().getInt("p2");
        p3=getIntent().getExtras().getInt("p3");
        createExampleList(p1, p2,p3);
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

    public void createExampleList(int P1, int P2,int P3) {


        mrecycleview = findViewById(R.id.rv);
        mrecycleview.setHasFixedSize(true);
        mrecycleview.setPadding(90, 5, 90, 0);

        String_Array=new String[]{};
        Addresses = new ArrayList<>();
        if (P1 == l1+3) {
            if (P2 == l2 && P3 == l3) {
                String_Array = getResources().getStringArray(R.array.Chemistry_I);
                String_Array_Uri = getResources().getStringArray(R.array.Chemistry_I_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            //Chemistry_Lab_I
            if (P2 == l2 && P3 == l3+1) {
                String_Array_Uri = getResources().getStringArray(R.array.Chemistry_I_Lab_Uri);
                String_Array = getResources().getStringArray(R.array.Chemistry_I_lab);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));
                }

            }
            if (P2 == l2 && P3 == l3+2) {
                String_Array_Uri = getResources().getStringArray(R.array.Chemistry_II_Uri);
                String_Array = getResources().getStringArray(R.array.Chemistry_II);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));
                }

            }
            if (P2 == l2 && P3 == l3+3) {
                String_Array_Uri = getResources().getStringArray(R.array.Physics_II_Uri);
                String_Array = getResources().getStringArray(R.array.Physics_II);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));
                }

            }
            if (P2 == l2 && P3 == l3+4) {

                String_Array_Uri = getResources().getStringArray(R.array.Principle_I_Uri);
                String_Array = getResources().getStringArray(R.array.Principles_I);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));
                }

            }
            //Second_Year
            if (P2 == l2 +1&& P3 == l3){
                String_Array_Uri = getResources().getStringArray(R.array.Principle_II_Uri);
                String_Array = getResources().getStringArray(R.array.Principles_II);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));
                }


            }
            if (P2 == l2 +1&& P3 == l3+1){
                String_Array = getResources().getStringArray(R.array.Fluid);
                String_Array_Uri = getResources().getStringArray(R.array.Fluid_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +1&& P3 == l3+2){
                String_Array = getResources().getStringArray(R.array.Calculus_III);
                String_Array_Uri = getResources().getStringArray(R.array.Calculus_III_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +1&& P3 == l3+3){
                String_Array = getResources().getStringArray(R.array.Mathematical);
                String_Array_Uri = getResources().getStringArray(R.array.Mathematical_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +1&& P3 == l3+4){
                String_Array = getResources().getStringArray(R.array.Analytical_Chemistry);
                String_Array_Uri = getResources().getStringArray(R.array.Analytical_Chemistry_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +1&& P3 == l3+5){
                String_Array = getResources().getStringArray(R.array.Analytical_Chemistry_Lab);
                String_Array_Uri = getResources().getStringArray(R.array.Analytical_Chemistry_Lab_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +1&& P3 == l3+6){
                String_Array = getResources().getStringArray(R.array.Organic_Chemistry);
                String_Array_Uri = getResources().getStringArray(R.array.Organic_Chemistry_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +1&& P3 == l3+7){
                String_Array = getResources().getStringArray(R.array.Organic_Chemistry_Lab);
                String_Array_Uri = getResources().getStringArray(R.array.Organic_Chemistry_Lab_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +1&& P3 == l3+8){
                String_Array = getResources().getStringArray(R.array.Electrical);
                String_Array_Uri = getResources().getStringArray(R.array.Electrical_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +2&& P3 == l3){
                String_Array = getResources().getStringArray(R.array.Thermo_I);
                String_Array_Uri = getResources().getStringArray(R.array.Thermo_I_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +2&& P3 == l3+1){
                String_Array = getResources().getStringArray(R.array.Thermo_II);
                String_Array_Uri = getResources().getStringArray(R.array.Thermo_II_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +2&& P3 == l3+2){
                String_Array = getResources().getStringArray(R.array.Solid_Operation);
                String_Array_Uri = getResources().getStringArray(R.array.Solid_Operation_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +2&& P3 == l3+3){
                String_Array = getResources().getStringArray(R.array.Heat_Transfer);
                String_Array_Uri = getResources().getStringArray(R.array.Heat_Transfer_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +2&& P3 == l3+4){
                String_Array = getResources().getStringArray(R.array.Numerical_Methods);
                String_Array_Uri = getResources().getStringArray(R.array.Numerical_Methods_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +2&& P3 == l3+5){
                String_Array = getResources().getStringArray(R.array.Statistic);
                String_Array_Uri = getResources().getStringArray(R.array.Statistic_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +2&& P3 == l3+6){
                String_Array = getResources().getStringArray(R.array.Environmental_Engineering);
                String_Array_Uri = getResources().getStringArray(R.array.Environmental_Engineering_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
            //***************************************************************** 4rd Year

            if (P2 == l2 +3&& P3 == l3){
                String_Array = getResources().getStringArray(R.array.Mass_Transfer);
                String_Array_Uri = getResources().getStringArray(R.array.Mass_Transfer_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
            if (P2 == l2 +3&& P3 == l3+1){
                String_Array = getResources().getStringArray(R.array.Rex_I);
                String_Array_Uri = getResources().getStringArray(R.array.Rex_I_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
            if (P2 == l2 +3&& P3 == l3+2){
                String_Array = getResources().getStringArray(R.array.Rex_II);
                String_Array_Uri = getResources().getStringArray(R.array.Rex_II_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
            if (P2 == l2 +3&& P3 == l3+3){
                String_Array = getResources().getStringArray(R.array.Control);
                String_Array_Uri = getResources().getStringArray(R.array.Control_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
            if (P2 == l2 +3&& P3 == l3+4){
                String_Array = getResources().getStringArray(R.array.Combined);
                String_Array_Uri = getResources().getStringArray(R.array.Combined_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            if (P2 == l2 +3&& P3 == l3+5){
                String_Array = getResources().getStringArray(R.array.Process_Design);
                String_Array_Uri = getResources().getStringArray(R.array.Process_Design_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
            if (P2 == l2 +3&& P3 == l3+6){
                String_Array = getResources().getStringArray(R.array.Process_Safety_Engineering);
                String_Array_Uri = getResources().getStringArray(R.array.Process_Safety_Engineering_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
            if (P2 == l2 +3&& P3 == l3+7){
                String_Array = getResources().getStringArray(R.array.Physical_Chemistry);
                String_Array_Uri = getResources().getStringArray(R.array.Physical_Chemistry_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
//************************************************************* 5th Year
            if (P2 == l2 +4&& P3 == l3){
                String_Array = getResources().getStringArray(R.array.Local_Chemical_Process);
                String_Array_Uri = getResources().getStringArray(R.array.Local_Chemical_Process_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }

            if (P2 == l2 +4&& P3 == l3+1){
                String_Array = getResources().getStringArray(R.array.Process_Dynamics_and_Control);
                String_Array_Uri = getResources().getStringArray(R.array.Process_Dynamics_and_Control_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
            if (P2 == l2 +4&& P3 == l3+2){
                String_Array = getResources().getStringArray(R.array.Chemical_Plant_Design);
                String_Array_Uri = getResources().getStringArray(R.array.Chemical_Plant_Design_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
            if (P2 == l2 +5&& P3 == l3){

                String_Array = getResources().getStringArray(R.array.Lab_I);
                String_Array_Uri = getResources().getStringArray(R.array.Lab_I_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
            if (P2 == l2 +5&& P3 == l3+1){

                String_Array = getResources().getStringArray(R.array.Lab_II);
                String_Array_Uri = getResources().getStringArray(R.array.Lab_II_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }

            if (P2 == l2 +5&& P3 == l3+2){

                String_Array = getResources().getStringArray(R.array.Lab_III);
                String_Array_Uri = getResources().getStringArray(R.array.Lab_III_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }

            if (P2 == l2 +5&& P3 == l3+3){

                String_Array = getResources().getStringArray(R.array.Lab_IV);
                String_Array_Uri = getResources().getStringArray(R.array.Lab_IV_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
            if (P2 == l2 +5&& P3 == l3+3){

                String_Array = getResources().getStringArray(R.array.Lab_IV);
                String_Array_Uri = getResources().getStringArray(R.array.Lab_IV_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
            if (P2 == l2 +5&& P3 == l3+4){

                String_Array = getResources().getStringArray(R.array.Chemistry_I_lab);
                String_Array_Uri = getResources().getStringArray(R.array.Chemistry_I_Lab_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
            if (P2 == l2 +5&& P3 == l3+5){

                String_Array = getResources().getStringArray(R.array.Analytical_Chemistry_Lab);
                String_Array_Uri = getResources().getStringArray(R.array.Analytical_Chemistry_Lab_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }

            if (P2 == l2 +5&& P3 == l3+6){

                String_Array = getResources().getStringArray(R.array.Organic_Chemistry_Lab);
                String_Array_Uri = getResources().getStringArray(R.array.Organic_Chemistry_Lab_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }

            if (P2 == l2 +5&& P3 == l3+7){

                String_Array = getResources().getStringArray(R.array.Physics_I_Lab);
                String_Array_Uri = getResources().getStringArray(R.array.Physics_I_Lab_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }
            if (P2 == l2 +5&& P3 == l3+8){

                String_Array = getResources().getStringArray(R.array.Matlab);
                String_Array_Uri = getResources().getStringArray(R.array.Matlab_Uri);

                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }

            }



        }
        if (P1 == l1+1) {
            if (P2 == l2 && P3 == l3) {
                String_Array = getResources().getStringArray(R.array.Eslam_kdaya);
                String_Array_Uri = getResources().getStringArray(R.array.Eslam_kdaya_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }
            }
            //Chemistry_Lab_I
            if (P2 == l2 && P3 == l3+1) {
                String_Array_Uri = getResources().getStringArray(R.array.jordan_tare5_7dara_Uri);
                String_Array = getResources().getStringArray(R.array.Jordan_tare5_7dara);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));
                }

            }
            if (P2 == l2 && P3 == l3+2) {
                String_Array_Uri = getResources().getStringArray(R.array.Alkods_Uri);
                String_Array = getResources().getStringArray(R.array.Alkods);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));
                }

            }


            if (P2 == l2 +1&& P3 == l3){
                String_Array = getResources().getStringArray(R.array.Althqafa_Albeeya);
                String_Array_Uri = getResources().getStringArray(R.array.Althqafa_Albeeya_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));
                }


            }
            if (P2 == l2 +1&& P3 == l3+1){
                String_Array = getResources().getStringArray(R.array.Althkafa_Alislmea);
                String_Array_Uri = getResources().getStringArray(R.array.Althkafa_Alislmea_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +1&& P3 == l3+2){
                String_Array = getResources().getStringArray(R.array.Althqafa_Als7ya);
                String_Array_Uri = getResources().getStringArray(R.array.Althqafa_Als7ya_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +1&& P3 == l3+3){
                String_Array = getResources().getStringArray(R.array.Althqafa_Albadanya);
                String_Array_Uri = getResources().getStringArray(R.array.Althqafa_Albadanya_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }


            if (P2 == l2 +2&& P3 == l3){
                String_Array = getResources().getStringArray(R.array.Altegara_Alelctronia);
                String_Array_Uri = getResources().getStringArray(R.array.Altegara_Alelctronia_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +2&& P3 == l3+1){
                String_Array = getResources().getStringArray(R.array.Social_Media1);
                String_Array_Uri = getResources().getStringArray(R.array.Social_Media1_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +2&& P3 == l3+2){
                String_Array = getResources().getStringArray(R.array.Arts);
                String_Array_Uri = getResources().getStringArray(R.array.Arts_Uri);
                for (int i = 0; i < String_Array.length; i++) {
                    Addresses.add(new addresses(String_Array[i], ""));

                }


            }
            if (P2 == l2 +2&& P3 == l3+3){
                String_Array = getResources().getStringArray(R.array.Modo3_5a8);
                String_Array_Uri = getResources().getStringArray(R.array.Modo3_5a8_Uri);
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
        mAdapter = new myadapter(Addresses,1);
        mrecycleview.setLayoutManager(manager);
        mrecycleview.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new myadapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent my;
                switch (position){
                    case 0:
                        uriUrl = Uri.parse( String_Array_Uri[0]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 1:
                        uriUrl = Uri.parse( String_Array_Uri[1]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 2:
                        uriUrl = Uri.parse( String_Array_Uri[2]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 3:
                        uriUrl = Uri.parse( String_Array_Uri[3]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 4:
                        uriUrl = Uri.parse( String_Array_Uri[4]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 5:
                        uriUrl = Uri.parse( String_Array_Uri[5]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 6:
                        uriUrl = Uri.parse( String_Array_Uri[6]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 7:
                        uriUrl = Uri.parse( String_Array_Uri[7]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 8:
                        uriUrl = Uri.parse( String_Array_Uri[8]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 9:
                        uriUrl = Uri.parse( String_Array_Uri[9]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 10:
                        uriUrl = Uri.parse( String_Array_Uri[10]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 11:
                        uriUrl = Uri.parse( String_Array_Uri[11]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;

                    case 12:
                        uriUrl = Uri.parse( String_Array_Uri[12]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;

                    case 13:
                        uriUrl = Uri.parse( String_Array_Uri[13]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 14:
                        uriUrl = Uri.parse( String_Array_Uri[14]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 15:
                        uriUrl = Uri.parse( String_Array_Uri[14]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 16:
                        uriUrl = Uri.parse( String_Array_Uri[14]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 17:
                        uriUrl = Uri.parse( String_Array_Uri[14]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 18:
                        uriUrl = Uri.parse( String_Array_Uri[14]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 19:
                        uriUrl = Uri.parse( String_Array_Uri[14]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break; case 20:
                        uriUrl = Uri.parse( String_Array_Uri[14]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break; case 21:
                        uriUrl = Uri.parse( String_Array_Uri[14]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 22:
                        uriUrl = Uri.parse( String_Array_Uri[14]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 23:
                        uriUrl = Uri.parse( String_Array_Uri[14]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 24:
                        uriUrl = Uri.parse( String_Array_Uri[14]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 25:
                        uriUrl = Uri.parse( String_Array_Uri[14]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;
                    case 26:
                        uriUrl = Uri.parse( String_Array_Uri[14]);
                        my = new Intent(Intent.ACTION_VIEW,uriUrl );
                        startActivity(my);
                        break;








                }


            }



        });
    }
    public void Get_String_Array(){

        int N=String_Array.length;
        for (int c=0;c<N;c++) {
            for (int j=0;j<N&&j!=c ;j++) {
                if(String_Array[c].charAt(0)<String_Array[j].charAt(0)) {
                    String ch;
                    ch=String_Array[c];
                    String_Array[c]=String_Array[j];
                    String_Array[j]=ch;
                    ch=String_Array_Uri[c];
                    String_Array_Uri[c]=String_Array_Uri[j];
                    String_Array_Uri[j]=ch;
                    break;
                }

            }

        }
        for (int i = 0; i < String_Array.length; i++) {

            Addresses.add(new addresses(String_Array[i], ""));

        }

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                             my = new Intent(T599_Mwad.this, MainActivity.class);
                            startActivity(my);
                            break;
                        case R.id.nav_favorites:
                            my = new Intent(T599_Mwad.this, Softwares.class);
                            my.putExtra("p1",1);
                            startActivity(my);
                            break;
                        case R.id.nav_search:
                            my = new Intent(T599_Mwad.this, Softwares.class);
                            my.putExtra("p1",0);
                            startActivity(my);
                            break;
                        case R.id.nav_Youtube:
                            my = new Intent(T599_Mwad.this, Softwares.class);
                            my.putExtra("p1",2);
                            startActivity(my);
                            break;

                        case R.id.nav_Other:
                            my = new Intent(T599_Mwad.this, Softwares.class);
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


            case R.id.email:
                my = new Intent(T599_Mwad.this, A7sbM3dlk1.class);
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
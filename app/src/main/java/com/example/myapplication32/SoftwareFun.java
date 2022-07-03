package com.example.myapplication32;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class SoftwareFun extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
TextView description;
String[] Descripton_Array,Windows_Uri,How_To_Install_Uri,Mobile_App_Uri;
int p1;
Intent my;
Uri uriUrl;
private DrawerLayout drawer;
private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        p1=getIntent().getExtras().getInt("p");
        setContentView(R.layout.activity_software_fun);
        description=findViewById(R.id.description);
        Descripton_Array=getResources().getStringArray(R.array.description);
        description.setText(Descripton_Array[p1]);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        How_To_Install_Uri=getResources().getStringArray(R.array.How_To_Install_Uri);
        Windows_Uri=getResources().getStringArray(R.array.Download_for_Windows_Uri);
        Mobile_App_Uri=getResources().getStringArray(R.array.Download_for_Mobile_Uri);

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

    public void howToInstall(View view) {
        uriUrl = Uri.parse(How_To_Install_Uri[p1]);
        my = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(my);
    }

    public void DownloadForWindows(View view) {
        uriUrl = Uri.parse(Windows_Uri[p1]);
        my = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(my);
    }


    public void MobileApp(View view) {
        switch (Mobile_App_Uri[p1]){
            case "n": Toast.makeText(this," No Mobile App Found :(  :" , Toast.LENGTH_LONG).show();
            break;
            default:uriUrl = Uri.parse(Mobile_App_Uri[p1]);
                my = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(my);
                break;

        }

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            my = new Intent(SoftwareFun.this, MainActivity.class);
                            startActivity(my);
                            break;
                        case R.id.nav_favorites:
                            my = new Intent(SoftwareFun.this, Softwares.class);
                            my.putExtra("p1",1);
                            startActivity(my);
                            break;
                        case R.id.nav_search:
                            my = new Intent(SoftwareFun.this, Softwares.class);
                            my.putExtra("p1",0);
                            startActivity(my);
                            break;

                        case R.id.nav_Youtube:
                            my = new Intent(SoftwareFun.this, Softwares.class);
                            my.putExtra("p1",2);
                            startActivity(my);
                            break;
                        case R.id.nav_Other:
                            my = new Intent(SoftwareFun.this, Softwares.class);
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
                my = new Intent(SoftwareFun.this, A7sbM3dlk1.class);
                startActivity(my);
                break;

            case R.id.ju:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("http://ju.edu.jo/home.aspx"));
                startActivity(my);
                break;

            case R.id.thermo:
                my = new Intent(this,Home.class);
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
}
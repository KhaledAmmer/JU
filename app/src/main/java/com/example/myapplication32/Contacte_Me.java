package com.example.myapplication32;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Contacte_Me extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView description;
    String[] Descripton_Array,Windows_Uri,How_To_Install_Uri,Mobile_App_Uri;
    int p1;
    Intent my;
    Uri uriUrl;
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contanctme);
        description=findViewById(R.id.description);
        description.setText("إذا كنت ترغب بمشاركة محتواك داخل التطبيق سواء ملخصات أو كتب أو حتى فيديوهات تعليمية أو أي شيء تراه مناسبا بإمكانك تواصل معي مباشر عن طريق وسائل التواصل الاجتماعي الموجودة في الأسفل  ");

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





    }



    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            my = new Intent(Contacte_Me.this, MainActivity.class);
                            startActivity(my);
                            break;
                        case R.id.nav_favorites:
                            my = new Intent(Contacte_Me.this, Softwares.class);
                            my.putExtra("p1",1);
                            startActivity(my);
                            break;
                        case R.id.nav_search:
                            my = new Intent(Contacte_Me.this, Softwares.class);
                            my.putExtra("p1",0);
                            startActivity(my);
                            break;

                        case R.id.nav_Youtube:
                            my = new Intent(Contacte_Me.this, Softwares.class);
                            my.putExtra("p1",2);
                            startActivity(my);
                            break;
                        case R.id.nav_Other:
                            my = new Intent(Contacte_Me.this, Softwares.class);
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

            case R.id.ju:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("http://ju.edu.jo/home.aspx"));
                startActivity(my);
                break;


            case R.id.email:
                my = new Intent(Contacte_Me.this, A7sbM3dlk1.class);
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

    public void Facebook(View view) {
        uriUrl = Uri.parse("https://www.facebook.com/khaledamersyr");
        my = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(my);
    }

    public void Whatsapp(View view) {
        uriUrl = Uri.parse("https://docs.google.com/document/d/1ozaZcITQKouSuhUEy66Bn3Ntqo2doAZXsXxM6DLrgXI/edit?usp=sharing");
        my = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(my);
    }

    public void Gmail(View view) {
        uriUrl = Uri.parse("https://docs.google.com/document/d/15fCwSNbaYFRKHzB3XukjxCeI6rUU8x8G-1y6ezTypDc/edit?usp=sharing");
        my = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(my);
    }


}
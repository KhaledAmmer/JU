package com.example.myapplication32;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class other extends AppCompatActivity {
    RecyclerView mrecycleview;
    myadapter mAdapter;
    RecyclerView.LayoutManager manager;
    ArrayList<addresses> Addresses;
    Uri uriUrl;
    Intent my;
    String[] String_Array;
    String[] String_Array_ar;
    String[] String_Array_Uri;
    int p;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);


        p = getIntent().getExtras().getInt("po");
        ;
        createExampleList();
        buildRecyclerView();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }


    public void createExampleList() {
        int l = 0;

        mrecycleview = findViewById(R.id.rv);
        mrecycleview.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        mrecycleview.setHasFixedSize(true);
        mrecycleview.setPadding(90, 50, 90, 0);
        String_Array = new String[]{};
        String_Array_Uri = new String[]{};
        Addresses = new ArrayList<>();

        if (p == 4) {
            String_Array = getResources().getStringArray(R.array.Social_Media);
            String_Array_Uri = getResources().getStringArray(R.array.Social_Media_Uri);
            for (int i = 0; i < String_Array.length; i++) {
                Addresses.add(new addresses(String_Array[i], ""));
            }


        }
        if (p == 5) {
            String_Array = getResources().getStringArray(R.array.Youtube);
            String_Array_ar = getResources().getStringArray(R.array.Youtube_ar);
            String_Array_Uri = getResources().getStringArray(R.array.Youtube_Uri);
            for (int i = 0; i < String_Array.length; i++) {
                Addresses.add(new addresses(String_Array[i], String_Array_ar[i]));
            }

        }
    }

    public void buildRecyclerView () {
        manager = new LinearLayoutManager(this);
        mAdapter = new myadapter(Addresses, 1);
        mrecycleview.setLayoutManager(manager);
        mrecycleview.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new myadapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if(p==4){
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


                    }}
                if(p==5){ switch (String_Array_Uri[position]) {
                    case "Not":
                        my = new Intent(other.this, YoutubeFun.class);
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

                }}

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
                            Intent my = new Intent(other.this, MainActivity.class);
                            startActivity(my);
                            break;
                        case R.id.nav_favorites:
                            my = new Intent(other.this, Softwares.class);
                            my.putExtra("p1", 1);
                            startActivity(my);
                            break;
                        case R.id.nav_search:
                            my = new Intent(other.this, Softwares.class);
                            my.putExtra("p1", 0);
                            startActivity(my);
                            break;

                        case R.id.nav_Youtube:
                            my = new Intent(other.this, Softwares.class);
                            my.putExtra("p1", 2);
                            startActivity(my);
                            break;


                        case R.id.nav_Other:
                            my = new Intent(other.this, Softwares.class);
                            my.putExtra("p1", 3);
                            startActivity(my);
                            break;
                    }

                    return true;
                }
            };
}
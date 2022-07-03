package com.example.myapplication32;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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
import java.util.ArrayList;

public class ThermoSolver extends AppCompatActivity implements AdapterView.OnItemSelectedListener ,NavigationView.OnNavigationItemSelectedListener{
    EditText T, P;
    ArrayList arrayList;
    TextView A, B, C, textView, textView2, Tmax, Tmin, unitmax, unitmin, unit, unitp, unit1, tcri, pcri, unit1t, unitpt;
    double temper, pressuresat;
    LinearLayout l;
    String Tunit, Punit;
    Spinner sT, sP, sSS;
    String[] As, Bs, Cs, Tmins, Tmaxs, tcris, pcris,Acntrics;
    NumberFormat formatter, formatter1;
    double[] n;
    double a1, c1, b1;
    Intent my;
    private AdView mAdView;
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermo_solver);
        formatter = new DecimalFormat("#,##0.00000");
        formatter1 = new DecimalFormat("#,##0.00");
        NavigationView navigationView = findViewById(R.id.navi);
        navigationView.setNavigationItemSelectedListener(this);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        FindId();
        GetResources();


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

    public void GetResources() {
        As = getResources().getStringArray(R.array.constant_a);
        Bs = getResources().getStringArray(R.array.constant_b);
        Cs = getResources().getStringArray(R.array.constant_c);
        Tmaxs = getResources().getStringArray(R.array.t_max);
        Tmins = getResources().getStringArray(R.array.t_min);
        tcris = getResources().getStringArray(R.array.t_critical);
        pcris = getResources().getStringArray(R.array.p_critical);
        n = new double[3];

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Temperature, R.layout.text1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sT.setAdapter(adapter);
        sT.setOnItemSelectedListener(this);

        sSS = findViewById(R.id.spices);
        ArrayAdapter<CharSequence> adapterr = ArrayAdapter.createFromResource(this,
                R.array.spicess, R.layout.text);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sSS.setAdapter(adapterr);
        sSS.setOnItemSelectedListener(this);

        sP = findViewById(R.id.spinnerp);
        ArrayAdapter<CharSequence> adapterp = ArrayAdapter.createFromResource(this,
                R.array.pressure, R.layout.text1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sP.setAdapter(adapterp);
        sP.setOnItemSelectedListener(this);
        A.setText(As[sSS.getSelectedItemPosition()]);
        B.setText(Bs[sSS.getSelectedItemPosition()]);
        C.setText(Cs[sSS.getSelectedItemPosition()]);
        Tmax.setText(Tmaxs[sSS.getSelectedItemPosition()]);
        Tmin.setText(Tmins[sSS.getSelectedItemPosition()]);
        tcri.setText(Tmaxs[sSS.getSelectedItemPosition()]);
        pcri.setText(Tmins[sSS.getSelectedItemPosition()]);


    }

    public void FindId() {
        sT = findViewById(R.id.spinnert);
        A = findViewById(R.id.a1);
        B = findViewById(R.id.b1);
        C = findViewById(R.id.c1);
        Tmin = findViewById(R.id.tmin);
        Tmax = findViewById(R.id.tmax);
        T = findViewById(R.id.temperaturee);
        P = findViewById(R.id.pressuree);
        unit = findViewById(R.id.tunit);
        unitp = findViewById(R.id.punit);
        unit1 = findViewById(R.id.tunit2);
        unitpt = findViewById(R.id.punitt);
        unit1t = findViewById(R.id.tunit2t);
        unitmax = findViewById(R.id.tunitmax);
        unitmin = findViewById(R.id.tunitmin);
        tcri = findViewById(R.id.tcri);
        pcri = findViewById(R.id.pcri);

    }

    public void SolveForP(View view) {
        a1 = Double.parseDouble(As[sSS.getSelectedItemPosition()]);
        b1 = Double.parseDouble(Bs[sSS.getSelectedItemPosition()]);
        c1 = Double.parseDouble(Cs[sSS.getSelectedItemPosition()]);
        n = ChangeConstant(sP.getSelectedItem().toString(), sT.getSelectedItem().toString(), a1, b1, c1);
        a1 = n[0];
        b1 = n[1];
        c1 = n[2];
        switch (T.getText().toString()) {
            case "":
                Toast.makeText(this, "Please check if the temperature was entered correctly", Toast.LENGTH_LONG).show();
                break;
            case "-":
                Toast.makeText(this, "Please check if the temperature  was entered correctly", Toast.LENGTH_LONG).show();
                break;
            case "+":
                Toast.makeText(this, "Please check if the temperature  was entered correctly", Toast.LENGTH_LONG).show();
                break;
            case ".":
                Toast.makeText(this, "Please check if the temperature  was entered correctly 2222222222", Toast.LENGTH_LONG).show();
                break;
            default:
                textView = findViewById(R.id.resultt);
                textView2 = findViewById(R.id.tp);
                pressuresat = Math.exp(a1 - (b1) / (
                       c1 + Double.parseDouble(T.getText().toString())));
                textView.setText(formatter.format(pressuresat));

                l = findViewById(R.id.layt);
                l.setVisibility(View.VISIBLE);

                textView2.setText("Psat=");
                unit.setText(sP.getSelectedItem().toString());
                break;
        }

    }

    public void SolveForT(View view) {

        a1 = Double.parseDouble(As[sSS.getSelectedItemPosition()]);
        b1 = Double.parseDouble(Bs[sSS.getSelectedItemPosition()]);
        c1 = Double.parseDouble(Cs[sSS.getSelectedItemPosition()]);
        n = ChangeConstant(sP.getSelectedItem().toString(), sT.getSelectedItem().toString(), a1, b1, c1);
        a1 = n[0];
        b1 = n[1];
        c1 = n[2];
        switch (P.getText().toString()) {
            case "":
                Toast.makeText(this, "Please check if the pressure was entered correctly", Toast.LENGTH_LONG).show();
                break;
            case "-":
                Toast.makeText(this, "Please check if the pressure was entered correctly", Toast.LENGTH_LONG).show();
                break;
            case "+":
                Toast.makeText(this, "Please check if the pressure was entered correctly", Toast.LENGTH_LONG).show();
                break;
            case ".":
                Toast.makeText(this, "Please check if the pressure was entered correctly", Toast.LENGTH_LONG).show();
                break;
            default:
        l = findViewById(R.id.layt);
        l.setVisibility(View.VISIBLE);
        textView = findViewById(R.id.resultt);
        temper = (b1 / (Math.log(Double.parseDouble(P.getText().toString())) - a1))
                + c1;
        textView.setText(formatter.format(temper * (-1)));
        unit.setText(Tunit);
        textView2 = findViewById(R.id.tp);
        textView2.setText("Tsat=");
        break;}


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        l = findViewById(R.id.layt);
        l.setVisibility(View.INVISIBLE);
        Tunit = sT.getSelectedItem().toString();
        Punit = sP.getSelectedItem().toString();
        unitmax.setText(Tunit);
        unitmin.setText(Tunit);
        unit1.setText(Tunit);
        unit1t.setText(Tunit);
        unitp.setText(Punit);
        unitpt.setText(Punit);
        A.setText(As[sSS.getSelectedItemPosition()]);
        B.setText(Bs[sSS.getSelectedItemPosition()]);
        C.setText(Cs[sSS.getSelectedItemPosition()]);
        Tmax.setText(Tmaxs[sSS.getSelectedItemPosition()]);
        Tmin.setText(Tmins[sSS.getSelectedItemPosition()]);
        tcri.setText(Tmaxs[sSS.getSelectedItemPosition()]);
        pcri.setText(Tmins[sSS.getSelectedItemPosition()]);
        ChangeConstant(sP.getSelectedItem().toString(), sT.getSelectedItem().toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void ChangeConstant(String cons, String cons1) {
        switch (cons) {

            case "kPa":
                A.setText(formatter.format(Double.parseDouble(As[sSS.getSelectedItemPosition()]) + (Math.log(100))));
                pcri.setText(formatter1.format(Double.parseDouble(pcris[sSS.getSelectedItemPosition()]) * 100));
                break;
            case "Pa":
                A.setText(formatter.format(Double.parseDouble(As[sSS.getSelectedItemPosition()]) + (Math.log(100000))));
                pcri.setText(formatter1.format(Double.parseDouble(pcris[sSS.getSelectedItemPosition()]) * 100000));
                break;
            case "MPa":
                A.setText(formatter.format(Double.parseDouble(As[sSS.getSelectedItemPosition()]) + (Math.log(0.1))));
                pcri.setText(formatter1.format(Double.parseDouble(pcris[sSS.getSelectedItemPosition()]) + 0.1));
                break;

            case "bar":
                A.setText(formatter.format(Double.parseDouble(As[sSS.getSelectedItemPosition()])));
                pcri.setText(formatter1.format(Double.parseDouble(pcris[sSS.getSelectedItemPosition()])));
                break;
            case "mmHg":
                A.setText(formatter.format(Double.parseDouble(As[sSS.getSelectedItemPosition()]) + (Math.log(750.061683))));
                pcri.setText(formatter1.format(Double.parseDouble(pcris[sSS.getSelectedItemPosition()]) * 750.061683));
                break;
            case "psi":
                A.setText(formatter.format(Double.parseDouble(As[sSS.getSelectedItemPosition()]) + (Math.log(14.503775))));
                pcri.setText(formatter1.format(Double.parseDouble(pcris[sSS.getSelectedItemPosition()]) * 14.503775));
                break;
            case "atm":
                A.setText(formatter.format(Double.parseDouble(As[sSS.getSelectedItemPosition()]) + (Math.log(0.986923))));
                pcri.setText(formatter1.format(Double.parseDouble(pcris[sSS.getSelectedItemPosition()]) * 0.986923));
                break;
        }
        switch (cons1) {
            case "K":
                B.setText(formatter.format(Double.parseDouble(Bs[sSS.getSelectedItemPosition()])));
                C.setText(formatter.format(Double.parseDouble(Cs[sSS.getSelectedItemPosition()])));
                Tmin.setText(formatter1.format(Double.parseDouble(Tmins[sSS.getSelectedItemPosition()])));
                Tmax.setText(formatter1.format(Double.parseDouble(Tmaxs[sSS.getSelectedItemPosition()])));
                tcri.setText(formatter1.format(Double.parseDouble(tcris[sSS.getSelectedItemPosition()])));

                break;
            case "C":
                B.setText(formatter.format(Double.parseDouble(Bs[sSS.getSelectedItemPosition()])));
                C.setText(formatter.format(Double.parseDouble(Cs[sSS.getSelectedItemPosition()]) + 273.15));
                Tmin.setText(formatter1.format(Double.parseDouble(Tmins[sSS.getSelectedItemPosition()]) - 273.15));
                Tmax.setText(formatter1.format(Double.parseDouble(Tmaxs[sSS.getSelectedItemPosition()]) - 273.15));
                tcri.setText(formatter1.format(Double.parseDouble(tcris[sSS.getSelectedItemPosition()]) - 273.15));

                break;
            case "R":
                B.setText(String.valueOf(Double.parseDouble(Bs[sSS.getSelectedItemPosition()]) * 1.8));
                C.setText(String.valueOf(Double.parseDouble(Cs[sSS.getSelectedItemPosition()]) * 1.8));
                Tmin.setText(formatter1.format(Double.parseDouble(Tmins[sSS.getSelectedItemPosition()]) * 1.8));
                Tmax.setText(formatter1.format(Double.parseDouble(Tmaxs[sSS.getSelectedItemPosition()]) * 1.8));
                tcri.setText(formatter1.format(Double.parseDouble(tcris[sSS.getSelectedItemPosition()]) * 1.8));


                break;
            case "F":
                B.setText(String.valueOf(Double.parseDouble(Bs[sSS.getSelectedItemPosition()]) * 1.8));
                C.setText(String.valueOf(Double.parseDouble(Cs[sSS.getSelectedItemPosition()]) * 1.8 + 459.67));
                Tmin.setText(formatter1.format(Double.parseDouble(Tmins[sSS.getSelectedItemPosition()]) * 1.8 - 459.67));
                Tmax.setText(formatter1.format(Double.parseDouble(Tmaxs[sSS.getSelectedItemPosition()]) * 1.8 - 459.67));
                tcri.setText(formatter1.format(Double.parseDouble(tcris[sSS.getSelectedItemPosition()]) * 1.8 - 459.67));

                break;


        }


    }

    public double[] ChangeConstant(String cons, String cons1, double a, double b, double c) {

        switch (cons) {

            case "kPa":
                a = a + (Math.log(100));

                break;
            case "Pa":
                a = a + (Math.log(100000));
                break;
            case "MPa":
                a = a + (Math.log(0.1));

                break;

            case "bar":
                break;
            case "mmHg":
                a = a + (Math.log(750.061683));
                break;
            case "psi":
                A.setText(formatter.format(Double.parseDouble(As[sSS.getSelectedItemPosition()]) + (Math.log(14.503775))));

                break;
            case "atm":
                A.setText(formatter.format(Double.parseDouble(As[sSS.getSelectedItemPosition()]) + (Math.log(0.986923))));

                break;
        }
        switch (cons1) {
            case "K":
                break;
            case "C":
                c = c + 273.15;

                break;
            case "R":
                b = b * 1.8;
                c = c * 1.8;
                break;
            case "F":
                b = b * 1.8;
                c = c * 1.8 + 459.67;

                break;


        }
        double[] k = new double[]{a, b, c};

        return k;
    }


    public void New_Ele(View view) {
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.satp:
                my = new Intent(this,ThermoSolver.class);
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
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer1221.CEJU"));
                startActivity(my);

                break;
            case R.id.tasjel:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer.ju"));
                startActivity(my);

                break;
            case R.id.checkupdate:
                Toast.makeText(this,"Comming in the next update",Toast.LENGTH_SHORT).show();
                break;
            case R.id.giveyourfeedback:
                Toast.makeText(this,"Comming in the next update",Toast.LENGTH_SHORT).show();
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
}
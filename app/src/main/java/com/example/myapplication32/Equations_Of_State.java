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

public class Equations_Of_State extends AppCompatActivity implements AdapterView.OnItemSelectedListener,NavigationView.OnNavigationItemSelectedListener {
    String[] Tcs, Pcs, Acintricss,As,Bs,Cs;
    double a, b, alpha, w, Tr, T, P, V, Rg, Tc, Pc, k;
    EditText Pv, Tv, Vv;
    Spinner specie, sT, sP, sV;
    double[] kk;
    NumberFormat formatter, formatter1;
    Intent my;
    private DrawerLayout drawer;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_equations__of__state);

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


        As = getResources().getStringArray(R.array.constant_a);
        Bs = getResources().getStringArray(R.array.constant_b);
        Cs = getResources().getStringArray(R.array.constant_c);
        formatter = new DecimalFormat("#0.0000000");
        formatter1 = new DecimalFormat("#,##0.0000");
        FindId();
        Tcs = getResources().getStringArray(R.array.t_critical);
        Acintricss = getResources().getStringArray(R.array.acentric_factor);
        Pcs = getResources().getStringArray(R.array.p_critical);
        SetAdaptar();

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

    public void SetAdaptar() {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Temperature, R.layout.text1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sT.setAdapter(adapter);
        sT.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapterr = ArrayAdapter.createFromResource(this,
                R.array.volume1, R.layout.text1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sV.setAdapter(adapterr);
        sV.setOnItemSelectedListener(this);


        sP = findViewById(R.id.spinnerp);
        ArrayAdapter<CharSequence> adapterp = ArrayAdapter.createFromResource(this,
                R.array.pressure, R.layout.text1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sP.setAdapter(adapterp);
        sP.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.spicess, R.layout.text);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        specie.setAdapter(adapter3);
        specie.setOnItemSelectedListener(this);

    }

    public void FindId() {
        kk = new double[]{};
        Pv = findViewById(R.id.pressure);
        Tv = findViewById(R.id.temperature);
        Vv = findViewById(R.id.volume);
        specie = findViewById(R.id.spices);
        sV = findViewById(R.id.spinnerv);
        sT = findViewById(R.id.spinnert);
        sP = findViewById(R.id.spinnerp);
        T = Double.parseDouble(Tv.getText().toString());
        P = Double.parseDouble(Pv.getText().toString());
        V = Double.parseDouble(Vv.getText().toString());
    }


    public double Peng_Robinson_Eqn(double T, double V, double a, double b, double R, double alpha) {
        double result;

        result = (T * R / (V - b)) - (a * alpha / (Math.pow(V, 2) + 2 * b * V - Math.pow(b, 2)));
        return result;
    }


    public static double Peng_Robinson_Eqn(double T, double V, double a, double b, double R, double w, double p, double Tc) {
        double result, k, alpha1;

        k = 0.37464 + 1.54226 * w - 0.26992 * Math.pow(w, 2);

        alpha1 = Math.pow((1 + k * (1 - Math.pow(T / Tc, 0.5))), 2);

        result = (T * R / (V - b)) - (a * alpha1 / (Math.pow(V, 2) + 2 * b * V - Math.pow(b, 2))) - p;
        return result;
    }

    public static double Peng_Robinson_Eqnt(double T, double v, double a, double b, double R, double w, double p, double Tc) {
        double result, k, alpha1;

        k = 0.37464 + 1.54226 * w - 0.26992 * Math.pow(w, 2);

        result = - R/(b - v) - (a*k*(k*(Math.pow(T/Tc,0.5) - 1) - 1))/(Tc*Math.pow(T/Tc,0.5)*(- b*b + 2*b*v + v*v));
        return result;
    }


    public static double Peng_Robinson_Eqntt(double T, double v, double a, double b, double R, double w, double p, double Tc) {
        double result, k, alpha1;
        k = 0.37464 + 1.54226 * w - 0.26992 * Math.pow(w, 2);


        result = (a*k*(k*(Math.pow(T/Tc,0.5) - 1) - 1))/(2*Tc*Tc*Math.pow(T/Tc,3/2)*(- b*b + 2*b*v + v*v)) - (a*k*k)/(2*T*Tc*(- b*b + 2*b*v + v*v));
        return result;
    }

    public static double Peng_Robinson_Eqnv(double T, double v, double a, double b, double R, double w, double p, double Tc) {
        double result, k, alpha1;

        k = 0.37464 + 1.54226 * w - 0.26992 * Math.pow(w, 2);
        alpha1 = Math.pow((1 + k * (1 - Math.pow(T / Tc, 0.5))), 2);


        result = (a * alpha1 * (2 * b + 2 * v)) / Math.pow((-b * b + 2 * b * v + v * v), 2) - (R * T) / Math.pow((b - v), 2);
        return result;
    }


    public static double Peng_Robinson_Eqntv(double T, double v, double a, double b, double R, double w, double p, double Tc) {
        double result, k, alpha1;

        k = 0.37464 + 1.54226 * w - 0.26992 * Math.pow(w, 2);
        alpha1 = Math.pow((1 + k * (1 - Math.pow(T / Tc, 0.5))), 2);

        //  (2*a*pha)/(- b^2 + 2*b*v + v^2)^2 - (2*R*T)/(b - v)^3 -
        // (2*a*pha*(2*b + 2*v)^2)/(- b^2 + 2*b*v + v^2)^3


        result = (2 * a * alpha1) / Math.pow((-b * b) + 2 * b * v + v * v, 2) - (2 * R * T) / Math.pow(b - v, 3) -
                (2 * a * alpha1 * Math.pow((2 * b + 2 * v), 2)) / Math.pow(((-b * b) + 2 * b * v + v * v), 3);

        return result;
    }

    public double psat(double t, double a2, double b2, double c2) {

        double result = 0;

        result = Math.exp(a2 - b2 / (t + c2));

        return result;
    }


    public void SolveForV(View view) {
        getads();
        double Psat;
        if (!condition("T", "P", "0")) {
            a = 1;
        } else {
            kk = Changeconstant("V");
            Rg = kk[0];
            Tc = kk[1];
            Pc = kk[2];
            P = kk[4];
            T = kk[3];
            Psat = psat(T, Double.parseDouble(As[specie.getSelectedItemPosition()]),
                    Double.parseDouble(Bs[specie.getSelectedItemPosition()]), Double.parseDouble(Cs[specie.getSelectedItemPosition()]));
            if (P > Psat) {
                V = 0.01;
            } else {
                V = Rg * T / (P);
            }

            alpha = Double.parseDouble(Acintricss[specie.getSelectedItemPosition()]);
            a = 0.45724 * Math.pow(Rg * Tc, 2) / Pc;
            b = 0.07780 * Rg * Tc / Pc;
            k = 0.37464 + 1.54226 * w - 0.26992 * Math.pow(w, 2);
            Tr = T / Tc;


            double tolerance = .000000000001; // Stop if you're close enough
            int max_count = 2000; // Maximum number of Newton's method iterations

	/* x is our current guess. If no command line guess is given,
	   we take 0 as our starting point. */

            double l = 0;
            double ll = 0;
            for (int count = 1;
                 (Math.abs(Peng_Robinson_Eqn(T, V, a, b, Rg, alpha, P, Tc)) > tolerance) && (count < max_count);
                 count++) {
                V = V - Peng_Robinson_Eqn(T, V, a, b, Rg, alpha, P, Tc) / (Peng_Robinson_Eqnv(T, V, a, b, Rg, alpha, P, Tc)
                        - (Peng_Robinson_Eqntv(T, V, a, b, Rg, alpha, P, Tc) * Peng_Robinson_Eqn(T, V, a, b, Rg, alpha, P, Tc)
                        / (2 * Peng_Robinson_Eqnv(T, V, a, b, Rg, alpha, P, Tc))));


                if ((count == 500 && (Math.abs(Peng_Robinson_Eqn(T, V, a, b, Rg, alpha, P, Tc)) > tolerance) & l <= 1000) || (T < 0 && (Math.abs(Peng_Robinson_Eqn(V, T, a, b, Rg, alpha, P, Tc)) <= tolerance) & l <= 1000)) {
                    V = l;
                    l++;
                }

                if (l >= 1000) {
                    if ((count == 500 && (Math.abs(Peng_Robinson_Eqn(T, V, a, b, Rg, alpha, P, Tc)) > tolerance)) || (T < 0 && (Math.abs(Peng_Robinson_Eqn(V, T, a, b, Rg, alpha, P, Tc)) <= tolerance))) {
                        V = ll;
                        ll = ll * 0.1;
                        l++;
                    }
                }
                if (l == 1500) {
                    break;
                }
            }
            if (((Math.abs(Peng_Robinson_Eqn(T, V, a, b, Rg, alpha, P, Tc)) > 0.0000001))) {
                Toast.makeText(this, "Failed to find the correct solution  :(", Toast.LENGTH_SHORT).show();
            }

            TextView bb = findViewById(R.id.volume);
            bb.setText(formatter.format(V));
        }
    }

    public void SolveForT(View view) {
        getads();
        if (!condition("0", "P", "V")) {
        } else {
            kk = Changeconstant("T");

            Tc = Double.parseDouble(Tcs[specie.getSelectedItemPosition()]);
            Pc = Double.parseDouble(Pcs[specie.getSelectedItemPosition()]);
            P = kk[1];
            V = kk[0];
            Rg = kk[2];
            alpha = Double.parseDouble(Acintricss[specie.getSelectedItemPosition()]);
            T = 1;
            a = 0.45724 * Math.pow(Rg * Tc, 2) / Pc;
            b = 0.07780 * Rg * Tc / Pc;
            a = 0.45724 * Math.pow(Rg * Tc, 2) / Pc;
            k = 0.37464 + 1.54226 * w - 0.26992 * Math.pow(w, 2);
            Tr = T / Tc;


            double tolerance = .00000000000001; // Stop if you're close enough
            int max_count = 600; // Maximum number of Newton's method iterations

	/* x is our current guess. If no command line guess is given,
	   we take 0 as our starting point. */

            int l = 0;
            for (int count = 1;
                 (Math.abs(Peng_Robinson_Eqn(T, V, a, b, Rg, alpha, P, Tc)) > tolerance||T < 0||String.valueOf(T).contentEquals("-NaN")) && (count < max_count);
                 count++) {
                T = T - Peng_Robinson_Eqn(T, V, a, b, Rg, alpha, P, Tc) / (Peng_Robinson_Eqnt(T, V, a, b, Rg, alpha, P, Tc)
                        - Peng_Robinson_Eqntt(T, V, a, b, Rg, alpha, P, Tc) * Peng_Robinson_Eqn(T, V, a, b, Rg, alpha, P, Tc) / (2 * Peng_Robinson_Eqnt(T, V, a, b, Rg, alpha, P, Tc)));


                if ((count == 500 && (Math.abs(Peng_Robinson_Eqn(T, V, a, b, Rg, alpha, P, Tc)) > tolerance))||
                        (T <0 && (Math.abs(Peng_Robinson_Eqn(V, T, a, b, Rg, alpha, P, Tc)) <= tolerance))
                        ||(T<0||String.valueOf(Math.abs(Peng_Robinson_Eqn(T, V, a, b, Rg, alpha, P, Tc))).contentEquals("NaN")) ) {
                    T=l;
                    l++;
                }

                if (l == 3000) {
                    Toast.makeText(this, "Failed to find the correct solution  :(", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
            if (T < 0) {
                Toast.makeText(this, String.valueOf(Peng_Robinson_Eqn(T, V, a, b, Rg, alpha, P, Tc)), Toast.LENGTH_SHORT).show();

            }

            switch (sT.getSelectedItem().toString()) {

                case "K":
                    break;
                case "C":
                    T = T - 273;
                    break;
                case "R":
                    T = T * 1.8;
                    break;
                case "F":
                    T = (T * 1.8 - 459.67);
                    break;
            }
            TextView bb = findViewById(R.id.temperature);
            bb.setText(formatter.format(T));
        }
    }

    public void SolveForP(View view) {
        getads();
        if (!condition("T", "0", "V")) {
        } else {
            kk = Changeconstant("p");
            Rg = kk[0];
            Tc = kk[1];
            Pc = kk[2];
            T = kk[3];
            V = Double.parseDouble(Vv.getText().toString());

            w = Double.parseDouble(Acintricss[specie.getSelectedItemPosition()]);
            a = 0.45724 * Math.pow(Rg * Tc, 2) / Pc;
            b = 0.07780 * Rg * Tc / Pc;
            a = 0.45724 * Math.pow(Rg * Tc, 2) / Pc;
            k = 0.37464 + 1.54226 * w - 0.26992 * Math.pow(w, 2);
            Tr = T / Tc;
            alpha = Math.pow((1 + k * (1 - Math.pow(Tr, 0.5))), 2);
            P = Peng_Robinson_Eqn(T, V, a, b, Rg, alpha);
            TextView T = findViewById(R.id.pressure);
            if (P > 0) {
                T.setText(formatter.format(P));
            } else {
                Toast.makeText(this, "Either T or V is negative number Check", Toast.LENGTH_SHORT).show();
                T.setText("0.0");
            }
        }
    }


    public double[] Changeconstant(String y) {
        getads();
        double[] k1 = new double[4];
        Rg = 0.08314;
        Tc = Double.parseDouble(Tcs[specie.getSelectedItemPosition()]);
        Pc = Double.parseDouble(Pcs[specie.getSelectedItemPosition()]);

        if (y.contentEquals("p")) {

            T = Double.parseDouble(Tv.getText().toString());
            switch (sP.getSelectedItem().toString()) {
                case "kPa":
                    Pc = Pc * 100;
                    Rg = Rg * 100;
                    break;
                case "Pa":
                    Pc = Pc * 100000;
                    Rg = Rg * 100000;
                    break;
                case "MPa":
                    Pc = Pc * 0.1;
                    Rg = Rg * 0.1;
                    break;
                case "bar":
                    break;
                case "mmHg":
                    Pc = Pc * 750.061683;
                    Rg = Rg * 750.061683;
                    break;
                case "psi":
                    Pc = Pc * 14.503775;
                    Rg = Rg * 14.503775;
                    break;
                case "atm":
                    Pc = Pc * 0.986923;
                    Rg = Rg * 0.986923;
                    break;
            }
            switch (sT.getSelectedItem().toString()) {

                case "K":
                    break;
                case "C":
                    T = T + 273;
                    break;
                case "R":
                    T = T / 1.8;
                    break;
                case "F":
                    T = (T + 459.67) / 1.8;
                    break;
            }
            switch (sV.getSelectedItem().toString()) {

                case "m^3/mol":
                    Rg = Rg / 1000;
                    break;
                case "cm^3/mol":
                    Rg = Rg * 1000;
                    break;
                case "in^3/mol":
                    Rg = Rg * 61.023744;
                    break;
                case "ft^3/mol":
                    Rg = Rg * 0.035315;
                    break;
                case "L/mol":

                    break;
            }
            k1[0] = Rg;
            k1[1] = Tc;
            k1[2] = Pc;
            k1[3] = T;
        }


        if (y.contentEquals("T")) {
            P = Double.parseDouble(Pv.getText().toString());
            V = Double.parseDouble(Vv.getText().toString());
            switch (sP.getSelectedItem().toString()) {
                case "kPa":

                    P = P / 100;
                    break;
                case "Pa":


                    P = P / 100000;
                    break;
                case "MPa":
                    P = P / 0.1;
                    break;
                case "bar":
                    break;
                case "mmHg":

                    P = P / 750.061683;
                    break;
                case "psi":

                    P = P / 14.503775;
                    break;
                case "atm":

                    P = P / 0.986923;
                    break;
            }
            switch (sV.getSelectedItem().toString()) {

                case "m^3/mol":
                    Rg = Rg / 1000;
                    break;
                case "cm^3/mol":
                    Rg = Rg * 1000;
                    break;
                case "in^3/mol":
                    Rg = Rg * 61.023744;
                    break;
                case "ft^3/mol":
                    Rg = Rg * 0.035315;
                    break;
                case "L/mol":

                    break;
            }
            k1[0] = V;
            k1[1] = P;
            k1[2] = Rg;
            k1[3] = 0;
        }


        if (y.contentEquals("V")) {
            T = Double.parseDouble(Tv.getText().toString());
            P = Double.parseDouble(Pv.getText().toString());
            k1 = new double[5];
            T = Double.parseDouble(Tv.getText().toString());
            P = Double.parseDouble(Pv.getText().toString());
            switch (sP.getSelectedItem().toString()) {
                case "kPa":
                    P = P / 100;
                    break;
                case "Pa":
                    P = P / 100000;

                    break;
                case "MPa":
                    P = P / 0.1;
                    break;
                case "bar":
                    break;
                case "mmHg":
                    P = P / 750.061683;

                    break;
                case "psi":
                    P = P / 14.503775;

                    break;
                case "atm":
                    P = P / 0.986923;

                    break;
            }
            switch (sV.getSelectedItem().toString()) {

                case "m^3/mol":
                    Rg = Rg / 1000;
                    break;
                case "cm^3/mol":
                    Rg = Rg * 1000;
                    break;
                case "in^3/mol":
                    Rg = Rg * 61.023744;
                    break;
                case "ft^3/mol":
                    Rg = Rg * 0.035315;
                    break;
                case "L/mol":

                    break;
            }
            k1[0] = Rg;
            k1[1] = Tc;
            k1[2] = Pc;
            k1[3] = T;
            k1[4] = P;

        }

        return k1;


    }

    public boolean condition(String T, String P, String V) {
        if (P.contentEquals("P")) {

            if (Pv.getText().toString().contentEquals("") || Pv.getText().toString().contentEquals(".") || Pv.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "P wasn't Entered correctly ", Toast.LENGTH_SHORT).show();
                return false;
            }

        }
        if (T.contentEquals("T")) {

            if (Tv.getText().toString().contentEquals("") || Tv.getText().toString().contentEquals(".") || Tv.getText().toString().contentEquals("-") || Tv.getText().toString().contentEquals("+")) {
                Toast.makeText(this, "T wasn't Entered correctly ", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        if (V.contentEquals("V")) {

            if (Vv.getText().toString().contentEquals("") || Vv.getText().toString().contentEquals(".") || Vv.getText().toString().contentEquals("-") || Vv.getText().toString().contentEquals("+")) {
                Toast.makeText(this, "T wasn't Entered correctly ", Toast.LENGTH_SHORT).show();
                return false;
            }

        }

        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.satp:
                my = new Intent(this, ThermoSolver.class);
                startActivity(my);
                break;

            case R.id.dew_bubble:
                my = new Intent(this, Bubble_Dew.class);
                startActivity(my);
                break;
            case R.id.Eos:
                my = new Intent(this, Equations_Of_State.class);
                startActivity(my);

                break;
            case R.id.chee:
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer1221.CEJU"));
                startActivity(my);

                break;
            case R.id.tasjel:
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer.ju"));
                startActivity(my);

                break;
            case R.id.checkupdate:
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer.test"));
                startActivity(my);
                break;
            case R.id.giveyourfeedback:
                my = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer.test"));
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

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    ;

    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
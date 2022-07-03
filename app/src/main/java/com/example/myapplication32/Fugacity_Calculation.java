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

public class Fugacity_Calculation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {
    EditText Tv, Pv, y3, y2, y1, y5, y4;
    TextView figp1, figp2, figp3, figp4, figp5, fig1, fig2, fig3, fig4, fig5;
    Spinner sT, sP, sSS, sSS2, sSS3, sSS4, sSS5;
    NumberFormat formatter, formatter1;
    String[] Tc, Pc, Acintrics, As1, Bs1, Cs1;
    Intent my;
    private DrawerLayout drawer;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fugacity__calculation);
        NavigationView navigationView = findViewById(R.id.navi);
        navigationView.setNavigationItemSelectedListener(this);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        As1 = getResources().getStringArray(R.array.constant_a);
        Bs1 = getResources().getStringArray(R.array.constant_b);
        Cs1 = getResources().getStringArray(R.array.constant_c);
        formatter = new DecimalFormat("#0.00000");
        formatter1 = new DecimalFormat("#,##0.0000");
        Tc = getResources().getStringArray(R.array.t_critical);
        Acintrics = getResources().getStringArray(R.array.acentric_factor);
        Pc = getResources().getStringArray(R.array.p_critical);
        FindId();
        SetAdaptar();


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

    public void SetAdaptar() {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Temperature, R.layout.text1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sT.setAdapter(adapter);
        sT.setOnItemSelectedListener(this);

        sSS = findViewById(R.id.spice1);
        ArrayAdapter<CharSequence> adapterr = ArrayAdapter.createFromResource(this,
                R.array.spicess, R.layout.text);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sSS.setAdapter(adapterr);
        sSS.setOnItemSelectedListener(this);

        sSS2 = findViewById(R.id.spice2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.spicess, R.layout.text);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sSS2.setAdapter(adapter2);
        sSS2.setOnItemSelectedListener(this);


        sSS3 = findViewById(R.id.spice3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.spicess, R.layout.text);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sSS3.setAdapter(adapter3);
        sSS3.setOnItemSelectedListener(this);

        sSS4 = findViewById(R.id.spice4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.spicess, R.layout.text);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sSS4.setAdapter(adapter4);
        sSS4.setOnItemSelectedListener(this);

        sSS5 = findViewById(R.id.spice5);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,
                R.array.spicess, R.layout.text);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sSS5.setAdapter(adapter4);
        sSS5.setOnItemSelectedListener(this);


        sP = findViewById(R.id.spinnerp);
        ArrayAdapter<CharSequence> adapterp = ArrayAdapter.createFromResource(this,
                R.array.pressure, R.layout.text1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sP.setAdapter(adapterp);
        sP.setOnItemSelectedListener(this);

    }

    public void FindId() {
        sT = findViewById(R.id.spinnert);
        y1 = findViewById(R.id.y1n);
        y2 = findViewById(R.id.y2n);
        y3 = findViewById(R.id.y3n);
        y4 = findViewById(R.id.y4n);
        y5 = findViewById(R.id.y5n);
        fig1 = findViewById(R.id.fug1);
        fig2 = findViewById(R.id.fug2);
        fig3 = findViewById(R.id.fug3);
        fig4 = findViewById(R.id.fug4);
        fig5 = findViewById(R.id.fug5);
        figp1 = findViewById(R.id.fugp1);
        figp2 = findViewById(R.id.fugp2);
        figp3 = findViewById(R.id.fugp3);
        figp4 = findViewById(R.id.fugp4);
        figp5 = findViewById(R.id.fugp5);
        Tv = findViewById(R.id.temperature1);
        Pv = findViewById(R.id.pressure1);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

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
            case R.id.fugs:
                my = new Intent(this, Fugacity_Calculation.class);
                startActivity(my);

                break;
            case R.id.unit:
                my = new Intent(this, UnitConverter.class);
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
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer.test"));
                startActivity(my);
                break;
            case R.id.giveyourfeedback:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer.test"));
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


    public static double Peng_Robinson_Eqn(double T, double V, double a, double b, double R, double alpha, double p, double Tc) {
        double result;


        result = (T * R / (V - b)) - (alpha / (Math.pow(V, 2) + 2 * b * V - Math.pow(b, 2))) - p;
        return result;
    }

    public static double Peng_Robinson_Eqnv(double T, double v, double a, double b, double R, double alpha, double p, double Tc) {
        double result;

        result = (alpha * (2 * b + 2 * v)) / Math.pow((-b * b + 2 * b * v + v * v), 2) - (R * T) / Math.pow((b - v), 2);
        return result;
    }


    public static double Peng_Robinson_Eqntv(double T, double v, double a, double b, double R, double alpha, double p, double Tc) {
        double result;


        //  (2*a*pha)/(- b^2 + 2*b*v + v^2)^2 - (2*R*T)/(b - v)^3 -
        // (2*a*pha*(2*b + 2*v)^2)/(- b^2 + 2*b*v + v^2)^3


        result = (2 * alpha) / Math.pow((-b * b) + 2 * b * v + v * v, 2) - (2 * R * T) / Math.pow(b - v, 3) -
                (2 * alpha * Math.pow((2 * b + 2 * v), 2)) / Math.pow(((-b * b) + 2 * b * v + v * v), 3);
        return result;
    }

    public static double solve_b(double R, double T, double P, double Tc, double Pc) {

        double re = 0, b1;
        b1 = 0.07780 * R * Tc / Pc;
        re = b1 * P / (R * T);
        return re;


    }

    public static double solve_b(double R, double T, double P, double b1) {
        double re = 0;
        re = b1 * P / (R * T);
        return re;

    }

    public static double solve_fugacity(double z, double B, double Bi, double A, double alpha, double[] Y, double[] a_alphs, int j) {
        double re = 0, sum = 0;

        for (int n = 0; n < Y.length; n++) {
            sum = sum + Y[n] * Math.pow(a_alphs[n] * a_alphs[j], 0.5);

        }

        re = Math.exp(Bi * (z - 1) / (B) - Math.log(z - B) + A * ((Bi / B) - 2 * sum / alpha) * (Math.log((z + 2.4142 * B) / (z - 0.4142 * B))) / (2.8284 * B));


        return re;


    }

    public static double solve_fugacity(double z, double Bi, double A) {
        double re = 0, sum = 0;


        re = Math.exp((z - 1) - Math.log(z - Bi) - A * (Math.log((z + 2.4142 * Bi) / (z - 0.4142 * Bi))) / (2.8284 * Bi));


        return re;


    }

    public double psat(double t, double a2, double b2, double c2) {

        double result = 0;

        result = Math.exp(a2 - b2 / (t + c2));

        return result;
    }

    public void Fug_solve(View view) {
        getads();
        fig1.setText("");
        fig2.setText("");
        fig3.setText("");
        fig4.setText("");
        fig5.setText("");
        figp1.setText("");
        figp2.setText("");
        figp3.setText("");
        figp4.setText("");
        figp5.setText("");

        if (!condition()) {

        } else {
            double[] Tcs, Pcs, ws, Y, n, bs, Bi, as, alphs, ks, a_alphas, As, figs, re;
            double T1, b = 0, alpha, P1, Tr, V, P, T, Rg, sum = 0, sumA = 0, B, a_alpha, A, sumy = 0;
            T1 = Double.parseDouble(Tv.getText().toString());
            P1 = Double.parseDouble(Pv.getText().toString());
            re = Changeunit(T1, P1);
            T = re[0];
            P = re[1];
            Rg = 0.08314;

            Tcs = new double[]{Double.parseDouble(Tc[sSS.getSelectedItemPosition()]), Double.parseDouble(Tc[sSS2.getSelectedItemPosition()]), Double.parseDouble(Tc[sSS3.getSelectedItemPosition()])
                    , Double.parseDouble(Tc[sSS4.getSelectedItemPosition()]), Double.parseDouble(Tc[sSS5.getSelectedItemPosition()])};

            Pcs = new double[]{Double.parseDouble(Pc[sSS.getSelectedItemPosition()]), Double.parseDouble(Pc[sSS2.getSelectedItemPosition()]), Double.parseDouble(Pc[sSS3.getSelectedItemPosition()])
                    , Double.parseDouble(Pc[sSS4.getSelectedItemPosition()]), Double.parseDouble(Pc[sSS5.getSelectedItemPosition()])};
            ws = new double[]{Double.parseDouble(Acintrics[sSS.getSelectedItemPosition()]), Double.parseDouble(Acintrics[sSS2.getSelectedItemPosition()]), Double.parseDouble(Acintrics[sSS3.getSelectedItemPosition()])
                    , Double.parseDouble(Acintrics[sSS4.getSelectedItemPosition()]), Double.parseDouble(Acintrics[sSS5.getSelectedItemPosition()])};

            n = new double[]{Double.parseDouble(y1.getText().toString()), Double.parseDouble(y2.getText().toString()),
                    Double.parseDouble(y3.getText().toString()), Double.parseDouble(y4.getText().toString()), Double.parseDouble(y5.getText().toString())};
            Y = new double[5];
            for (int i = 0; i < n.length; i++) {
                sumy = sumy + n[i];
            }
            for (int i = 0; i < n.length; i++) {
                Y[i] = n[i] / sumy;
            }

            bs = new double[Y.length];
            Bi = new double[Y.length];
            as = new double[Y.length];
            alphs = new double[Y.length];
            ks = new double[Y.length];
            a_alphas = new double[Y.length];
            As = new double[Y.length];

            for (int i = 0; i < Y.length; i++) {

                Bi[i] = solve_b(Rg, T, P, Tcs[i], Pcs[i]);
                b = b + Y[i] * 0.07780 * Rg * Tcs[i] / Pcs[i];
                bs[i] = 0.07780 * Rg * Tcs[i] / Pcs[i];
                as[i] = 0.45724 * Math.pow(Rg * Tcs[i], 2) / Pcs[i];
                ks[i] = 0.37464 + 1.54226 * ws[i] - 0.26992 * Math.pow(ws[i], 2);
                alphs[i] = Math.pow((1 + ks[i] * (1 - Math.pow(T / Tcs[i], 0.5))), 2);
                a_alphas[i] = as[i] * alphs[i];
                As[i] = as[i] * alphs[i] * P / Math.pow(Rg * T, 2);
            }
            B = solve_b(Rg, T, P, b);

            for (int j = 1; j <= Y.length; j++) {
                for (int k1 = 1; k1 <= Y.length; k1++) {
                    sum = sum + Y[j - 1] * Y[k1 - 1] * Math.pow(a_alphas[j - 1] * a_alphas[k1 - 1], 0.5);
                    sumA = sumA + Y[j - 1] * Y[k1 - 1] * Math.pow(As[j - 1] * As[k1 - 1], 0.5);
                }

            }

            alpha = sum;
            A = sumA;

            V = 1;


            double tolerance = .000000000001; // Stop if you're close enough
            int max_count = 600; // Maximum number of Newton's method iterations

	/* x is our current guess. If no command line guess is given,
	   we take 0 as our starting point. */
            double z,z4=0.0001;
            double Psat1 = 1;
            figs = new double[]{10,10,10,10,10};
            int l = 0;
            for (int kk = 0; kk < n.length; kk++) {

                if (n[kk] != 0) {
                    switch (kk) {

                        case 0:
                            Psat1 = psat(T, Double.parseDouble(As1[sSS.getSelectedItemPosition()]),
                                    Double.parseDouble(Bs1[sSS.getSelectedItemPosition()]), Double.parseDouble(Cs1[sSS.getSelectedItemPosition()]));
                            break;
                        case 1:
                            Psat1 = psat(T, Double.parseDouble(As1[sSS2.getSelectedItemPosition()]),
                                    Double.parseDouble(Bs1[sSS2.getSelectedItemPosition()]), Double.parseDouble(Cs1[sSS2.getSelectedItemPosition()]));
                            break;
                        case 2:
                            Psat1 = psat(T, Double.parseDouble(As1[sSS3.getSelectedItemPosition()]),
                                    Double.parseDouble(Bs1[sSS3.getSelectedItemPosition()]), Double.parseDouble(Cs1[sSS3.getSelectedItemPosition()]));
                            break;
                        case 3:
                            Psat1 = psat(T, Double.parseDouble(As1[sSS4.getSelectedItemPosition()]),
                                    Double.parseDouble(Bs1[sSS4.getSelectedItemPosition()]), Double.parseDouble(Cs1[sSS4.getSelectedItemPosition()]));
                            break;
                        case 4:
                            Psat1 = psat(T, Double.parseDouble(As1[sSS5.getSelectedItemPosition()]),
                                    Double.parseDouble(Bs1[sSS5.getSelectedItemPosition()]), Double.parseDouble(Cs1[sSS5.getSelectedItemPosition()]));
                            break;
                    }

                    if (P > Psat1) {
                        V = 0.01;
                    } else {
                        V = Rg * T / (P);
                    }
                    for (int count = 1;
                         (Math.abs(Peng_Robinson_Eqn(T, V, 0, b, Rg, alpha, P, 0)) > tolerance) && (count < max_count);
                         count++) {
                        V = V - Peng_Robinson_Eqn(T, V, 0, b, Rg, alpha, P, 0) / (Peng_Robinson_Eqnv(T, V, 0, b, Rg, alpha, P, 0)
                                - (Peng_Robinson_Eqntv(T, V, 0, b, Rg, alpha, P, 0) * Peng_Robinson_Eqn(T, V, 0, b, Rg, alpha, P, 0)
                                / (2 * Peng_Robinson_Eqnv(T, V, 0, b, Rg, alpha, P, 0))));
                        z = V * P / (T * Rg);
                        figs[kk] = solve_fugacity(z, B, Bi[kk], A, alpha, Y, a_alphas, kk);
                        if ((count == 500 && (Math.abs(Peng_Robinson_Eqn(T, V, 0, b, Rg, alpha, P, 0)) > tolerance)||figs[kk]>1.5) || (V < 0 && (Math.abs(Peng_Robinson_Eqn(T, V, 0, b, Rg, alpha, P, 0)) <= tolerance))) {
                           V=l;
                            count = 1;
                            l++;
                        }

                        if (l > 3000) {
                            Toast.makeText(this, "Faild To find the correct solution", Toast.LENGTH_SHORT).show();

                            break;
                        }

                    }
                }
                l=0;
                z4=0;
                    }



                    z = V * P / (T * Rg);

                    for (int i = 0; i < Y.length; i++) {

                        figs[i] = solve_fugacity(z, B, Bi[i], A, alpha, Y, a_alphas, i);
                    }
                    for (int i = 0; i < Y.length; i++) {

                        if (n[i] != 0.0) {

                            switch (i) {
                                case 0:
                                    fig1.setText(formatter.format(figs[0]));
                                    break;
                                case 1:
                                    fig2.setText(formatter.format(figs[1]));
                                    break;
                                case 2:
                                    fig3.setText(formatter.format(figs[2]));
                                    break;
                                case 3:
                                    fig4.setText(formatter.format(figs[3]));
                                    break;
                                case 4:
                                    fig5.setText(formatter.format(figs[4]));
                                    break;
                            }
                        }

                    }

                    double v = 1 ,z1=1;
                    double[] Vs = new double[]{0, 0, 0, 0, 0};
                    double[] zs = new double[5];
                    double [] figps=new double[]{10, 10, 10, 10, 10};

                    l = 0;
                    for (int kk = 0; kk < n.length; kk++) {

                        if (n[kk] != 0) {
                            switch (kk) {

                                case 0:
                                    Psat1 = psat(T, Double.parseDouble(As1[sSS.getSelectedItemPosition()]),
                                            Double.parseDouble(Bs1[sSS.getSelectedItemPosition()]), Double.parseDouble(Cs1[sSS.getSelectedItemPosition()]));
                                    break;
                                case 1:
                                    Psat1 = psat(T, Double.parseDouble(As1[sSS2.getSelectedItemPosition()]),
                                            Double.parseDouble(Bs1[sSS2.getSelectedItemPosition()]), Double.parseDouble(Cs1[sSS2.getSelectedItemPosition()]));
                                    break;
                                case 2:
                                    Psat1 = psat(T, Double.parseDouble(As1[sSS3.getSelectedItemPosition()]),
                                            Double.parseDouble(Bs1[sSS3.getSelectedItemPosition()]), Double.parseDouble(Cs1[sSS3.getSelectedItemPosition()]));
                                    break;
                                case 3:
                                    Psat1 = psat(T, Double.parseDouble(As1[sSS4.getSelectedItemPosition()]),
                                            Double.parseDouble(Bs1[sSS4.getSelectedItemPosition()]), Double.parseDouble(Cs1[sSS4.getSelectedItemPosition()]));
                                    break;
                                case 4:
                                    Psat1 = psat(T, Double.parseDouble(As1[sSS5.getSelectedItemPosition()]),
                                            Double.parseDouble(Bs1[sSS5.getSelectedItemPosition()]), Double.parseDouble(Cs1[sSS5.getSelectedItemPosition()]));
                                    break;
                            }

                            if (P > Psat1) {
                                v = 0.01;
                            } else {
                                v = Rg * T / (P);
                            }

                            for (int count = 1;
                                 (Math.abs(Peng_Robinson_Eqn(T, v, 0, bs[kk], Rg, a_alphas[kk], P, 0)) >= tolerance) && (count < max_count);
                                 count++) {
                                v = v - Peng_Robinson_Eqn(T, v, 0, bs[kk], Rg, a_alphas[kk], P, 0) / (Peng_Robinson_Eqnv(T, v, 0, bs[kk], Rg, a_alphas[kk], P, 0)
                                        - (Peng_Robinson_Eqntv(T, v, 0, bs[kk], Rg, a_alphas[kk], P, 0) * Peng_Robinson_Eqn(T, v, 0, bs[kk], Rg, a_alphas[kk], P, 0)
                                        / (2 * Peng_Robinson_Eqnv(T, v, 0, bs[kk], Rg, a_alphas[kk], P, 0))));


                                z1 = P * v / (Rg * T);
                                figps[kk] = solve_fugacity(z1, Bi[kk], As[kk]);
                                if ((count == 500 && (Math.abs(Peng_Robinson_Eqn(T, v, 0, bs[kk], Rg, a_alphas[kk], P, 0)) > tolerance||(figps[kk]>1.5))) || ((v < 0||(figps[kk]>1.5)) && (Math.abs(Peng_Robinson_Eqn(T, v, 0, bs[kk], Rg, a_alphas[kk], P, 0)) <= tolerance))) {
                                    v = l;
                                    count = 1;
                                    l++;
                                }



                                if (l == 3000) {
                                    Toast.makeText(this, "Faild To find the correct solution", Toast.LENGTH_SHORT).show();
                                    break;
                                }


                            }

                            Vs[kk] = v;
                            zs[kk] = P * Vs[kk] / (Rg * T);
                        }


                        l = 0;
                    }


                   for (int i = 0; i < Y.length; i++) {

                        figps[i] = solve_fugacity(zs[i], Bi[i], As[i]);
                    }
                    double sumn = 0;
                    for (int i = 0; i < Y.length; i++) {

                        if (n[i] != 0.0) {
                            sumn = sumn + n[i];
                            switch (i) {
                                case 0:
                                    figp1.setText(formatter.format(figps[0]));
                                    break;
                                case 1:
                                    figp2.setText(formatter.format(figps[1]));
                                    break;
                                case 2:
                                    figp3.setText(formatter.format(figps[2]));
                                    break;
                                case 3:
                                    figp4.setText(formatter.format(figps[3]));
                                    break;
                                case 4:
                                    figp5.setText(formatter.format(figps[4]));
                                    break;
                            }
                        }
                    }
                    if (sumn <= 0) {
                        Toast.makeText(this, "All # moles are equal to Zero please give one of them a value different than Zero otherwise the program will not work", Toast.LENGTH_SHORT).show();
                    }


                }


            }

            public double[] Changeunit ( double Ts1, double Pc1){

                switch (sP.getSelectedItem().toString()) {
                    case "kPa":
                        Pc1 = Pc1 / 100;

                        break;
                    case "Pa":
                        Pc1 = Pc1 / 100000;

                        break;
                    case "MPa":
                        Pc1 = Pc1 / 0.1;

                        break;
                    case "bar":
                        break;
                    case "mmHg":
                        Pc1 = Pc1 / 750.061683;

                        break;
                    case "psi":
                        Pc1 = Pc1 / 14.503775;

                        break;
                    case "atm":
                        Pc1 = Pc1 / 0.986923;

                        break;
                }
                switch (sT.getSelectedItem().toString()) {

                    case "K":
                        break;
                    case "C":
                        Ts1 = Ts1 + 273.15;
                        break;
                    case "R":
                        Ts1 = Ts1 / 1.8;
                        break;
                    case "F":
                        Ts1 = (Ts1 + 459.67) / 1.8;
                        break;
                }
                double[] tp = new double[2];
                tp[0] = Ts1;
                tp[1] = Pc1;

                return tp;
            }

            public boolean condition () {


                if (Pv.getText().toString().contentEquals("") || Pv.getText().toString().contentEquals(".") || Pv.getText().toString().contentEquals("-")) {
                    Toast.makeText(this, "P wasn't Entered correctly ", Toast.LENGTH_SHORT).show();
                    return false;
                }

                if (Tv.getText().toString().contentEquals("") || Tv.getText().toString().contentEquals(".") || Tv.getText().toString().contentEquals("-") || Tv.getText().toString().contentEquals("+")) {
                    Toast.makeText(this, "T wasn't Entered correctly ", Toast.LENGTH_SHORT).show();
                    return false;

                }


                if (y1.getText().toString().contentEquals("") || y1.getText().toString().contentEquals(".") || y1.getText().toString().contentEquals("-")) {
                    Toast.makeText(this, "n1 wasn't Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                    return false;
                }
                if (y2.getText().toString().contentEquals("") || y2.getText().toString().contentEquals(".") || y2.getText().toString().contentEquals("-")) {
                    Toast.makeText(this, "n2 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                    return false;
                }
                if (y3.getText().toString().contentEquals("") || y3.getText().toString().contentEquals(".") || y3.getText().toString().contentEquals("-")) {
                    Toast.makeText(this, "n3 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                    return false;
                }
                if (y4.getText().toString().contentEquals("") || y4.getText().toString().contentEquals(".") || y4.getText().toString().contentEquals("-")) {
                    Toast.makeText(this, "n4 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                    return false;
                }

                if (y5.getText().toString().contentEquals("") || y5.getText().toString().contentEquals(".") || y5.getText().toString().contentEquals("-")) {
                    Toast.makeText(this, "n5 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                    return false;
                }


                return true;
            }
        }
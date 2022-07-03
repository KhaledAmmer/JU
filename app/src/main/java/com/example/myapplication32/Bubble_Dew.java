package com.example.myapplication32;

import android.content.Intent;
import android.graphics.Color;
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

public class Bubble_Dew extends AppCompatActivity implements AdapterView.OnItemSelectedListener ,NavigationView.OnNavigationItemSelectedListener{
    EditText T, P;
    TextView x1, x2, x3, textView, y3, y2, y1, x4, y4, unitp, unit1;
    double  pressuresat;
    Spinner sT, sP, sSS, sSS2, sSS3, sSS4;
    String[] As, Bs, Cs;
    NumberFormat formatter, formatter1;
    String[] mAs, mBs, mCs;
    double[] y, x, psat, psatprim1, pssatprime2;
    Intent my;
    private DrawerLayout drawer;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bubble__dew);

        NavigationView navigationView = findViewById(R.id.navi);
        navigationView.setNavigationItemSelectedListener(this);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        formatter = new DecimalFormat("#0.0000000");
        formatter1 = new DecimalFormat("#,##0.0000");
        mAs = new String[]{"0.0", "0.0", "0.0", "0.0"};
        mBs = new String[]{"0.0", "0.0", "0.0", "0.0"};
        mCs = new String[]{"0.0", "0.0", "0.0", "0.0"};

        FindId();
        SetAdaptar();
        As = getResources().getStringArray(R.array.constant_a);
        Bs = getResources().getStringArray(R.array.constant_b);
        Cs = getResources().getStringArray(R.array.constant_c);


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


        sP = findViewById(R.id.spinnerp);
        ArrayAdapter<CharSequence> adapterp = ArrayAdapter.createFromResource(this,
                R.array.pressure, R.layout.text1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sP.setAdapter(adapterp);
        sP.setOnItemSelectedListener(this);

    }

    public void FindId() {
        sT = findViewById(R.id.spinnert);
        x1 = findViewById(R.id.x1);
        x2 = findViewById(R.id.x2);
        x3 = findViewById(R.id.x3);
        x4 = findViewById(R.id.x4);
        y1 = findViewById(R.id.y1);
        y2 = findViewById(R.id.y2);
        y3 = findViewById(R.id.y3);
        y4 = findViewById(R.id.y4);

        T = findViewById(R.id.temperature1);
        P = findViewById(R.id.pressure1);

        unitp = findViewById(R.id.punit);
        unit1 = findViewById(R.id.tunit2);
        x4 = findViewById(R.id.x4);
        y4 = findViewById(R.id.y4);
        textView = findViewById(R.id.answer);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public double ChangeConstant(String cons, double a) {
        getads();
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
                a = a + (Math.log(14.503775));
                break;
            case "atm":
                a = a + +(Math.log(0.986923));
                break;
        }


        return a;
    }

    public double ChangeConstant(String cons, double aa, String k) {
        getads();
        switch (k) {
            case "c":
                switch (sT.getSelectedItem().toString()) {
                    case "K":
                        break;
                    case "C":
                        aa = aa + 273.15;
                        break;
                    case "R":
                        aa = aa * 1.8;
                        break;
                    case "F":
                        aa = aa * 1.8 + 459.67;
                        break;


                }
                break;
            case "b":
                switch (sT.getSelectedItem().toString()) {
                    case "K":
                        break;
                    case "C":
                        break;
                    case "R":
                        aa = aa * 1.8;
                        break;
                    case "F":
                        aa = aa * 1.8;
                        break;


                }
                break;
        }

        return aa;
    }


    public double psat(double t, double a, double b, double c) {

        double result = 0;

        result = Math.exp(a - b / (t + c));

        return result;
    }

    public double psat(double t, double[] a, double[] b, double[] c, double p, double[] x) {

        double result = 0;
        for (int i = 0; i < a.length; i++) {

            result = result + Math.exp(a[i] - b[i] / (t + c[i])) * x[i];
        }
        result = result - p;
        return result;
    }

    public double psatprime(double t, double[] a, double[] b, double[] c, double[] x) {

        double result = 0;
        for (int i = 0; i < a.length; i++) {

            result = result + b[i] * Math.exp(a[i] - b[i] / (t + c[i])) * x[i] / (Math.pow(t + c[i], 2));
        }


        return result;
    }

    public double psatprime2(double t, double[] a, double[] b, double[] c, double[] x) {

        double result = 0;
        for (int i = 0; i < a.length; i++) {

            result = result + ((Math.pow(b[i], 2) * (Math.exp(a[i] - b[i] / (t + c[i])))) / (Math.pow(Math.pow(t + c[i], 2), 2))
                    - 2 * b[i] * Math.exp(a[i] - b[i] / (t + c[i])) / (Math.pow(t + c[i], 3))) * x[i];
        }


        return result;
    }

    static double psatt(double t, double[] a, double[] b, double[] c, double p, double[] x) {

        double result = 0;
        for (int i = 0; i < a.length; i++) {

            result = result + x[i] / Math.exp(a[i] - b[i] / (t + c[i]));
        }
        result = (result) - 1 / p;
        return result;
    }

    //f'(x) /*first derivative*/
    static double psatprimet(double t, double[] a, double[] b, double[] c, double[] x) {

        double result = 0;
        for (int i = 0; i < a.length; i++) {

            result = result + (-b[i] * Math.exp(-(a[i] - b[i] / (t + c[i]))) * x[i] / (Math.pow(t + c[i], 2)));
        }


        return result;
    }

    static double psatprime2t(double t, double[] a, double[] b, double[] c, double[] x) {
        //(b^2*y1*exp(b/(c + x) - a))/(c + x)^4 + (2*b*y1*exp(b/(c + x) - a))/(c + x)^3
        double result = 0;
        for (int i = 0; i < a.length; i++) {

            result = result + ((Math.pow(b[i], 2) * (Math.exp(-(a[i] - b[i] / (t + c[i]))))) / (Math.pow(Math.pow(t + c[i], 2), 2))
                    + 2 * b[i] * Math.exp(-(a[i] - b[i] / (t + c[i]))) / (Math.pow(t + c[i], 3))) * x[i];
        }


        return result;
    }

    public void solve_yp(View view) {
        getads();
        if (condition("yp")) {
            String[] posations;
            x = new double[]{Double.parseDouble(x1.getText().toString()), Double.parseDouble(x2.getText().toString()), Double.parseDouble(x3.getText().toString())
                    , Double.parseDouble(x4.getText().toString())};
            double sump = 0;
            for (int i = 0; i < x.length; i++) {
                sump = sump + x[i];
            }
            if (sump != 1) {
                Toast.makeText(this, "Summation of Xi is not equal to 1 ", Toast.LENGTH_SHORT).show();

            } else {


                double[] a, b, c;
                double t = Double.parseDouble(T.getText().toString());

                a = new double[]{Double.parseDouble(As[sSS.getSelectedItemPosition()]), Double.parseDouble(As[sSS2.getSelectedItemPosition()]),
                        Double.parseDouble(As[sSS3.getSelectedItemPosition()]), Double.parseDouble(As[sSS4.getSelectedItemPosition()])};
                b = new double[]{Double.parseDouble(Bs[sSS.getSelectedItemPosition()]), Double.parseDouble(Bs[sSS2.getSelectedItemPosition()]),
                        Double.parseDouble(Bs[sSS3.getSelectedItemPosition()]), Double.parseDouble(Bs[sSS4.getSelectedItemPosition()])
                };
                c = new double[]{
                        Double.parseDouble(Cs[sSS.getSelectedItemPosition()]), Double.parseDouble(Cs[sSS2.getSelectedItemPosition()]),
                        Double.parseDouble(Cs[sSS3.getSelectedItemPosition()]), Double.parseDouble(Cs[sSS4.getSelectedItemPosition()])
                };


                posations = new String[]{sT.getSelectedItem().toString(), sP.getSelectedItem().toString()};
                for (int i = 0; i < a.length; i++) {
                    a[i] = ChangeConstant(posations[1], a[i]);
                    c[i] = ChangeConstant(posations[0], c[i], "c");
                    b[i] = ChangeConstant(posations[0], b[i], "b");
                }
                psat = new double[4];
                for (int i = 0; i < x.length; i++) {
                    psat[i] = psat(t, a[i], b[i], c[i]);
                }


                y = new double[4];
                pressuresat = 0;
                for (int i = 0; i < x.length; i++) {
                    pressuresat = pressuresat + x[i] * psat[i];

                }
                for (int i = 0; i < x.length; i++) {

                    y[i] = x[i] * psat[i] / pressuresat;
                }
                P.setText(formatter1.format(pressuresat));
                P.setTextColor(Color.parseColor("#8F2734"));
                y1.setText(formatter.format(y[0]));
                y1.setTextColor(Color.parseColor("#8F2734"));
                y2.setText(formatter.format(y[1]));
                y2.setTextColor(Color.parseColor("#8F2734"));
                y3.setText(formatter.format(y[2]));
                y3.setTextColor(Color.parseColor("#8F2734"));
                y4.setText(formatter.format(y[3]));
                y4.setTextColor(Color.parseColor("#8F2734"));
                x1.setTextColor(Color.parseColor("#10100F"));
                x2.setTextColor(Color.parseColor("#10100F"));
                x3.setTextColor(Color.parseColor("#10100F"));
                x4.setTextColor(Color.parseColor("#10100F"));
                T.setTextColor(Color.parseColor("#10100F"));
                textView.setVisibility(View.VISIBLE);

            }
        }

    }

    public void solve_yt(View view) {
        getads();
        double[] a, b, c;
        double t = 100, sump = 0, sumpprime1 = 0, sumpprime2 = 0;
        double tolerance = .00000000001;
        int max_count = 500;


        a = new double[]{Double.parseDouble(As[sSS.getSelectedItemPosition()]), Double.parseDouble(As[sSS2.getSelectedItemPosition()]),
                Double.parseDouble(As[sSS3.getSelectedItemPosition()]), Double.parseDouble(As[sSS4.getSelectedItemPosition()])};
        b = new double[]{Double.parseDouble(Bs[sSS.getSelectedItemPosition()]), Double.parseDouble(Bs[sSS2.getSelectedItemPosition()]),
                Double.parseDouble(Bs[sSS3.getSelectedItemPosition()]), Double.parseDouble(Bs[sSS4.getSelectedItemPosition()])
        };
        c = new double[]{
                Double.parseDouble(Cs[sSS.getSelectedItemPosition()]), Double.parseDouble(Cs[sSS2.getSelectedItemPosition()]),
                Double.parseDouble(Cs[sSS3.getSelectedItemPosition()]), Double.parseDouble(Cs[sSS4.getSelectedItemPosition()])
        };
        String[] posations;
        posations = new String[]{sT.getSelectedItem().toString(), sP.getSelectedItem().toString()};
        for (int i = 0; i < a.length; i++) {
            a[i] = ChangeConstant(posations[1], a[i]);
            c[i] = ChangeConstant(posations[0], c[i], "c");
            b[i] = ChangeConstant(posations[0], b[i], "b");
        }

        if (condition("yt")) {

            x = new double[]{Double.parseDouble(x1.getText().toString()), Double.parseDouble(x2.getText().toString()), Double.parseDouble(x3.getText().toString())
                    , Double.parseDouble(x4.getText().toString())};
            for (int i = 0; i < x.length; i++) {
                sump = sump + x[i];
            }
            if (sump != 1) {
                Toast.makeText(this, "Summation of Xi is not equal to 1 ", Toast.LENGTH_SHORT).show();

            } else {
                double psa = Double.parseDouble(P.getText().toString());
                psat = new double[4];
                psatprim1 = new double[4];
                pssatprime2 = new double[4];
                int l = 1;
                for (int count = 1;
                     (Math.abs(psat(t, a, b, c, psa, x)) > tolerance) && (count < max_count);
                     count++) {
                    t = t - psat(t, a, b, c, psa, x) / (psatprime(t, a, b, c, x) -
                            (psatprime2(t, a, b, c, x) * psat(t, a, b, c, psa, x) / (2 * psatprime(t, a, b, c, x))));
                    if (T.getText().toString().contentEquals("-NaN")) {
                        switch (l) {
                            case 1:
                                t = 0;
                                count = 1;
                                break;
                            case 2:
                                t = 200;
                                count = 1;
                                break;
                            case 3:
                                t = 500;
                                count = 1;
                                break;
                            case 4:
                                t = -100;
                                count = 1;
                                break;
                            case 5:
                                t = -50;
                                count = 1;
                                break;
                            case 6:
                                t = -5;
                                count = 1;
                                break;
                            case 7:
                                t = 600;
                                count = 1;
                                break;
                            case 8:
                                t = 400;
                                count = 1;
                                break;

                        }
                        l++;
                    }
                }
            }


            for (int i = 0; i < x.length; i++) {
                psat[i] = psat(t, a[i], b[i], c[i]);
            }

            y = new double[4];
            pressuresat = 0;
            for (int i = 0; i < x.length; i++) {
                pressuresat = pressuresat + x[i] * psat[i];

            }
            for (int i = 0; i < x.length; i++) {

                y[i] = x[i] * psat[i] / pressuresat;
            }
            T.setText(formatter1.format(t));
            T.setTextColor(Color.parseColor("#8F2734"));
            y1.setText(formatter.format(y[0]));
            y1.setTextColor(Color.parseColor("#8F2734"));
            y2.setText(formatter.format(y[1]));
            y2.setTextColor(Color.parseColor("#8F2734"));
            y3.setText(formatter.format(y[2]));
            y3.setTextColor(Color.parseColor("#8F2734"));
            y4.setText(formatter.format(y[3]));
            y4.setTextColor(Color.parseColor("#8F2734"));
            x1.setTextColor(Color.parseColor("#10100F"));
            x2.setTextColor(Color.parseColor("#10100F"));
            x3.setTextColor(Color.parseColor("#10100F"));
            x4.setTextColor(Color.parseColor("#10100F"));
            P.setTextColor(Color.parseColor("#10100F"));
            textView.setVisibility(View.VISIBLE);
        }
    }


    public void solve_xp(View view) {
        getads();
        double sump = 0;
        if (condition("xp")) {
            y = new double[]{Double.parseDouble(y1.getText().toString()), Double.parseDouble(y2.getText().toString()), Double.parseDouble(y3.getText().toString())
                    , Double.parseDouble(y4.getText().toString())};

            for (int i = 0; i < y.length; i++) {
                sump = sump + y[i];
            }
            if (sump != 1) {
                Toast.makeText(this, "Summation of Xi is not equal to 1 ", Toast.LENGTH_SHORT).show();

            } else {
                double[] a, b, c;
                a = new double[]{Double.parseDouble(As[sSS.getSelectedItemPosition()]), Double.parseDouble(As[sSS2.getSelectedItemPosition()]),
                        Double.parseDouble(As[sSS3.getSelectedItemPosition()]), Double.parseDouble(As[sSS4.getSelectedItemPosition()])};
                b = new double[]{Double.parseDouble(Bs[sSS.getSelectedItemPosition()]), Double.parseDouble(Bs[sSS2.getSelectedItemPosition()]),
                        Double.parseDouble(Bs[sSS3.getSelectedItemPosition()]), Double.parseDouble(Bs[sSS4.getSelectedItemPosition()])
                };
                c = new double[]{
                        Double.parseDouble(Cs[sSS.getSelectedItemPosition()]), Double.parseDouble(Cs[sSS2.getSelectedItemPosition()]),
                        Double.parseDouble(Cs[sSS3.getSelectedItemPosition()]), Double.parseDouble(Cs[sSS4.getSelectedItemPosition()])
                };

                String[] posations;
                posations = new String[]{sT.getSelectedItem().toString(), sP.getSelectedItem().toString()};
                for (int i = 0; i < a.length; i++) {
                    a[i] = ChangeConstant(posations[1], a[i]);
                    c[i] = ChangeConstant(posations[0], c[i], "c");
                    b[i] = ChangeConstant(posations[0], b[i], "b");
                }
                psat = new double[]{Math.exp(a[0] - (b[0]) / ((c[0]) + Double.parseDouble(T.getText().toString()))),
                        Math.exp(a[1] - (b[1]) / ((c[1]) + Double.parseDouble(T.getText().toString())))
                        , Math.exp(a[2] - (b[2]) / ((c[2]) + Double.parseDouble(T.getText().toString()))),
                        Math.exp(a[3] - (b[3]) / ((c[3]) + Double.parseDouble(T.getText().toString())))
                };


                x = new double[4];
                pressuresat = 0;
                double sum = 0;
                for (int i = 0; i < x.length; i++) {

                    sum = sum + y[i] / psat[i];
                }
                pressuresat = 1.0 / sum;
                for (int i = 0; i < x.length; i++) {
                    x[i] = y[i] * pressuresat / psat[i];
                }
                P.setText(formatter1.format(pressuresat));
                P.setTextColor(Color.parseColor("#8F2734"));
                x1.setText(formatter.format(x[0]));
                x1.setTextColor(Color.parseColor("#8F2734"));
                x2.setText(formatter.format(x[1]));
                x2.setTextColor(Color.parseColor("#8F2734"));
                x3.setText(formatter.format(x[2]));
                x3.setTextColor(Color.parseColor("#8F2734"));
                x4.setText(formatter.format(x[3]));
                x4.setTextColor(Color.parseColor("#8F2734"));
                y1.setTextColor(Color.parseColor("#10100F"));
                y2.setTextColor(Color.parseColor("#10100F"));
                y3.setTextColor(Color.parseColor("#10100F"));
                y4.setTextColor(Color.parseColor("#10100F"));
                T.setTextColor(Color.parseColor("#10100F"));
                textView.setVisibility(View.VISIBLE);
            }
        }
    }


    public void solve_xt(View view) {
        getads();
        double[] a, b, c;
        double t = 100, sump = 0, sumpprime1 = 0, sumpprime2 = 0;
        double tolerance = .0000000000001;
        int max_count = 500;
        if (condition("xt")) {
            double psa = Double.parseDouble(P.getText().toString());
            a = new double[]{Double.parseDouble(As[sSS.getSelectedItemPosition()]), Double.parseDouble(As[sSS2.getSelectedItemPosition()]),
                    Double.parseDouble(As[sSS3.getSelectedItemPosition()]), Double.parseDouble(As[sSS4.getSelectedItemPosition()])};
            b = new double[]{Double.parseDouble(Bs[sSS.getSelectedItemPosition()]), Double.parseDouble(Bs[sSS2.getSelectedItemPosition()]),
                    Double.parseDouble(Bs[sSS3.getSelectedItemPosition()]), Double.parseDouble(Bs[sSS4.getSelectedItemPosition()])
            };
            c = new double[]{
                    Double.parseDouble(Cs[sSS.getSelectedItemPosition()]), Double.parseDouble(Cs[sSS2.getSelectedItemPosition()]),
                    Double.parseDouble(Cs[sSS3.getSelectedItemPosition()]), Double.parseDouble(Cs[sSS4.getSelectedItemPosition()])
            };

            String[] posations;
            posations = new String[]{sT.getSelectedItem().toString(), sP.getSelectedItem().toString()};
            for (int i = 0; i < a.length; i++) {
                a[i] = ChangeConstant(posations[1], a[i]);
                c[i] = ChangeConstant(posations[0], c[i], "c");
                b[i] = ChangeConstant(posations[0], b[i], "b");
            }

            x = new double[]{Double.parseDouble(y1.getText().toString()), Double.parseDouble(y2.getText().toString()), Double.parseDouble(y3.getText().toString())
                    , Double.parseDouble(y4.getText().toString())};
            for (int i = 0; i < x.length; i++) {
                sump = sump + x[i];
            }
            if (sump != 1) {
                Toast.makeText(this, "Summation of Yi is not equal to 1 ", Toast.LENGTH_SHORT).show();

            } else {
                psat = new double[4];
                psatprim1 = new double[4];
                pssatprime2 = new double[4];
                y = new double[4];
                int l = 1;
                for (int count = 1;
                     (Math.abs(psatt(t, a, b, c, psa, x)) > tolerance) && (count < max_count);
                     count++) {
                    t = t - psatt(t, a, b, c, psa, x) / (psatprimet(t, a, b, c, x) -
                            (psatprime2t(t, a, b, c, x) * psatt(t, a, b, c, psa, x) / (2 * psatprimet(t, a, b, c, x))));
                    T.setText(formatter1.format(t));
                    if (T.getText().toString().contentEquals("-NaN")) {
                        switch (l) {
                            case 1:
                                t = 0;
                                count = 1;
                                break;
                            case 2:
                                t = 200;
                                count = 1;
                                break;
                            case 3:
                                t = 500;
                                count = 1;
                                break;
                            case 4:
                                t = -100;
                                count = 1;
                                break;
                            case 5:
                                t = -50;
                                count = 1;
                                break;
                            case 6:
                                t = -5;
                                count = 1;
                                break;
                            case 7:
                                t = 600;
                                count = 1;
                                break;
                            case 8:
                                t = 400;
                                count = 1;
                                break;

                        }
                        l++;
                    }
                }
                for (int i = 0; i < x.length; i++) {
                    psat[i] = psat(t, a[i], b[i], c[i]);
                    y[i] = x[i] * psa / psat[i];
                }


                T.setText(formatter1.format(t));
                T.setTextColor(Color.parseColor("#8F2734"));
                x1.setText(formatter.format(y[0]));
                x1.setTextColor(Color.parseColor("#8F2734"));
                x2.setText(formatter.format(y[1]));
                x2.setTextColor(Color.parseColor("#8F2734"));
                x3.setText(formatter.format(y[2]));
                x3.setTextColor(Color.parseColor("#8F2734"));
                x4.setText(formatter.format(y[3]));
                x4.setTextColor(Color.parseColor("#8F2734"));
                y1.setTextColor(Color.parseColor("#10100F"));
                y2.setTextColor(Color.parseColor("#10100F"));
                y3.setTextColor(Color.parseColor("#10100F"));
                y4.setTextColor(Color.parseColor("#10100F"));
                P.setTextColor(Color.parseColor("#10100F"));
                textView.setVisibility(View.VISIBLE);
            }
        }

    }

    public boolean condition(String st) {
        if (st.contentEquals("xt")) {

            if (P.getText().toString().contentEquals("") || P.getText().toString().contentEquals(".") || P.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "P wasn't Entered correctly ,please check", Toast.LENGTH_LONG).show();
                return false;
            }
            if (y1.getText().toString().contentEquals("") || y1.getText().toString().contentEquals(".") || y1.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "Y1 wasn't Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
            if (y2.getText().toString().contentEquals("") || y2.getText().toString().contentEquals(".") || y2.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "Y2 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
            if (y3.getText().toString().contentEquals("") || y3.getText().toString().contentEquals(".") || y3.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "Y3 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
            if (y4.getText().toString().contentEquals("") || y4.getText().toString().contentEquals(".") || y4.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "Y4 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        if (st.contentEquals("xp")) {

            if (T.getText().toString().contentEquals("") || T.getText().toString().contentEquals(".") || T.getText().toString().contentEquals("-") || T.getText().toString().contentEquals("+")) {
                Toast.makeText(this, "T wasn't Entered correctly ,please check", Toast.LENGTH_LONG).show();
                return false;
            }
            if (y1.getText().toString().contentEquals("") || y1.getText().toString().contentEquals(".") || y1.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "Y1 wasn't Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
            if (y2.getText().toString().contentEquals("") || y2.getText().toString().contentEquals(".") || y2.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "Y2 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
            if (y3.getText().toString().contentEquals("") || y3.getText().toString().contentEquals(".") || y3.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "Y3 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
            if (y4.getText().toString().contentEquals("") || y4.getText().toString().contentEquals(".") || y4.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "Y4 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        if (st.contentEquals("yp")) {

            if (T.getText().toString().contentEquals("") || T.getText().toString().contentEquals(".") || T.getText().toString().contentEquals("-") || T.getText().toString().contentEquals("+")) {
                Toast.makeText(this, "T wasn't Entered correctly ,please check", Toast.LENGTH_LONG).show();
                return false;
            }
            if (x1.getText().toString().contentEquals("") || x1.getText().toString().contentEquals(".") || x1.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "X1 wasn't Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
            if (x2.getText().toString().contentEquals("") || x2.getText().toString().contentEquals(".") || x2.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "X2 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
            if (x3.getText().toString().contentEquals("") || x3.getText().toString().contentEquals(".") || x3.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "X3 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
            if (x4.getText().toString().contentEquals("") || y4.getText().toString().contentEquals(".") || y4.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "X4 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        if (st.contentEquals("yt")) {

            if (P.getText().toString().contentEquals("") || P.getText().toString().contentEquals(".") || P.getText().toString().contentEquals("-") || P.getText().toString().contentEquals("+")) {
                Toast.makeText(this, "P wasn't Entered correctly ,please check", Toast.LENGTH_LONG).show();
                return false;
            }

            if (x1.getText().toString().contentEquals("") || x1.getText().toString().contentEquals(".") || x1.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "X1 wasn't Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
            if (x2.getText().toString().contentEquals("") || x2.getText().toString().contentEquals(".") || x2.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "X2 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
            if (x3.getText().toString().contentEquals("") || x3.getText().toString().contentEquals(".") || x3.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "X3 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
            if (x4.getText().toString().contentEquals("") || y4.getText().toString().contentEquals(".") || y4.getText().toString().contentEquals("-")) {
                Toast.makeText(this, "X4 wasn't  Entered correctly ,If you don't need it in your calculations please give it the value of 0 otherwise the program will not work", Toast.LENGTH_LONG).show();
                return false;
            }
        }


        return true;
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
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer.test"));
                startActivity(my);
                break;
            case R.id.giveyourfeedback:
                my = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.khaledamer.test"));
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

    };
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
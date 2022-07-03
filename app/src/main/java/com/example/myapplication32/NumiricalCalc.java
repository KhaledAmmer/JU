package com.example.myapplication32;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NumiricalCalc extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText[] ETs, Xts, Yts, Vtx, Ztx, Dtx, Conts;
    TextView[] TVs;
    LinearLayout[] Lays;
    String[][] array;
    Spinner[] Spns;
    int Size;
    String[] co;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numirical_calc);

        findId();
        SetAdaptar();
        setVisability();
    }

    private void findId() {
        Spns = new Spinner[]{findViewById(R.id.method), findViewById(R.id.matrix)};
        Lays = new LinearLayout[]{findViewById(R.id.xlayout), findViewById(R.id.ylayout),
                findViewById(R.id.zlayout), findViewById(R.id.vlayout),
                findViewById(R.id.dlayout), findViewById(R.id.clayout)};
        Xts = new EditText[]{findViewById(R.id.ex1), findViewById(R.id.ex2)};
        Yts = new EditText[]{findViewById(R.id.ey1), findViewById(R.id.ey2)};
        Conts = new EditText[]{findViewById(R.id.econs1), findViewById(R.id.econs2)};

    }

    private void setVisability() {
        int j=Spns[1].getSelectedItemPosition();
        Yts[0].setText(String.valueOf(Spns[1].getSelectedItemPosition()));
        for(int i=j+2;i<Lays.length-1;i++){
            Lays[i].setVisibility(View.GONE);
        }
        Size=j+2;

    }

    private void SetAdaptar() {

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(NumiricalCalc.this,
                R.array.methods, R.layout.text1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spns[0].setAdapter(adapter1);
        Spns[0].setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(NumiricalCalc.this,
                R.array.matrix, R.layout.text1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spns[1].setAdapter(adapter2);
        Spns[1].setOnItemSelectedListener(this);
    }

    private void Guss() {
        array = new String[ETs.length / 2][ETs.length / 2];
        int l = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = ETs[l].getText().toString();
                l++;
            }
        }


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void Calc(View view) {
        co=new String [Size *3];
        AddValus(Xts);
         AddValus(Yts);
        AddValus(Conts);
        double [][] ab =new double[Size][Size+1];
        int l=0;
        for(int i=0;i<Size;i++){
            for(int j=0;j<Size+1;j++){
                ab[i][j]=Double.parseDouble(co[l]);
                l++;
            }
        }
        //**************
        for(int k=1;k<=Size;k++) {
            for(int i=k+1;k<=Size+1;i++) {
             //   m(i,k)=ab(i,k)/ab(k,k);
            }
        }



    }
    private void AddValus(EditText [] Edx){

        for (int  i=0;i<Edx.length;i++){
            co[i]=(Edx[i].getText().toString());
        }

    }
}
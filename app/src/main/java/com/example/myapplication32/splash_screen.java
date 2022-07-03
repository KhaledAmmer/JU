package com.example.myapplication32;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class splash_screen extends AppCompatActivity {
    private static int SPLASH_SCREEN=3100;
    Animation top, bottom,top1;
    ImageView uv;
    TextView textView,textView1;
ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        im=findViewById(R.id.im);
        textView=findViewById(R.id.textview22);
        textView1=findViewById(R.id.textview2);

        top1 = AnimationUtils.loadAnimation(this, R.anim.top1_anim);
        top = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_ainm);
        im.setAnimation(bottom);
        textView.setAnimation(top);
        textView1.setAnimation(top1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myy=new Intent(splash_screen.this, MainActivity.class);
                startActivity(myy);
                finish();
            }
        },SPLASH_SCREEN);


    }
}
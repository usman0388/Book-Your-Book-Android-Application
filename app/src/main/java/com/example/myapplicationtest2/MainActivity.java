package com.example.myapplicationtest2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 7000;
    Animation rotateAnim;
    Animation fadeInAnime;
    Animation bounceAnim;

    ImageView imageView;
    ImageView imageLogo;
    TextView textView;
    private View background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imageView = findViewById(R.id.imageView3);
        imageLogo = findViewById(R.id.imageView2);
        textView = findViewById(R.id.LogoText);
        background = findViewById(R.id.background);

        if (savedInstanceState == null) {
            background.setVisibility(View.INVISIBLE);

            final ViewTreeObserver viewTreeObserver = background.getViewTreeObserver();

            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

                    @Override
                    public void onGlobalLayout() {
                        circularRevealActivity();
                        background.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }

                });
            }

        }


        fadeinAnim();
        TextAnim();
        rotateAnim();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
    private void circularRevealActivity() {
        int cx = background.getWidth()/2;
        int cy = background.getHeight()/2;

        float finalRadius = Math.max(background.getWidth(), background.getHeight());

        Animator circularReveal = ViewAnimationUtils.createCircularReveal(
                background,
                cx,
                cy,
                0,
                finalRadius);

        circularReveal.setDuration(4000);
        background.setVisibility(View.VISIBLE);
        circularReveal.start();

    }

    private void TextAnim() {
        bounceAnim = AnimationUtils.loadAnimation(this,R.anim.bounce_anim);
        textView.startAnimation(bounceAnim);

    }

    private void fadeinAnim() {
        fadeInAnime = AnimationUtils.loadAnimation(this,R.anim.fadein_anim);
        imageLogo.startAnimation(fadeInAnime);

    }

    private void rotateAnim() {
        rotateAnim = AnimationUtils.loadAnimation(this,R.anim.rotate_anim);
        imageView.startAnimation(rotateAnim);
    }

}
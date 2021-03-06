package de.hsos.ersti_app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //Welcome Image which will fade in at the beginning of the app
        ImageView welcomeImage = (ImageView)findViewById(R.id.welcomeView);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        welcomeImage.startAnimation(fadeInAnimation);
        //Welcome-View will be displayed for 3 seconds -> then main-View
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcomeIntent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(welcomeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}

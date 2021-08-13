package ke.xd.guideapp.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import ke.xd.guideapp.R;
import ke.xd.guideapp.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIMER = 5000;


//    variables
    ImageView backgroundImage;
    TextView poweredByLine;


//    Animations
    Animation sideAnim, bottomAnim;


    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // to remove Status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);



//        hooks
        backgroundImage = findViewById(R.id.background_image);
        poweredByLine = findViewById(R.id.powered_by_line);


//        Animations


        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);


//        set Animations on elements
        backgroundImage.setAnimation(sideAnim);
        poweredByLine.setAnimation(bottomAnim);


        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                *//*Intent intent = new Intent(SplashScreen.this, OnBoarding.class);
                startActivity(intent);
                finish();*//*

            }
        },SPLASH_TIMER);*/
        new Handler().postDelayed((Runnable) () -> {

            onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);


            boolean isFirstTime = onBoardingScreen.getBoolean("firstTime",true);


            if (isFirstTime){
                SharedPreferences.Editor editor = onBoardingScreen.edit();
                editor.putBoolean("firstTime" ,false);
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), OnBoarding.class);
                startActivity(intent);
                finish();

            }
            else {
                Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(intent);
                finish();

            }




        },SPLASH_TIMER);
    }
}
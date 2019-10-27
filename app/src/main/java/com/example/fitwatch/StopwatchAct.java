package com.example.fitwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopwatchAct extends AppCompatActivity {

    Button btnstart; ImageView icanchor; Animation roundingalone;
    Button btnstop;
    Chronometer timerHere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        btnstart = findViewById(R.id.btnstart);
        btnstop = findViewById(R.id.btnstop);
        icanchor = findViewById(R.id.icanchor);
        timerHere = findViewById(R.id.timerHere);

        //create optional animation
     btnstop.setAlpha(0);

    //load animation
        roundingalone = AnimationUtils.loadAnimation(this,R.anim.roundingalone);

        //import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");


        btnstart.setTypeface(MMedium);
        btnstart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //passing Animation
                icanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(1).setDuration(300).start();

                //Start Time
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();
            }
        });

    }
}

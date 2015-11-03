package com.pedrovelasco.lanzarmoneda2;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub



        int action = MotionEventCompat.getActionMasked(event);
        if(action == MotionEvent.ACTION_UP){

            animate();
            return true;

        }else{
            return  super.onTouchEvent(event);

        }



    }








    private void animate(){
        final ImageView imgView = (ImageView)findViewById(R.id.imageView);
        final Drawable cara = (Drawable)getDrawable(R.drawable.cara);
        final Drawable cruz = (Drawable)getDrawable(R.drawable.cruz);
        final int segundosA = 1000;




        imgView.setImageDrawable(null);


        imgView.setVisibility(ImageView.VISIBLE);
        imgView.setBackgroundResource(R.drawable.frame_animation);


        final AnimationDrawable frame = (AnimationDrawable) imgView.getBackground();
        frame.start();

        Random randomGenerator = new Random();
        int randomTime = (randomGenerator.nextInt(4) + 1) * 1000;
        final int randomCara = randomGenerator.nextInt(2);
        final Toast toast = new Toast(getApplicationContext());

        new CountDownTimer(randomTime, segundosA) {

            public void onTick(long millisUntilFinished) {
                //accion cada tic

            }

            public void onFinish() {
                //terminado el tiempo

                    frame.stop();
                    if (randomCara == 0) {
                        imgView.setImageDrawable(cara);
                        Log.d("Resultado", "cara");

                        Toast.makeText(getApplicationContext(), "Cara",
                                Toast.LENGTH_SHORT).show();

                    } else {
                        imgView.setImageDrawable(cruz);
                        Log.d("Resultado", "cruz");
                        Toast.makeText(getApplicationContext(), "Cruz",
                                Toast.LENGTH_SHORT).show();
                    }


                    imgView.setBackgroundResource(0);


                }

        }.start();

    }

}

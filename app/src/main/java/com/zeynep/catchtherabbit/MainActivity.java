package com.zeynep.catchtherabbit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView []bunnys;
    int skor=0;
    TextView scoreNum;
    TextView sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreNum=findViewById(R.id.scoreNum);
        sonuc=findViewById(R.id.sonuc);

        bunnys=new ImageView[]{findViewById(R.id.bunny),findViewById(R.id.bunny2), findViewById(R.id.bunny3),
                               findViewById(R.id.bunny4),findViewById(R.id.bunny5), findViewById(R.id.bunny6),
                               findViewById(R.id.bunny7),findViewById(R.id.bunny8), findViewById(R.id.bunny9)};



        new CountDownTimer(20000,6000){

            @Override
            public void onTick(long l) {
                hideBunny();
                Random random=new Random();
                int showBunny= random.nextInt(9);
                bunnys[showBunny].setVisibility(View.VISIBLE);
            }

            @Override
            public void onFinish() {
                hideBunny();
                sonuc.setText("GAME OVER");
            }
        }.start();
    }
    public void catchBunny(View view){
        skor++;
        scoreNum.setText("SCORE:"+skor);

    }
    public void hideBunny(){
       for(ImageView showedBunny:bunnys){
           showedBunny.setVisibility(View.INVISIBLE);
       }
    }



}
package com.example.trema1032138.applicationdeboutonmusique;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivityMusique extends AppCompatActivity {
    int paused;
    MediaPlayer music;
    int X=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_musique);
        final int [] musique = {R.raw.savior,R.raw.biscuit};
        final Button boutonMusique1 = (Button) findViewById(R.id.buttonmusique1);
        final Button boutonMusique2 = (Button) findViewById(R.id.buttonmusique2);
        music = new MediaPlayer();


        boutonMusique1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                X=0;


                music = MediaPlayer.create(MainActivityMusique.this,musique[X]);

                music.start();
                boutonMusique1.setEnabled(false);
                boutonMusique2.setEnabled(false);

            }
    });




        boutonMusique2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                X=1;

                music = MediaPlayer.create(MainActivityMusique.this,musique[X]);
                music.start();
                boutonMusique1.setEnabled(false);
                boutonMusique2.setEnabled(false);

            }
        });
        /*music.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                music.stop();
                boutonMusique1.setEnabled(true);
                boutonMusique2.setEnabled(true);

                try {
                    music.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/





        final Button boutonStop = (Button) findViewById(R.id.buttonStop);
        boutonStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    music.stop();
                    boutonMusique1.setEnabled(true);
                    boutonMusique2.setEnabled(true);
                try {
                    music.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        final Button boutonPause = (Button) findViewById(R.id.buttonPause);
        boutonPause.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                    music.pause();
                    paused = music.getCurrentPosition();


            }
        });

        final Button boutonPlay = (Button) findViewById(R.id.buttonPlay);
        boutonPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                    music.start();




            }
        });

        final Button boutonReculer = (Button) findViewById(R.id.Reculer);
        boutonReculer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                music.pause();
                music.seekTo(music.getCurrentPosition()-5000);
                music.start();





            }
        });

        final Button boutonAvancer = (Button) findViewById(R.id.Avancer);
        boutonAvancer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                music.pause();
                music.seekTo(music.getCurrentPosition()+5000);
                music.start();





            }
        });

        final Button boutonPrecedent = (Button) findViewById(R.id.Precedent);
        boutonPrecedent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                music.stop();try {
                    music.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                music = MediaPlayer.create(MainActivityMusique.this,musique[X =X-1]);
                   /*if(X ==-1)
                {
                    int MaxX = musique.length;
                    music = MediaPlayer.create(MainActivityMusique.this,musique[1]);
                }*/
                music.start();
            }
        });

        final Button boutonPasser = (Button) findViewById(R.id.Passer);
        boutonPasser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                music.stop();try {
                    music.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                music = MediaPlayer.create(MainActivityMusique.this,musique[X =X+1]);

                music.start();




            }
        });

        final Button buttonAjout = (Button) findViewById(R.id.buttonAjoutMusique);
        buttonAjout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent inten = new Intent(MainActivityMusique.this, AjoutMusique.class);
                startActivity(inten);
            }




        });


        /*public void EtatEnabled(boolean Etat)
        {
            if(Etat==true)
            {
                boutonMusique1.setEnabled(true);
                boutonMusique2.setEnabled(true);
            }
            else
            {
                if(Etat==false)
                {
                    boutonMusique1.setEnabled(false);
                    boutonMusique2.setEnabled(false);
                }

            }
        }*/
    }






}


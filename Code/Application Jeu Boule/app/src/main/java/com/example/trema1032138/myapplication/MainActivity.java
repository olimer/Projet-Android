package com.example.trema1032138.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.R.attr.x;
import static android.R.attr.y;


public class MainActivity extends AppCompatActivity {

    private TextView TestText,scorepoint;
    private LinearLayout TestInt;
    private com.example.trema1032138.myapplication.CercleCanvas InvalidCanvas;
    private String TAG;
   private float x,y,z;
    private int score;

    private float mLastX, mLastY, mLastZ;
    private boolean mInitialized;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private final float NOISE = (float) 2.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);


        final Boule PropBoule = new Boule();
        InvalidCanvas = (com.example.trema1032138.myapplication.CercleCanvas) findViewById(R.id.Boule);
        final MediaPlayer Son = MediaPlayer.create(this, R.raw.sound_effect);
        final MediaPlayer Bye = MediaPlayer.create(this,R.raw.bye);
        GestBoule GestionBoule = new GestBoule();
        GestionBoule.execute(InvalidCanvas);
        score =InvalidCanvas.score;
        scorepoint = (TextView)findViewById(R.id.Score);
        scorepoint.setText(Integer.toString(score));





        SensorEventListener gyroscopeSensorListener = new SensorEventListener() {
            

            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                String tvX ,tvY,tvZ;

                float x = sensorEvent.values[0];
                float y = sensorEvent.values[1];
                float z = sensorEvent.values[2];
                if (!mInitialized) {
                    mLastX = x;
                    mLastY = y;
                    mLastZ = z;
                    tvX="0.0";
                    tvY ="0.0";
                    tvZ="0.0";
                    mInitialized = true;
                } else {
                    float deltaX = Math.abs(mLastX - x);
                    float deltaY = Math.abs(mLastY - y);
                    float deltaZ = Math.abs(mLastZ - z);
                    if (deltaX < NOISE) deltaX = (float)0.0;
                    if (deltaY < NOISE) deltaY = (float)0.0;
                    if (deltaZ < NOISE) deltaZ = (float)0.0;
                    mLastX = x;
                    mLastY = y;
                    mLastZ = z;
                    tvX=(Float.toString(deltaX));
                    tvY=(Float.toString(deltaY));
                    tvZ=(Float.toString(deltaZ));
                   Log.i("DICJ","X : " + tvX + ", Y : "+ tvY +", Z : "+ tvZ);
                }


                /*double valeurSensorX = sensorEvent.values[1];
                double valeurSensorY = sensorEvent.values[0];
                Log.i("DICJ", "Y : " + valeurSensorY + ", X : " + valeurSensorX );*/

                if (sensorEvent.values[0] > 0.4f) {
                    InvalidCanvas.VitesseY(50);


                } else if (sensorEvent.values[0] < -0.4f) { // clockwise
                    InvalidCanvas.VitesseY(-50);

                }
                if (sensorEvent.values[1] > 0.4f) { // anticlockwise
                    InvalidCanvas.VitesseX(50);



                } else if (sensorEvent.values[1] < -0.4f) { // clockwise
                    InvalidCanvas.VitesseX(-50);
                }

                score =InvalidCanvas.score;
                scorepoint = (TextView)findViewById(R.id.Score);
                scorepoint.setText(Integer.toString(score));
            }




            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {


            }
        };


        sensorManager.registerListener(gyroscopeSensorListener, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);


        final Button button = (Button) findViewById(R.id.BtnJouer);
        final Button buttonQuitter = (Button) findViewById(R.id.BtnQuitter);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Button btnJouer = (Button) findViewById(R.id.BtnJouer);
                btnJouer.setVisibility(View.INVISIBLE);
                Son.start();
            }
        });


        buttonQuitter.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {

                                                 Bye.start();
                                                 MainActivity.this.finish();



                                             }

                                         }
        );



    }




}

















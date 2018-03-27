package com.example.trema1032138.appgyroscope;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     TextView TextChange,TextX,TextY,TextZ;
    /*private static final float NS2S = 1.0f / 1000000000.0f;
    private final float[] deltaRotationVector = new float[4];
    private float timestamp;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextChange = (TextView)findViewById(R.id.TextChange);
        /*TextX = (TextView)findViewById(R.id.X);
        TextY = (TextView)findViewById(R.id.Y);
        TextZ = (TextView)findViewById(R.id.Z);*/
        SensorManager sensorManager =(SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        SensorEventListener gyroscopeSensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent)
            {
                if(sensorEvent.values[0]>2.0f) { // anticlockwise
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                    TextChange.setText("En arriere");
                } else if(sensorEvent.values[0] < -2.0f) { // clockwise
                    getWindow().getDecorView().setBackgroundColor(Color.BLACK);
                    TextChange.setText("En avant");
                }
                if(sensorEvent.values[2] > 2.0f) { // anticlockwise
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                    TextChange.setText("Gauche");
                } else if(sensorEvent.values[2] < -2.0f) { // clockwise
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                    TextChange.setText("Droite");
                }
                /*double AxisX = sensorEvent.values[0];
                double AxisY = sensorEvent.values[1];
                double AxisZ = sensorEvent.values[2];

                double omegaMagnitude = java.lang.Math.sqrt(AxisX*AxisX + AxisY*AxisY + AxisZ*AxisZ);

                // Normalize the rotation vector if it's big enough to get the axis
                // (that is, EPSILON should represent your maximum allowable margin of error)
               /* if (omegaMagnitude > EPSILON) {
                    axisX /= omegaMagnitude;
                    axisY /= omegaMagnitude;
                    axisZ /= omegaMagnitude;
                }

                // Integrate around this axis with the angular speed by the timestep
                // in order to get a delta rotation from this sample over the timestep
                // We will convert this axis-angle representation of the delta rotation
                // into a quaternion before turning it into the rotation matrix.
                float thetaOverTwo = omegaMagnitude * dT / 2.0f;
                float sinThetaOverTwo = sin(thetaOverTwo);
                float cosThetaOverTwo = cos(thetaOverTwo);
                deltaRotationVector[0] = sinThetaOverTwo * axisX;
                deltaRotationVector[1] = sinThetaOverTwo * axisY;
                deltaRotationVector[2] = sinThetaOverTwo * axisZ;
                deltaRotationVector[3] = cosThetaOverTwo;
            }
            timestamp = event.timestamp;
            float[] deltaRotationMatrix = new float[9];
  SensorManager.getRotationMatrixFromVector(deltaRotationMatrix, deltaRotationVector);
            // User code should concatenate the delta rotation we computed with the current rotation
            // in order to get the updated rotation.
            // rotationCurrent = rotationCurrent * deltaRotationMatrix;
        }*/
            }

            @Override
            public void onAccuracyChanged(Sensor sensor,int i)
            {

            }

        };

        sensorManager.registerListener(gyroscopeSensorListener,gyroscopeSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }




}

package com.example.trema1032138.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button button = (Button) findViewById(R.id.BtnJouer);
        button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Button btnJouer = (Button) findViewById(R.id.BtnJouer);
                btnJouer.setVisibility(View.INVISIBLE);
                Button btnQuitter = (Button) findViewById(R.id.BtnQuitter);
                btnQuitter.setVisibility(View.INVISIBLE);
            }
        });

    }

















}

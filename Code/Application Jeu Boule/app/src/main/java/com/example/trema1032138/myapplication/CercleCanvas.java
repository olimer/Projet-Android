package com.example.trema1032138.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by TreMa1032138 on 2018-03-21.
 */

public class CercleCanvas extends View {
    private String Maxime;
    private boolean PremierTour = true;
    private boolean VerificationDeplacement = false;
    private Boule PropBoule;
    int Radius = 50;
    int score =0;


    public CercleCanvas(Context context) {
        super(context);
    }

    public CercleCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);

        PropBoule = new Boule();

    }


    public void Deplacer() {
        Log.i("Maxime", "Deplacer");
        if(pasdepasserbordure()==true)
        {
            PropBoule.SetX(PropBoule.getX() + PropBoule.getVitesseX());
            PropBoule.SetY(PropBoule.getY() + PropBoule.getVitesseY());
            invalidate();

        }
    }

    boolean pasdepasserbordure() {
        if (PropBoule.getX() - Radius + PropBoule.getVitesseX() <= 0) {
            score =0;
            return false;


        }
        if (PropBoule.getX() + Radius + PropBoule.getVitesseX() >= getWidth()) {
            score =0;
            return false;
        }
        if (PropBoule.getY() - Radius  + PropBoule.getVitesseY() < 0) {
            score =0;
            return false;
        }
        if (PropBoule.getY() + Radius  + PropBoule.getVitesseY() > getHeight())
        {
            score =0;
            return false;
        }
        score =score+10;
        return true;

    }

    public void VitesseX(int x){

        Log.i("Maxime","VitesseX");
        PropBoule.SetX(PropBoule.getX() + x);



    }

    public void VitesseY(int y){

        Log.i("Maxime","VitesseY");
        PropBoule.SetY(PropBoule.getY() + y);

    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        if(PremierTour == true)
        {
            super.onDraw(canvas);

        /*int x = getWidth();
        int y =getHeight();*/
            PropBoule.SetX(getWidth()/2);
            PropBoule.SetY(getHeight()/2);

            Paint Couleur = new Paint();
            Couleur.setColor(Color.parseColor("#FF0000"));

            canvas.drawCircle(PropBoule.getX(), PropBoule.getY(), Radius, Couleur);
            PremierTour = false;
        }
        else
        {

            Log.i("Maxime","onDraw");
            super.onDraw(canvas);


            /*PropBoule.SetX(PropBoule.getX());
            PropBoule.SetY(PropBoule.getY());*/
            int Radius;
            Radius = 50;
            Paint Couleur = new Paint();
            Couleur.setColor(Color.parseColor("#FF0000"));

            canvas.drawCircle(PropBoule.getX(), PropBoule.getY(), Radius, Couleur);

        }
    }
}

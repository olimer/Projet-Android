package com.example.trema1032138.myapplication;

import android.util.Log;

/**
 * Created by TreMa1032138 on 2018-03-28.
 */

public class Boule {
    int X,Y,VitesseX=0,VitesseY=0;
    String Maxime;





    public void Deplacer()
    {
        Log.i("Maxime","Deplacer");


        X = X+getVitesseX();
        Y = Y+getVitesseY();


    }


    public int getX() {
        return X;
    }

    public void SetX(int ValeurX)
    {
        X = ValeurX;
    }

    public int getY() {
        return Y;
    }

    public void SetY(int ValeurY)
    {
        Y = ValeurY;
    }

    public int getVitesseX() {
        return VitesseX;
    }

    public void SetVitesseX(int ValX)
    {
        VitesseX = ValX;
    }

    public int getVitesseY() {
        return VitesseY;
    }

    public void SetVitesseY(int ValY)
    {
        VitesseY = ValY;
    }

}

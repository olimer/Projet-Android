package com.example.trema1032138.myapplication;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by TreMa1032138 on 2018-04-05.
 */

public class GestBoule extends AsyncTask<CercleCanvas,Void,Void> {
    boolean Etat =true;
    String Maxime;
    CercleCanvas Cercle;

    @Override
    protected Void doInBackground(CercleCanvas ...Params)
    {

        Cercle = Params[0];

        while (Etat == true)
        {
            try {
                Log.i("Maxime","doInBackground");
                Thread.sleep(10);
                publishProgress();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        Log.i("Maxime","onProgressUpdate");
        super.onProgressUpdate(values);
        Cercle.Deplacer();
    }
}

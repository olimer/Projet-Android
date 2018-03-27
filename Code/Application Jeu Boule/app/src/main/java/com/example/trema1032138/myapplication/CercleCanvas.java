package com.example.trema1032138.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by TreMa1032138 on 2018-03-21.
 */

public class CercleCanvas extends View {

    public CercleCanvas (Context context)
    {
        super(context);
    }

    public CercleCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        int x = getWidth();
        int y =getHeight();
        int Radius;
        Radius =50;
        Paint Couleur = new Paint();
        Couleur.setColor(Color.parseColor("#FF0000"));

        canvas.drawCircle(x/2,y/2,Radius,Couleur);
    }
}

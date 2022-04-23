package com.bognet.eudaimonia.homescreen.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import lombok.Getter;
import lombok.Setter;

public class OrbitPath extends View {

    private final Paint brush;

    private float startRads;

    private float lengthRads;

    // default ccw

    OrbitPath(Context ctx) {
        super(ctx);
        brush = new Paint();
        startRads = 0;
        lengthRads = 0;
        // orbit originates at center
    }

    public void setStartRads(float rads) {
        startRads = rads;
    }

    public void setLengthRads(float rads) {
        lengthRads = rads;
    }

    public float getOrbitRadius() {
        return Math.min(getWidth(), getHeight()) / 2.0f;
    }

    public void setColor(int col) {
        brush.setColor(col);
    }

    public void setStrokeWidth(float width) {
        brush.setStrokeWidth(width);
    }

    @Override
    public void onDraw(Canvas canvas) {
        // draw a circle around its center
        int[] center = {getWidth(), getHeight()};
        float orbitRadius = Math.min(center[0], center[1]) / 2.0f;


        canvas.drawArc(center[0] - orbitRadius, center[1] - orbitRadius, center[0] + orbitRadius, center[1] + orbitRadius,
                startRads, lengthRads, false, brush);
    }
}

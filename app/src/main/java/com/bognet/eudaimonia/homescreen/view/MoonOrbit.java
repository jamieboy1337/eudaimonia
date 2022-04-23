package com.bognet.eudaimonia.homescreen.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

public class MoonOrbit extends ViewGroup {
    private final OrbitPath path;
    private double delta;

    public MoonOrbit(Context ctx) {
        super(ctx);
        path = new OrbitPath(ctx);
        addView(path);

        path.setStartRads(-1.0f);
        path.setLengthRads(1.0f);
        path.setColor(Color.RED);
    }

    @Override
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        LayoutParams param = (LayoutParams) path.getLayoutParams();
        param.height = bottom - top;
        param.width = right - left;

        path.setLayoutParams(param);
    }
}

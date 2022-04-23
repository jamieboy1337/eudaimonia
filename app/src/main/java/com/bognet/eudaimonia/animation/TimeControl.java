package com.bognet.eudaimonia.animation;

public class TimeControl {
    private long lastTimePoint;

    public TimeControl() {
        lastTimePoint = System.nanoTime();
    }

    public double getDelta() {
        long currentTimePoint = System.nanoTime();
        double delta = ((double)(currentTimePoint - lastTimePoint)) / 1e9;
        lastTimePoint = currentTimePoint;
        return delta;
    }
}

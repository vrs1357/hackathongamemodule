package main.java.pool.PoolObjects;

import java.awt.*;

import java.time.LocalTime;

public class CueBall extends Ball {
    public CueBall(int num, double xPos, double yPos, Color color) {
        super(num, xPos, yPos, color);
        moveStartTime = 0;
    }

    // set the initial velocity in x and y direction; used when hit by cue
    public void hit(double direction, int powerLevel) {
        this.speed_x = powerLevel * Math.cos(direction);
        this.speed_y = powerLevel * Math.sin(direction);
        moveStartTime = LocalTime.now().getSecond();
        move();
    }

}

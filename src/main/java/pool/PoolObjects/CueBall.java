package main.java.pool.PoolObjects;

import java.awt.*;

import java.time.LocalTime;

public class CueBall extends Ball {
    public CueBall(int num, double xPos, double yPos, Color color, Table t) {
        super(num, xPos, yPos, color, t);
        moveStartTime = 0;
    }

    // set the initial velocity in x and y direction; used when hit by cue
    public void hit(double direction, double powerLevel) {
        this.speed_x = powerLevel * Math.cos(Math.toRadians(180-direction));
        this.speed_y = powerLevel * Math.sin(Math.toRadians(direction));
        moveStartTime = LocalTime.now().getSecond();
        move();
    }

}

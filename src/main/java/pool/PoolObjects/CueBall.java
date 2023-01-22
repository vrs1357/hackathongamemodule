package pool.PoolObjects;

import java.awt.*;
import java.awt.event.*;

import java.time.LocalTime;
import javax.swing.Timer;

public class CueBall extends Ball {
    public int firstHitBall;
    public CueBall(int num, double xPos, double yPos, Color color, Table t) {
        super(num, xPos, yPos, color, t);
        moveStartTime = 0;
    }

    // set the initial velocity in x and y direction; used when hit by cue
    public void hit(double direction, double powerLevel) {
        this.speed_x = powerLevel * Math.cos(Math.toRadians(direction));
        this.speed_y = powerLevel * Math.sin(Math.toRadians(-direction));
        this.moveStartTime = LocalTime.now().getSecond();
        move();
    }
}

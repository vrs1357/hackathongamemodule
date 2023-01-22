package pool.PoolObjects;

import java.util.Scanner;

public class Ball {
    private static final double DECELERATION  = 0.02;
    private static final double RADIUS = 10;
    private double x;
    private double y;
    protected double speed_x;
    protected double speed_y;
    private boolean inHole;
    private int number;


    public Ball(int num, double xPos, double yPos) {
        this.inHole = false;
        this.number = num;
        this.x = xPos;
        this.y = yPos;
        this.speed_x = 0;
        this.speed_y = 0;
    }

    public double getSpeedX() {
        return this.speed_x;
    }

    public double getSpeedY() {
        return this.speed_y;
    }

    public double getComponent(double theta) {
        return Math.cos(theta) * this.x + Math.sin(theta) * this.y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public boolean isInHole() {
        return this.inHole;
    }

    public int getNumber() {
        return this.number;
    }

    public void setSpeedX(double speed) {
        this.speed_x = speed;
    }

    public void setSpeedY(double speed) {
        this.speed_y = speed;
    }

    public void sink() {
        this.inHole = true;
        this.speed_y = 0;
        this.speed_x = 0;
    }

    public void move(double time) {
        this.x += this.speed_x * time;
        this.y += this.speed_y * time;
        decelerate(time);
        // check collision
    }

    public void decelerate(double time) {
        this.speed_x -= DECELERATION * time;
        this.speed_y -= DECELERATION * time;
    }

    public void collideBall(Ball ballCollide) {
        double theta = Math.atan2(ballCollide.y - this.y, ballCollide.x - this.x);
        double component1 = this.getComponent(theta);
        double component2 = ballCollide.getComponent(theta);

        this.speed_x = Math.cos(theta) * (component2 - component1);
        this.speed_y = Math.sin(theta) * (component2 - component1);
        ballCollide.setSpeedX(Math.cos(theta) * (component1 - component2));
        ballCollide.setSpeedY(Math.sin(theta) * (component1 - component2));
    }

    // direction: true->x-direction; false->y-direction
    public void collideTable(boolean isX) {
        if (isX) {
            this.speed_x *= -1;
        } else {
            this.speed_y *= -1;
        }
    }
}
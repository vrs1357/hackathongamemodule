package main.java.pool.PoolObjects;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.time.LocalTime;

public class Ball {
    private static final double DECELERATION  = 0.02;
    private static final double RADIUS = 12;
    private double x;
    private double y;
    protected double speed_x;
    protected double speed_y;
    private boolean inHole;
    private int number;
    private Color color;
    protected int moveStartTime;
    protected int secondsPassed;


    public Ball(int num, double xPos, double yPos, Color color) {
        this.inHole = false;
        this.number = num;
        this.x = xPos;
        this.y = yPos;
        this.speed_x = 0;
        this.speed_y = 0;
        this.color = color;
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

    public void move() {
        secondsPassed = LocalTime.now().getSecond() - moveStartTime; 
        this.x += this.speed_x * secondsPassed;
        this.y += this.speed_y * secondsPassed;
        decelerate(secondsPassed);
        // check collision
    }

    public void decelerate(double time) {
        this.speed_x -= DECELERATION * time;
        this.speed_y -= DECELERATION * time;

        if (!(Math.sqrt(Math.pow(this.speed_x, 2) + Math.pow(this.speed_y, 2)) <= 0)){
            move();
        }
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

    public void render(Graphics g) {
        Graphics2D ball = (Graphics2D) g;
        ball.setColor(this.color);
        ball.fill(new Ellipse2D.Double(this.x - this.RADIUS, this.y - this.RADIUS, 2.0 * this.RADIUS, 2.0 * this.RADIUS));
        if (this.number != 0) {
            ball.setColor(Color.WHITE);
            ball.fillOval((int)(this.x - 9.0), (int)(this.y - 7.3), 14, 14);
            ball.setColor(Color.BLACK);
            ball.drawString(String.valueOf(this.number), (int)(this.x - 6.3), (int)(this.y + 4.0));
        }
    }

    private void updatePos(){
    }
}

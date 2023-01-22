package pool.PoolObjects;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.event.ChangeListener;

public class Ball {
    private static double DECELERATION  = 0.997;
    private static final double RADIUS = 12;
    private double x;
    private double y;
    protected double speed_x;
    protected double speed_y;
    private boolean inHole;
    public final int number;
    private Color color;
    protected int moveStartTime;
    protected int secondsPassed;
    private Table gameTable;
    private int contact;
    private int contactNo;


    public Ball(int num, double xPos, double yPos, Color color, Table t) {
        this.inHole = false;
        this.number = num;
        this.x = xPos;
        this.y = yPos;
        this.speed_x = 0;
        this.speed_y = 0;
        this.color = color;
        gameTable = t;
        contact = 0;
        contactNo = 0;
    }

    public double getSpeedX() {
        return this.speed_x;
    }

    public double getSpeedY() {
        return this.speed_y;
    }

    public double getSpeed() {
        double speed = Math.sqrt(Math.pow(getSpeedY(), 2) + Math.pow(getSpeedX(), 2));
        return speed;
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

//    public double getRadius() {
//        return RADIUS;
//    }

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
        ArrayList<Map.Entry<Integer, Integer>> holes = gameTable.getHoles();

        for (Map.Entry<Integer, Integer> hole : holes) {
            int holeX = hole.getKey();
            int holeY = hole.getValue();

            if (Math.sqrt(Math.pow(holeX-this.x, 2) + Math.pow(holeY-this.y, 2)) <= 20) {
                this.inHole = true;
                gameTable.pocketBall(this.number);
                this.speed_y = 0;
                this.speed_x = 0;
            } else {
            }
        }
    }

    public void move() {
        System.out.println("Speed = " + getSpeed());
        secondsPassed = LocalTime.now().getSecond() - moveStartTime;
        this.x += this.speed_x * secondsPassed/10;
        this.y += this.speed_y * secondsPassed/10;
        System.out.println("x = " + this.x);
        decelerate();
        moveStartTime = secondsPassed;
        Timer timer = new Timer(1000/60, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });
        timer.start();
        checkBallCollisions();
        sink();
        checkCollideTable();
    }

    public void update() {
        gameTable.updateUI();
        if ((Math.sqrt(Math.pow(this.speed_x, 2) + Math.pow(this.speed_y, 2)) > 0)){
            move();
        }
    }
    public void decelerate() {
        if(getSpeed() <  0.3)
        {
            this.speed_x = 0;
            this.speed_y = 0;
            this.DECELERATION = 0.997;
        }
        else if(getSpeed() < 0.6)
        {
            this.DECELERATION = 0.997;
        }
        if(this.speed_x > 0){
            this.speed_x = this.speed_x*(DECELERATION);
            if(this.speed_x < 0){
                this.speed_x = 0;
            }
        }
        else if(this.speed_x < 0){
            this.speed_x = this.speed_x*(DECELERATION);
            if(this.speed_x > 0){
                this.speed_x = 0;
            }
        }
        else{
            this.speed_x = 0;
        }
        if(this.speed_y > 0){
            this.speed_y = this.speed_y*(DECELERATION);
            if(this.speed_y < 0){
                this.speed_y = 0;
            }
        }
        else if(this.speed_y < 0){
            this.speed_y = this.speed_y*(DECELERATION);
            if(this.speed_y > 0){
                this.speed_y = 0;
            }
        }
        else{
            this.speed_y = 0;
        }
    }

    public void checkBallCollisions() {
        ArrayList<Ball> balls = gameTable.getBalls();
        for (int i = 0; i < balls.size(); i++) {
            if (i != this.number) {
                Ball b = balls.get(i);
                double dist = this.getDistanceOtherBall(b);
                if (dist <= RADIUS * 2) {
                    this.collideBall(b);
                }
            }
        }
    }

    public void collideBall(Ball ballCollide) {
        
        if (this.speed_x == 0){
            ballCollide.speed_y = this.speed_y;

            this.speed_y = -this.speed_y;
        }
        else if(Math.atan(this.speed_y/this.speed_x) > 1)
        {
            ballCollide.speed_y = this.speed_y;
            this.speed_y = -this.speed_y;
        }
        else{
            ballCollide.speed_x = this.speed_x;
            this.speed_x = -this.speed_x;
        }
        ballCollide.move();

        // tracker to switch turns
        if(contact == 0){
            contact++;
            contactNo = ballCollide.number;
        }
    }

    public double getDistanceOtherBall(Ball ballOther) {
        return Math.sqrt(Math.pow(ballOther.getX() - x, 2) + Math.pow(ballOther.getY() - y, 2));
    }

    // direction: true->x-direction; false->y-direction
    public void checkCollideTable() {
        if (this.x <= gameTable.getBroundary().get(0)){
            this.speed_x = Math.abs(this.speed_x);
        }else if(this.x >= gameTable.getBroundary().get(1)) {
            this.speed_x = -1*Math.abs(this.speed_x);
        } else if(this.y <= gameTable.getBroundary().get(2)){
            this.speed_y = Math.abs(this.speed_y);
        } else if(this.y >= gameTable.getBroundary().get(3)) {
            this.speed_y = -1*Math.abs(this.speed_y);
        }
    }

    public void render(Graphics g) {
        Graphics2D ball = (Graphics2D) g;
        if (!isInHole()) {
            ball.setColor(this.color);
            ball.fill(new Ellipse2D.Double(this.x - this.RADIUS, this.y - this.RADIUS, 2.0 * this.RADIUS, 2.0 * this.RADIUS));
            if (this.number != 0) {
            ball.setColor(Color.WHITE);
            ball.fillOval((int)(this.x - 9.0), (int)(this.y - 7.3), 14, 14);
            ball.setColor(Color.BLACK);
            ball.drawString(String.valueOf(this.number), (int)(this.x - 6.3), (int)(this.y + 4.0));
            }
        }
    }

    public void addChangeListener(ChangeListener ballmove) {
        this.addChangeListener(ballmove);
    }
}

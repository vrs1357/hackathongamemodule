package pool.PoolObjects;

public class Ball {
    private static final int DECELERATION  = 261;
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

    public void collide(Ball ballCollide) {

    }
}

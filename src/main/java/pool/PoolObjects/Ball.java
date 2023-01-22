package pool.PoolObjects;

public class Ball {
    private static final int DECELERATION  = 261;
    private static final double RADIUS = 10;
    private double x;
    private double y;
    private double speed_x;
    private double speed_y;
    private boolean inHole;
    private int number;

    public Ball(int num, double xPos, double yPos) {
        inHole = false;
        number = num;
        x = xPos;
        y = yPos;
        speed_x = 0;
        speed_y = 0;
    }
}

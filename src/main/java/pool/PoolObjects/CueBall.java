package pool.PoolObjects;

public class CueBall extends Ball {
    public CueBall(int num, double xPos, double yPos) {
        super(num, xPos, yPos);
    }

    // set the initial velocity in x and y direction; used when hit by cue
    public void hit(double direction, double powerLevel) {
        this.speed_x = powerLevel * Math.cos(direction);
        this.speed_y = powerLevel * Math.sin(direction);
    }

//    public void hit(double iniVelX, double iniVelY) {
//        this.speed_x = iniVelX;
//        this.speed_y = iniVelY;
//    }
}
import java.util.Scanner;

public class ElasticCollision {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the initial velocity of the first ball (m/s): ");
        double v1 = input.nextDouble();
        System.out.print("Enter the angle of velocity of the first ball (degrees): ");
        double angle1 = input.nextDouble();
        double x1 = v1 * Math.cos(Math.toRadians(angle1));
        double y1 = v1 * Math.sin(Math.toRadians(angle1));

        System.out.print("Enter the initial velocity of the second ball (m/s): ");
        double v2 = input.nextDouble();
        System.out.print("Enter the angle of velocity of the second ball (degrees): ");
        double angle2 = input.nextDouble();
        double x2 = v2 * Math.cos(Math.toRadians(angle2));
        double y2 = v2 * Math.sin(Math.toRadians(angle2));
        
        System.out.print("Enter the angle of the arbitrary axis(degrees): ");
        double angleAxis = input.nextDouble();
        double xAxis = Math.cos(Math.toRadians(angleAxis));
        double yAxis = Math.sin(Math.toRadians(angleAxis));

        double v1fx = (x1*xAxis)+(y1*yAxis);
        double v1fy = (y1*xAxis)-(x1*yAxis);
        double v2fx = (x2*xAxis)+(y2*yAxis);
        double v2fy = (y2*xAxis)-(x2*yAxis);
        
        double finalAngle1 = Math.toDegrees(Math.atan2(v1fy, v1fx));
        double finalAngle2 = Math.toDegrees(Math.atan2(v2fy, v2fx));
        double finalVelocity1 = Math.sqrt((v1fx*v1fx)+(v1fy*v1fy));
        double finalVelocity2 = Math.sqrt((v2fx*v2fx)+(v2fy*v2fy));

        System.out.println("The final velocity of the first ball is "+ finalVelocity1 +" m/s at "+finalAngle1+" degrees");
        System.out.println("The final velocity of the second ball is "+finalVelocity2+" m/s at "+finalAngle2+" degrees");
    }
}

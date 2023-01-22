package pool.PoolObjects;

import java.awt.event.*;
import java.awt.*;
import java.math.*;

import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;

public class Cue{
    private int x;
    private int y;

    private int length = 300;
    private Color cueColor;
    public double angle; // in degrees
    public Cue(int x, int y){
        this.x = x;
        this.y = y;
        angle = 0;
        cueColor = new Color(214,184,90);
    }

    public void render(Graphics g){
        Graphics2D machine = (Graphics2D) g;
        machine.setColor(cueColor);
        machine.rotate(Math.toRadians(angle), x, y);
        
        
        machine.setStroke(new BasicStroke(10));
        machine.drawLine(x- 20, y, x-length,y);

        machine.setColor(new Color(127,125,156));
        machine.setStroke(new BasicStroke(5));
        machine.drawLine(x-18, y-3, x-18, y+3);

        machine.setStroke(new BasicStroke(1));
        machine.setColor(Color.BLACK);
        for(int i = y-5; i < y+6; i+=10){
            machine.drawLine(x-20, i, x-length, i);
        }
        
    }

    public void updatePos(int angle){
        this.angle = this.angle + angle;
    }

    public void updatePos(double x, double y){
        this.x = (int) x;
        this.y = (int) y;
    }

}

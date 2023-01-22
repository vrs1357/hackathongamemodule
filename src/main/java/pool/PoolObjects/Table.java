package main.java.pool.PoolObjects;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.basic.BasicBorders;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Table extends JPanel{

    private ArrayList<Ball> balls;
    private ArrayList<Ball> pocketed;

    public Table() {
        ArrayList<Ball> balls = new ArrayList<Ball>();
        CueBall cueBall = new CueBall(0, 10, 20);
        Ball ball1 = new Ball(1, 60, 20);
        Ball ball2 = new Ball(2, 65, 20);
        Ball ball3 = new Ball(3, 65, 25);
        Ball ball4 = new Ball(4, 70, 20);
        Ball ball5 = new Ball(5, 70, 25);
        Ball ball6 = new Ball(6, 70, 30);
        Ball ball7 = new Ball(7, 75, 20);
        Ball ball8 = new Ball(8, 75, 25);
        Ball ball9 = new Ball(9, 80, 20);

        balls.add(ball1);
        balls.add(ball2);
        balls.add(ball3);
        balls.add(ball4);
        balls.add(ball5);
        balls.add(ball6);
        balls.add(ball7);
        balls.add(ball8);
        balls.add(ball9);
        balls.add(cueBall);
    }

    // for initializing a new game
    public void initializeGame(JPanel panel){
        
        this.setPreferredSize(new Dimension(1000, 500));
        this.setMinimumSize(new Dimension(1000, 500));
        this.setMaximumSize(new Dimension(1000, 500));
        this.setBackground(Color.GRAY);
        panel.add(this);
    }

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GREEN);
        g2.fillRoundRect(100, 50, 800, 400, 40, 40);
        g2.setColor(new Color(92,64,51));
        g2.drawRoundRect(100,50,800,400,40,40);
        g2.drawRoundRect(99,49,802,402,41,41);
    }
    
    
}

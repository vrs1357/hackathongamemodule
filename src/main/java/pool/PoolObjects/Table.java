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
    // draw the pool table
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(0,100,0));
        g2.fillRoundRect(100, 50, 800, 400, 40, 40);
        g2.setColor(new Color(150,75,0));
        
        g2.setColor(new Color(102,51,0));
        for(int i = 120; i < 801; i = i+ 380){
            for(int j = 50; j < 451; j = j+380){
                g2.fillRoundRect(i,j,380,20,0,0);
            }
        }
        for(int i = 100; i < 901; i = i+780){
            g2.fillRoundRect(i,70,20, 360, 0, 0);
        }

        g2.setColor(Color.black);
        for(int i = 100; i < 901; i = i+380){
            for(int j = 50; j < 451; j = j + 360){
                g2.fillOval(i, j, 40, 40);
            }
        }
        g2.setColor(new Color(150,75,0));
        g2.setStroke(new BasicStroke(4));
        for(int i = 140; i < 881; i = i+380){
            for(int j = 70; j < 440; j = j+360){
                g2.drawLine(i, j, i+340, j);
            }
        }
        for(int i = 120; i < 901; i += 760){
            g2.drawLine(i,90,i,410);
        }
        for(int i = 100; i < 901; i = i+380){
            for(int j = 50; j < 451; j= j +360){
                if(j < 200){
                    if(i < 160){
                        g2.drawArc(i, j, 40, 40, 270,-90);
                    }
                    else if (i > 500){
                        g2.drawArc(i,j,40,40,0,-90);
                    }
                    g2.drawArc(i, j, 40, 40, 0,180);
                }
                else{
                    g2.drawArc(i, j, 40, 40, 180,180);

                    if(i < 160){
                        g2.drawArc(i, j, 40, 40, 270,-90);
                    }
                    else if (i > 600){
                        g2.drawArc(i,j,40,40,0,90);
                    }
                }
            }
        }
        g2.drawArc(100,70+340, 40, 40, 90 ,90);

        g2.drawRoundRect(100,50,800,400,40,40);

    }
    
    
}

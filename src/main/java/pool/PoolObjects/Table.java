package pool.PoolObjects;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicBorders;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static javax.swing.border.EtchedBorder.RAISED;

public class Table extends JPanel implements MouseMotionListener, MouseListener {

    private ArrayList<Ball> balls;
    private ArrayList<Ball> pocketed;
    public Cue cue;
    private int Y;
    private int cursordir;
    public CueBall cueBall;
    private int temp;

    public Table() {
        balls = new ArrayList<Ball>();
        cueBall = new CueBall(0, 280, 250, Color.WHITE);
        Ball ball1 = new Ball(1, 700, 250, Color.YELLOW);
        Ball ball2 = new Ball(2, 725, 237, Color.BLUE);
        Ball ball3 = new Ball(3, 725, 263, Color.RED);
        Ball ball4 = new Ball(4, 750, 224, Color.MAGENTA);
        Ball ball5 = new Ball(5, 750, 250, Color.ORANGE);
        Ball ball6 = new Ball(6, 750, 276, Color.GREEN);
        Ball ball7 = new Ball(7, 775, 237, Color.red);
        Ball ball8 = new Ball(8, 775, 263, Color.BLACK);
        Ball ball9 = new Ball(9, 800, 250, Color.yellow);

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

        cue = new Cue((int) cueBall.getX(), (int) cueBall.getY());
        this.addMouseMotionListener(this);
        this.addMouseListener(this);

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
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        this.setBackground(Color.GRAY);
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


        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).render(g2);
        }
        cue.render(g2);
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        Point location = MouseInfo.getPointerInfo().getLocation();
        Y = (int) Math.round(location.getY());    
        temp = Y;
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {     
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        System.out.println("" + cursordir);
        
        Point location = MouseInfo.getPointerInfo().getLocation();
        int newY = (int) Math.round(location.getY());

        if (temp < newY && cursordir != 0) {
            cursordir = 0;
            Y = newY;
        } else if (temp > newY && cursordir != 1) {
            cursordir = 1;
            Y = newY;
        }

        int deltaTheta = (Y - newY)/20;

        temp = newY;
        cue.updatePos(deltaTheta);
        repaint();
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    
}

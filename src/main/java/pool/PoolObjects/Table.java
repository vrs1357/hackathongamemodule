package main.java.pool.PoolObjects;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Table extends JPanel implements MouseEvent, MouseInputListener{

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
    public void initializeGame(){
        //TODO: render the table, set relative positions of the game
    }

    @Override
    public AbstractView getView() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getDetail() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void initUIEvent(String typeArg, boolean canBubbleArg, boolean cancelableArg, AbstractView viewArg,
            int detailArg) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EventTarget getTarget() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EventTarget getCurrentTarget() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public short getEventPhase() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean getBubbles() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean getCancelable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public long getTimeStamp() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void stopPropagation() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void preventDefault() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void initEvent(String eventTypeArg, boolean canBubbleArg, boolean cancelableArg) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getScreenX() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getScreenY() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getClientX() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getClientY() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean getCtrlKey() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean getShiftKey() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean getAltKey() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean getMetaKey() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public short getButton() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public EventTarget getRelatedTarget() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void initMouseEvent(String typeArg, boolean canBubbleArg, boolean cancelableArg, AbstractView viewArg,
            int detailArg, int screenXArg, int screenYArg, int clientXArg, int clientYArg, boolean ctrlKeyArg,
            boolean altKeyArg, boolean shiftKeyArg, boolean metaKeyArg, short buttonArg, EventTarget relatedTargetArg) {
        // TODO Auto-generated method stub
        
    }
    
}

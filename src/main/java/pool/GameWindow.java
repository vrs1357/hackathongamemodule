package main.java.pool;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.FlowLayout;
import java.awt.Container;
import javax.swing.plaf.DimensionUIResource;

public class GameWindow extends JFrame {
    //setting up the viewing
    private int width;
    private int height;
    private Container controls;
    
    // slider components
    private JSlider power;
    private int minPower = 0;
    private int maxPower = 10;
    
    
    //button components

    private JButton shoot;

    public GameWindow(int w, int h){
        width = w;
        height = h;
        controls = getContentPane();
        FlowLayout flow = new FlowLayout();
        controls.setLayout(flow);
        shoot = new JButton("Shoot");
        controls.add(shoot);
        power = new JSlider(JSlider.HORIZONTAL, minPower, maxPower, minPower);
        power.setMinorTickSpacing(1);
        power.setMajorTickSpacing(2);
        power.setPaintTicks(true);
        power.setPaintLabels(true);
        controls.add(power);

    }

    public void createWindow(){
        setSize(width, height);
        setTitle("Game Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add(power);

        // last command of frame instantiation
        setVisible(true);

    }
    // use this to compile all actionListeners
    public void setUpListeners() {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                System.out.println("bruh moment");
            }
        };

        shoot.addActionListener(buttonListener);
        power.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(power.getValue());                
            }
            
        });
    }

}

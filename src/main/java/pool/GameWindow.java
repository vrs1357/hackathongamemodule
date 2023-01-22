package main.java.pool;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class GameWindow extends JFrame {
    //setting up the viewing
    private int width;
    private int height;
    private JPanel slider;
    private JPanel button;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JTextArea playerTurn;
    public boolean player1turn;
    
    // slider components
    private JSlider power;
    private JLabel sliderLabel;
    private int minPower = 0;
    private int maxPower = 10;
    
    
    //button components

    private JButton shoot;

    public GameWindow(int w, int h){
        width = w;
        height = h;
        shoot = new JButton("Shoot");
        playerTurn = new JTextArea("Player 1 turn");
        playerTurn.setEditable(false);
        player1turn = true;
        sliderLabel = new JLabel("Shot Power:");
        power = new JSlider(JSlider.HORIZONTAL, minPower, maxPower, minPower);
        power.setMinorTickSpacing(1);
        power.setMajorTickSpacing(5);
        power.setPaintTicks(true);
        power.setPaintLabels(true);
    }

    public void createWindow(){
        setSize(width, height);
        setTitle("Game Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        slider = new JPanel();
        slider.add(sliderLabel);
        slider.add(power);

        button = new JPanel();
        button.add(shoot);
        button.add(playerTurn);

        mainPanel = (JPanel)getContentPane();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(button);
        topPanel.add(slider);
        mainPanel.add(topPanel);
        setLocationByPlatform(true);

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
                actionPerformed(null);
            }
            
        });
    }



    // go to next frame
    public void actionPerformed(ActionEvent e)
    {
        player1turn = !player1turn;
        if(player1turn == true){
            playerTurn.setText("Player 1 Turn");
        }
        else{
            playerTurn.setText("Player 2 Turn");
        }                
        repaint();
    }

}

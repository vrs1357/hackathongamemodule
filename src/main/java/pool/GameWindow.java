package main.java.pool;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.java.pool.PoolObjects.*;


public class GameWindow extends JFrame {
    //setting up the viewing
    private int width;
    private int height;
    private JPanel slider;
    private JPanel button;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel turn;
    private JTextArea playerTurn;
    public boolean player1turn;

    public Table gameTable;
    
    // slider components
    public JSlider power;
    private JLabel sliderLabel;
    private int minPower = 0;
    private int maxPower = 10;
    
    
    //button components
    private JButton shoot;

    // Player details
    private Player player1;
    private Player player2;


    // constructor
    public GameWindow(int w, int h){
        width = w;
        height = h;
        shoot = new JButton("Shoot");
        player1turn = true;
        sliderLabel = new JLabel("Shot Power:");
        power = new JSlider(JSlider.HORIZONTAL, minPower, maxPower, minPower);
        power.setMinorTickSpacing(1);
        power.setMajorTickSpacing(5);
        power.setPaintTicks(true);
        power.setPaintLabels(true);
        gameTable = new Table();
    }
    // get player names
    public void setup(){

        player1 = new Player(
            JOptionPane.showInputDialog(this, "PLAYER 1 NAME:")
        );

        player2 = new Player(
            JOptionPane.showInputDialog(this, "PLAYER 2 NAME:")
        );
    }

    public void createWindow(){
        setSize(width, height);
        setTitle("Game Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        playerTurn = new JTextArea(player1.name + "'s turn");
        playerTurn.setFont(playerTurn.getFont().deriveFont(35f));
        playerTurn.setEditable(false);
        // constructing power slider
        slider = new JPanel();
        slider.add(sliderLabel);
        slider.add(power);
        // constructing shoot button
        button = new JPanel();
        button.add(shoot);
        // constructing turn windwow
        turn = new JPanel();
        turn.add(playerTurn);
        // initializing the game

        // assembling the main game window
        mainPanel = (JPanel)getContentPane();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.add(button);
        topPanel.add(slider);
        topPanel.add(turn);
        mainPanel.add(topPanel);
        gameTable.initializeGame(mainPanel);

        
        // last command of frame instantiation
        pack();
        setVisible(true);


    }


    // use this to compile all actionListeners for any interactive element on the board
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
            playerTurn.setText(player1.name +"'s Turn");
        }
        else{
            playerTurn.setText(player2.name +"'s Turn");
        }                
        repaint();
    }

}

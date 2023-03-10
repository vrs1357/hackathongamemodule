package pool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import pool.PoolObjects.*;


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
    private Player curPlayer;

    public Table gameTable;
    
    // slider components
    public JSlider power;
    private JLabel sliderLabel;
    private int minPower = 0;
    private int maxPower = 10;
    private int appliedPower = 0;
    
    
    //button components
    private JButton shoot;
    private Dimension bd = new Dimension(100, 60);

    // Player details
    private Player player1;
    private Player player2;

    public GameWindow(int w, int h){
        width = w;
        height = h;
        shoot = new JButton("Shoot");
        shoot.setMaximumSize(bd);
        shoot.setMinimumSize(bd);
        shoot.setPreferredSize(bd);
        player1turn = true;
        sliderLabel = new JLabel("Shot Power:");
        power = new JSlider(JSlider.HORIZONTAL, minPower, maxPower, minPower);
        power.setMinorTickSpacing(1);
        power.setMajorTickSpacing(5);
        power.setPaintTicks(true);
        power.setPaintLabels(true);
        gameTable = new Table();
    }

    public void setup(){

        player1 = new Player(
            JOptionPane.showInputDialog(this, "PLAYER 1 NAME:"), this
        );

        player2 = new Player(
            JOptionPane.showInputDialog(this, "PLAYER 2 NAME:"), this
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

        slider = new JPanel();
        slider.add(sliderLabel);
        slider.add(power);

        button = new JPanel();
        button.add(shoot);

        turn = new JPanel();
        turn.add(playerTurn);

        mainPanel = (JPanel)getContentPane();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.add(button);
        topPanel.add(slider);
        topPanel.add(turn);
        mainPanel.setMaximumSize(new Dimension(1000, 600));
        mainPanel.setMinimumSize(new Dimension(1000,600));
        mainPanel.setPreferredSize(new Dimension(1000,600));
        mainPanel.add(topPanel);
        gameTable.initializeGame(mainPanel);
        curPlayer = player1;

        // last command of frame instantiation
        pack();
        setVisible(true);
    }


    // use this to compile all actionListeners
    public void setUpListeners() {

        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                System.out.println("bruh moment");
                gameTable.cueBall.hit(-gameTable.cue.angle, appliedPower * 0.2);
                gameTable.cue.updatePos(-300, -300);
            }
        };
        shoot.addActionListener(buttonListener);
        power.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println(power.getValue());
                appliedPower = power.getValue();
            }
        });
    }

    // go to next frame
    public void actionPerformed(ActionEvent e)
    {
        if(curPlayer.hit())
        {
            if(curPlayer.equals(player1)){
                curPlayer = player2;
                player1.isTurn = false;
            }
            else{
                curPlayer = player1;
                player1.isTurn = true;
            }
        }
        if(player1.isTurn){
            playerTurn.setText(player1.name +"'s Turn");
            curPlayer = player1;
        }
        else{
            playerTurn.setText(player2.name +"'s Turn");
            curPlayer = player2;
        }
        repaint();
    }
}

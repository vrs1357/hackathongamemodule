package pool;

import java.awt.*; 

import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*; 

public class GameWindow extends JFrame implements ActionListener{
    public void createWindow(){
        JFrame frame = new JFrame("Game Window");
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // TODO: frame.setSize(0, 0);

        JLabel todoJLabel = new JLabel("To do: finish designing the window", SwingConstants.CENTER);
        todoJLabel.setPreferredSize(new Dimension(300,100));
        frame.getContentPane().add(todoJLabel, BorderLayout.CENTER);
        frame.pack();

        frame.setVisible(true);


        Timer time = new Timer(20, this);
        time.start();

    }

    public void actionPerformed(ActionEvent e){
        repaint();
    }
}

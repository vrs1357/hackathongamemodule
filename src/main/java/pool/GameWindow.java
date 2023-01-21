package main.java.pool;

import java.awt.*; 

import javax.swing.*; 

public class GameWindow {
    public static void createWindow(){
        JFrame frame = new JFrame("Game Window");
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // TODO: frame.setSize(0, 0);

        JLabel todoJLabel = new JLabel("To do: finish designing the window", SwingConstants.CENTER);
        todoJLabel.setPreferredSize(new Dimension(300,100));
        frame.getContentPane().add(todoJLabel, BorderLayout.CENTER);
        frame.pack();

        frame.setVisible(true);



    }
}

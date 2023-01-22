package pool;

import pool.PoolObjects.Table;

import java.awt.*;
import java.util.Timer;

public class main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                @SuppressWarnings("unused")
                GameWindow window = new GameWindow(1280, 720);
                window.setup();
                window.createWindow();
                window.setUpListeners();
            }
        });
    }
}


// where did the main go
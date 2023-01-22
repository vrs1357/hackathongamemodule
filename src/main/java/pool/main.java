package main.java.pool;

import main.java.pool.PoolObjects.Table;

public class main {

    public static void main(String[] args) {
        GameWindow window = new GameWindow(1280, 720);
        window.setup();
        window.createWindow();
        window.setUpListeners();
    }
}


// where did the main go
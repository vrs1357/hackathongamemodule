package pool.PoolObjects;

import pool.GameWindow;

public class Player {
    
    public String name;

    public int ballHit;

    public boolean isTurn;

    private GameWindow gWindow;
    
    public Player(String name, GameWindow gWindow){
        this.name = name;
        this.gWindow = gWindow;
    }

    public boolean hit(){

        if(gWindow.gameTable.cueBall.firstHitBall != gWindow.gameTable.lowestBallno)
        {
            return false;
        }
        else if(!gWindow.gameTable.whatashot){
            return false;
        }
        else{
            return true;
        }
    }
}

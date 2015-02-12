/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameloop;
import laurikinnunen.javatetris.gameLogic.Game;
import java.util.Timer;
import ui.UI;

/**
 *
 * @author laurikin
 */
public class GameLoop {

    private Timer timer;
    private boolean isRunning;
    private final Game game;
    private final UI ui;
    private long runningTime;
    private long startTime;

    public GameLoop(Game game, UI ui) {
        this.game = game;
        this.ui = ui;
    }
    
    public void start() {
        startTime = System.currentTimeMillis();
        runningTime = 0;
        isRunning = true;
        timer = new Timer();
        timer.schedule(new Loop(), 0, 1000 / 60); //new timer at 60 fps, the timing mechanism
    }

    private void advanceGame() {    
        long currTime = System.currentTimeMillis() - startTime; 
        ui.render(game.advance(currTime, runningTime));
        runningTime = currTime;
    }

    private class Loop extends java.util.TimerTask
    {
        @Override
        public void run()
        {
            if (!isRunning) {
                timer.cancel();
            }
            
            if (game.isGameOver()) {
                isRunning = false;
                System.out.println("game over");
            } else {
                advanceGame();
            }

        }
    }

}

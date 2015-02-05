/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameloop;
import java.util.Timer;
import laurikinnunen.javatetris.gameLogic.EventQueue;
import laurikinnunen.javatetris.gameLogic.GameState;
import laurikinnunen.javatetris.gameLogic.IAction;
import ui.UI;

/**
 *
 * @author laurikin
 */
public class GameLoop {

    private Timer timer;
    private boolean isRunning;
    private final Runnable gameLoop;

    public GameLoop(Runnable gameLoop) {
        this.gameLoop = gameLoop;
    }
    
    public void start() {
        isRunning = true;
        timer = new Timer();
        timer.schedule(new Loop(), 0, 1000 / 60); //new timer at 60 fps, the timing mechanism
    }

    private class Loop extends java.util.TimerTask
    {
        @Override
        public void run()
        {
            if (!isRunning) {
                timer.cancel();
            }

            gameLoop.run();

        }
    }
}
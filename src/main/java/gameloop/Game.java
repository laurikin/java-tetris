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
public class Game {

    private Timer timer;
    private boolean isRunning;
    private final UI ui;
    private final EventQueue eq;
    private GameState gs;

    public Game(UI ui, GameState initialState, EventQueue eq) {
        this.ui = ui;
        this.gs = initialState;
        this.eq = eq;
    }
    
    public void start() {
        isRunning = true;
        timer = new Timer();
        timer.schedule(new GameLoop(), 0, 1000 / 60); //new timer at 60 fps, the timing mechanism
    }

    private class GameLoop extends java.util.TimerTask
    {
        @Override
        public void run() //this becomes the loop
        {
            if (!isRunning) {
                timer.cancel();
            }

            IAction a;
            while ((a = eq.deque()) != null) {
                gs = a.run(gs);
            }

            // get events from queue
            // process events
            ui.render(gs);
        }
    }
}

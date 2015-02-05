/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic;

/**
 *
 * @author laurikin
 */
public class Game {

    private final EventQueue eq;
    private final long turnLength = 1000;
    private GameState gs;

    public Game(GameState gs, EventQueue eq) {
        this.gs = gs;
        this.eq = eq;
    }

    public GameState advance(long currTime, long prevTime)
    {
        if (currTime % turnLength < prevTime % turnLength) {
            makeTurn();
        }
        return processActions();
    }

    private GameState processActions() {
        IAction a;
        while ((a = eq.deque()) != null) {
            gs = a.run(gs);
        }
        return gs;
    }

    private void makeTurn() {
        eq.queue(new MoveDownAction());
    }
}

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
    private final long TURN_LENGTH = 1000;
    private GameState gs;

    public Game(GameState gs, EventQueue eq) {
        this.gs = gs;
        this.eq = eq;
    }

    public GameState advance(long currTime, long prevTime)
    {
        if (nextTurn(currTime, prevTime)) {
            makeTurn();
        }
        return processActions();
    }

    private boolean nextTurn (long currTime, long prevTime) {
        return currTime % TURN_LENGTH < prevTime % TURN_LENGTH;
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

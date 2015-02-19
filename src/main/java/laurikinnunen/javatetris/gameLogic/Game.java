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
    private final int TURN_LENGTH = 700;
    private GameState gs;

    /**
     * Takes actions from eventQueue and executes them on the gamestate
     * Keeps track of the current gamestate
     * @param gs
     * @param eq
     */
    public Game(GameState gs, EventQueue eq) {
        this.gs = gs;
        this.eq = eq;
    }

    /**
     * Advances the game based on the given time interval
     * @param currTime
     * @param prevTime
     * @return updated game state
     */
    public GameState advance(long currTime, long prevTime)
    {
        if (nextTurn(currTime, prevTime)) {
            makeTurn();
        }

        return processActions();
    }

    /**
     * returns true if game is over and should be stopped
     * @return boolean
     */
    public boolean isGameOver() {
        return gs.isGameOver();
    }

    public GameState getState() {
        return gs;
    }

    private boolean nextTurn (long currTime, long prevTime) {
        return currTime % turnLength() < prevTime % turnLength();
    }

    private int turnLength() {
        return TURN_LENGTH - (gs.getScore() + 1);
    }

    private GameState processActions() {
        IAction a;
        while ((a = eq.deque()) != null) {
            GameState newGs = a.run(gs);
            if (newGs.isValid()) {
                gs = newGs;
            }
        }
        return gs;
    }

    private void makeTurn() {
        if (gs.endOfFall()) {
            eq.queue(new NextTetriminoAction());
        } else {
            eq.queue(new MoveDownAction());
        }
    }
}

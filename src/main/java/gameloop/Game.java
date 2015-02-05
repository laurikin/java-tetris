/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameloop;

import laurikinnunen.javatetris.gameLogic.EventQueue;
import laurikinnunen.javatetris.gameLogic.GameState;
import laurikinnunen.javatetris.gameLogic.IAction;
import ui.UI;

/**
 *
 * @author laurikin
 */
public class Game implements Runnable{

    private final UI ui;
    private final EventQueue eq;
    private GameState gs;

    public Game(UI ui, GameState gs, EventQueue eq) {
        this.ui = ui;
        this.gs = gs;
        this.eq = eq;
    }

    @Override
    public void run()
    {
        processActions();
        ui.render(gs);
    }

    private void processActions() {
        IAction a;
        while ((a = eq.deque()) != null) {
            gs = a.run(gs);
        }
    }
}

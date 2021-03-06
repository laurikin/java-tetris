/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameloop;

import laurikinnunen.javatetris.gameLogic.Game;
import laurikinnunen.javatetris.gameLogic.Board;
import laurikinnunen.javatetris.gameLogic.EventQueue;
import laurikinnunen.javatetris.gameLogic.GameState;
import laurikinnunen.javatetris.gameLogic.NewGameAction;
import laurikinnunen.javatetris.gameLogic.tetriminos.TetriminoFactory;
import ui.UI;

/**
 *
 * @author laurikin
 */
public class Main {
    
    public static void main(String[] args) {

        EventQueue eq = new EventQueue();

        UI ui = new UI(eq);
        
        Game game = new Game((new NewGameAction()).run(null), eq);
        GameLoop gameLoop = new GameLoop(game, ui);
        gameLoop.start();
    }
}

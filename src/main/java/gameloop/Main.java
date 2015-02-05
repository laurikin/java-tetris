/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameloop;

import laurikinnunen.javatetris.gameLogic.Board;
import laurikinnunen.javatetris.gameLogic.Block;
import laurikinnunen.javatetris.gameLogic.EventQueue;
import laurikinnunen.javatetris.gameLogic.GameState;
import laurikinnunen.javatetris.gameLogic.Tetrimino;
import ui.UI;

/**
 *
 * @author laurikin
 */
public class Main {
    
    public static void main(String[] args) {

        Board board = new Board(10,20);
        board = board.fill(0, 0).fill(9, 19);

        Tetrimino tetrimino = new Tetrimino(new Block[] { 
            new Block(4,4),
            new Block(5,4),
            new Block(6,4),
            new Block(5,3)
        });
        GameState initialState = new GameState(board, tetrimino);
        EventQueue eq = new EventQueue();

        UI ui = new UI(eq);
        
        Game gameLoop = new Game(ui, initialState, eq);
        GameLoop game = new GameLoop(gameLoop);
        game.start();
    }
}

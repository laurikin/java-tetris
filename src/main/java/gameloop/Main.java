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
import laurikinnunen.javatetris.gameLogic.tetriminos.LLeftTetrimino;
import laurikinnunen.javatetris.gameLogic.tetriminos.LRightTetrimino;
import laurikinnunen.javatetris.gameLogic.tetriminos.SLeftTetrimino;
import laurikinnunen.javatetris.gameLogic.tetriminos.SRightTetrimino;
import laurikinnunen.javatetris.gameLogic.tetriminos.SquareTetrimino;
import laurikinnunen.javatetris.gameLogic.tetriminos.TTetrimino;
import laurikinnunen.javatetris.gameLogic.tetriminos.Tetrimino;
import laurikinnunen.javatetris.gameLogic.tetriminos.TetriminoFactory;
import ui.UI;

/**
 *
 * @author laurikin
 */
public class Main {
    
    public static void main(String[] args) {

        Board board = new Board(10,20);
        TetriminoFactory tFactory = new TetriminoFactory();

        GameState initialState = new GameState(board, tFactory.getRandomTetrimino());
        EventQueue eq = new EventQueue();

        UI ui = new UI(eq);
        
        Game game = new Game(initialState, eq);
        GameLoop gameLoop = new GameLoop(game, ui);
        gameLoop.start();
    }
}

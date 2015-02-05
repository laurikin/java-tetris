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
public class GameState {

    public Board board;
    public Tetrimino tetrimino;

    public GameState(Board board, Tetrimino tetrimino) {
        this.board = board;
        this.tetrimino = tetrimino;
    }

    public Board getBoard() {
        return this.board;
    }

    public Tetrimino getTetrimino() {
        return this.tetrimino;
    }
}

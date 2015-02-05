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

    public boolean isValid() {
        for (Block block : tetrimino.blocks()) {
            if (isOutOfBounds(block) || hasOverLap(block) ) {
                return false;
            }
        }
        return true;
    }

    public boolean endOfFall() {
        for (Block block : tetrimino.blocks()) {
            if (touchesFloor(block)) {
                return true;
            }
        }
        return false;
    }

    public Board getBoard() {
        return this.board;
    }

    public Tetrimino getTetrimino() {
        return this.tetrimino;
    }

    private boolean hasOverLap(Block block) {
        return board.isFilled(block.x(), block.y());
    }

    private boolean isOutOfBounds(Block block) {
        if (block.y() >= board.height()) {
            return true;
        } else if (block.x() < 0) {
            return true;
        } else if (block.x() >= board.width()){
            return true;
        } else {
            return false;
        }
    }

    private boolean touchesFloor(Block block) {
        return block.y() == board.height() - 1;
    }
}

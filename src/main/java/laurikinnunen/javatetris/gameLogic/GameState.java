/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic;

import laurikinnunen.javatetris.gameLogic.Board.DropUpdate;
import laurikinnunen.javatetris.gameLogic.tetriminos.Tetrimino;

/**
 *
 * @author laurikin
 */
public class GameState {

    private final int score;
    private final Board board;
    private final Tetrimino tetrimino;

    public GameState(Board board, Tetrimino tetrimino) {
        this.score = 0;
        this.board = board;
        this.tetrimino = tetrimino;
    }

    private GameState(Board board, Tetrimino tetrimino, int score) {
        this.score = score;
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

    public boolean isGameOver() {
        for (int i = 0; i < board.width(); i++) {
            if (board.isFilled(i,0)) {
                return true;
            }
        }
        return false;
    }

    public boolean endOfFall() {
        for (Block block : tetrimino.blocks()) {
            if (touchesFloor(block) || cannotMoveDown(block)) {
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

    public int getScore() {
        return this.score;
    }

    public GameState nextTetrimino(Tetrimino nextTetrimino) {
        Board newBoard = transferTetriminoToBoard();
        DropUpdate update = newBoard.dropFullRows();
        return new GameState(update.board(), nextTetrimino, incrementScore(update.droppedRows()));
    }

    public GameState rotateTetrimino() {
        return new GameState(board, tetrimino.rotate(), score);
    }

    public GameState moveTetriminoDown() {
        return new GameState(board, tetrimino.moveDown(), score);
    }

    public GameState moveTetriminoLeft() {
        return new GameState(board, tetrimino.moveLeft(), score);
    }

    public GameState moveTetriminoRight() {
        return new GameState(board, tetrimino.moveRight(), score);
    }

    private int incrementScore(int droppedRows) {
        if (droppedRows < 1) {
            return score;
        } else {
            return score + 10 * (int)Math.pow(2, droppedRows);
        }
    }

    private Board transferTetriminoToBoard() {
        Board newBoard = board;
        for (Block block : tetrimino.blocks()) {
            newBoard = newBoard.fill(block.x(), block.y());
        }
        return newBoard;
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

    private boolean cannotMoveDown(Block block) {
        return board.isFilled(block.x(), block.y() + 1);
    }
}

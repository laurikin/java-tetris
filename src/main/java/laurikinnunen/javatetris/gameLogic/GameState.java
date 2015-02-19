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
    private final Tetrimino nextTetrimino;

    public GameState(Board board, Tetrimino tetrimino) {
        this.score = 0;
        this.board = board;
        this.tetrimino = tetrimino;
        this.nextTetrimino = tetrimino;
    }

    public GameState(Board board, Tetrimino tetrimino, Tetrimino nextTetrimino) {
        this.score = 0;
        this.board = board;
        this.tetrimino = tetrimino;
        this.nextTetrimino = tetrimino;
    }

    private GameState(Board board, Tetrimino tetrimino, Tetrimino nextTetrimino, int score) {
        this.score = score;
        this.board = board;
        this.tetrimino = tetrimino;
        this.nextTetrimino = nextTetrimino;
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

    public Tetrimino getNextTetrimino() {
        return this.nextTetrimino;
    }

    public int getScore() {
        return this.score;
    }

    public GameState nextTetrimino(Tetrimino newTetrimino) {
        Board newBoard = transferTetriminoToBoard();
        DropUpdate update = newBoard.dropFullRows();
        return new GameState(update.board(), nextTetrimino, newTetrimino, incrementScore(update.droppedRows()));
    }

    public GameState rotateTetrimino() {
        return moveTetrimino(tetrimino.rotate());
    }

    public GameState moveTetriminoDown() {
        return moveTetrimino(tetrimino.moveDown());
    }

    public GameState moveTetriminoLeft() {
        return moveTetrimino(tetrimino.moveLeft());
    }

    public GameState moveTetriminoRight() {
        return moveTetrimino(tetrimino.moveRight());
    }

    private GameState moveTetrimino(Tetrimino newTetrimino) {
        return new GameState(board, newTetrimino, nextTetrimino, score);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic;

import laurikinnunen.javatetris.gameLogic.tetriminos.BarTetrimino;
import laurikinnunen.javatetris.gameLogic.tetriminos.Tetrimino;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author laurikin
 */
public class GameStateTest {

    private Board board;

    @Before
    public void setUp() {
        board = new Board(10, 20);
        board = board.fill(2, 4);
    }
    
    @Test
    public void isValidReturnsTrueIfTetriminoIsWithinBounds() {
        GameState validGs = new GameState(
            board,
            new Tetrimino(new Block[] { new Block(1,4), new Block(1,5) }, 0, 0));

        assertTrue(validGs.isValid());
    }

    @Test
    public void isValidReturnsTrueIfTetriminoIsAboveBoard() {
        GameState validGs = new GameState(
            board,
            new Tetrimino(new Block[] { new Block(1,-1), new Block(1,0) }, 0, 0));

        assertTrue(validGs.isValid());
    }

    @Test
    public void isValidReturnsFalseIfTetriminoOverlapsWithOtherBlocks() {
        GameState overLappingGs = new GameState(
            board,
            new Tetrimino(new Block[] { new Block(1,4), new Block(2,4) }, 0, 0));

        assertFalse(overLappingGs.isValid());
    }

    @Test
    public void isValidReturnsFalseIfTetriminoIsBelowBoard() {
        GameState outOfBoundsGs = new GameState(
            board,
            new Tetrimino(new Block[] { new Block(2,20), new Block(2,19) }, 0, 0));

        assertFalse(outOfBoundsGs.isValid());
    }

    @Test
    public void isValidReturnsFalseIfTetriminoIsToTheLeftOfBoard() {
        GameState outOfBoundsGs = new GameState(
            board,
            new Tetrimino(new Block[] { new Block(-1,19), new Block(0,19) }, 0, 0));

        assertFalse(outOfBoundsGs.isValid());
    }

    @Test
    public void isValidReturnsFalseIfTetriminoIsToTheRightOfBoard() {
        GameState outOfBoundsGs = new GameState(
            board,
            new Tetrimino(new Block[] { new Block(10,19), new Block(9,19) }, 0, 0));

        assertFalse(outOfBoundsGs.isValid());
    }

    @Test
    public void isEndOfFallReturnsTrueWhenTetriminoTouchesTheFloor() {
        GameState endOfFallGs = new GameState(
            board,
            new Tetrimino(new Block[] { new Block(9,19), new Block(9,19) }, 0, 0));
        
        assertTrue(endOfFallGs.endOfFall());
    }

    @Test
    public void isEndOfFallReturnsFalseWhenTetriminoIsInMidAir() {
        GameState midAirGs = new GameState(
            board,
            new Tetrimino(new Block[] { new Block(9,18), new Block(9,18) }, 0, 0));
        
        assertFalse(midAirGs.endOfFall());
    }

    @Test
    public void isEndOfFallReturnsTrueWhenThereIsABlockOneSquareBelow() {
        GameState endOfFallGs = new GameState(
            board.fill(9, 19),
            new Tetrimino(new Block[] { new Block(8,18), new Block(9,18) }, 0, 0));
        
        assertTrue(endOfFallGs.endOfFall());
    }

    @Test
    public void isGameOverReturnsTrueIfABlockTouchesTheCeiling() {
        GameState gameOverGs = new GameState(
            board.fill(9, 19).fill(3, 0),
            new Tetrimino(new Block[] { new Block(8,18), new Block(9,18) }, 0, 0));
        
        assertTrue(gameOverGs.isGameOver());
    }

    @Test
    public void isGameOverReturnsFalseIfNoBlocksTouchTheCeiling() {
        GameState gameOverGs = new GameState(
            board.fill(9, 19),
            new Tetrimino(new Block[] { new Block(8,18), new Block(9,18) }, 0, 0));
        
        assertFalse(gameOverGs.isGameOver());
    }

    @Test
    public void nextTetriminoIncreasesScoreBy20WhenOneDestroyedRow() {
        Board b = new Board(2,8);
        GameState gs = new GameState(
            b.fill(0, 7).fill(1, 7),
            new BarTetrimino()
        );
        
        gs = gs.nextTetrimino(new BarTetrimino());
        assertEquals(20, gs.getScore());
    }

    @Test
    public void nextTetriminoIncreasesScoreBy0WhenNoDestroyedRows() {
        Board b = new Board(2,8);
        GameState gs = new GameState(
            b.fill(0, 7).fill(1, 8),
            new BarTetrimino()
        );
        
        gs = gs.nextTetrimino(new BarTetrimino());
        assertEquals(0, gs.getScore());
    }

    @Test
    public void nextTetriminoIncreasesScoreBy40WhenTwoDestroyedRows() {
        Board b = new Board(2,8);
        GameState gs = new GameState(
            b.fill(0, 7).fill(1, 7)
                .fill(0, 6).fill(1, 6),
            new BarTetrimino()
        );
        
        gs = gs.nextTetrimino(new BarTetrimino());
        assertEquals(40, gs.getScore());
    }

    @Test
    public void nextTetriminoIncreasesScoreBy80WhenThreeDestroyedRows() {
        Board b = new Board(2,8);
        GameState gs = new GameState(
            b.fill(0, 7).fill(1, 7)
                .fill(0, 6).fill(1, 6)
                .fill(0, 5).fill(1, 5),
            new BarTetrimino()
        );
        
        gs = gs.nextTetrimino(new BarTetrimino());
        assertEquals(80, gs.getScore());
    }

    @Test
    public void nextTetriminoIncreasesScoreBy160WhenFourDestroyedRows() {
        Board b = new Board(2,8);
        GameState gs = new GameState(
            b.fill(0, 7).fill(1, 7)
                .fill(0, 6).fill(1, 6)
                .fill(0, 5).fill(1, 5)
                .fill(0, 4).fill(1, 4),
            new BarTetrimino()
        );
        
        gs = gs.nextTetrimino(new BarTetrimino());
        assertEquals(160, gs.getScore());
    }
}

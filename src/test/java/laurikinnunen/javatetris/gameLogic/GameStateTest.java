/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic;

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
            new Tetrimino(new Block[] { new Block(1,4), new Block(1,5) }));

        assertTrue(validGs.isValid());
    }

    @Test
    public void isValidReturnsFalseIfTetriminoOverlapsWithOtherBlocks() {
        GameState overLappingGs = new GameState(
            board,
            new Tetrimino(new Block[] { new Block(1,4), new Block(2,4) }));

        assertFalse(overLappingGs.isValid());
    }

    @Test
    public void isValidReturnsFalseIfTetriminoIsBelowBoard() {
        GameState outOfBoundsGs = new GameState(
            board,
            new Tetrimino(new Block[] { new Block(2,20), new Block(2,19) }));

        assertFalse(outOfBoundsGs.isValid());
    }

    @Test
    public void isValidReturnsFalseIfTetriminoIsToTheLeftOfBoard() {
        GameState outOfBoundsGs = new GameState(
            board,
            new Tetrimino(new Block[] { new Block(-1,19), new Block(0,19) }));

        assertFalse(outOfBoundsGs.isValid());
    }

    @Test
    public void isValidReturnsFalseIfTetriminoIsToTheRightOfBoard() {
        GameState outOfBoundsGs = new GameState(
            board,
            new Tetrimino(new Block[] { new Block(10,19), new Block(9,19) }));

        assertFalse(outOfBoundsGs.isValid());
    }

    @Test
    public void isEndOfFallReturnsTrueWhenTetriminoTouchesTheFloor() {
        GameState endOfFallGs = new GameState(
            board,
            new Tetrimino(new Block[] { new Block(10,19), new Block(9,19) }));
        
        assertTrue(endOfFallGs.endOfFall());
    }

    @Test
    public void isEndOfFallReturnsFalseWhenTetriminoIsInMidAir() {
        GameState midAirGs = new GameState(
            board,
            new Tetrimino(new Block[] { new Block(10,18), new Block(9,18) }));
        
        assertFalse(midAirGs.endOfFall());
    }
}

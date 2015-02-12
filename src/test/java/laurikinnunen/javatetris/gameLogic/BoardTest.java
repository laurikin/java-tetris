/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laurikin
 */
public class BoardTest {
    
    public BoardTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void constructorIniniatesABoardWithGivenDimensions() {
        Board b = new Board(8,4);
        assertEquals(8, b.width());
        assertEquals(4, b.height());
    }

    @Test
    public void fillInsertsANewBlockWithGivenCoordinatesAndReturnsTheNewBoard() {
        Board b = new Board(10,20);
        b = b.fill(2, 3).fill(4, 3);
        assertTrue(b.isFilled(2, 3));
        assertTrue(b.isFilled(4, 3));
    }

    @Test
    public void fillDoesNotRaiseExeptionWithOutOfBoundValues() {
        Board b = new Board(10,20);
        b = b.fill(2, -1).fill(4, 3);
        assertTrue(b.isFilled(4, 3));
    }

    @Test
    public void isFilledReturnsTheStatusOfGivenBlock() {
        Board b = new Board(4,4);
        Board b2 = b.fill(2,3);
        assertFalse(b.isFilled(1,1));
    }

    @Test
    public void dropFullRowsRemovesAllFullRows() {
        Board b = new Board(2,5);
        b = b.fill(0,4)
                .fill(1,4)
                .fill(0,3)
                .fill(1,3)
                .dropFullRows();

        assertFalse(b.isFilled(0, 4));
        assertFalse(b.isFilled(1, 4));
        assertFalse(b.isFilled(0, 3));
        assertFalse(b.isFilled(1, 3));
    }
    
    @Test
    public void dropFullRowsMovesRowsAboveRemovedOnesDown() {
        Board b = new Board(2,5);
        b = b.fill(1,0)
                .fill(1,1)
                .fill(0,3)
                .fill(1,3)
                .fill(1,4)
                .dropFullRows();

        assertFalse(b.isFilled(1, 0));
        assertTrue(b.isFilled(1, 1));
        assertTrue(b.isFilled(1, 2));
        assertFalse(b.isFilled(0, 3));
        assertFalse(b.isFilled(1, 3));
        assertTrue(b.isFilled(1, 4));
    }
}

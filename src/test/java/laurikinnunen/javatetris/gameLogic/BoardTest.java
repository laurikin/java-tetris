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
    public void isFilledReturnsTheStatusOfGivenBlock() {
        Board b = new Board(4,4);
        Board b2 = b.fill(2,3);
        assertFalse(b.isFilled(1,1));
    }

    @Test
    public void constructorIniniatesABoardWithGivenDimensions() {
        Board b = new Board(8,4);
        assertEquals(8, b.width());
        assertEquals(4, b.height());
    }
    
}

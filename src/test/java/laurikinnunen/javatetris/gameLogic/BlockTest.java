/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laurikin
 */
public class BlockTest {
    
    public BlockTest() {
    }

    @Test
    public void constructorValuesAreCoordinatesOfNewInstance() {
        Block b = new Block(3,2);
        assertEquals(3, b.x());
        assertEquals(2, b.y());
    }

    @Test
    public void moveDownReturnsNewBlockWithYoneSmaller() {
        Block b = new Block(3,2);
        Block b2 = b.moveDown();
        assertEquals(1, b2.y());
        assertEquals(3, b2.x());
    }

    @Test
    public void moveLeftReturnsNewBlockWithXoneSmaller() {
        Block b = new Block(3,2);
        Block b2 = b.moveLeft();
        assertEquals(2, b2.y());
        assertEquals(2, b2.x());
    }
    
    @Test
    public void moveRightReturnsNewBlockWithXoneGreater() {
        Block b = new Block(3,2);
        Block b2 = b.moveRight();
        assertEquals(2, b2.y());
        assertEquals(4, b2.x());
    }

    @Test
    public void moveToReturnsNewBlockWithTheGivenLocationRelativeToCurrentLocation() {
        Block b = new Block(3,2);
        Block b2 = b.moveRelative(8,12);
        assertEquals(14, b2.y());
        assertEquals(11, b2.x());
    }
}

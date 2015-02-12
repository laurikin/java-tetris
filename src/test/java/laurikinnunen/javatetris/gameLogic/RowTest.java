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
public class RowTest {
    
    public RowTest() {
        
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void constructorReturnsAnEmptyRow() {
        Row r = new Row(3);
        assertFalse(r.get(0));
        assertFalse(r.get(1));
        assertFalse(r.get(2));
    }

    @Test 
    public void addReturnsARowWithGivenIndecesTurnedTrue() {
        Row r = new Row(5);
        Row r2 = r.add(new int[] {0, 2}).add(new int[] {2, 4});
        assertTrue(r2.get(0));
        assertFalse(r2.get(1));
        assertTrue(r2.get(2));
        assertFalse(r2.get(3));
        assertTrue(r2.get(4));
    }

    @Test
    public void isFullReturnsFalseIfRowContainsEmptySlots() {
        Row r = new Row(5);
        Row r2 = r.add(new int[] {0, 2, 4, 3});
        assertFalse(r2.isFull());
    }

    @Test
    public void isFullReturnsTrueIfRowDoesNotContainsEmptySlots() {
        Row r = new Row(5);
        Row r2 = r.add(new int[] {0, 1, 2, 3, 4});
        assertTrue(r2.isFull());
    }
}

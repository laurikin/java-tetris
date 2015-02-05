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
public class TetriminoTest {
    
    private final Tetrimino t;

    public TetriminoTest() {
        t = new Tetrimino(new Block[] {new Block(3,2), new Block(2,5), new Block(4,3)});
    }

    @Test
    public void BlocksReturnsTheBlocksOfThisTetrinimo() {
        Block[] blocks = t.blocks();
        assertEquals(3, blocks[0].x());
        assertEquals(2, blocks[0].y());
        assertEquals(2, blocks[1].x());
        assertEquals(5, blocks[1].y());
        assertEquals(4, blocks[2].x());
        assertEquals(3, blocks[2].y());
        assertEquals(3, blocks.length);
    }
    
    @Test
    public void moveDownReturnsTetriminoWithAllBlocksOneDown() {
        Tetrimino t2 = t.moveDown();
        Block[] blocks = t2.blocks();
        assertEquals(3, blocks[0].x());
        assertEquals(1, blocks[0].y());
        assertEquals(2, blocks[1].x());
        assertEquals(4, blocks[1].y());
        assertEquals(4, blocks[2].x());
        assertEquals(2, blocks[2].y());
        assertEquals(3, blocks.length);
    }

    @Test
    public void moveLeftReturnsTetriminoWithAllBlocksOneLeft() {
        Tetrimino t2 = t.moveLeft();
        Block[] blocks = t2.blocks();
        assertEquals(2, blocks[0].x());
        assertEquals(2, blocks[0].y());
        assertEquals(1, blocks[1].x());
        assertEquals(5, blocks[1].y());
        assertEquals(3, blocks[2].x());
        assertEquals(3, blocks[2].y());
        assertEquals(3, blocks.length);
    }

    @Test
    public void moveRightReturnsTetriminoWithAllBlocksOneRight() {
        Tetrimino t2 = t.moveRight();
        Block[] blocks = t2.blocks();
        assertEquals(4, blocks[0].x());
        assertEquals(2, blocks[0].y());
        assertEquals(3, blocks[1].x());
        assertEquals(5, blocks[1].y());
        assertEquals(5, blocks[2].x());
        assertEquals(3, blocks[2].y());
        assertEquals(3, blocks.length);
    }
}

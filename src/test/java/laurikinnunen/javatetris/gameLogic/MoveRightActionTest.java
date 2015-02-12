/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic;

import laurikinnunen.javatetris.gameLogic.tetriminos.Tetrimino;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laurikin
 */
public class MoveRightActionTest {
    
    private GameState gs;
    
    @Before
    public void setUp() {
        gs = new GameState(
            new Board(10, 20),
            new Tetrimino(new Block[] { new Block(1,1), new Block(2,1) }, 0, 1));
    }

    @Test
    public void movesTetriminoOneRight() {
        IAction a = new MoveRightAction();
        GameState newGs = a.run(gs);
        Tetrimino newTetrimino = newGs.getTetrimino();
        Block[] newBlocks = newTetrimino.blocks();
        assertEquals(2, newBlocks[0].x());
        assertEquals(1, newBlocks[0].y());
        assertEquals(3, newBlocks[1].x());
        assertEquals(1, newBlocks[1].y());
    }
    
}

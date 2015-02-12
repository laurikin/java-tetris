package laurikinnunen.javatetris.gameLogic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laurikin
 */
public class NextTetriminoActionTest {
    
    private GameState gs;
    
    @Before
    public void setUp() {
        gs = new GameState(
            new Board(10, 20),
            new Tetrimino(new Block[] { new Block(8,19), new Block(9,19) }));
    }

    @Test
    public void TransfersTetriminoBlocksToBoard() {
        IAction a = new NextTetriminoAction();
        GameState newGs = a.run(gs);
        Board newBoard = newGs.getBoard(); 
        assertTrue(newBoard.isFilled(8,19));
        assertTrue(newBoard.isFilled(9,19));
    }
    
}

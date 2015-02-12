/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic;

/**
 *
 * @author laurikin
 */
public class NextTetriminoAction implements IAction {

    @Override
    public GameState run(GameState gs) {
        Tetrimino tetrimino = gs.getTetrimino();
        Board newBoard = gs.getBoard();
        for (Block block : tetrimino.blocks()) {
            newBoard = newBoard.fill(block.x(), block.y());
        }
        return new GameState(
                newBoard,
                new Tetrimino(new Block[] { 
                    new Block(1,0), 
                    new Block(2,0),
                    new Block(3,0),
                    new Block(2,1),
                }));
    }
    
}

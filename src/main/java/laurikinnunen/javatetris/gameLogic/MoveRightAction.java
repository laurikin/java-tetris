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
public class MoveRightAction implements IAction {
    
    /**
     * Moves tetrimino right one step
     * @param gs current game state
     * @return updated game state
     */
    @Override
    public GameState run(GameState gs) {
        return gs.moveTetriminoRight();
    }

}

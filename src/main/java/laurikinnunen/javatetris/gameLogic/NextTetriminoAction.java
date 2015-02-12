/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic;

import laurikinnunen.javatetris.gameLogic.tetriminos.TetriminoFactory;

/**
 *
 * @author laurikin
 */
public class NextTetriminoAction implements IAction {

    @Override
    public GameState run(GameState gs) {
        TetriminoFactory tFactory = new TetriminoFactory();
        return gs.nextTetrimino(tFactory.getRandomTetrimino());
    }
    
}

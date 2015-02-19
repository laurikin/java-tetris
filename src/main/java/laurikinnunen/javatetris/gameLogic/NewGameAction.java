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
public class NewGameAction implements IAction {

    @Override
    public GameState run(GameState gs) {
        if (gs == null || gs.isGameOver()) {
            Board board = new Board(10, 20);
            TetriminoFactory tFactory = new TetriminoFactory();

            return new GameState(
                    board,
                    tFactory.getRandomTetrimino(),
                    tFactory.getRandomTetrimino());
        } else {
            return gs;
        }
    }

}

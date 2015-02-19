/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic.tetriminos;

import laurikinnunen.javatetris.gameLogic.Block;

/**
 *
 * @author laurikin
 */
public class BarTetrimino extends Tetrimino {

    public BarTetrimino() {
        super(new Block[] {
            new Block(4,-1),
            new Block(5,-1),
            new Block(6,-1),
            new Block(7,-1)
        }, 6, -1);
    }

}

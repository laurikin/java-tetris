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
public class SquareTetrimino extends Tetrimino {

    public SquareTetrimino() {
        super(new Block[] {
            new Block(4,-2),
            new Block(5,-2),
            new Block(4,-1),
            new Block(5,-1)
        }, 5, -2);
    }
    
}

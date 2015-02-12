/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic.tetriminos;

import java.util.Random;

/**
 *
 * @author laurikin
 */
public class TetriminoFactory {

    private final Tetrimino[] tetriminos;

    public TetriminoFactory() {
        tetriminos = new Tetrimino[] {
            new LLeftTetrimino(),
            new LRightTetrimino(),
            new SLeftTetrimino(),
            new SRightTetrimino(),
            new SquareTetrimino(),
            new TTetrimino()
        };
    }

    public Tetrimino getRandomTetrimino() {
        Random r = new Random();
        return tetriminos[r.nextInt(tetriminos.length)];
    }
    
}

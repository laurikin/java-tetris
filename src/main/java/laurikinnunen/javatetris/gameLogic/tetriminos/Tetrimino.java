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
public class Tetrimino {

    private final Block[] blocks;
    private final int[] center;

    public Tetrimino(Block[] blocks, int centerX, int centerY) {
        this.blocks = blocks;
        this.center = new int[] { centerX, centerY };
    }

    public Block[] blocks() {
        return blocks;
    }

    private Tetrimino move(int dx, int dy) {
        Block[] newBlocks = new Block[blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            newBlocks[i] = new Block(blocks[i].x() + dx, blocks[i].y() + dy);
        }
        return new Tetrimino(newBlocks, center[0] + dx, center[1] + dy);
    }

    public Tetrimino moveDown() {
        return move(0, 1);
    }

    public Tetrimino moveLeft() {
        return move(-1, 0);
    }

    public Tetrimino moveRight() {
        return move(1, 0);
    }

    public Tetrimino moveRelative(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Tetrimino rotate() {
        Block[] newBlocks = new Block[blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            int dx = blocks[i].x() - center[0];
            int dy = blocks[i].y() - center[1];
            Block newBlock = new Block(
                dy + center[0], 
                -dx + center[1]
            );
            newBlocks[i] = newBlock;
        }
        return new Tetrimino(newBlocks, center[0], center[1]);
    }

    public int[] center() {
        return center;
    }
}

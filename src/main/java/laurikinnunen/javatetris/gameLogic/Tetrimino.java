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
public class Tetrimino implements IMoveable<Tetrimino> {

    private final Block[] blocks;
    
    public Tetrimino(Block[] blocks) {
        this.blocks = blocks;
    }

    public Block[] blocks() {
        return blocks;
    }

    private Tetrimino move(int dx, int dy) {
        Block[] newBlocks = new Block[blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            newBlocks[i] = new Block(blocks[i].x() + dx, blocks[i].y() + dy);        
        }
        return new Tetrimino(newBlocks);
    }

    @Override
    public Tetrimino moveDown() {
        return move(0, -1);
    }

    @Override
    public Tetrimino moveLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tetrimino moveRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tetrimino moveRelative(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

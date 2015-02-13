/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic;

/**
 * represents a block in a tetrimino
 * @author laurikin
 */
public class Block {
    private final int x;
    private final int y;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Block moveDown() {
        return move(x,y-1);
    }

    public Block moveLeft() {
        return move(x-1,y);
    }

    public Block moveRight() {
        return move(x+1,y);
    }

    public Block moveRelative(int dx, int dy) {
        return move(x+dx, y+dy);
    }

    private Block move(int x, int y) {
        return new Block(x, y);
    }

}

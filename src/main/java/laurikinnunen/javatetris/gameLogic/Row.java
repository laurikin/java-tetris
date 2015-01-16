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
public class Row {
    private final boolean[] blocks;

    public Row(int length) {    
        this.blocks = new boolean[length];
    }

    private Row(boolean[] blocks) {
        this.blocks = blocks;
    }

    public boolean get(int ind) {
        return blocks[ind];
    }

    public Row add(int[] inds) {
        boolean[] newBlocks = new boolean[blocks.length];
        for (int i = 0; i < inds.length; i++) {
            newBlocks[inds[i]] = true;
        }
        return new Row(newBlocks);
    }
}

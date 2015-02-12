/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laurikinnunen.javatetris.gameLogic;

import java.util.Arrays;

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

    /**
     * Add blocks to a row
     * @param inds places of new blocks counted from the left
     * @return updated row
     */
    public Row add(int[] inds) {
        boolean[] newBlocks = Arrays.copyOf(blocks, blocks.length);
        for (int i = 0; i < inds.length; i++) {
            newBlocks[inds[i]] = true;
        }
        return new Row(newBlocks);
    }

    public boolean isFull() {
        for (boolean block : blocks) {
            if (!block) {
                return false;
            }
        }
        return true;
    }

    
}

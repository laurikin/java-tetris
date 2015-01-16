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
public class Board {
    private final int width;
    private final int height;
    private final Row[] rows;

    Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.rows = createRows();
    }

    public Board fill(int x, int y) {
        return this;
    }

    public boolean isFilled(int x, int y) {
        return this.rows[y].get(x);
    }

    private Row[] createRows() {
        Row[] newRows = new Row[height];
        for (int i = 0; i < newRows.length; i++) {
            newRows[i] = new Row(width);
        }
        return newRows;
    }
    
}

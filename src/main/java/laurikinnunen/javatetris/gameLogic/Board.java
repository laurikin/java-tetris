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
public class Board {
    private final int width;
    private final int height;
    private final Row[] rows;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.rows = createRows();
    }

    private Board(Row[] rows, int width, int height) {
        this.rows = rows;
        this.width = width;
        this.height = height;
    }

    public Board fill(int x, int y) {
        Row newRow = this.rows[y].add(new int[] {x});
        Row[] newRows = Arrays.copyOf(rows, rows.length);
        newRows[y] = newRow;
        return new Board(newRows, width, height);
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

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }
    
}

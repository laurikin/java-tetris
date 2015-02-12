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

    /**
     * fills the given coordinate with a block
     * @param x
     * @param y
     * @return updated board
     */
    public Board fill(int x, int y) {
        Row newRow = this.rows[y].add(new int[] {x});
        Row[] newRows = Arrays.copyOf(rows, rows.length);
        newRows[y] = newRow;
        return new Board(newRows, width, height);
    }

    /**
     * Returns true if the given grid coordinate is occupied
     * @param x
     * @param y
     * @return Boolean
     */
    public boolean isFilled(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return false;
        } else {
            return this.rows[y].get(x);
        }
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public Board dropFullRows() {
        Row[] newRows = Arrays.copyOf(rows, rows.length);
        for (int i = rows.length - 1; i >= 0; i--) {
            while (newRows[i].isFull()) {
                moveRowsAboveDown(i, newRows);
            }
        }
        return new Board(newRows, this.width, this.height);
    }

    private Row[] moveRowsAboveDown(int n, Row[] rows) {
        for (int i = n; i > 0; i--) {
            rows[i] = rows[i - 1];
        }
        rows[0] = new Row(this.width);
        return rows;
    }
    
    private Row[] createRows() {
        Row[] newRows = new Row[height];
        for (int i = 0; i < newRows.length; i++) {
            newRows[i] = new Row(width);
        }
        return newRows;
    }
}

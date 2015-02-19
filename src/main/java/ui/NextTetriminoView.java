/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import laurikinnunen.javatetris.gameLogic.Block;
import laurikinnunen.javatetris.gameLogic.tetriminos.Tetrimino;

/**
 *
 * @author laurikin
 */
public class NextTetriminoView extends JPanel {

    private Tetrimino tetrimino;
    private final int VIEW_WIDTH = 200;
    private final int BLOCK_SIZE = 32;
    private final int VIEW_HEIGHT = 4 * BLOCK_SIZE; 

    public void render(Tetrimino tetrimino) {
        this.tetrimino = tetrimino;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(VIEW_WIDTH, VIEW_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        setBackground(Color.BLACK);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, VIEW_WIDTH, VIEW_HEIGHT);
        if (tetrimino != null) {
            renderTetrimino(g, tetrimino);
        }
    }

    private void renderTetrimino(Graphics g, Tetrimino tetrimino) {
        g.setColor(Color.WHITE);
        Block[] blocks = tetrimino.blocks();
        for (Block block : blocks) {
            g.fillRect(
                (block.x() - 3) * BLOCK_SIZE,
                (block.y() + 3) * BLOCK_SIZE,
                BLOCK_SIZE,
                BLOCK_SIZE);
        }
    }
}
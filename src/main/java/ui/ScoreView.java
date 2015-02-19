/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author laurikin
 */
public class ScoreView extends JPanel {

    private int score = 0;
    private final int VIEW_WIDTH = 200;
    private final int VIEW_HEIGHT = 100;

    public void render(int score) {
        this.score = score;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(VIEW_WIDTH, VIEW_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        setBackground(Color.BLACK);
        Font font = UIManager.getFont("Label.font");
        setFont(font.deriveFont(Font.BOLD, 48));

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 200, 100);
        g.setColor(Color.WHITE);
        g.drawString("" + this.score,15,60);
    }
}

package ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import laurikinnunen.javatetris.gameLogic.Board;

/**
 *
 * @author Lauri Kinnunen
 */
public class BoardView extends JPanel {
    private final int PIXEL_SIZE = 30;
    private Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    @Override
    public void paintComponent(Graphics g) {
        setBackground(Color.GRAY);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 240, 240);
        g.setColor(Color.BLACK);

        for (int i = 0; i < 64; i++) {
            if (true) {
                g.fillRect((i * PIXEL_SIZE) % 240, i / 8 * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
            }
        }
    }

    public void render(Board board) {
        this.board = board;
        this.repaint();
    }
    
}

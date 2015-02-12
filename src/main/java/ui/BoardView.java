package ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import laurikinnunen.javatetris.gameLogic.Block;
import laurikinnunen.javatetris.gameLogic.Board;
import laurikinnunen.javatetris.gameLogic.GameState;
import laurikinnunen.javatetris.gameLogic.tetriminos.Tetrimino;

/**
 *
 * @author Lauri Kinnunen
 */
public class BoardView extends JPanel {
    private final int BLOCK_SIZE = 30;
    private GameState gs;

    @Override
    public void paintComponent(Graphics g) {
        if (gs == null) return;

        renderBoard(g, gs.getBoard());
        renderTetrimino(g, gs.getTetrimino());

    }

    public void render(GameState gs) {
        this.gs = gs;
        this.repaint();
    }

    private void renderBoard(Graphics g, Board board) {
        setBackground(Color.GRAY);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, board.width() * BLOCK_SIZE, board.height() * BLOCK_SIZE);
        g.setColor(Color.WHITE);

        for (int i = 0; i < board.height(); i++) {
            for (int j = 0; j < board.width(); j++) {
                if (board.isFilled(j, i)) {
                    g.fillRect(
                        j * BLOCK_SIZE, // x
                        i * BLOCK_SIZE, // y
                        BLOCK_SIZE, // width
                        BLOCK_SIZE // height
                    );
                }
            }
        }
    }

    private void renderTetrimino(Graphics g, Tetrimino tetrimino) {
        g.setColor(Color.WHITE);
        Block[] blocks = tetrimino.blocks();
        for (Block block : blocks) {
            g.fillRect(
                block.x() * BLOCK_SIZE,
                block.y() * BLOCK_SIZE,
                BLOCK_SIZE,
                BLOCK_SIZE);
        }
    }
    
}

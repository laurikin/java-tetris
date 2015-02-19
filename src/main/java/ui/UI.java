/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import laurikinnunen.javatetris.gameLogic.EventQueue;
import laurikinnunen.javatetris.gameLogic.GameState;
import laurikinnunen.javatetris.gameLogic.tetriminos.BarTetrimino;

/**
 *
 * @author laurikin
 */
public class UI {

    private JFrame jFrame;
    private final BoardView boardView;
    private final ScoreView scoreView;
    private final NextTetriminoView blockView;
    private final KeyListener keyListener;

    public UI (EventQueue eq) {

        boardView = new BoardView();
        scoreView = new ScoreView();
        blockView = new NextTetriminoView();
        keyListener = new ArrowKeyListener(eq);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainFrame(boardView, scoreView, blockView);
                frame.addKeyListener(keyListener);
                frame.setSize(720, 620);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
    }

    public void render (GameState gs, GameState old) {
        if(gs.getBoard() != old.getBoard() || 
           gs.getTetrimino() != old.getTetrimino())
        {
            boardView.render(gs);
        }

        if (gs.getScore() != old.getScore()) {
            scoreView.render(gs.getScore());
        }

        blockView.render(gs.getNextTetrimino());
    }

}

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

/**
 *
 * @author laurikin
 */
public class UI {

    private JFrame jFrame;
    private final BoardView boardView;
    private final KeyListener keyListener;

    public UI (EventQueue eq) {

        boardView = new BoardView();
        keyListener = new ArrowKeyListener(eq);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainFrame(boardView);
                frame.addKeyListener(keyListener);
                frame.setSize(350, 700);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    public void render (GameState gs) {
        boardView.render(gs);
    }

}

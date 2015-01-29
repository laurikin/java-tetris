/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import laurikinnunen.javatetris.gameLogic.GameState;

/**
 *
 * @author laurikin
 */
public class UI {

    private JFrame jFrame;
    private final BoardView boardView;

    public UI () {

        boardView = new BoardView();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainFrame(boardView);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import laurikinnunen.javatetris.gameLogic.Board;

/**
 *
 * @author laurikin
 */
public class UI {

    private JFrame jFrame;
    private final BoardView boardView;

    public UI (Board board) {

        boardView = new BoardView(board);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainFrame(boardView);
                frame.setSize(500, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    public void render (Board board) {
        boardView.render(board);
    }
}
